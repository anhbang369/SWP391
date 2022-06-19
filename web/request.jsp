<%-- 
    Document   : request
    Created on : Jun 16, 2022, 9:17:30 PM
    Author     : 84348
--%>

<%@page import="java.util.List"%>
<%@page import="user.UserRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Request Page</title>
    </head>
    <body>
        <a href="MainController?action=ShowRequest&showRequest=">Request</a>
        <a href="MainController?action=SeacrhReceipt&search=">Receipt</a>
        <a href="MainController?action=SeacrhIssue&seacrhIssue=">Issue</a>
        <a href="MainController?action=ShowReport&showReport=">Report</a>
        <a href="MainController?action=SearchInventoryF&searchInventoryF=">Inventory Report</a>
        
        <form action="MainController">
            Search<input type="text" name="showRequest" />
            <input type="submit" name="action" value="ShowRequest"/>
        </form>
        <%
            List<UserRequest> listRequest = (List<UserRequest>) request.getAttribute("LIST_REQUEST");
            if (listRequest != null) {
                if (listRequest.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Receipt ID</th>
                    <th>Product ID</th>
                    <th>Quantity In Shipping</th>
                    <th>Quantity In Bill</th>
                    <th>Deviant</th>
                    <th>Solution</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (UserRequest rc : listRequest) {
                %>
            <form action="MainController">
                <tr>
                    <td>
                        <input type="text" name="receiptID" value="<%=rc.getReceiptID() %>">
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%=rc.getProductID()%>">
                    </td>
                    <td>
                        <input type="text" name="quantityInShipping" value="<%=rc.getQuantityInShipping()%>">
                    </td>
                    <td>
                        <input type="text" name="quantityInBill" value="<%=rc.getQuantityInBill()%>">
                    </td>
                    <td>
                        <input type="text" name="Diviant" value="<%=rc.getQuantityInBill()- rc.getQuantityInShipping()%>">
                    </td>
                    <td>
                        <input type="text" name="solution" value="<%=rc.getSolution()%>">
                    </td>
                    <td>
                        <input type="submit" name="action" value="UpdateRequest">
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
