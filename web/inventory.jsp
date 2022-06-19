<%-- 
    Document   : inventory
    Created on : Jun 17, 2022, 4:57:06 PM
    Author     : 84348
--%>

<%@page import="java.util.List"%>
<%@page import="user.UserInventory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory Page</title>
    </head>
    <body>
        <a href="MainController?action=ShowRequest&showRequest=">Request</a>
        <a href="MainController?action=SeacrhReceipt&search=">Receipt</a>
        <a href="MainController?action=SeacrhIssue&seacrhIssue=">Issue</a>
        <a href="MainController?action=ShowReport&showReport=">Report</a>
        <a href="MainController?action=SearchInventoryF&searchInventoryF=">Inventory Report</a>
        <form action="MainController">
            Search<input type="date" name="searchInventory" required=""/>
            To<input type="date" name="searchInventoryM" required=""/>
            <input type="submit" name="action" value="SearchInventory"/>
        </form>
        
        <%
            List<UserInventory> inventory = (List<UserInventory>) request.getAttribute("LIST_INVENTORY");
            if (inventory != null) {
                if (inventory.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>productID</th>
                    <th>checkingDate</th>
                    <th>quantityInChecking</th>
                    <th>Deviant</th>
                    <th>note</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (UserInventory rc : inventory) {
                %>
                <tr>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getProductID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getCheckingDate()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getQuantityInChecking()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= ((rc.getQuality()/rc.getQuantityInChecking())*10) %>%" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getNote()%>" readonly=""/>
                    </td>
                </tr>
                <%
                }
            %>
            </tbody>
            
        </table>
<%
            }
        }
    %>
    <a href=""></a>
    </body>
</html>
