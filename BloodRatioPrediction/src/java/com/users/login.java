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
public class login extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Authorization Result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
                
            DBsingletone db = DBsingletone.getDbSingletone();
            Connection con = db.getConnection();
            String userName = request.getParameter("userName");
            String passWord = request.getParameter("passWord");
            String person = request.getParameter("radio");
            
            String query = "SELECT name,pw FROM auth WHERE name = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,userName);

            ResultSet rs = ps.executeQuery();


            if(rs.next()){
                if(userName.equals(rs.getString("name")) && passWord.equals(rs.getString("pw"))){
                    if(person.equals("Hospital")){
                        out.println("<script>");
                        out.println("window.onload = function() { alert('You are authorized!');location.href='Hospital.jsp'}");
                        out.println("</script>");
                    }
                    else if(person.equals("Admin")){
                        out.println("<script>");
                        out.println("window.onload = function() { alert('You are authorized!');location.href='Admin.jsp'}");
                        out.println("</script>");
                    }
                    else{
                        out.println("<script>");
                        out.println("window.onload = function() { alert('You are authorized!');location.href='User.jsp'}");
                        out.println("</script>");
                    }
              
//                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//                dispatcher.forward(request, response);

            }else {
//                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//                dispatcher.forward(request, response);
                out.println("<script>");
                out.println("window.onload = function() { alert('Invalid Username or Password');location.href='login.jsp'};");
                out.println("</script>");
                }
        }else{
                out.println("<script>");
                out.println("window.onload = function() { alert('Invalid Username or Password');location.href='login.jsp'};");
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
