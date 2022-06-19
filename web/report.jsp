<%-- 
    Document   : report
    Created on : Jun 17, 2022, 10:05:43 AM
    Author     : 84348
--%>

<%@page import="user.UserReport"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report Page</title>
    </head>
    <body>
        <a href="MainController?action=ShowRequest&showRequest=">Request</a>
        <a href="MainController?action=SeacrhReceipt&search=">Receipt</a>
        <a href="MainController?action=SeacrhIssue&seacrhIssue=">Issue</a>
        <a href="MainController?action=ShowReport&showReport=">Report</a>
        <a href="MainController?action=SearchInventoryF&searchInventoryF=">Inventory Report</a>
        
        <form action="MainController">
            Search<input type="text" name="showReport">
            <input type="submit" name="action" value="ShowReport">
        </form>
        <form action="MainController">
            <input type="submit" name="action" value="SortReport">
        </form>
        
        
        <%
            List<UserReport> report = (List<UserReport>) request.getAttribute("LIST_REPORT");
            if (report != null) {
                if (report.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Brand</th>
                    <th>Import</th>
                    <th>Export</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (UserReport rc : report) {
                %>
            <form action="MainController">
                <tr>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getProductID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getBrand()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getQuantityImport()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getQuantityExport()%>" readonly=""/>
                    </td>
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>
    <%
            }
        }
    %>
</body>
</html>
