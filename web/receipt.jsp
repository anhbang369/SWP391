<%-- 
    Document   : receipt
    Created on : Jun 16, 2022, 4:27:44 PM
    Author     : 84348
--%>

<%@page import="java.util.List"%>
<%@page import="user.UserReceipt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Receipt Page</title>
    </head>
    <body>
        <a href="MainController?action=ShowRequest&showRequest=">Request</a>
        <a href="MainController?action=SeacrhReceipt&search=">Receipt</a>
        <a href="MainController?action=SeacrhIssue&seacrhIssue=">Issue</a>
        <a href="MainController?action=ShowReport&showReport=">Report</a>
        <a href="MainController?action=SearchInventoryF&searchInventoryF=">Inventory Report</a>
        
        <a href="MainController?action=ShowProductCreate">Create</a>
        
        <form action="MainController">
            Search<input type="text" name="search" />
            <input type="submit" name="action" value="SeacrhReceipt"/>
        </form>
        
        <%
            List<UserReceipt> receipt = (List<UserReceipt>) request.getAttribute("LIST_RECEIPT");
            if (receipt != null) {
                if (receipt.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Receipt ID</th>
                    <th>Brand</th>
                    <th>Create date</th>
                    <th>Status</th>
                    <th>Total Quantity</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (UserReceipt rc : receipt) {
                %>
            <form action="MainController">
                <tr>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getReceiptID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getInputDate()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getStatus()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getTotalQuantity()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getNote()%>" readonly=""/>
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
