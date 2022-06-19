<%-- 
    Document   : createReceiptDetail
    Created on : Jun 18, 2022, 5:12:32 PM
    Author     : 84348
--%>

<%@page import="user.UserProduct"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Receipt Detail Page</title>
    </head>
    <body>
        <%
            List<UserProduct> product = (List<UserProduct>) request.getAttribute("LIST_PRODUCT");
            if (product != null) {
                if (product.size() > 0) {
                    for (UserProduct rc : product) {

        %>
        <form action="MainController">
            <input type="text" name="" value="<%=rc.getProductID()+"------"+rc.getBrand() %>">
            <input type="submit" name="action" value="AddReDetailVirtual">
        </form>
        <%                    }

                }
            }
        %>
    </body>
</html>
