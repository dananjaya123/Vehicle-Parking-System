/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.entity;

/**
 *
 * @author asitha
 */
public class Vehicle {
     private String vID;
     private String vehicleNumber;
     private String vehicleColour;
     private String vehicleCategory;

    public Vehicle() {
    }

    public Vehicle(String vID, String vehicleNumber, String vehicleColour, String vehicleCategory) {
        this.vID = vID;
        this.vehicleNumber = vehicleNumber;
        this.vehicleColour = vehicleColour;
        this.vehicleCategory = vehicleCategory;
    }

    /**
     * @return the vID
     */
    public String getvID() {
        return vID;
    }

    /**
     * @param vID the vID to set
     */
    public void setvID(String vID) {
        this.vID = vID;
    }

  
   
    /**
     * @return the vehicleNumber
     */
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    /**
     * @param vehicleNumber the vehicleNumber to set
     */
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    /**
     * @return the vehicleColour
     */
    public String getVehicleColour() {
        return vehicleColour;
    }

    /**
     * @param vehicleColour the vehicleColour to set
     */
    public void setVehicleColour(String vehicleColour) {
        this.vehicleColour = vehicleColour;
    }

    /**
     * @return the vehicleCategory
     */
    public String getVehicleCategory() {
        return vehicleCategory;
    }

    /**
     * @param vehicleCategory the vehicleCategory to set
     */
    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }
     
   
}
