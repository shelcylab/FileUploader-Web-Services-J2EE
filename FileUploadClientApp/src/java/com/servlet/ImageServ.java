
package com.servlet;

import com.db.DbUtil;
import static com.servlet.ImageServlet.initiateDBConnection;
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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shelc
 */
@WebServlet(name = "ImageServ", urlPatterns = {"/ImageServ"})
public class ImageServ extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Blob image = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ServletOutputStream out = response.getOutputStream();
        try {
            conn = initiateDBConnection();
            stmt = conn.createStatement();
             String photoid = request.getParameter("txtid");
//            rs = stmt.executeQuery("select photo from imagefiles where  id = '2'");
            rs = stmt.executeQuery("select photo from imagefiles where  id = '" + photoid + "'");
                    String query = "select photo from imagefiles where  id = '" + photoid + "'";
            if (rs.next()) {
                image = rs.getBlob(1);
            } else {
                response.setContentType("text/html");
                out.println("<html><head><title>Display Blob Example</title></head>");
                out.println("<body><h4><font color='red'>image not found for given id</font></h4></body></html>");
                return;
            }
            response.setContentType("image/gif");
            InputStream in = image.getBinaryStream();
            int length = (int) image.length();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.flush();
        } catch (Exception e) {
            response.setContentType("text/html");
            out.println("<html><head><title>Unable To Display image</title></head>");
            out.println("<body><h4><font color='red'>Image Display Error=" + e.getMessage()
                    + "</font></h4></body></html>");
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
}
