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
public class ParkingArea {

    private String paID;
    private String area_Name;
    private double fee;
    private String vehicle_category;

    public ParkingArea() {
    }

    public ParkingArea(String paID, String area_Name, double fee, String vehicle_category) {
        this.paID = paID;
        this.area_Name = area_Name;
        this.fee = fee;
        this.vehicle_category = vehicle_category;
    }

    /**
     * @return the paID
     */
    public String getPaID() {
        return paID;
    }

    /**
     * @param paID the paID to set
     */
    public void setPaID(String paID) {
        this.paID = paID;
    }

    /**
     * @return the area_Name
     */
    public String getArea_Name() {
        return area_Name;
    }

    /**
     * @param area_Name the area_Name to set
     */
    public void setArea_Name(String area_Name) {
        this.area_Name = area_Name;
    }

    /**
     * @return the fee
     */
    public double getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(double fee) {
        this.fee = fee;
    }

    /**
     * @return the vehicle_category
     */
    public String getVehicle_category() {
        return vehicle_category;
    }

    /**
     * @param vehicle_category the vehicle_category to set
     */
    public void setVehicle_category(String vehicle_category) {
        this.vehicle_category = vehicle_category;
    }

}
