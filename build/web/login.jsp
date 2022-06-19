<%-- 
    Document   : login
    Created on : Jun 16, 2022, 4:20:57 PM
    Author     : 84348
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            User ID<input type="text" name="accountID" required=""></br>
            Password<input type="password" name="password" required=""></br>
            <input type="submit" name="action" value="Login">
            <input type="reset" name="Reset">
        </form>
        
        <%
            String error = (String) request.getAttribute("ERROR");
            if (error == null) {
                error = "";
            }
        %>
        <h2><%=error%></h2>
    </body>
</html>
