/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sort.SortReport;

import utils.DBUtils;

/**
 *
 * @author 84348
 */
public class UserDAO {

    private static final String LOGIN = "SELECT name,role,status,phoneNumber FROM Account WHERE accountID=? AND password=?";
    private static final String SHOW = "SELECT receiptID,inputDate,status,totalQuantity,note,accountantID,stockKeeperID FROM Receipt";
    private static final String SEARCH = "SELECT receiptID,inputDate,status,totalQuantity,note,accountantID,stockKeeperID FROM Receipt WHERE receiptID like ?";
    private static final String SHOW_PRODUCT = "SELECT productID,model,brand,status,type,width,depth,height,screenSize,voiceRemote,bluetooth,manufacturingDate,madeIn,quantityOnHand FROM Product";
    private static final String SEARCH_DETAIL = "SELECT pt.productID, pt.model,pt.brand,pt.type,rd.quantityInBill,rd.quantityInShipping,r.inputDate,r.status,r.totalQuantity,r.note,r.stockKeeperID,r.accountantID FROM Receipt as r,ReceiptDetail as rd,Product as pt WHERE r.receiptID=rd.receiptID AND rd.productID=pt.productID AND r.receiptID like ?";
    private static final String ADD_RECEIPT = "INSERT INTO Receipt(inputDate, status, totalQuantity, note, accountantID, stockKeeperID) VALUES(?,?,?,?,?,?)";
    private static final String CHECK_DUPLICATE = "SELECT name,role,status,phoneNumber,password FROM Account WHERE accountID=?";
    private static final String ADD_RECEIPT_DETAIL = "INSERT INTO ReceiptDetail(quantityInBill, quantityInShipping, productID, receiptID) VALUES(?,?,?,?)";
    private static final String GET_RECEIPTID = "SELECT top 1 * FROM Receipt order by receiptID desc";
    private static final String SHOW_REQUEST = "SELECT receiptID,productID,quantityInShipping,quantityInBill,solution FROM ReceiptDetail WHERE receiptID like ?";
    private static final String UPDATE_REQUEST = "UPDATE ReceiptDetail SET solution=? WHERE productID=?";
    private static final String SHOW_REPORT = "SELECT p.productID,p.brand, od.quantity,rd.quantityInShipping FROM Product AS p,OrderDetail AS od, ReceiptDetail AS rd WHERE p.productID=rd.productID AND p.productID=od.productID AND p.productID like ?";
    private static final String SEARCH_INVENTORY = "SELECT p.productID,rd.quality,rd.quantityInChecking,r.checkingDate,r.note FROM Product as p,ReportDetail as rd,Report as r WHERE p.productID=rd.productID AND rd.reportID=r.reportID AND r.checkingDate BETWEEN ? AND ? ORDER BY YEAR(checkingDate) DESC,Month(checkingDate) DESC,day(checkingDate) DESC";
    private static final String SEARCH_INVENTORY_F = "SELECT p.productID,rd.quality,rd.quantityInChecking,r.checkingDate,r.note FROM Product as p,ReportDetail as rd,Report as r WHERE p.productID=rd.productID AND rd.reportID=r.reportID ORDER BY YEAR(checkingDate) DESC,Month(checkingDate) DESC,day(checkingDate) DESC";
    private static final String SEARCH_ORDER = "SELECT od.orderDetailID,o.customerName,o.address,o.phoneNumber,i.accountantID,i.issueID,i.orderID,i.note FROM Issue as i,Orders as o,OrderDetail as od WHERE i.orderID=o.orderID AND o.orderID=od.orderID AND o.customerName like ?";
    private static final String UPDATE_ISSUE = "UPDATE Issue SET note=? WHERE issueID=?";
    private static final String CHECK_EXIST_ACCOUNT = "SELECT name,role,status,phoneNumber FROM Account WHERE accountID like ?";
    private static final String CHECK_EXIST_ORDERID = "SELECT customerName,address,phoneNumber,status,note,deliveryDate,sellerID FROM Orders WHERE orderID like ?";
    private static final String INSERT_ISSUE = "INSERT INTO Issue(note, accountantID, sellerID, orderID) VALUES(?,?,?,?)";
    private static final String CHECK_ORDER_ISSUE = "SELECT issueID,note,accountantID,sellerID FROM Issue WHERE orderID like ?";


    public UserDTO checkLogin(String accountID, String password) throws SQLException {
        UserDTO user = null;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(LOGIN);
                ptm.setString(1, accountID);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    String role = rs.getString("role");
                    String status = rs.getString("status");
                    String phoneNumber = rs.getString("phoneNumber");
                    user = new UserDTO(accountID, password, name, role, status, phoneNumber);
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return user;
    }
    
