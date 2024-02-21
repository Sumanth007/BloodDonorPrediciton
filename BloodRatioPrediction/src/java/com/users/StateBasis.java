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

/**
 *
 * @author Rakshith
 */
@WebServlet(name = "StateBasis", urlPatterns = {"/StateBasis"})
public class StateBasis extends HttpServlet {

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
            
            String year = request.getParameter("year");
            String ctype = request.getParameter("ctype");
            String csubtype = request.getParameter("csubtype");
            
//            String year = "2008";
//            String ctype = "Alcohol";
//            String csubtype = "-1";
            
            DBsingletone db = DBsingletone.getDbSingletone();
            Connection con = db.getConnection();
            JSONObject js = new JSONObject();
            
            if(ctype.equals("Gender"))
            {
                PreparedStatement ps = con.prepareStatement("SELECT "+csubtype+" as yer,region FROM `gender` WHERE `Year`='"+year+"'  ");
                ResultSet rs = ps.executeQuery();
                JSONArray jarray = new JSONArray();
                JSONArray jarray1 = new JSONArray();
                JSONArray jarray2 = new JSONArray();
                while(rs.next())
                {
                    JSONObject json1 = new JSONObject();
                    json1.put("name", rs.getString("Region"));
                    json1.put("y", Integer.parseInt(rs.getString("yer")));
                    jarray2.put(rs.getString("Region"));
                    jarray.put(json1);
                }
                
                JSONObject json = new JSONObject();
                json.put("name", year+" - "+ctype);
                json.put("data", jarray);

                jarray1.put(json);
                js.put("aray1", jarray1);
                js.put("aray2", jarray2);
                
                out.print(js);
                //(" SELECT `States` FROM `climatebasedrecords` WHERE `States`!='All india' AND `Year`='2017'");//(SELECT `State` FROM `predictedresult` WHERE `States`!='All india' AND `Category`='Alcohol' AND `PYear`=2018) AS B2018,(SELECT `State` FROM `predict2017` WHERE `States`!='All india' AND `Category`='Alcohol' AND `PYear`=2017) AS C2017");
                
            }
            else if(ctype.equals("Occupation"))
            {
                PreparedStatement ps = con.prepareStatement(" SELECT "+csubtype+" as yer,region FROM `occupation` WHERE `Year`='"+year+"'  ");
                ResultSet rs = ps.executeQuery();
                JSONArray jarray = new JSONArray();
                JSONArray jarray1 = new JSONArray();
                JSONArray jarray2 = new JSONArray();
                while(rs.next())
                {
                    JSONObject json1 = new JSONObject();
                    json1.put("name", rs.getString("Region"));
                    json1.put("y", Integer.parseInt(rs.getString("yer")));
                    jarray2.put(rs.getString("Region"));
                    jarray.put(json1);
                }
                
                JSONObject json = new JSONObject();
                json.put("name", year+" - "+ctype+" - "+csubtype);
                json.put("data", jarray);

                jarray1.put(json);
                js.put("aray1", jarray1);
                js.put("aray2", jarray2);
                
                out.print(js);
            }
            else if(ctype.equals("Bloodgroup"))
            {
                PreparedStatement ps = con.prepareStatement(" SELECT "+csubtype+" as yer,region FROM `bloodgroup` WHERE `Year`='"+year+"' ");
                ResultSet rs = ps.executeQuery();
                JSONArray jarray = new JSONArray();
                JSONArray jarray1 = new JSONArray();
                JSONArray jarray2 = new JSONArray();
                while(rs.next())
                {
                    JSONObject json1 = new JSONObject();
                    json1.put("name", rs.getString("Region"));
                    json1.put("y", Integer.parseInt(rs.getString("yer")));
                    jarray2.put(rs.getString("Region"));
                    jarray.put(json1);
                }
                
                JSONObject json = new JSONObject();
                json.put("name", year+" - "+ctype+" - "+csubtype);
                json.put("data", jarray);

                jarray1.put(json);
                js.put("aray1", jarray1);
                js.put("aray2", jarray2);
                
                out.print(js);
            }
            else 
            {
                PreparedStatement ps = con.prepareStatement(" SELECT "+csubtype+" as yer,region FROM `age` WHERE `Year`='"+year+"'  ");
                ResultSet rs = ps.executeQuery();
                JSONArray jarray = new JSONArray();
                JSONArray jarray1 = new JSONArray();
                JSONArray jarray2 = new JSONArray();
                while(rs.next())
                {
                    JSONObject json1 = new JSONObject();
                    json1.put("name", rs.getString("region"));
                    json1.put("y", Integer.parseInt(rs.getString("yer")));
                    jarray2.put(rs.getString("region"));
                    jarray.put(json1);
                }
                
                JSONObject json = new JSONObject();
                json.put("name", year+" - "+ctype+" - "+csubtype);
                json.put("data", jarray);

                jarray1.put(json);
                js.put("aray1", jarray1);
                js.put("aray2", jarray2);
                
                out.print(js);
            }
            
        }
        catch(Exception e)
        {
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
