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
public class UserUpdateRequest {
    public String productID;
    public String solution;

    public UserUpdateRequest() {
    }

    public UserUpdateRequest(String productID, String solution) {
        this.productID = productID;
        this.solution = solution;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
    
}
