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
public class UserProduct {
    public String productID;
    public String model;
    public String brand;
    public String status;
    public String type;
    public float width;
    public float depth;
    public float height;
    public float screenSize;
    public String voiceRemote;
    public String bluetooth;
    public int manufacturingDate;
    public String madeIn;
    public int quantityOnHand;

    public UserProduct() {
    }

    public UserProduct(String productID, String model, String brand, String status, String type, float width, float depth, float height, float screenSize, String voiceRemote, String bluetooth, int manufacturingDate, String madeIn, int quantityOnHand) {
        this.productID = productID;
        this.model = model;
        this.brand = brand;
        this.status = status;
        this.type = type;
        this.width = width;
        this.depth = depth;
        this.height = height;
        this.screenSize = screenSize;
        this.voiceRemote = voiceRemote;
        this.bluetooth = bluetooth;
        this.manufacturingDate = manufacturingDate;
        this.madeIn = madeIn;
        this.quantityOnHand = quantityOnHand;
    }

    

    

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(float screenSize) {
        this.screenSize = screenSize;
    }

    public String getVoiceRemote() {
        return voiceRemote;
    }

    public void setVoiceRemote(String voiceRemote) {
        this.voiceRemote = voiceRemote;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public int getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(int manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }
}