    public List<UserReceipt> getListReceipt() throws SQLException {
        List<UserReceipt> listReceipt = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(SHOW);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int receiptID = Integer.parseInt(rs.getString("receiptID"));
                    String inputDate = rs.getString("inputDate");
                    String status = rs.getString("status");
                    int totalQuantity = Integer.parseInt(rs.getString("totalQuantity"));
                    String note = rs.getString("note");
                    String accountantID = rs.getString("accountantID");
                    String stockKeeperID = rs.getString("stockKeeperID");
                    listReceipt.add(new UserReceipt(receiptID, inputDate, status, totalQuantity, note, accountantID, stockKeeperID));
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listReceipt;
    }
    
    public List<UserReceipt> getListUser(String search) throws SQLException {
        List<UserReceipt> listUser = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int receiptID = Integer.parseInt(rs.getString("receiptID"));
                    String inputDate = rs.getString("inputDate");
                    String status = rs.getString("status");
                    int totalQuantity = Integer.parseInt(rs.getString("totalQuantity"));
                    String note = rs.getString("note");
                    String accountantID = rs.getString("accountantID");
                    String stockKeeperID = rs.getString("stockKeeperID");
                    listUser.add(new UserReceipt(receiptID, inputDate, status, totalQuantity, note, accountantID, stockKeeperID));
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listUser;
    }
    
    public List<UserProduct> getListShowProduct() throws SQLException {
        List<UserProduct> listProduct = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(SHOW_PRODUCT);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String model = rs.getString("model");
                    String brand = rs.getString("brand");
                    String status = rs.getString("status");
                    String type = rs.getString("type");
                    float width = Float.parseFloat(rs.getString("width"));
                    float depth = Float.parseFloat(rs.getString("depth"));
                    float height = Float.parseFloat(rs.getString("height"));
                    float screenSize = Float.parseFloat(rs.getString("screenSize"));
                    String voiceRemote = rs.getString("voiceRemote");
                    String bluetooth = rs.getString("bluetooth");
                    int manufacturingDate = Integer.parseInt(rs.getString("manufacturingDate"));
                    String madeIn = rs.getString("madeIn");
                    int quantityOnHand = Integer.parseInt(rs.getString("quantityOnHand"));
                    listProduct.add(new UserProduct(productID, model, brand, status, type, width, depth, height, screenSize, voiceRemote, bluetooth, manufacturingDate, madeIn, quantityOnHand));
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listProduct;
    }
    
