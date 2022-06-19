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
public class UserRequest {
    public int receiptDetailID;
    public int quantityInBill;
    public int quantityInShipping;
    public String productID;
    public int receiptID;
    public String solution;

    public UserRequest() {
    }

    public UserRequest(int receiptDetailID, int quantityInBill, int quantityInShipping, String productID, int receiptID, String solution) {
        this.receiptDetailID = receiptDetailID;
        this.quantityInBill = quantityInBill;
        this.quantityInShipping = quantityInShipping;
        this.productID = productID;
        this.receiptID = receiptID;
        this.solution = solution;
    }

    public int getReceiptDetailID() {
        return receiptDetailID;
    }

    public void setReceiptDetailID(int receiptDetailID) {
        this.receiptDetailID = receiptDetailID;
    }

    public int getQuantityInBill() {
        return quantityInBill;
    }

    public void setQuantityInBill(int quantityInBill) {
        this.quantityInBill = quantityInBill;
    }

    public int getQuantityInShipping() {
        return quantityInShipping;
    }

    public void setQuantityInShipping(int quantityInShipping) {
        this.quantityInShipping = quantityInShipping;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(int receiptID) {
        this.receiptID = receiptID;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
    
}
