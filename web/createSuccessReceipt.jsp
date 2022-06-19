<%-- 
    Document   : createSuccessReceipt
    Created on : Jun 16, 2022, 4:26:18 PM
    Author     : 84348
--%>

<%@page import="java.util.List"%>
<%@page import="user.UserFakeList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Success Receipt Page</title>
    </head>
    <body>
        <a href="MainController?action=ShowRequest&showRequest=">Request</a>
        <a href="MainController?action=SeacrhReceipt&search=">Receipt</a>
        <a href="MainController?action=SeacrhIssue&seacrhIssue=">Issue</a>
        <a href="MainController?action=ShowReport&showReport=">Report</a>
        <a href="MainController?action=SearchInventoryF&searchInventoryF=">Inventory Report</a>

        <form action="MainController">
            <%
            List<UserFakeList> list = (List<UserFakeList>) request.getAttribute("LIST_ALL_RECEIPT");
            if (list != null) {
                if (list.size() > 0) {

        %>

        <table border="1">
            <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Model</th>
                    <th>Brand</th>
                    <th>type</th>
                    <th>Quantity In Bill</th>
                    <th>quantity In Shipping</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (UserFakeList elem : list) {
                            
                        
                %>
            Input Date: <%=elem.getInputDate() %></br>
            Status: <%=elem.getStatus()%></br>
            Accountant ID: <%=elem.getAccountantID()%></br>
            StockKeeper ID: <%=elem.getStockKeeperID()%></br>
            Total Quantity: <%=elem.getTotalQuantity()%></br>
            Note: <%=elem.getNote()%></br>
                <%
                    break;
                    }
                %>
                
                <%                      
                    
                    for (UserFakeList rc : list) {

                %>
            
                
<!--                Input Date: <%= rc.getInputDate()%></br>
                Status: <%= rc.getStatus()%></br>
                Accountant ID: <%= rc.getAccountantID()%></br>
                StockKeeper ID: <%= rc.getStockKeeperID()%></br>
                Total Quantity: <%= rc.getTotalQuantity()%></br>
                Note: <%= rc.getNote()%></br>-->

                <tr>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getProductID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="model" value="<%= rc.getModel()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="brand" value="<%= rc.getBrand()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="type" value="<%= rc.getType()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="number" name="quantityInBill" value="<%= rc.getQuantityInBill()%>" />
                    </td>
                    <td>
                        <input type="number" name="quantityInShipping" value="<%= rc.getQuantityInShipping()%>"/>
                    </td>
            <input type="hidden" name="inputDate" value="<%= rc.getInputDate()%>" readonly=""/>
            <input type="hidden" name="status" value="<%= rc.getStatus()%>" readonly=""/>
            <input type="hidden" name="accountantID" value="<%= rc.getAccountantID()%>" readonly=""/>
            <input type="hidden" name="stockKeeperID" value="<%= rc.getStockKeeperID()%>" readonly=""/>
            <input type="hidden" name="totalQuantity" value="<%= rc.getTotalQuantity()%>" readonly=""/>
            <input type="hidden" name="note" value="<%= rc.getNote()%>" readonly=""/>
                </tr>   
            
        </tbody>
        <%
            
            }
        %>
    </table>



    <%
            }
        }
    %>
    <input type="submit" name="action" value="Export">
        </form>
    </body>
</html>
