<%-- 
    Document   : issueVirtual
    Created on : Jun 17, 2022, 10:20:13 PM
    Author     : 84348
--%>

<%@page import="user.UserVirtualIssue"%>
<%@page import="virtual.ListVirtual"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Issue Virtual Page</title>
    </head>
    <body>
        <a href="MainController?action=ShowRequest&showRequest=">Request</a>
        <a href="MainController?action=SeacrhReceipt&search=">Receipt</a>
        <a href="MainController?action=SeacrhIssue&seacrhIssue=">Issue</a>
        <a href="MainController?action=ShowReport&showReport=">Report</a>
        <a href="MainController?action=SearchInventoryF&searchInventoryF=">Inventory Report</a>
        <form action="MainController">
            Issue<input type="number" name="issueID" ></br>
            Note<input type="text" name="note" ></br>
            AccountantID<input type="text" name="accountantID"></br>
            SellerID<input type="text" name="sellerID"></br>
            OrderID<input type="number" name="orderID"></br>
            
            <input type="submit" name="action" value="AddIssueVirtual">
        </form>


        <%
            ListVirtual cart = (ListVirtual) session.getAttribute("LIST_VIRTUAL");
            if (cart != null) {
                if (cart.getListVirtual().size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Note</th>
                    <th>AccountantID</th>
                    <th>SellerID</th>
                    <th>OrderID</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (UserVirtualIssue tm : cart.getListVirtual().values()) {
                %>
            <form action="MainController">
                <tr>
                    <td>
                        <input type="text" name="" value="<%= count++%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="note" value="<%= tm.getNote()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="accountantID" value="<%= tm.getAccountantID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="sellerID" value="<%= tm.getSellerID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="orderID" value="<%= tm.getOrderID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="hidden" name="issueID" value="<%= tm.getIssueID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="submit" name="action" value="RemoveIssueVirtual"/>
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
    
    <form action="MainController">
        <input type="submit" name="action" value="InsertIssue"/>
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
