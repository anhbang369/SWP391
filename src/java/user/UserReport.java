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
public class UserReport {
    public String productID;
    public String brand;
    public int quantityImport;
    public int quantityExport;

    public UserReport() {
    }

    public UserReport(String productID, String brand, int quantityImport, int quantityExport) {
        this.productID = productID;
        this.brand = brand;
        this.quantityImport = quantityImport;
        this.quantityExport = quantityExport;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantityImport() {
        return quantityImport;
    }

    public void setQuantityImport(int quantityImport) {
        this.quantityImport = quantityImport;
    }

    public int getQuantityExport() {
        return quantityExport;
    }

    public void setQuantityExport(int quantityExport) {
        this.quantityExport = quantityExport;
    }
           
    
}
