package com.users;


import com.database.util.DBsingletone;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class KMeansClustering {

    public JSONObject atRiskStudents(String year, String ctype, String csubtype ) {
        JSONArray jsonaray = new JSONArray();
        JSONArray jsonaray1 = new JSONArray();
        JSONObject js = new JSONObject();
        
        try {

            DBsingletone db = DBsingletone.getDbSingletone();
            Connection con = db.getConnection();
            
            int arr[] = new int[36];

            String query = "";
            
           
                query = "select "+csubtype+" as csub,region from "+ctype+" where Year='"+year+"'";
           
//                query = "select "+csubtype+" as csub,region from "+ctype+" where Year=2015";
            
            PreparedStatement psmt = con.prepareStatement(query);
            ResultSet rs = psmt.executeQuery();
            int x = 0;
            while (rs.next()) {
                arr[x] = rs.getInt("csub");
                x++;
            }

            int i, m1, m2, a, b, n = 0;
            boolean flag;
            float sum1, sum2;
            a = arr[0];
            b = arr[1];
            m1 = a;
            m2 = b;
            int cluster1[] = new int[arr.length], cluster2[] = new int[arr.length];
            do {
                sum1 = 0;
                sum2 = 0;
                cluster1 = new int[arr.length];
                cluster2 = new int[arr.length];
                n++;
                int k = 0, j = 0;
                for (i = 0; i < arr.length; i++) {
                    if (Math.abs(arr[i] - m1) <= Math.abs(arr[i] - m2)) {
                        cluster1[k] = arr[i];
                        k++;
                    } else {
                        cluster2[j] = arr[i];
                        j++;
                    }
                }
//                out.println();
                for (i = 0; i < k; i++) {
                    sum1 = sum1 + cluster1[i];
                }
                for (i = 0; i < j; i++) {
                    sum2 = sum2 + cluster2[i];
                }
                //printing Centroids/Means\
//                out.println("m1=" + m1 + "   m2=" + m2);
                a = m1;
                b = m2;
                m1 = Math.round(sum1 / k);
                m2 = Math.round(sum2 / j);
                flag = !(m1 == a && m2 == b);

//                out.println("After iteration " + n + " , cluster 1 :\n");    //printing the clusters of each iteration
                for (i = 0; i < cluster1.length; i++) {
//                   out.print(cluster1[i] + "\t");
                }

//                out.println("\n");
//                out.println("After iteration " + n + " , cluster 2 :\n");
                for (i = 0; i < cluster2.length; i++) {
//                    out.print(cluster2[i] + "\t");
                }

            } while (flag);

//            out.println("Final cluster 1 :\n");
            // final clusters
            List accident = new ArrayList();
            List accident1 = new ArrayList();
            for (i = 0; i < cluster1.length; i++) {
//            JSONObject json = new JSONObject();
//            json.put("risk", cluster1[i]);
//            jsonaray.put(json);
                accident.add(cluster1[i]);
            }

//            out.println();
//            out.println("Final cluster 2 :\n");
            for (i = 0; i < cluster2.length; i++) {
                   accident1.add(cluster2[i]);
            }

            List DD = new ArrayList();
            List DD1 = new ArrayList();
            DD = (List) accident.stream().distinct().collect(Collectors.toList());
            DD1 = (List) accident1.stream().distinct().collect(Collectors.toList());

            String query1 = "";
            
            
                query1 = "select "+csubtype+" as csub,region from "+ctype+" where Year='"+year+"' and "+csubtype+" ";
            
            
            
            for (int k = 0; k < DD.size(); k++) {
                PreparedStatement psm = con.prepareStatement(query1+"='" + DD.get(k) + "' ");
                ResultSet rr = psm.executeQuery();
                while (rr.next()) {
                        JSONObject json = new JSONObject();
                        json.put("name", rr.getString("region"));
                        json.put("accidents", DD.get(k));
                        jsonaray.put(json);
                }
            }
            
            for (int k = 0; k < DD1.size(); k++) {
                PreparedStatement psm = con.prepareStatement(query1+"='" + DD1.get(k) + "' ");
                ResultSet rr = psm.executeQuery();
                while (rr.next()) {
                        JSONObject json = new JSONObject();
                        json.put("name", rr.getString("region"));
                        json.put("accidents", DD1.get(k));
                        jsonaray1.put(json);
                }
            }
            
            js.put("less", jsonaray);
            js.put("high", jsonaray1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // initial data

        return js;
    }

    public static void main(String args[]) {
    }
}
