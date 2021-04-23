<%-- 
    Document   : uploadImage.jsp
    Created on : 27 Mar, 2021, 9:10:45 AM
    Author     : shelc
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>File Upload</title>
    </head>
    <div>
    <body>
        <h1>Upload an image to mysql DB</h1>
        <form method="post" action="UploadServ"
              enctype="multipart/form-data">
            <table>
                <tr>
                    <td>Filename:</td>
                    <td><input type="text" name="filename" size="10"
                               required="required" /></td>
                </tr>
                <tr>
                    <td>Choose Image:</td>
                    <td><input type="file" name="photo" size="10"
                               required="required" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"></td>
                    <td><input type="reset" value="Clear" /></td>
                </tr>
            </table>
        </form>
          </div>
<div>

        <form method="get" action="ImageServ"
              enctype="multipart/form-data">
            <table>
                <tr>
                    <td>Enter PhotoId:</td>
                    <td><input type="text" name="txtid" size="10"
                               required="required" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"></td>
                    <td><input type="reset" value="Clear" /></td>
                </tr>
            </table>
        </form>
    </body>

</div>
</html>
