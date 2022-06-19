<%-- 
    Document   : issue
    Created on : Jun 17, 2022, 8:57:17 PM
    Author     : 84348
--%>

<%@page import="user.UserIssue"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
    </head>
    <body>
        <a href="MainController?action=ShowRequest&showRequest=">Request</a>
        <a href="MainController?action=SeacrhReceipt&search=">Receipt</a>
        <a href="MainController?action=SeacrhIssue&seacrhIssue=">Issue</a>
        <a href="MainController?action=ShowReport&showReport=">Report</a>
        <a href="MainController?action=SearchInventoryF&searchInventoryF=">Inventory Report</a>
        <form action="MainController">
            Search<input type="text" name="seacrhIssue" />
            <input type="submit" name="action" value="SeacrhIssue"/>
        </form>
        <%
            List<UserIssue> issue = (List<UserIssue>) request.getAttribute("LIST_ISSUE");
            if (issue != null) {
                if (issue.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>OrderDetailID</th>
                    <th>CustomerName</th>
                    <th>Address</th>
                    <th>PhoneNumber</th>
                    <th>AccountantID</th>
                    <th>IssueID</th>
                    <th>OrderID</th>
                    <th>Note</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (UserIssue rc : issue) {
                %>
            <form action="MainController">
                <tr>
                    <td>
                        <input type="text" name="orderDetailID" value="<%= rc.getOrderDetailID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="customerName" value="<%= rc.getCustomerName()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="address" value="<%= rc.getAddress()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="phoneNumber" value="<%= rc.getPhoneNumber()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="accountantID" value="<%= rc.getAccountantID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="issueID" value="<%= rc.getIssueID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="orderID" value="<%= rc.getOrderID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="note" value="<%= rc.getNote()%>" />
                    </td>
                    <td>
                        <input type="submit" name="action" value="UpdateIssue" />
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
    <a href="issueVirtual.jsp">Create</a>

        
    </body>
</html>
