/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users;

import com.database.util.DBsingletone;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;


@WebServlet(name = "predict17", urlPatterns = {"/predict17"})
public class predict17 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String state = request.getParameter("state");
            String ctype = request.getParameter("ctype");

//              String state = "Kollur";
//           String ctype = "Occupation";
            DBsingletone db = DBsingletone.getDbSingletone();
            Connection con = db.getConnection();
            
            String ratio = "";
            
            if (ctype.equals("Occupation")) {
                JSONArray jaray = new JSONArray();
                try {
                     PreparedStatement psm = con.prepareStatement(" SELECT (SELECT `bu  siness` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2021') AS y2021,(SELECT `business` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2012') AS y2012,(SELECT `business` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2013') AS y2013,(SELECT `business` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2014') AS y2014,(SELECT `business` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2015') AS y2015,(SELECT `business` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2016') AS y2016,(SELECT `business` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2017') AS y2017,(SELECT `business` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2018') AS y2018,(SELECT `business` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2019') AS y2019,(SELECT `business` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2020') AS y2020 ");
                    ResultSet rs = psm.executeQuery();
                    JSONArray jarray = new JSONArray();
                    if (rs.next()) {
                        JSONObject json2 = new JSONObject();
                        JSONObject json3 = new JSONObject();
                        JSONObject json4 = new JSONObject();
                        JSONObject json5 = new JSONObject();
                        JSONObject json6 = new JSONObject();
                        JSONObject json7 = new JSONObject();
                        JSONObject json8 = new JSONObject();
                        JSONObject json9 = new JSONObject();
                        JSONObject json10 = new JSONObject();
                        JSONObject json11 = new JSONObject();
                        JSONObject json12 = new JSONObject();

                       

                        json4.put("name", "2021");
                        json4.put("y", Float.parseFloat(rs.getString("y2021")));

                        json5.put("name", "2012");
                        json5.put("y", Float.parseFloat(rs.getString("y2012")));

                        json6.put("name", "2013");
                        json6.put("y", Float.parseFloat(rs.getString("y2013")));

                        json7.put("name", "2014");
                        json7.put("y", Float.parseFloat(rs.getString("y2014")));

                        json8.put("name", "2015");
                        json8.put("y", Float.parseFloat(rs.getString("y2015")));

                        json9.put("name", "2016");
                        json9.put("y", Float.parseFloat(rs.getString("y2016")));

                        json10.put("name", "2017");
                        json10.put("y", Float.parseFloat(rs.getString("y2017")));
                        
                         json2.put("name", "2018");
                        json2.put("y", Float.parseFloat(rs.getString("y2018")));

                        json3.put("name", "2019");
                        json3.put("y", Float.parseFloat(rs.getString("y2019")));
                        
                        json11.put("name", "2020");
                        json11.put("y", Float.parseFloat(rs.getString("y2020")));

                        float  data2, data3, data4, data5, data6, data7, data8, data9, data10,data11;

                        
                        data4 = Float.parseFloat(rs.getString("Y2021"));
                        data5 = Float.parseFloat(rs.getString("Y2012"));
                        data6 = Float.parseFloat(rs.getString("Y2013"));
                        data7 = Float.parseFloat(rs.getString("Y2014"));
                        data8 = Float.parseFloat(rs.getString("Y2015"));
                        data9 = Float.parseFloat(rs.getString("Y2016"));
                        data10 = Float.parseFloat(rs.getString("Y2017"));
                        data2 = Float.parseFloat(rs.getString("Y2018"));
                        data3 = Float.parseFloat(rs.getString("Y2019"));
                        data11 = Float.parseFloat(rs.getString("Y2020"));

                        double x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
                        double y[] = {data2, data3, data4, data5, data6, data7, data8, data9, data10,data11};

                        LinearRegression lr = new LinearRegression(x, y);
                        json12.put("name", "2022");
                        if (lr.predict(11) < 0) {
                            json12.put("y", 0.0);
                        
                   } else {
                            json12.put("y", lr.predict(11));
                        }
                        
                         

                        

                     
                        jarray.put(json4);
                        jarray.put(json5);
                        jarray.put(json6);
                        jarray.put(json7);
                        jarray.put(json8);
                        jarray.put(json9);
                        jarray.put(json10);
                        jarray.put(json2);
                        jarray.put(json3);
                        jarray.put(json11);
                        jarray.put(json12);

                    

                    

                    }
                    PreparedStatement psm1 = con.prepareStatement(" SELECT (SELECT `government` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2021') AS y2021,(SELECT `government` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2012') AS y2012,(SELECT `government` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2013') AS y2013,(SELECT `government` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2014') AS y2014,(SELECT `government` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2015') AS y2015,(SELECT `government` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2016') AS y2016,(SELECT `government` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2017') AS y2017,(SELECT `government` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2018') AS y2018,(SELECT `government` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2019') AS y2019,(SELECT `government` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2020') AS y2020 ");
                    ResultSet rs1 = psm1.executeQuery();
                    JSONArray jarray1 = new JSONArray();
                    if (rs1.next()) {
                        JSONObject json2 = new JSONObject();
                        JSONObject json3 = new JSONObject();
                        JSONObject json4 = new JSONObject();
                        JSONObject json5 = new JSONObject();
                        JSONObject json6 = new JSONObject();
                        JSONObject json7 = new JSONObject();
                        JSONObject json8 = new JSONObject();
                        JSONObject json9 = new JSONObject();
                        JSONObject json10 = new JSONObject();
                        JSONObject json11 = new JSONObject();
                        JSONObject json12 = new JSONObject();

                      

                        json4.put("name", "2021");
                        json4.put("y", Float.parseFloat(rs1.getString("y2021")));

                        json5.put("name", "2012");
                        json5.put("y", Float.parseFloat(rs1.getString("y2012")));

                        json6.put("name", "2013");
                        json6.put("y", Float.parseFloat(rs1.getString("y2013")));

                        json7.put("name", "2014");
                        json7.put("y", Float.parseFloat(rs1.getString("y2014")));

                        json8.put("name", "2015");
                        json8.put("y", Float.parseFloat(rs1.getString("y2015")));

                        json9.put("name", "2016");
                        json9.put("y", Float.parseFloat(rs1.getString("y2016")));

                        json10.put("name", "2017");
                        json10.put("y", Float.parseFloat(rs1.getString("y2017")));
                        
                          json2.put("name", "2018");
                        json2.put("y", Float.parseFloat(rs1.getString("y2018")));

                        json3.put("name", "2019");
                        json3.put("y", Float.parseFloat(rs1.getString("y2019")));
                        
                       json11.put("name", "2020");
                       json11.put("y", Float.parseFloat(rs1.getString("y2020")));

                        float  data2, data3, data4, data5, data6, data7, data8, data9, data10,data11;

                    
                        data4 = Float.parseFloat(rs1.getString("Y2021"));
                        data5 = Float.parseFloat(rs1.getString("Y2012"));
                        data6 = Float.parseFloat(rs1.getString("Y2013"));
                        data7 = Float.parseFloat(rs1.getString("Y2014"));
                        data8 = Float.parseFloat(rs1.getString("Y2015"));
                        data9 = Float.parseFloat(rs1.getString("Y2016"));
                        data10 = Float.parseFloat(rs1.getString("Y2017"));
                            data2 = Float.parseFloat(rs1.getString("Y2018"));
                        data3 = Float.parseFloat(rs1.getString("Y2019"));
                         data11 = Float.parseFloat(rs1.getString("Y2020"));

                        double x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
                        double y[] = {data2, data3, data4, data5, data6, data7, data8, data9, data10,data11};

                        LinearRegression lr = new LinearRegression(x, y);
                        json12.put("name", "2022");
                        if (lr.predict(10) < 0) {
                            json12.put("y", 0.0);
                        } else {
                            json12.put("y", lr.predict(11));
                        }
                         
                       

                        jarray1.put(json4);
                        jarray1.put(json5);
                        jarray1.put(json6);
                        jarray1.put(json7);
                        jarray1.put(json8);
                        jarray1.put(json9);
                        jarray1.put(json10);
                        
                        jarray1.put(json2);
                        jarray1.put(json3);
                        jarray1.put(json11);
                        jarray1.put(json12);


                    }
                     PreparedStatement psm2 = con.prepareStatement(" SELECT (SELECT `software` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2021') AS y2021,(SELECT `software` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2012') AS y2012,(SELECT `software` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2013') AS y2013,(SELECT `software` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2014') AS y2014,(SELECT `software` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2015') AS y2015,(SELECT `software` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2016') AS y2016,(SELECT `software` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2017') AS y2017,(SELECT `software` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2018') AS y2018,(SELECT `software` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2019') AS y2019,(SELECT `software` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2020') AS y2020");
                    ResultSet rs2 = psm2.executeQuery();
                    JSONArray jarray2 = new JSONArray();
                    if (rs2.next()) {
                        JSONObject json2 = new JSONObject();
                        JSONObject json3 = new JSONObject();
                        JSONObject json4 = new JSONObject();
                        JSONObject json5 = new JSONObject();
                        JSONObject json6 = new JSONObject();
                        JSONObject json7 = new JSONObject();
                        JSONObject json8 = new JSONObject();
                        JSONObject json9 = new JSONObject();
                        JSONObject json10 = new JSONObject();
                       JSONObject json11 = new JSONObject();
                        JSONObject json12 = new JSONObject();

                     

                        json4.put("name", "2021");
                        json4.put("y", Float.parseFloat(rs2.getString("y2021")));

                        json5.put("name", "2012");
                        json5.put("y", Float.parseFloat(rs2.getString("y2012")));

                        json6.put("name", "2013");
                        json6.put("y", Float.parseFloat(rs2.getString("y2013")));

                        json7.put("name", "2014");
                        json7.put("y", Float.parseFloat(rs2.getString("y2014")));

                        json8.put("name", "2015");
                        json8.put("y", Float.parseFloat(rs2.getString("y2015")));

                        json9.put("name", "2016");
                        json9.put("y", Float.parseFloat(rs2.getString("y2016")));

                        json10.put("name", "2017");
                        json10.put("y", Float.parseFloat(rs2.getString("y2017")));
                        
                           json2.put("name", "2018");
                        json2.put("y", Float.parseFloat(rs2.getString("y2018")));

                        json3.put("name", "2019");
                        json3.put("y", Float.parseFloat(rs2.getString("y2019")));
                        
                        json11.put("name", "2020");
                        json11.put("y", Float.parseFloat(rs2.getString("y2020")));

                        float  data2, data3, data4, data5, data6, data7, data8, data9, data10,data11;

                        
                        data4 = Float.parseFloat(rs2.getString("Y2021"));
                        data5 = Float.parseFloat(rs2.getString("Y2012"));
                        data6 = Float.parseFloat(rs2.getString("Y2013"));
                        data7 = Float.parseFloat(rs2.getString("Y2014"));
                        data8 = Float.parseFloat(rs2.getString("Y2015"));
                        data9 = Float.parseFloat(rs2.getString("Y2016"));
                        data10 = Float.parseFloat(rs2.getString("Y2017"));
                        data2 = Float.parseFloat(rs2.getString("Y2018"));
                        data3 = Float.parseFloat(rs2.getString("Y2019"));
                       data11 = Float.parseFloat(rs2.getString("Y2020"));

                        double x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
                        double y[] = {data2, data3, data4, data5, data6, data7, data8, data9, data10,data11};

                        LinearRegression lr = new LinearRegression(x, y);
                        json12.put("name", "2022");
                        if (lr.predict(10) < 0) {
                            json12.put("y", 0.0);
                        } else {
                            json12.put("y", lr.predict(11));
                        }
                        
                       

                        jarray2.put(json2);
                        jarray2.put(json3);
                        jarray2.put(json4);
                        jarray2.put(json5);
                        jarray2.put(json6);
                        jarray2.put(json7);
                        jarray2.put(json8);
                        jarray2.put(json9);
                        jarray2.put(json10);
                        jarray2.put(json11);
                        jarray2.put(json12);


                    }
                    PreparedStatement psm4 = con.prepareStatement(" SELECT (SELECT `farmer` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2021') AS y2021,(SELECT `farmer` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2012') AS y2012,(SELECT `farmer` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2013') AS y2013,(SELECT `farmer` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2014') AS y2014,(SELECT `farmer` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2015') AS y2015,(SELECT `farmer` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2016') AS y2016,(SELECT `farmer` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2017') AS y2017,(SELECT `farmer` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2018') AS y2018,(SELECT `farmer` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2019') AS y2019,(SELECT `farmer` FROM `occupation` WHERE `region`='" + state + "' AND `Year`='2020') AS y2020");
                    ResultSet rs4 = psm4.executeQuery();
                    JSONArray jarray3 = new JSONArray();
                    if (rs4.next()) {
                        JSONObject json2 = new JSONObject();
                        JSONObject json3 = new JSONObject();
                        JSONObject json4 = new JSONObject();
                        JSONObject json5 = new JSONObject();
                        JSONObject json6 = new JSONObject();
                        JSONObject json7 = new JSONObject();
                        JSONObject json8 = new JSONObject();
                        JSONObject json9 = new JSONObject();
                        JSONObject json10 = new JSONObject();
                        JSONObject json11 = new JSONObject();
                         JSONObject json12 = new JSONObject();

                    

                        json4.put("name", "2021");
                        json4.put("y", Float.parseFloat(rs4.getString("y2021")));

                        json5.put("name", "2012");
                        json5.put("y", Float.parseFloat(rs4.getString("y2012")));

                        json6.put("name", "2013");
                        json6.put("y", Float.parseFloat(rs4.getString("y2013")));

                        json7.put("name", "2014");
                        json7.put("y", Float.parseFloat(rs4.getString("y2014")));

                        json8.put("name", "2015");
                        json8.put("y", Float.parseFloat(rs4.getString("y2015")));

                        json9.put("name", "2016");
                        json9.put("y", Float.parseFloat(rs4.getString("y2016")));

                        json10.put("name", "2017");
                        json10.put("y", Float.parseFloat(rs4.getString("y2017")));
                        
                            json2.put("name", "2018");
                        json2.put("y", Float.parseFloat(rs4.getString("y2018")));

                        json3.put("name", "2019");
                        json3.put("y", Float.parseFloat(rs4.getString("y2019")));
                        
                      json11.put("name", "2020");
                        json11.put("y", Float.parseFloat(rs4.getString("y2020")));

                        float data1, data2, data3, data4, data5, data6, data7, data8, data9, data10,data11;

                        
                        data4 = Float.parseFloat(rs4.getString("y2021"));
                        data5 = Float.parseFloat(rs4.getString("y2012"));
                        data6 = Float.parseFloat(rs4.getString("y2013"));
                        data7 = Float.parseFloat(rs4.getString("y2014"));
                        data8 = Float.parseFloat(rs4.getString("y2015"));
                        data9 = Float.parseFloat(rs4.getString("y2016"));
                        data10 = Float.parseFloat(rs4.getString("y2017"));
                        data2 = Float.parseFloat(rs4.getString("y2018"));
                        data3 = Float.parseFloat(rs4.getString("y2019"));
                      data11 = Float.parseFloat(rs4.getString("y2020"));

                        double x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
                        double y[] = {data2, data3, data4, data5, data6, data7, data8, data9, data10,data11};

                        LinearRegression lr = new LinearRegression(x, y);
                        json12.put("name", "2022");
                        if (lr.predict(10) < 0) {
                            json12.put("y", 0.0);
                        } else {
                            json12.put("y", lr.predict(11));
                        }
                                            
                        
                      
                        jarray3.put(json4);
                        jarray3.put(json5);
                        jarray3.put(json6);
                        jarray3.put(json7);
                        jarray3.put(json8);
                        jarray3.put(json9);
                        jarray3.put(json10);
                          jarray3.put(json2);
                        jarray3.put(json3);
                         jarray3.put(json11);
                        jarray3.put(json12);

                    }


                    JSONObject json = new JSONObject();
                    //json.put("name", "Fog");
                    //json.put("data", jarray);

                    JSONObject json1 = new JSONObject();
                    json1.put("name", "Business");
                    json1.put("data", jarray);

                    JSONObject json2 = new JSONObject();
                    json2.put("name", "Governement");
                    json2.put("data", jarray1);
                    
                    JSONObject json3 = new JSONObject();
                    json3.put("name", "software");
                    json3.put("data", jarray2);
                    
                     JSONObject json4 = new JSONObject();
                    json4.put("name", "Farmer");
                    json4.put("data", jarray3);
                    
                    jaray.put(json);
                    jaray.put(json1);
                    jaray.put(json2);
                    jaray.put(json3);
                    jaray.put(json4);
                    
                    out.print(jaray);

               
           
            

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }  
             else  if (ctype.equals("Gender")) {
                JSONArray jaray = new JSONArray();
                try {
                     PreparedStatement psm = con.prepareStatement(" SELECT (SELECT `Male` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2021') AS y2021,(SELECT `Male` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2011') AS y2011,(SELECT `Male` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2013') AS y2013,(SELECT `Male` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2014') AS y2014,(SELECT `Male` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2015') AS y2015,(SELECT `Male` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2016') AS y2016,(SELECT `Male` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2017') AS y2017,(SELECT `Male` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2018') AS y2018,(SELECT `Male` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2019') AS y2019,(SELECT `Male` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2020') AS y2020");
                    ResultSet rs = psm.executeQuery();
                    JSONArray jarray = new JSONArray();
                    if (rs.next()) {
                        JSONObject json2 = new JSONObject();
                        JSONObject json3 = new JSONObject();
                        JSONObject json4 = new JSONObject();
                        JSONObject json5 = new JSONObject();
                        JSONObject json6 = new JSONObject();
                        JSONObject json7 = new JSONObject();
                        JSONObject json8 = new JSONObject();
                        JSONObject json9 = new JSONObject();
                        JSONObject json10 = new JSONObject();
                        JSONObject json11 = new JSONObject();
                        JSONObject json12 = new JSONObject();

                      

                        json4.put("name", "2021");
                        json4.put("y", Float.parseFloat(rs.getString("y2021")));

                        json5.put("name", "2012");
                        json5.put("y", Float.parseFloat(rs.getString("y2011")));

                        json6.put("name", "2013");
                        json6.put("y", Float.parseFloat(rs.getString("y2013")));

                        json7.put("name", "2014");
                        json7.put("y", Float.parseFloat(rs.getString("y2014")));

                        json8.put("name", "2015");
                        json8.put("y", Float.parseFloat(rs.getString("y2015")));

                        json9.put("name", "2016");
                        json9.put("y", Float.parseFloat(rs.getString("y2016")));

                        json10.put("name", "2017");
                        json10.put("y", Float.parseFloat(rs.getString("y2017")));
                        
                          json2.put("name", "2018");
                        json2.put("y", Float.parseFloat(rs.getString("y2018")));

                        json3.put("name", "2019");
                        json3.put("y", Float.parseFloat(rs.getString("y2019")));
                        
                       json11.put("name", "2020");
                       json11.put("y", Float.parseFloat(rs.getString("y2020")));

                        float data1, data2, data3, data4, data5, data6, data7, data8, data9, data10,data11;

                        
                        data4 = Float.parseFloat(rs.getString("Y2021"));
                        data5 = Float.parseFloat(rs.getString("Y2011"));
                        data6 = Float.parseFloat(rs.getString("Y2013"));
                        data7 = Float.parseFloat(rs.getString("Y2014"));
                        data8 = Float.parseFloat(rs.getString("Y2015"));
                        data9 = Float.parseFloat(rs.getString("Y2016"));
                        data10 = Float.parseFloat(rs.getString("Y2017"));
                        data2 = Float.parseFloat(rs.getString("Y2018"));
                        data3 = Float.parseFloat(rs.getString("Y2019"));
                        data11 = Float.parseFloat(rs.getString("Y2020"));

                        double x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
                        double y[] = {data2, data3, data4, data5, data6, data7, data8, data9, data10,data11};

                        LinearRegression lr = new LinearRegression(x, y);
                        json12.put("name", "2022");
                        if (lr.predict(10) < 0) {
                            json12.put("y", 0.0);
                        } else {
                            json12.put("y", lr.predict(11));
                        }
                              
                        
                        

                        jarray.put(json2);
                        jarray.put(json3);
                        jarray.put(json4);
                        jarray.put(json5);
                        jarray.put(json6);
                        jarray.put(json7);
                        jarray.put(json8);
                        jarray.put(json9);
                        jarray.put(json10);
                        jarray.put(json11);
                        jarray.put(json12);

                    

                    

                    }
                    PreparedStatement psm1 = con.prepareStatement(" SELECT (SELECT `Female` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2021') AS y2021,(SELECT `Female` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2011') AS y2011,(SELECT `Female` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2013') AS y2013,(SELECT `Female` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2014') AS y2014,(SELECT `Female` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2015') AS y2015,(SELECT `Female` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2016') AS y2016,(SELECT `Female` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2017') AS y2017,(SELECT `Female` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2018') AS y2018,(SELECT `Female` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2019') AS y2019,(SELECT `Female` FROM `gender` WHERE `region`='" + state + "' AND `Year`='2020') AS y2020");
                    ResultSet rs1 = psm1.executeQuery();
                    JSONArray jarray1 = new JSONArray();
                    if (rs1.next()) {
                        JSONObject json2 = new JSONObject();
                        JSONObject json3 = new JSONObject();
                        JSONObject json4 = new JSONObject();
                        JSONObject json5 = new JSONObject();
                        JSONObject json6 = new JSONObject();
                        JSONObject json7 = new JSONObject();
                        JSONObject json8 = new JSONObject();
                        JSONObject json9 = new JSONObject();
                        JSONObject json10 = new JSONObject();
                    JSONObject json11 = new JSONObject();
                        JSONObject json12 = new JSONObject();

                       

                        json4.put("name", "2021");
                        json4.put("y", Float.parseFloat(rs1.getString("y2021")));

                        json5.put("name", "2011");
                        json5.put("y", Float.parseFloat(rs1.getString("y2011")));

                        json6.put("name", "2013");
                        json6.put("y", Float.parseFloat(rs1.getString("y2013")));

                        json7.put("name", "2014");
                        json7.put("y", Float.parseFloat(rs1.getString("y2014")));

                        json8.put("name", "2015");
                        json8.put("y", Float.parseFloat(rs1.getString("y2015")));

                        json9.put("name", "2016");
                        json9.put("y", Float.parseFloat(rs1.getString("y2016")));

                        json10.put("name", "2017");
                        json10.put("y", Float.parseFloat(rs1.getString("y2017")));
                        
                         json2.put("name", "2018");
                        json2.put("y", Float.parseFloat(rs1.getString("y2018")));

                        json3.put("name", "2019");
                        json3.put("y", Float.parseFloat(rs1.getString("y2019")));
                        
                       json11.put("name", "2020");
                    json11.put("y", Float.parseFloat(rs1.getString("y2020")));

                        float data1, data2, data3, data4, data5, data6, data7, data8, data9, data10,data11;

                       
                        data4 = Float.parseFloat(rs1.getString("Y2021"));
                        data5 = Float.parseFloat(rs1.getString("Y2011"));
                        data6 = Float.parseFloat(rs1.getString("Y2013"));
                        data7 = Float.parseFloat(rs1.getString("Y2014"));
                        data8 = Float.parseFloat(rs1.getString("Y2015"));
                        data9 = Float.parseFloat(rs1.getString("Y2016"));
                        data10 = Float.parseFloat(rs1.getString("Y2017"));
                         data2 = Float.parseFloat(rs1.getString("Y2018"));
                        data3 = Float.parseFloat(rs1.getString("Y2019"));
                        data11 = Float.parseFloat(rs1.getString("Y2020"));

                        double x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
                        double y[] = {data2, data3, data4, data5, data6, data7, data8, data9, data10,data11};

                        LinearRegression lr = new LinearRegression(x, y);
                        json12.put("name", "2022");
                        if (lr.predict(10) < 0) {
                            json12.put("y", 0.0);
                        } else {
                            json12.put("y", lr.predict(10));
                        }
                                 
                        
                       

                      
                        jarray1.put(json4);
                        jarray1.put(json5);
                        jarray1.put(json6);
                        jarray1.put(json7);
                        jarray1.put(json8);
                        jarray1.put(json9);
                        jarray1.put(json10);
                        jarray1.put(json2);
                        jarray1.put(json3);
                        jarray1.put(json11);
                        jarray1.put(json12);


                    }
                    
                    
                     

                    JSONObject json = new JSONObject();
                    //json.put("name", "Fog");
                    //json.put("data", jarray);

                    JSONObject json1 = new JSONObject();
                    json1.put("name", "Male");
                    json1.put("data", jarray);

                    JSONObject json2 = new JSONObject();
                    json2.put("name", "Female");
                    json2.put("data", jarray1);
                    
                   
                    
                    jaray.put(json);
                    jaray.put(json1);
                    jaray.put(json2);
                   
                    
                    out.print(jaray);


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
             else  if (ctype.equals("Bloodgroup1")) {
                JSONArray jaray = new JSONArray();
                try {
                     PreparedStatement psm = con.prepareStatement(" SELECT (SELECT `Opos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2021') AS y2021,(SELECT `Opos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2012') AS y2012,(SELECT `Opos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2013') AS y2013,(SELECT `Opos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2014') AS y2014,(SELECT `Opos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2015') AS y2015,(SELECT `Opos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2016') AS y2016,(SELECT `Opos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2017') AS y2017,(SELECT `Opos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2018') AS y2018,(SELECT `Opos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2019') AS y2019,(SELECT `Opos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2020') AS y2020");
                    ResultSet rs = psm.executeQuery();
                    JSONArray jarray = new JSONArray();
                    if (rs.next()) {
                       JSONObject json2 = new JSONObject();
                        JSONObject json3 = new JSONObject();
                        JSONObject json4 = new JSONObject();
                        JSONObject json5 = new JSONObject();
                        JSONObject json6 = new JSONObject();
                        JSONObject json7 = new JSONObject();
                        JSONObject json8 = new JSONObject();
                        JSONObject json9 = new JSONObject();
                        JSONObject json10 = new JSONObject();
                        JSONObject json11 = new JSONObject();
                        JSONObject json12 = new JSONObject();

                       

                        json4.put("name", "2021");
                        json4.put("y", Float.parseFloat(rs.getString("y2021")));

                        json5.put("name", "2012");
                        json5.put("y", Float.parseFloat(rs.getString("y2012")));

                        json6.put("name", "2013");
                        json6.put("y", Float.parseFloat(rs.getString("y2013")));

                        json7.put("name", "2014");
                        json7.put("y", Float.parseFloat(rs.getString("y2014")));

                        json8.put("name", "2015");
                        json8.put("y", Float.parseFloat(rs.getString("y2015")));

                        json9.put("name", "2016");
                        json9.put("y", Float.parseFloat(rs.getString("y2016")));

                        json10.put("name", "2017");
                        json10.put("y", Float.parseFloat(rs.getString("y2017")));
                        
                         json2.put("name", "2018");
                        json2.put("y", Float.parseFloat(rs.getString("y2018")));

                        json3.put("name", "2019");
                        json3.put("y", Float.parseFloat(rs.getString("y2019")));
                        
                        json11.put("name", "2020");
                        json11.put("y", Float.parseFloat(rs.getString("y2020")));

                        float  data2, data3, data4, data5, data6, data7, data8, data9, data10,data11;

                        
                        data4 = Float.parseFloat(rs.getString("Y2021"));
                        data5 = Float.parseFloat(rs.getString("Y2012"));
                        data6 = Float.parseFloat(rs.getString("Y2013"));
                        data7 = Float.parseFloat(rs.getString("Y2014"));
                        data8 = Float.parseFloat(rs.getString("Y2015"));
                        data9 = Float.parseFloat(rs.getString("Y2016"));
                        data10 = Float.parseFloat(rs.getString("Y2017"));
                        data2 = Float.parseFloat(rs.getString("Y2018"));
                        data3 = Float.parseFloat(rs.getString("Y2019"));
                        data11 = Float.parseFloat(rs.getString("Y2020"));

                        double x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
                        double y[] = {data2, data3, data4, data5, data6, data7, data8, data9, data10,data11};

                        LinearRegression lr = new LinearRegression(x, y);
                        json12.put("name", "2022");
                        if (lr.predict(10) < 0) {
                            json12.put("y", 0.0);
                        
                   } else {
                            json12.put("y", lr.predict(11));
                        }
                        
                         

                        

                     
                        jarray.put(json4);
                        jarray.put(json5);
                        jarray.put(json6);
                        jarray.put(json7);
                        jarray.put(json8);
                        jarray.put(json9);
                        jarray.put(json10);
                        jarray.put(json2);
                        jarray.put(json3);
                        jarray.put(json11);
                        jarray.put(json12);

                    

                    
                    }
                   
                     PreparedStatement psm2 = con.prepareStatement(" SELECT (SELECT `Apos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2021') AS y2021,(SELECT `Apos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2012') AS y2012,(SELECT `Apos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2013') AS y2013,(SELECT `Apos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2014') AS y2014,(SELECT `Apos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2015') AS y2015,(SELECT `Apos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2016') AS y2016,(SELECT `Apos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2017') AS y2017,(SELECT `Apos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2018') AS y2018,(SELECT `Apos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2019') AS y2019,(SELECT `Apos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2020') AS y2020");
                    ResultSet rs2 = psm2.executeQuery();
                    JSONArray jarray2 = new JSONArray();
                    if (rs2.next()) {
                       JSONObject json2 = new JSONObject();
                        JSONObject json3 = new JSONObject();
                        JSONObject json4 = new JSONObject();
                        JSONObject json5 = new JSONObject();
                        JSONObject json6 = new JSONObject();
                        JSONObject json7 = new JSONObject();
                        JSONObject json8 = new JSONObject();
                        JSONObject json9 = new JSONObject();
                        JSONObject json10 = new JSONObject();
                       JSONObject json11 = new JSONObject();
                        JSONObject json12 = new JSONObject();

                     

                        json4.put("name", "2021");
                        json4.put("y", Float.parseFloat(rs2.getString("y2021")));

                        json5.put("name", "2012");
                        json5.put("y", Float.parseFloat(rs2.getString("y2012")));

                        json6.put("name", "2013");
                        json6.put("y", Float.parseFloat(rs2.getString("y2013")));

                        json7.put("name", "2014");
                        json7.put("y", Float.parseFloat(rs2.getString("y2014")));

                        json8.put("name", "2015");
                        json8.put("y", Float.parseFloat(rs2.getString("y2015")));

                        json9.put("name", "2016");
                        json9.put("y", Float.parseFloat(rs2.getString("y2016")));

                        json10.put("name", "2017");
                        json10.put("y", Float.parseFloat(rs2.getString("y2017")));
                        
                           json2.put("name", "2018");
                        json2.put("y", Float.parseFloat(rs2.getString("y2018")));

                        json3.put("name", "2019");
                        json3.put("y", Float.parseFloat(rs2.getString("y2019")));
                        
                        json11.put("name", "2020");
                        json11.put("y", Float.parseFloat(rs2.getString("y2020")));

                        float  data2, data3, data4, data5, data6, data7, data8, data9, data10,data11;

                        
                        data4 = Float.parseFloat(rs2.getString("Y2021"));
                        data5 = Float.parseFloat(rs2.getString("Y2012"));
                        data6 = Float.parseFloat(rs2.getString("Y2013"));
                        data7 = Float.parseFloat(rs2.getString("Y2014"));
                        data8 = Float.parseFloat(rs2.getString("Y2015"));
                        data9 = Float.parseFloat(rs2.getString("Y2016"));
                        data10 = Float.parseFloat(rs2.getString("Y2017"));
                        data2 = Float.parseFloat(rs2.getString("Y2018"));
                        data3 = Float.parseFloat(rs2.getString("Y2019"));
                       data11 = Float.parseFloat(rs2.getString("Y2020"));

                        double x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
                        double y[] = {data2, data3, data4, data5, data6, data7, data8, data9, data10,data11};

                        LinearRegression lr = new LinearRegression(x, y);
                        json12.put("name", "2022");
                        if (lr.predict(10) < 0) {
                            json12.put("y", 0.0);
                        } else {
                            json12.put("y", lr.predict(11));
                        }
                        
                       

                        jarray2.put(json2);
                        jarray2.put(json3);
                        jarray2.put(json4);
                        jarray2.put(json5);
                        jarray2.put(json6);
                        jarray2.put(json7);
                        jarray2.put(json8);
                        jarray2.put(json9);
                        jarray2.put(json10);
                        jarray2.put(json11);
                        jarray2.put(json12);



                    }
                    PreparedStatement psm1 = con.prepareStatement(" SELECT (SELECT `Bpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2021') AS y2021,(SELECT `Bpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2012') AS y2012,(SELECT `Bpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2013') AS y2013,(SELECT `Bpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2014') AS y2014,(SELECT `Bpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2015') AS y2015,(SELECT `Bpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2016') AS y2016,(SELECT `Bpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2017') AS y2017,(SELECT `Bpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2018') AS y2018,(SELECT `Bpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2019') AS y2019,(SELECT `Bpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2020') AS y2020 ");
                    ResultSet rs1 = psm1.executeQuery();
                    JSONArray jarray1 = new JSONArray();
                    if (rs1.next()) {
                       JSONObject json2 = new JSONObject();
                        JSONObject json3 = new JSONObject();
                        JSONObject json4 = new JSONObject();
                        JSONObject json5 = new JSONObject();
                        JSONObject json6 = new JSONObject();
                        JSONObject json7 = new JSONObject();
                        JSONObject json8 = new JSONObject();
                        JSONObject json9 = new JSONObject();
                        JSONObject json10 = new JSONObject();
                        JSONObject json11 = new JSONObject();
                        JSONObject json12 = new JSONObject();

                      

                        json4.put("name", "2021");
                        json4.put("y", Float.parseFloat(rs1.getString("y2021")));

                        json5.put("name", "2012");
                        json5.put("y", Float.parseFloat(rs1.getString("y2012")));

                        json6.put("name", "2013");
                        json6.put("y", Float.parseFloat(rs1.getString("y2013")));

                        json7.put("name", "2014");
                        json7.put("y", Float.parseFloat(rs1.getString("y2014")));

                        json8.put("name", "2015");
                        json8.put("y", Float.parseFloat(rs1.getString("y2015")));

                        json9.put("name", "2016");
                        json9.put("y", Float.parseFloat(rs1.getString("y2016")));

                        json10.put("name", "2017");
                        json10.put("y", Float.parseFloat(rs1.getString("y2017")));
                        
                          json2.put("name", "2018");
                        json2.put("y", Float.parseFloat(rs1.getString("y2018")));

                        json3.put("name", "2019");
                        json3.put("y", Float.parseFloat(rs1.getString("y2019")));
                        
                       json11.put("name", "2020");
                       json11.put("y", Float.parseFloat(rs1.getString("y2020")));

                        float  data2, data3, data4, data5, data6, data7, data8, data9, data10,data11;

                    
                        data4 = Float.parseFloat(rs1.getString("Y2021"));
                        data5 = Float.parseFloat(rs1.getString("Y2012"));
                        data6 = Float.parseFloat(rs1.getString("Y2013"));
                        data7 = Float.parseFloat(rs1.getString("Y2014"));
                        data8 = Float.parseFloat(rs1.getString("Y2015"));
                        data9 = Float.parseFloat(rs1.getString("Y2016"));
                        data10 = Float.parseFloat(rs1.getString("Y2017"));
                            data2 = Float.parseFloat(rs1.getString("Y2018"));
                        data3 = Float.parseFloat(rs1.getString("Y2019"));
                         data11 = Float.parseFloat(rs1.getString("Y2020"));

                        double x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
                        double y[] = {data2, data3, data4, data5, data6, data7, data8, data9, data10,data11};

                        LinearRegression lr = new LinearRegression(x, y);
                        json12.put("name", "2022");
                        if (lr.predict(10) < 0) {
                            json12.put("y", 0.0);
                        } else {
                            json12.put("y", lr.predict(11));
                        }
                         
                       

                        jarray1.put(json4);
                        jarray1.put(json5);
                        jarray1.put(json6);
                        jarray1.put(json7);
                        jarray1.put(json8);
                        jarray1.put(json9);
                        jarray1.put(json10);
                        
                        jarray1.put(json2);
                        jarray1.put(json3);
                        jarray1.put(json11);
                        jarray1.put(json12);



                    }
                    PreparedStatement psm4 = con.prepareStatement(" SELECT (SELECT `ABpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2021') AS y2021,(SELECT `ABpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2012') AS y2012,(SELECT `ABpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2013') AS y2013,(SELECT `ABpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2014') AS y2014,(SELECT `ABpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2015') AS y2015,(SELECT `ABpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2016') AS y2016,(SELECT `ABpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2017') AS y2017,(SELECT `ABpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2018') AS y2018,(SELECT `ABpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2019') AS y2019,(SELECT `ABpos` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2020') AS y2020");
                    ResultSet rs4 = psm4.executeQuery();
                    JSONArray jarray3 = new JSONArray();
                    if (rs4.next()) {
                        JSONObject json2 = new JSONObject();
                        JSONObject json3 = new JSONObject();
                        JSONObject json4 = new JSONObject();
                        JSONObject json5 = new JSONObject();
                        JSONObject json6 = new JSONObject();
                        JSONObject json7 = new JSONObject();
                        JSONObject json8 = new JSONObject();
                        JSONObject json9 = new JSONObject();
                        JSONObject json10 = new JSONObject();
                        JSONObject json11 = new JSONObject();
                         JSONObject json12 = new JSONObject();

                    

                        json4.put("name", "2021");
                        json4.put("y", Float.parseFloat(rs4.getString("y2021")));

                        json5.put("name", "2012");
                        json5.put("y", Float.parseFloat(rs4.getString("y2012")));

                        json6.put("name", "2013");
                        json6.put("y", Float.parseFloat(rs4.getString("y2013")));

                        json7.put("name", "2014");
                        json7.put("y", Float.parseFloat(rs4.getString("y2014")));

                        json8.put("name", "2015");
                        json8.put("y", Float.parseFloat(rs4.getString("y2015")));

                        json9.put("name", "2016");
                        json9.put("y", Float.parseFloat(rs4.getString("y2016")));

                        json10.put("name", "2017");
                        json10.put("y", Float.parseFloat(rs4.getString("y2017")));
                        
                            json2.put("name", "2018");
                        json2.put("y", Float.parseFloat(rs4.getString("y2018")));

                        json3.put("name", "2019");
                        json3.put("y", Float.parseFloat(rs4.getString("y2019")));
                        
                      json11.put("name", "2020");
                        json11.put("y", Float.parseFloat(rs4.getString("y2020")));

                        float data1, data2, data3, data4, data5, data6, data7, data8, data9, data10,data11;

                        
                        data4 = Float.parseFloat(rs4.getString("y2021"));
                        data5 = Float.parseFloat(rs4.getString("y2012"));
                        data6 = Float.parseFloat(rs4.getString("y2013"));
                        data7 = Float.parseFloat(rs4.getString("y2014"));
                        data8 = Float.parseFloat(rs4.getString("y2015"));
                        data9 = Float.parseFloat(rs4.getString("y2016"));
                        data10 = Float.parseFloat(rs4.getString("y2017"));
                        data2 = Float.parseFloat(rs4.getString("y2018"));
                        data3 = Float.parseFloat(rs4.getString("y2019"));
                      data11 = Float.parseFloat(rs4.getString("y2020"));

                        double x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
                        double y[] = {data2, data3, data4, data5, data6, data7, data8, data9, data10,data11};

                        LinearRegression lr = new LinearRegression(x, y);
                        json12.put("name", "2022");
                        if (lr.predict(10) < 0) {
                            json12.put("y", 0.0);
                        } else {
                            json12.put("y", lr.predict(11));
                        }
                                            
                        
                      
                        jarray3.put(json4);
                        jarray3.put(json5);
                        jarray3.put(json6);
                        jarray3.put(json7);
                        jarray3.put(json8);
                        jarray3.put(json9);
                        jarray3.put(json10);
                          jarray3.put(json2);
                        jarray3.put(json3);
                         jarray3.put(json11);
                        jarray3.put(json12);

                    }
                   
                     

                    JSONObject json = new JSONObject();
                    //json.put("name", "Fog");
                    //json.put("data", jarray);

                    JSONObject json1 = new JSONObject();
                    json1.put("name", "O+");
                    json1.put("data", jarray);
                    
                    JSONObject json2 = new JSONObject();
                    json2.put("name", "A+");
                    json2.put("data", jarray1);
                    
                    JSONObject json3 = new JSONObject();
                    json3.put("name", "B+");
                    json3.put("data", jarray2);
                    
                     JSONObject json4 = new JSONObject();
                    json4.put("name", "AB+");
                    json4.put("data", jarray3);
                 
                      
                    jaray.put(json);
                    jaray.put(json1);
                    jaray.put(json2);
                    jaray.put(json3);
                    jaray.put(json4);
                  
                    out.print(jaray);
           
            

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
             else  if (ctype.equals("Bloodgroup2")) {
                JSONArray jaray = new JSONArray();
                try {
                     PreparedStatement psm = con.prepareStatement(" SELECT (SELECT `Oneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2021') AS y2021,(SELECT `Oneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2012') AS y2012,(SELECT `Oneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2013') AS y2013,(SELECT `Oneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2014') AS y2014,(SELECT `Oneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2015') AS y2015,(SELECT `Oneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2016') AS y2016,(SELECT `Oneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2017') AS y2017,(SELECT `Oneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2018') AS y2018,(SELECT `Oneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2019') AS y2019,(SELECT `Oneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2020') AS y2020");
                    ResultSet rs = psm.executeQuery();
                    JSONArray jarray = new JSONArray();
                    if (rs.next()) {
                        JSONObject json2 = new JSONObject();
                        JSONObject json3 = new JSONObject();
                        JSONObject json4 = new JSONObject();
                        JSONObject json5 = new JSONObject();
                        JSONObject json6 = new JSONObject();
                        JSONObject json7 = new JSONObject();
                        JSONObject json8 = new JSONObject();
                        JSONObject json9 = new JSONObject();
                        JSONObject json10 = new JSONObject();
                        JSONObject json11 = new JSONObject();
                        JSONObject json12 = new JSONObject();

                       

                        json4.put("name", "2021");
                        json4.put("y", Float.parseFloat(rs.getString("y2021")));

                        json5.put("name", "2012");
                        json5.put("y", Float.parseFloat(rs.getString("y2012")));

                        json6.put("name", "2013");
                        json6.put("y", Float.parseFloat(rs.getString("y2013")));

                        json7.put("name", "2014");
                        json7.put("y", Float.parseFloat(rs.getString("y2014")));

                        json8.put("name", "2015");
                        json8.put("y", Float.parseFloat(rs.getString("y2015")));

                        json9.put("name", "2016");
                        json9.put("y", Float.parseFloat(rs.getString("y2016")));

                        json10.put("name", "2017");
                        json10.put("y", Float.parseFloat(rs.getString("y2017")));
                        
                         json2.put("name", "2018");
                        json2.put("y", Float.parseFloat(rs.getString("y2018")));

                        json3.put("name", "2019");
                        json3.put("y", Float.parseFloat(rs.getString("y2019")));
                        
                        json11.put("name", "2020");
                        json11.put("y", Float.parseFloat(rs.getString("y2020")));

                        float  data2, data3, data4, data5, data6, data7, data8, data9, data10,data11;

                        
                        data4 = Float.parseFloat(rs.getString("Y2021"));
                        data5 = Float.parseFloat(rs.getString("Y2012"));
                        data6 = Float.parseFloat(rs.getString("Y2013"));
                        data7 = Float.parseFloat(rs.getString("Y2014"));
                        data8 = Float.parseFloat(rs.getString("Y2015"));
                        data9 = Float.parseFloat(rs.getString("Y2016"));
                        data10 = Float.parseFloat(rs.getString("Y2017"));
                        data2 = Float.parseFloat(rs.getString("Y2018"));
                        data3 = Float.parseFloat(rs.getString("Y2019"));
                        data11 = Float.parseFloat(rs.getString("Y2020"));

                        double x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
                        double y[] = {data2, data3, data4, data5, data6, data7, data8, data9, data10,data11};

                        LinearRegression lr = new LinearRegression(x, y);
                        json12.put("name", "2022");
                        if (lr.predict(10) < 0) {
                            json12.put("y", 0.0);
                        
                   } else {
                            json12.put("y", lr.predict(11));
                        }
                        
                         

                        

                     
                        jarray.put(json4);
                        jarray.put(json5);
                        jarray.put(json6);
                        jarray.put(json7);
                        jarray.put(json8);
                        jarray.put(json9);
                        jarray.put(json10);
                        jarray.put(json2);
                        jarray.put(json3);
                        jarray.put(json11);
                        jarray.put(json12);
                    }
                   
                     PreparedStatement psm2 = con.prepareStatement(" SELECT (SELECT `Aneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2021') AS y2021,(SELECT `Aneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2012') AS y2012,(SELECT `Aneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2013') AS y2013,(SELECT `Aneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2014') AS y2014,(SELECT `Aneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2015') AS y2015,(SELECT `Aneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2016') AS y2016,(SELECT `Aneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2017') AS y2017,(SELECT `Aneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2018') AS y2018,(SELECT `Aneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2019') AS y2019,(SELECT `Aneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2020') AS y2020");
                    ResultSet rs2 = psm2.executeQuery();
                    JSONArray jarray2 = new JSONArray();
                    if (rs2.next()) {
                       JSONObject json2 = new JSONObject();
                        JSONObject json3 = new JSONObject();
                        JSONObject json4 = new JSONObject();
                        JSONObject json5 = new JSONObject();
                        JSONObject json6 = new JSONObject();
                        JSONObject json7 = new JSONObject();
                        JSONObject json8 = new JSONObject();
                        JSONObject json9 = new JSONObject();
                        JSONObject json10 = new JSONObject();
                       JSONObject json11 = new JSONObject();
                        JSONObject json12 = new JSONObject();

                     

                        json4.put("name", "2021");
                        json4.put("y", Float.parseFloat(rs2.getString("y2021")));

                        json5.put("name", "2012");
                        json5.put("y", Float.parseFloat(rs2.getString("y2012")));

                        json6.put("name", "2013");
                        json6.put("y", Float.parseFloat(rs2.getString("y2013")));

                        json7.put("name", "2014");
                        json7.put("y", Float.parseFloat(rs2.getString("y2014")));

                        json8.put("name", "2015");
                        json8.put("y", Float.parseFloat(rs2.getString("y2015")));

                        json9.put("name", "2016");
                        json9.put("y", Float.parseFloat(rs2.getString("y2016")));

                        json10.put("name", "2017");
                        json10.put("y", Float.parseFloat(rs2.getString("y2017")));
                        
                           json2.put("name", "2018");
                        json2.put("y", Float.parseFloat(rs2.getString("y2018")));

                        json3.put("name", "2019");
                        json3.put("y", Float.parseFloat(rs2.getString("y2019")));
                        
                        json11.put("name", "2020");
                        json11.put("y", Float.parseFloat(rs2.getString("y2020")));

                        float  data2, data3, data4, data5, data6, data7, data8, data9, data10,data11;

                        
                        data4 = Float.parseFloat(rs2.getString("Y2021"));
                        data5 = Float.parseFloat(rs2.getString("Y2012"));
                        data6 = Float.parseFloat(rs2.getString("Y2013"));
                        data7 = Float.parseFloat(rs2.getString("Y2014"));
                        data8 = Float.parseFloat(rs2.getString("Y2015"));
                        data9 = Float.parseFloat(rs2.getString("Y2016"));
                        data10 = Float.parseFloat(rs2.getString("Y2017"));
                        data2 = Float.parseFloat(rs2.getString("Y2018"));
                        data3 = Float.parseFloat(rs2.getString("Y2019"));
                       data11 = Float.parseFloat(rs2.getString("Y2020"));

                        double x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
                        double y[] = {data2, data3, data4, data5, data6, data7, data8, data9, data10,data11};

                        LinearRegression lr = new LinearRegression(x, y);
                        json12.put("name", "2022");
                        if (lr.predict(10) < 0) {
                            json12.put("y", 0.0);
                        } else {
                            json12.put("y", lr.predict(11));
                        }
                        
                       

                        jarray2.put(json2);
                        jarray2.put(json3);
                        jarray2.put(json4);
                        jarray2.put(json5);
                        jarray2.put(json6);
                        jarray2.put(json7);
                        jarray2.put(json8);
                        jarray2.put(json9);
                        jarray2.put(json10);
                        jarray2.put(json11);
                        jarray2.put(json12);


                    }
                    PreparedStatement psm1 = con.prepareStatement(" SELECT (SELECT `Bneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2021') AS y2021,(SELECT `Bneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2012') AS y2012,(SELECT `Bneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2013') AS y2013,(SELECT `Bneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2014') AS y2014,(SELECT `Bneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2015') AS y2015,(SELECT `Bneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2016') AS y2016,(SELECT `Bneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2017') AS y2017,(SELECT `Bneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2018') AS y2018,(SELECT `Bneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2019') AS y2019,(SELECT `Bneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2020') AS y2020 ");
                    ResultSet rs1 = psm1.executeQuery();
                    JSONArray jarray1 = new JSONArray();
                    if (rs1.next()) {
                     JSONObject json2 = new JSONObject();
                        JSONObject json3 = new JSONObject();
                        JSONObject json4 = new JSONObject();
                        JSONObject json5 = new JSONObject();
                        JSONObject json6 = new JSONObject();
                        JSONObject json7 = new JSONObject();
                        JSONObject json8 = new JSONObject();
                        JSONObject json9 = new JSONObject();
                        JSONObject json10 = new JSONObject();
                        JSONObject json11 = new JSONObject();
                        JSONObject json12 = new JSONObject();

                      

                        json4.put("name", "2021");
                        json4.put("y", Float.parseFloat(rs1.getString("y2021")));

                        json5.put("name", "2012");
                        json5.put("y", Float.parseFloat(rs1.getString("y2012")));

                        json6.put("name", "2013");
                        json6.put("y", Float.parseFloat(rs1.getString("y2013")));

                        json7.put("name", "2014");
                        json7.put("y", Float.parseFloat(rs1.getString("y2014")));

                        json8.put("name", "2015");
                        json8.put("y", Float.parseFloat(rs1.getString("y2015")));

                        json9.put("name", "2016");
                        json9.put("y", Float.parseFloat(rs1.getString("y2016")));

                        json10.put("name", "2017");
                        json10.put("y", Float.parseFloat(rs1.getString("y2017")));
                        
                          json2.put("name", "2018");
                        json2.put("y", Float.parseFloat(rs1.getString("y2018")));

                        json3.put("name", "2019");
                        json3.put("y", Float.parseFloat(rs1.getString("y2019")));
                        
                       json11.put("name", "2020");
                       json11.put("y", Float.parseFloat(rs1.getString("y2020")));

                        float  data2, data3, data4, data5, data6, data7, data8, data9, data10,data11;

                    
                        data4 = Float.parseFloat(rs1.getString("Y2021"));
                        data5 = Float.parseFloat(rs1.getString("Y2012"));
                        data6 = Float.parseFloat(rs1.getString("Y2013"));
                        data7 = Float.parseFloat(rs1.getString("Y2014"));
                        data8 = Float.parseFloat(rs1.getString("Y2015"));
                        data9 = Float.parseFloat(rs1.getString("Y2016"));
                        data10 = Float.parseFloat(rs1.getString("Y2017"));
                            data2 = Float.parseFloat(rs1.getString("Y2018"));
                        data3 = Float.parseFloat(rs1.getString("Y2019"));
                         data11 = Float.parseFloat(rs1.getString("Y2020"));

                        double x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
                        double y[] = {data2, data3, data4, data5, data6, data7, data8, data9, data10,data11};

                        LinearRegression lr = new LinearRegression(x, y);
                        json12.put("name", "2022");
                        if (lr.predict(10) < 0) {
                            json12.put("y", 0.0);
                        } else {
                            json12.put("y", lr.predict(11));
                        }
                         
                       

                        jarray1.put(json4);
                        jarray1.put(json5);
                        jarray1.put(json6);
                        jarray1.put(json7);
                        jarray1.put(json8);
                        jarray1.put(json9);
                        jarray1.put(json10);
                        
                        jarray1.put(json2);
                        jarray1.put(json3);
                        jarray1.put(json11);
                        jarray1.put(json12);


                    }
                    PreparedStatement psm4 = con.prepareStatement(" SELECT (SELECT `ABneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2021') AS y2021,(SELECT `ABneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2012') AS y2012,(SELECT `ABneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2013') AS y2013,(SELECT `ABneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2014') AS y2014,(SELECT `ABneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2015') AS y2015,(SELECT `ABneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2016') AS y2016,(SELECT `ABneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2017') AS y2017,(SELECT `ABneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2018') AS y2018,(SELECT `ABneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2019') AS y2019,(SELECT `ABneg` FROM `bloodgroup` WHERE `region`='" + state + "' AND `Year`='2020') AS y2020");
                    ResultSet rs4 = psm4.executeQuery();
                    JSONArray jarray3 = new JSONArray();
                    if (rs4.next()) {
                        JSONObject json2 = new JSONObject();
                        JSONObject json3 = new JSONObject();
                        JSONObject json4 = new JSONObject();
                        JSONObject json5 = new JSONObject();
                        JSONObject json6 = new JSONObject();
                        JSONObject json7 = new JSONObject();
                        JSONObject json8 = new JSONObject();
                        JSONObject json9 = new JSONObject();
                        JSONObject json10 = new JSONObject();
                        JSONObject json11 = new JSONObject();
                         JSONObject json12 = new JSONObject();

                    

                        json4.put("name", "2021");
                        json4.put("y", Float.parseFloat(rs4.getString("y2021")));

                        json5.put("name", "2012");
                        json5.put("y", Float.parseFloat(rs4.getString("y2012")));

                        json6.put("name", "2013");
                        json6.put("y", Float.parseFloat(rs4.getString("y2013")));

                        json7.put("name", "2014");
                        json7.put("y", Float.parseFloat(rs4.getString("y2014")));

                        json8.put("name", "2015");
                        json8.put("y", Float.parseFloat(rs4.getString("y2015")));

                        json9.put("name", "2016");
                        json9.put("y", Float.parseFloat(rs4.getString("y2016")));

                        json10.put("name", "2017");
                        json10.put("y", Float.parseFloat(rs4.getString("y2017")));
                        
                            json2.put("name", "2018");
                        json2.put("y", Float.parseFloat(rs4.getString("y2018")));

                        json3.put("name", "2019");
                        json3.put("y", Float.parseFloat(rs4.getString("y2019")));
                        
                      json11.put("name", "2020");
                        json11.put("y", Float.parseFloat(rs4.getString("y2020")));

                        float data1, data2, data3, data4, data5, data6, data7, data8, data9, data10,data11;

                        
                        data4 = Float.parseFloat(rs4.getString("y2021"));
                        data5 = Float.parseFloat(rs4.getString("y2012"));
                        data6 = Float.parseFloat(rs4.getString("y2013"));
                        data7 = Float.parseFloat(rs4.getString("y2014"));
                        data8 = Float.parseFloat(rs4.getString("y2015"));
                        data9 = Float.parseFloat(rs4.getString("y2016"));
                        data10 = Float.parseFloat(rs4.getString("y2017"));
                        data2 = Float.parseFloat(rs4.getString("y2018"));
                        data3 = Float.parseFloat(rs4.getString("y2019"));
                      data11 = Float.parseFloat(rs4.getString("y2020"));

                        double x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
                        double y[] = {data2, data3, data4, data5, data6, data7, data8, data9, data10,data11};

                        LinearRegression lr = new LinearRegression(x, y);
                        json12.put("name", "2022");
                        if (lr.predict(10) < 0) {
                            json12.put("y", 0.0);
                        } else {
                            json12.put("y", lr.predict(11));
                        }
                                            
                        
                      
                        jarray3.put(json4);
                        jarray3.put(json5);
                        jarray3.put(json6);
                        jarray3.put(json7);
                        jarray3.put(json8);
                        jarray3.put(json9);
                        jarray3.put(json10);
                          jarray3.put(json2);
                        jarray3.put(json3);
                         jarray3.put(json11);
                        jarray3.put(json12);

                    }
                   
                     

                    JSONObject json = new JSONObject();
                    //json.put("name", "Fog");
                    //json.put("data", jarray);

                    JSONObject json1 = new JSONObject();
                    json1.put("name", "O-");
                    json1.put("data", jarray);
                    
                    JSONObject json2 = new JSONObject();
                    json2.put("name", "A-");
                    json2.put("data", jarray1);
                    
                    JSONObject json3 = new JSONObject();
                    json3.put("name", "B-");
                    json3.put("data", jarray2);
                    
                     JSONObject json4 = new JSONObject();
                    json4.put("name", "AB-");
                    json4.put("data", jarray3);
                 
                      
                    jaray.put(json);
                    jaray.put(json1);
                    jaray.put(json2);
                    jaray.put(json3);
                    jaray.put(json4);
                  
                    out.print(jaray);
           
            

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
             else  if (ctype.equals("Age")) {
                JSONArray jaray = new JSONArray();
                try {
                     PreparedStatement psm = con.prepareStatement(" SELECT (SELECT `Age18` FROM `age` WHERE `region`='" + state + "' AND `Year`='2021') AS y2021,(SELECT `Age18` FROM `age` WHERE `region`='" + state + "' AND `Year`='2012') AS y2012,(SELECT `Age18` FROM `age` WHERE `region`='" + state + "' AND `Year`='2013') AS y2013,(SELECT `Age18` FROM `age` WHERE `region`='" + state + "' AND `Year`='2014') AS y2014,(SELECT `Age18` FROM `age` WHERE `region`='" + state + "' AND `Year`='2015') AS y2015,(SELECT `Age18` FROM `age` WHERE `region`='" + state + "' AND `Year`='2016') AS y2016,(SELECT `Age18` FROM `age` WHERE `region`='" + state + "' AND `Year`='2017') AS y2017,(SELECT `Age18` FROM `age` WHERE `region`='" + state + "' AND `Year`='2018') AS y2018,(SELECT `Age18` FROM `age` WHERE `region`='" + state + "' AND `Year`='2019') AS y2019,(SELECT `Age18` FROM `age` WHERE `region`='" + state + "' AND `Year`='2020') AS y2020");
                    ResultSet rs = psm.executeQuery();
                    JSONArray jarray = new JSONArray();
                    if (rs.next()) {
                        JSONObject json2 = new JSONObject();
                        JSONObject json3 = new JSONObject();
                        JSONObject json4 = new JSONObject();
                        JSONObject json5 = new JSONObject();
                        JSONObject json6 = new JSONObject();
                        JSONObject json7 = new JSONObject();
                        JSONObject json8 = new JSONObject();
                        JSONObject json9 = new JSONObject();
                        JSONObject json10 = new JSONObject();
                        JSONObject json11 = new JSONObject();
                        JSONObject json12 = new JSONObject();

                       

                        json4.put("name", "2021");
                        json4.put("y", Float.parseFloat(rs.getString("y2021")));

                        json5.put("name", "2012");
                        json5.put("y", Float.parseFloat(rs.getString("y2012")));

                        json6.put("name", "2013");
                        json6.put("y", Float.parseFloat(rs.getString("y2013")));

                        json7.put("name", "2014");
                        json7.put("y", Float.parseFloat(rs.getString("y2014")));

                        json8.put("name", "2015");
                        json8.put("y", Float.parseFloat(rs.getString("y2015")));

                        json9.put("name", "2016");
                        json9.put("y", Float.parseFloat(rs.getString("y2016")));

                        json10.put("name", "2017");
                        json10.put("y", Float.parseFloat(rs.getString("y2017")));
                        
                         json2.put("name", "2018");
                        json2.put("y", Float.parseFloat(rs.getString("y2018")));

                        json3.put("name", "2019");
                        json3.put("y", Float.parseFloat(rs.getString("y2019")));
                        
                        json11.put("name", "2020");
                        json11.put("y", Float.parseFloat(rs.getString("y2020")));

                        float  data2, data3, data4, data5, data6, data7, data8, data9, data10,data11;

                        
                        data4 = Float.parseFloat(rs.getString("Y2021"));
                        data5 = Float.parseFloat(rs.getString("Y2012"));
                        data6 = Float.parseFloat(rs.getString("Y2013"));
                        data7 = Float.parseFloat(rs.getString("Y2014"));
                        data8 = Float.parseFloat(rs.getString("Y2015"));
                        data9 = Float.parseFloat(rs.getString("Y2016"));
                        data10 = Float.parseFloat(rs.getString("Y2017"));
                        data2 = Float.parseFloat(rs.getString("Y2018"));
                        data3 = Float.parseFloat(rs.getString("Y2019"));
                        data11 = Float.parseFloat(rs.getString("Y2020"));

                        double x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
                        double y[] = {data2, data3, data4, data5, data6, data7, data8, data9, data10,data11};

                        LinearRegression lr = new LinearRegression(x, y);
                        json12.put("name", "2022");
                        if (lr.predict(10) < 0) {
                            json12.put("y", 0.0);
                        
                   } else {
                            json12.put("y", lr.predict(11));
                        }
                        
                         

                        

                     
                        jarray.put(json4);
                        jarray.put(json5);
                        jarray.put(json6);
                        jarray.put(json7);
                        jarray.put(json8);
                        jarray.put(json9);
                        jarray.put(json10);
                        jarray.put(json2);
                        jarray.put(json3);
                        jarray.put(json11);
                        jarray.put(json12);
                    }
                    PreparedStatement psm1 = con.prepareStatement(" SELECT (SELECT `Age21` FROM `age` WHERE `region`='" + state + "' AND `Year`='2021') AS y2021,(SELECT `Age21` FROM `age` WHERE `region`='" + state + "' AND `Year`='2012') AS y2012,(SELECT `Age21` FROM `age` WHERE `region`='" + state + "' AND `Year`='2013') AS y2013,(SELECT `Age21` FROM `age` WHERE `region`='" + state + "' AND `Year`='2014') AS y2014,(SELECT `Age21` FROM `age` WHERE `region`='" + state + "' AND `Year`='2015') AS y2015,(SELECT `Age21` FROM `age` WHERE `region`='" + state + "' AND `Year`='2016') AS y2016,(SELECT `Age21` FROM `age` WHERE `region`='" + state + "' AND `Year`='2017') AS y2017,(SELECT `Age21` FROM `age` WHERE `region`='" + state + "' AND `Year`='2018') AS y2018,(SELECT `Age21` FROM `age` WHERE `region`='" + state + "' AND `Year`='2019') AS y2019,(SELECT `Age21` FROM `age` WHERE `region`='" + state + "' AND `Year`='2020') AS y2020 ");
                    ResultSet rs1 = psm1.executeQuery();
                    JSONArray jarray1 = new JSONArray();
                    if (rs1.next()) {
                      JSONObject json2 = new JSONObject();
                        JSONObject json3 = new JSONObject();
                        JSONObject json4 = new JSONObject();
                        JSONObject json5 = new JSONObject();
                        JSONObject json6 = new JSONObject();
                        JSONObject json7 = new JSONObject();
                        JSONObject json8 = new JSONObject();
                        JSONObject json9 = new JSONObject();
                        JSONObject json10 = new JSONObject();
                        JSONObject json11 = new JSONObject();
                        JSONObject json12 = new JSONObject();

                      

                        json4.put("name", "2021");
                        json4.put("y", Float.parseFloat(rs1.getString("y2021")));

                        json5.put("name", "2012");
                        json5.put("y", Float.parseFloat(rs1.getString("y2012")));

                        json6.put("name", "2013");
                        json6.put("y", Float.parseFloat(rs1.getString("y2013")));

                        json7.put("name", "2014");
                        json7.put("y", Float.parseFloat(rs1.getString("y2014")));

                        json8.put("name", "2015");
                        json8.put("y", Float.parseFloat(rs1.getString("y2015")));

                        json9.put("name", "2016");
                        json9.put("y", Float.parseFloat(rs1.getString("y2016")));

                        json10.put("name", "2017");
                        json10.put("y", Float.parseFloat(rs1.getString("y2017")));
                        
                          json2.put("name", "2018");
                        json2.put("y", Float.parseFloat(rs1.getString("y2018")));

                        json3.put("name", "2019");
                        json3.put("y", Float.parseFloat(rs1.getString("y2019")));
                        
                       json11.put("name", "2020");
                       json11.put("y", Float.parseFloat(rs1.getString("y2020")));

                        float  data2, data3, data4, data5, data6, data7, data8, data9, data10,data11;

                    
                        data4 = Float.parseFloat(rs1.getString("Y2021"));
                        data5 = Float.parseFloat(rs1.getString("Y2012"));
                        data6 = Float.parseFloat(rs1.getString("Y2013"));
                        data7 = Float.parseFloat(rs1.getString("Y2014"));
                        data8 = Float.parseFloat(rs1.getString("Y2015"));
                        data9 = Float.parseFloat(rs1.getString("Y2016"));
                        data10 = Float.parseFloat(rs1.getString("Y2017"));
                            data2 = Float.parseFloat(rs1.getString("Y2018"));
                        data3 = Float.parseFloat(rs1.getString("Y2019"));
                         data11 = Float.parseFloat(rs1.getString("Y2020"));

                        double x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
                        double y[] = {data2, data3, data4, data5, data6, data7, data8, data9, data10,data11};

                        LinearRegression lr = new LinearRegression(x, y);
                        json12.put("name", "2022");
                        if (lr.predict(10) < 0) {
                            json12.put("y", 0.0);
                        } else {
                            json12.put("y", lr.predict(11));
                        }
                         
                       

                        jarray1.put(json4);
                        jarray1.put(json5);
                        jarray1.put(json6);
                        jarray1.put(json7);
                        jarray1.put(json8);
                        jarray1.put(json9);
                        jarray1.put(json10);
                        
                        jarray1.put(json2);
                        jarray1.put(json3);
                        jarray1.put(json11);
                        jarray1.put(json12);



                    }
                    PreparedStatement psm2 = con.prepareStatement(" SELECT (SELECT `Age41` FROM `age` WHERE `region`='" + state + "' AND `Year`='2021') AS y2021,(SELECT `Age41` FROM `age` WHERE `region`='" + state + "' AND `Year`='2012') AS y2012,(SELECT `Age41` FROM `age` WHERE `region`='" + state + "' AND `Year`='2013') AS y2013,(SELECT `Age41` FROM `age` WHERE `region`='" + state + "' AND `Year`='2014') AS y2014,(SELECT `Age41` FROM `age` WHERE `region`='" + state + "' AND `Year`='2015') AS y2015,(SELECT `Age41` FROM `age` WHERE `region`='" + state + "' AND `Year`='2016') AS y2016,(SELECT `Age41` FROM `age` WHERE `region`='" + state + "' AND `Year`='2017') AS y2017,(SELECT `Age41` FROM `age` WHERE `region`='" + state + "' AND `Year`='2018') AS y2018,(SELECT `Age41` FROM `age` WHERE `region`='" + state + "' AND `Year`='2019') AS y2019,(SELECT `Age41` FROM `age` WHERE `region`='" + state + "' AND `Year`='2020') AS y2020 ");
                    ResultSet rs2 = psm2.executeQuery();
                    JSONArray jarray2 = new JSONArray();
                    if (rs2.next()) {
                         JSONObject json2 = new JSONObject();
                        JSONObject json3 = new JSONObject();
                        JSONObject json4 = new JSONObject();
                        JSONObject json5 = new JSONObject();
                        JSONObject json6 = new JSONObject();
                        JSONObject json7 = new JSONObject();
                        JSONObject json8 = new JSONObject();
                        JSONObject json9 = new JSONObject();
                        JSONObject json10 = new JSONObject();
                       JSONObject json11 = new JSONObject();
                        JSONObject json12 = new JSONObject();

                     

                        json4.put("name", "2021");
                        json4.put("y", Float.parseFloat(rs2.getString("y2021")));

                        json5.put("name", "2012");
                        json5.put("y", Float.parseFloat(rs2.getString("y2012")));

                        json6.put("name", "2013");
                        json6.put("y", Float.parseFloat(rs2.getString("y2013")));

                        json7.put("name", "2014");
                        json7.put("y", Float.parseFloat(rs2.getString("y2014")));

                        json8.put("name", "2015");
                        json8.put("y", Float.parseFloat(rs2.getString("y2015")));

                        json9.put("name", "2016");
                        json9.put("y", Float.parseFloat(rs2.getString("y2016")));

                        json10.put("name", "2017");
                        json10.put("y", Float.parseFloat(rs2.getString("y2017")));
                        
                           json2.put("name", "2018");
                        json2.put("y", Float.parseFloat(rs2.getString("y2018")));

                        json3.put("name", "2019");
                        json3.put("y", Float.parseFloat(rs2.getString("y2019")));
                        
                        json11.put("name", "2020");
                        json11.put("y", Float.parseFloat(rs2.getString("y2020")));

                        float  data2, data3, data4, data5, data6, data7, data8, data9, data10,data11;

                        
                        data4 = Float.parseFloat(rs2.getString("Y2021"));
                        data5 = Float.parseFloat(rs2.getString("Y2012"));
                        data6 = Float.parseFloat(rs2.getString("Y2013"));
                        data7 = Float.parseFloat(rs2.getString("Y2014"));
                        data8 = Float.parseFloat(rs2.getString("Y2015"));
                        data9 = Float.parseFloat(rs2.getString("Y2016"));
                        data10 = Float.parseFloat(rs2.getString("Y2017"));
                        data2 = Float.parseFloat(rs2.getString("Y2018"));
                        data3 = Float.parseFloat(rs2.getString("Y2019"));
                       data11 = Float.parseFloat(rs2.getString("Y2020"));

                        double x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
                        double y[] = {data2, data3, data4, data5, data6, data7, data8, data9, data10,data11};

                        LinearRegression lr = new LinearRegression(x, y);
                        json12.put("name", "2022");
                        if (lr.predict(10) < 0) {
                            json12.put("y", 0.0);
                        } else {
                            json12.put("y", lr.predict(11));
                        }
                        
                       

                        jarray2.put(json2);
                        jarray2.put(json3);
                        jarray2.put(json4);
                        jarray2.put(json5);
                        jarray2.put(json6);
                        jarray2.put(json7);
                        jarray2.put(json8);
                        jarray2.put(json9);
                        jarray2.put(json10);
                        jarray2.put(json11);
                        jarray2.put(json12);

                    }
                     PreparedStatement psm4 = con.prepareStatement(" SELECT (SELECT `Age60` FROM `age` WHERE `region`='" + state + "' AND `Year`='2021') AS y2021,(SELECT `Age60` FROM `age` WHERE `region`='" + state + "' AND `Year`='2012') AS y2012,(SELECT `Age60` FROM `age` WHERE `region`='" + state + "' AND `Year`='2013') AS y2013,(SELECT `Age60` FROM `age` WHERE `region`='" + state + "' AND `Year`='2014') AS y2014,(SELECT `Age60` FROM `age` WHERE `region`='" + state + "' AND `Year`='2015') AS y2015,(SELECT `Age60` FROM `age` WHERE `region`='" + state + "' AND `Year`='2016') AS y2016,(SELECT `Age60` FROM `age` WHERE `region`='" + state + "' AND `Year`='2017') AS y2017,(SELECT `Age60` FROM `age` WHERE `region`='" + state + "' AND `Year`='2018') AS y2018,(SELECT `Age60` FROM `age` WHERE `region`='" + state + "' AND `Year`='2019') AS y2019,(SELECT `Age60` FROM `age` WHERE `region`='" + state + "' AND `Year`='2020') AS y2020 ");
                    ResultSet rs4 = psm4.executeQuery();
                    JSONArray jarray3 = new JSONArray();
                    if (rs4.next()) {
                        JSONObject json2 = new JSONObject();
                        JSONObject json3 = new JSONObject();
                        JSONObject json4 = new JSONObject();
                        JSONObject json5 = new JSONObject();
                        JSONObject json6 = new JSONObject();
                        JSONObject json7 = new JSONObject();
                        JSONObject json8 = new JSONObject();
                        JSONObject json9 = new JSONObject();
                        JSONObject json10 = new JSONObject();
                        JSONObject json11 = new JSONObject();
                         JSONObject json12 = new JSONObject();

                    

                        json4.put("name", "2021");
                        json4.put("y", Float.parseFloat(rs4.getString("y2021")));

                        json5.put("name", "2012");
                        json5.put("y", Float.parseFloat(rs4.getString("y2012")));

                        json6.put("name", "2013");
                        json6.put("y", Float.parseFloat(rs4.getString("y2013")));

                        json7.put("name", "2014");
                        json7.put("y", Float.parseFloat(rs4.getString("y2014")));

                        json8.put("name", "2015");
                        json8.put("y", Float.parseFloat(rs4.getString("y2015")));

                        json9.put("name", "2016");
                        json9.put("y", Float.parseFloat(rs4.getString("y2016")));

                        json10.put("name", "2017");
                        json10.put("y", Float.parseFloat(rs4.getString("y2017")));
                        
                            json2.put("name", "2018");
                        json2.put("y", Float.parseFloat(rs4.getString("y2018")));

                        json3.put("name", "2019");
                        json3.put("y", Float.parseFloat(rs4.getString("y2019")));
                        
                      json11.put("name", "2020");
                        json11.put("y", Float.parseFloat(rs4.getString("y2020")));

                        float data1, data2, data3, data4, data5, data6, data7, data8, data9, data10,data11;

                        
                        data4 = Float.parseFloat(rs4.getString("y2021"));
                        data5 = Float.parseFloat(rs4.getString("y2012"));
                        data6 = Float.parseFloat(rs4.getString("y2013"));
                        data7 = Float.parseFloat(rs4.getString("y2014"));
                        data8 = Float.parseFloat(rs4.getString("y2015"));
                        data9 = Float.parseFloat(rs4.getString("y2016"));
                        data10 = Float.parseFloat(rs4.getString("y2017"));
                        data2 = Float.parseFloat(rs4.getString("y2018"));
                        data3 = Float.parseFloat(rs4.getString("y2019"));
                      data11 = Float.parseFloat(rs4.getString("y2020"));

                        double x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
                        double y[] = {data2, data3, data4, data5, data6, data7, data8, data9, data10,data11};

                        LinearRegression lr = new LinearRegression(x, y);
                        json12.put("name", "2022");
                        if (lr.predict(10) < 0) {
                            json12.put("y", 0.0);
                        } else {
                            json12.put("y", lr.predict(11));
                        }
                                            
                        
                      
                        jarray3.put(json4);
                        jarray3.put(json5);
                        jarray3.put(json6);
                        jarray3.put(json7);
                        jarray3.put(json8);
                        jarray3.put(json9);
                        jarray3.put(json10);
                          jarray3.put(json2);
                        jarray3.put(json3);
                         jarray3.put(json11);
                        jarray3.put(json12);

                    

                    }

                    JSONObject json = new JSONObject();
                    //json.put("name", "Fog");
                    //json.put("data", jarray);

                    JSONObject json1 = new JSONObject();
                    json1.put("name", "Age 18-20");
                    json1.put("data", jarray);
                    
                     JSONObject json2 = new JSONObject();
                    json2.put("name", "Age 20-40");
                    json2.put("data", jarray1);
                    
                     JSONObject json3 = new JSONObject();
                    json3.put("name", "Age 41-60");
                    json3.put("data", jarray2);
                    
                    JSONObject json4 = new JSONObject();
                    json4.put("name", "Age 60 and above");
                    json4.put("data", jarray3);
                    
                    
                    
                        
                   
                    
                    jaray.put(json);
                    jaray.put(json1);
                    jaray.put(json2);
                    jaray.put(json3);
                     jaray.put(json4);
                    
                  
                  
                   
                    
                    out.print(jaray);
           
            

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
