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
public class UserReceipt {
    public int receiptID;
    public String inputDate;
    public String status;
    public int totalQuantity;
    public String note;
    public String accountantID;
    public String stockKeeperID;

    public UserReceipt() {
    }

    public UserReceipt(int receiptID, String inputDate, String status, int totalQuantity, String note, String accountantID, String stockKeeperID) {
        this.receiptID = receiptID;
        this.inputDate = inputDate;
        this.status = status;
        this.totalQuantity = totalQuantity;
        this.note = note;
        this.accountantID = accountantID;
        this.stockKeeperID = stockKeeperID;
    }

    public String getAccountantID() {
        return accountantID;
    }

    public void setAccountantID(String accountantID) {
        this.accountantID = accountantID;
    }

    public String getStockKeeperID() {
        return stockKeeperID;
    }

    public void setStockKeeperID(String stockKeeperID) {
        this.stockKeeperID = stockKeeperID;
    }

    

    public int getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(int receiptID) {
        this.receiptID = receiptID;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
