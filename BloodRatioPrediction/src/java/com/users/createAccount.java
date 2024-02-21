/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Logger;
import com.database.util.DBsingletone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author suman
 */
public class createAccount extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Authorization Result</title>");  
            out.println("</body>");
            out.println("</html>");
            
            DBsingletone db = DBsingletone.getDbSingletone();
            Connection con = db.getConnection();
            String userName = request.getParameter("userName");
            String passWord = request.getParameter("passWord");
            String person = request.getParameter("radio");
            
            Statement st = con.createStatement();
            String query = "SELECT name FROM auth WHERE users = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,person);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(!(userName.equals(rs.getString("name")))){
                String queryCreate = "INSERT INTO auth(users, name, pw) VALUES ('" + person + "','" + userName + "','" + passWord + "')";
                out.println("<script>console.log('query created');</script>");
                st.execute(queryCreate);
                out.println("<script>console.log('query exuecuted');</script>");
                out.println("<script>");
                out.println("window.onload = function() { alert('Account Created');location.href='index.jsp';}");
                out.println("</script>");
             
//                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//                dispatcher.forward(request, response);
                }
                else { 

                out.println("<script>");
                out.println("window.onload = function() { alert('User Already Exist');location.href='login.jsp';}");
                out.println("</script>");
//                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//                dispatcher.forward(request, response);
                }
            }
            else {
                out.println("<script>");
                out.println("window.onload = function() { alert('User Already Exist');location.href='login.jsp';}");
                out.println("</script>");                  
                    }
        }
        catch(Exception e){
            System.out.println("Error is : "+e);
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
