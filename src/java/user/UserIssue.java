/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author 84348
 */
public class UserIssue {
    public int orderDetailID;
    public String customerName;
    public String address;
    public String phoneNumber;
    public String accountantID;
    public int issueID;
    public int orderID;
    public String note;

    public UserIssue() {
    }

    public UserIssue(int orderDetailID, String customerName, String address, String phoneNumber, String accountantID, int issueID, int orderID, String note) {
        this.orderDetailID = orderDetailID;
        this.customerName = customerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accountantID = accountantID;
        this.issueID = issueID;
        this.orderID = orderID;
        this.note = note;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountantID() {
        return accountantID;
    }

    public void setAccountantID(String accountantID) {
        this.accountantID = accountantID;
    }

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
    
}
