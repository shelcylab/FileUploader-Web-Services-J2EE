/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.db.DbUtil;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import service.ImageService;
import service.ImageServiceService;
import service.Imaged;

/**
 *
 * @author shelc
 */
@WebServlet(name = "UploadServ", urlPatterns = {"/UploadServ"})
public class UploadServ extends HttpServlet {

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

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UploadServ</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadServ at " + request.getContextPath() + "</h1>");
            out.println("<h1>Servlet UploadServ at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

        //Getting the port 
        ImageServiceService service = new ImageServiceService();
        ImageService port = service.getImageServicePort();

       //Getting inputs from the jsp

        String filename = request.getParameter("filename");
        Part filePart = request.getPart("photo");

        //Converting file to byte[]
        InputStream inputStream = null;
        if (filePart != null) {
            // debug messages
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }

        InputStream is = inputStream;

//        Calling function getBytesFromInputStream()
        byte[] data = getBytesFromInputStream(is);

//        Calling the upload method from the web services
        port.upload(filename, data);
        
//        Calling the function getImageDetails() from the webservice
        
        List<Imaged> imglist = port.getImageDetails();
        List<Imagedata> Imagedatalist = new ArrayList<Imagedata>();

        Imagedata imagedata = new Imagedata();

        imglist.forEach(ls -> {
            Imagedatalist.add(new Imagedata(ls));
        });

        for (int i = 0; i < Imagedatalist.size(); i++) {
            imagedata.setId(imglist.get(i).getId());
            imagedata.setFilename(imglist.get(i).getFilename());
            imagedata.setData(imglist.get(i).getData());

        }

        for (int i = 0; i < Imagedatalist.size(); i++) {
            Integer id = imagedata.getId();
            String file = imagedata.getFilename();
            byte[] photo = imagedata.getData();

        }

        
        //Displaying the list of data from the database
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body>");
        try {

            Connection conn = DbUtil.initiateDBConnection();
            Statement smt = conn.createStatement();
            ResultSet rs = smt.executeQuery("Select * from imagefiles");
            // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  

            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>ID</th><th>FileName</th><th>Data</th><tr>");
            for (int i = 0; i < Imagedatalist.size(); i++) {
                Integer id = imagedata.getId();
                String file = imagedata.getFilename();
                byte[] photo = imagedata.getData();
                out.println("<tr><td>" + id + "</td><td>" + file + "</td><td>" + photo + "</td></tr>");

            }
//            while (rs.next()) {
//                Integer n = rs.getInt("id");
//                String nm = rs.getString("filename");
//                byte[] s = rs.getBytes("photo");
//                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");
//            }
            out.println("</table>");
            out.println("</html></body>");
            conn.close();
        } catch (Exception e) {
            out.println("error");
        }

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

    
    // Function to convert file into byte[]
    public static byte[] getBytesFromInputStream(InputStream is) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] buffer = new byte[0xFFFF];
        for (int len = is.read(buffer); len != -1; len = is.read(buffer)) {
            os.write(buffer, 0, len);
        }
        return os.toByteArray();
    }
}
