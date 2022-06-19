<%-- 
    Document   : createReceipt
    Created on : Jun 16, 2022, 4:25:46 PM
    Author     : 84348
--%>

<%@page import="user.UserProduct"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Receipt Page</title>
    </head>
    <body>
        <a href="MainController?action=ShowRequest&showRequest=">Request</a>
        <a href="MainController?action=SeacrhReceipt&search=">Receipt</a>
        <a href="MainController?action=SeacrhIssue&seacrhIssue=">Issue</a>
        <a href="MainController?action=ShowReport&showReport=">Report</a>
        <a href="MainController?action=SearchInventoryF&searchInventoryF=">Inventory Report</a>
        
        <a href="MainController?action=SeacrhReceiptDetail&searchDetail=">SEE MORE DETAIL</a>
        <form action="MainController">

            <input type="submit" name="action" value="Export"/>
        </form>

        <form action="MainController">
            InPut Date<input type="date" name="inputDate" value="" required=""/>
            Status<input type="text" name="status" value="" required=""/>
            Total Quantity<input type="number" name="totalQuantity" value="" required=""/>
            Note<input type="text" name="note" value="" placeholder="Note here..." required=""/>
            Stock Keeper<input type="text" name="accountantID" value="" required=""/>
            Accountant<input type="text" name="stockKeeperID" value="" required=""/>
            <input type="submit" name="action" value="AddReceipt"/>
        </form>


        <%
            List<UserProduct> product = (List<UserProduct>) request.getAttribute("LIST_PRODUCT");
            if (product != null) {
                if (product.size() > 0) {

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
                <%                        for (UserProduct rc : product) {

                %>
            <form action="MainController">
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
                        <input type="number" name="quantityInBill" value="" />
                    </td>
                    <td>
                        <input type="number" name="quantityInShipping" value=""/>
                    </td>
                </tr> 
            </form>
            <%
                }
            %>
            <input type="submit" name="action" value="MainController?action=AddReceiptDetail&&AddReceipt">
            </form>
            </tbody>
        </table>

        <%
                }
            }
        %>
        
    </body>
</html>