    public boolean createReceipt(UserReceipt receipt) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_RECEIPT);
                ptm.setString(1, receipt.getInputDate());
                ptm.setString(2, receipt.getStatus());
                ptm.setInt(3, receipt.getTotalQuantity());
                ptm.setString(4, receipt.getNote());
                ptm.setString(5, receipt.getAccountantID());
                ptm.setString(6, receipt.getStockKeeperID());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
            
        }
        return check;
    }
    
    public boolean createReceiptDetail(UserReceiptDetail receiptDetail) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_RECEIPT_DETAIL);
                ptm.setInt(1, receiptDetail.getQuantityInBill());
                ptm.setInt(2, receiptDetail.getQuantityInShipping());
                ptm.setString(3, receiptDetail.getProductID());
                ptm.setInt(4, receiptDetail.getReceiptID());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
            
        }
        return check;
    }
    
    public boolean checkDupAccountantID(String accountantID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, accountantID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean checkDupStockKeeperID(String stockKeeperID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, stockKeeperID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public int getReceiptID() throws SQLException {
        int check = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_RECEIPTID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int receiptID = Integer.parseInt(rs.getString("receiptID"));
                    check = receiptID;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public List<UserFakeList> getListShowDetail(int a) throws SQLException {
        List<UserFakeList> listFake = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(SEARCH_DETAIL);
                ptm.setString(1, "%" + a + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String model = rs.getString("model");
                    String brand = rs.getString("brand");
                    String type = rs.getString("type");
                    int quantityInBill = Integer.parseInt(rs.getString("quantityInBill"));
                    int quantityInShipping = Integer.parseInt(rs.getString("quantityInShipping"));
                    String inputDate = rs.getString("inputDate");
                    String status = rs.getString("status");
                    int totalQuantity = Integer.parseInt(rs.getString("totalQuantity"));
                    String note = rs.getString("note");
                    String accountantID = rs.getString("accountantID");
                    String stockKeeperID = rs.getString("stockKeeperID");
                    
                    listFake.add(new UserFakeList(productID, model, brand, type, quantityInBill, quantityInShipping, a, inputDate, status, totalQuantity, note, accountantID, stockKeeperID));
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listFake;
    }
    
    public List<UserRequest> getListShowRequest(String search) throws SQLException {
        List<UserRequest> listRequest = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(SHOW_REQUEST);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int quantityInBill = Integer.parseInt(rs.getString("quantityInBill"));
                    int quantityInShipping = Integer.parseInt(rs.getString("quantityInShipping"));                    
                    String productID = rs.getString("productID");
                    String solution = rs.getString("solution");
                    int receiptID = Integer.parseInt(rs.getString("receiptID"));
                    listRequest.add(new UserRequest(receiptID, quantityInBill, quantityInShipping, productID, receiptID, solution));
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listRequest;
    }
    
    public boolean updateRequest(UserUpdateRequest user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_REQUEST);
                ptm.setString(1, user.getSolution());
                ptm.setString(2, user.getProductID());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
            
        }
        return check;
    }
    
    public List<UserReport> getListShowReport(String search) throws SQLException {
        List<UserReport> listReprot = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(SHOW_REPORT);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String brand = rs.getString("brand");
                    int quantityImport = Integer.parseInt(rs.getString("quantity"));                    
                    int quantityExport = Integer.parseInt(rs.getString("quantityInShipping"));
                    listReprot.add(new UserReport(productID, brand, quantityImport, quantityExport));
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listReprot;
    }
    
    public List<UserReport> getListSortReport() throws SQLException {
        List<UserReport> listReprot = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(SHOW_REPORT);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String brand = rs.getString("brand");
                    int quantityImport = Integer.parseInt(rs.getString("quantity"));                    
                    int quantityExport = Integer.parseInt(rs.getString("quantityInShipping"));
                    listReprot.add(new UserReport(productID, brand, quantityImport, quantityExport));
                }
                Collections.sort(listReprot, new SortReport());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listReprot;
    }
    
    public List<UserInventory> getListSearchInventory(String searchInventory, String searchInventoryM) throws SQLException {
        List<UserInventory> listInventory = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(SEARCH_INVENTORY);
                ptm.setString(1, searchInventory);
                ptm.setString(2, searchInventoryM);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String checkingDate = rs.getString("checkingDate");
                    int quantityInChecking = Integer.parseInt(rs.getString("quantityInChecking"));
                    int quality = Integer.parseInt(rs.getString("quality"));
                    String note = rs.getString("note");
                    listInventory.add(new UserInventory(productID, checkingDate, quantityInChecking, quality, note));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listInventory;
    }
    
    public List<UserInventory> getListSearchInventoryF() throws SQLException {
        List<UserInventory> listInventory = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(SEARCH_INVENTORY_F);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String checkingDate = rs.getString("checkingDate");
                    int quantityInChecking = Integer.parseInt(rs.getString("quantityInChecking"));
                    int quality = Integer.parseInt(rs.getString("quality"));
                    String note = rs.getString("note");
                    listInventory.add(new UserInventory(productID, checkingDate, quantityInChecking, quality, note));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listInventory;
    }
    
    public List<UserIssue> getListIssue(String search) throws SQLException {
        List<UserIssue> listIssue = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(SEARCH_ORDER);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int orderDetailID = Integer.parseInt(rs.getString("orderDetailID"));
                    String customerName = rs.getString("customerName");
                    String address = rs.getString("address");
                    String phoneNumber = rs.getString("phoneNumber");
                    String accountantID = rs.getString("accountantID");
                    int issueID = Integer.parseInt(rs.getString("issueID"));
                    int orderID = Integer.parseInt(rs.getString("orderID"));
                    String note = rs.getString("note");
                    listIssue.add(new UserIssue(orderDetailID, customerName, address, phoneNumber, accountantID, issueID, orderID, note));
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listIssue;
    }
    
    public boolean updateIssue(UserUpdateIssue user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_ISSUE);
                ptm.setString(1, user.getNote());
                ptm.setInt(2, user.getIssueID());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ptm != null) {
                ptm.close();
            }

        }
        return check;
    }
    
    public boolean checkExistAccount(String Account) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_EXIST_ACCOUNT);
                ptm.setString(1, Account);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean checkExistOrderID(int orderID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_EXIST_ORDERID);
                ptm.setInt(1, orderID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    
    public boolean createDetail(UserVirtualIssueS virtualIssue) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT_ISSUE);
                ptm.setString(1, virtualIssue.getNote());
                ptm.setString(2, virtualIssue.getAccountantID());
                ptm.setString(3, virtualIssue.getSellerID());
                ptm.setInt(4, virtualIssue.getOrderID());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
            
        }
        return check;
    }
    
    public boolean checkOrderIdIssue(int orderID) throws SQLException {
        boolean check = true;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_ORDER_ISSUE);
                ptm.setInt(1, orderID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
