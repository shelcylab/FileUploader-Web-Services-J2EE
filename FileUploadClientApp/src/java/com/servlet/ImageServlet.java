/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.db.DbUtil;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.out;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,
            
        ServletException {
        String photoid = request.getParameter("txtid");
        Blob photo = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "select photo from imagefiles where  id = '" + photoid + "'";
        ServletOutputStream out = response.getOutputStream();

        try {
            conn = initiateDBConnection();
        } catch (Exception e) {
            response.setContentType("text/html");
            out.println("<html><head><title>Person Photo</title></head>");
            out.println("<body><h1>Database Connection Problem.</h1></body></html>");
            return;
        }

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                photo = rs.getBlob(photoid);

            } else {
                response.setContentType("text/html");
                out.println("<html><head><title>Person Photo</title></head>");
                out.println("<body><h1>No photo found for id= 001 </h1></body></html>");
                return;
            }

            response.setContentType("image/gif");
//            
//            InputStream in = photo.getBinaryStream();             
//int length = (int) photo.length();              
//int bufferSize = 1024;             
//byte[] buffer = new byte[bufferSize];              
//while ((length = in.read(buffer)) != -1) {                
// System.out.println("writing " + length + " bytes");                 
//out.write(buffer, 0, length);             
//}              
//in.close(); 
            InputStream in = photo.getBinaryStream();
            int length = (int) photo.length();

            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];

            while ((length = in.read(buffer)) != -1) {
                System.out.println("writing " + length + " bytes");
                out.write(buffer, 0, length);
            }

            in.close();
            out.flush();
        } catch (SQLException e) {
            response.setContentType("text/html");
            out.println("<html><head><title>Error: Person Photo</title></head>");
            out.println("<body><h1>Error=" + e.getMessage() + "</h1></body></html>");
            return;
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static Connection initiateDBConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String db_URL = "jdbc:mysql://localhost:3306/imagedatadb?zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false";
            String db_username = "root";
            String db_password = "root123";

            conn = DriverManager.getConnection(db_URL, db_username, db_password);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return conn;
    }


    
}