/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;


/**
 *
 * @author shelc
 */

@WebService
@HandlerChain(file = "ImageService_handler.xml")
public class ImageService  {

    @WebMethod
    public List<Imaged> GetImageDetails() {
        List<Imaged> image = new ArrayList<>();

        try {
            Connection conn = DbUtil.initiateDBConnection();
            Statement smt = conn.createStatement();
            ResultSet rs = smt.executeQuery("Select * from imagefiles");

            while (rs.next()) {
                image.add(new Imaged(rs.getInt("id"),
                        rs.getString("filename"),
                        rs.getBytes("photo")) {
                });
            }
            rs.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return image;
    }
    
     @WebMethod
         public void upload( String filename, byte[] photo) {
           Connection conn = DbUtil.initiateDBConnection();
        // gets values of text fields
        
       // String filedata = request.getParameter("filename");
//        Integer id = Integer.parseInt(request.getParameter("id"));

        InputStream inputStream = null;

        // obtains the upload file part in this multipart request
       // Part filePart = request.getPart("photo");
        /*if (filePart != null) {
            // debug messages
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
*/
        String message = null; // message will be sent back to client

        try {
            // constructs SQL statement
            String sql = "INSERT INTO imagefiles (filename, photo) values (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setInt(1, id);
            statement.setString(1, filename);

            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(2, inputStream);
            }

            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "Image is uploaded successfully into the Database";
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        }
        // sets the message in request scope
        //request.setAttribute("Message", message);

  
    }
        
    }
    
   
