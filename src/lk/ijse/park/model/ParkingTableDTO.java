/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.model;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author asitha
 */
public class ParkingTableDTO {
    private String name;
    private String nic;
    private String vehicleNumber;
    private String checkInDate;
    private String checkInTime;
    private String checkOutDate;
    private String checkOutTime;
    private Double amount;
    private String parkingArea;

    public ParkingTableDTO() {
    }

    public ParkingTableDTO(String name, String nic, String vehicleNumber, String checkInDate, String checkInTime, String checkOutDate, String checkOutTime, Double amount, String parkingArea) {
        this.name = name;
        this.nic = nic;
        this.vehicleNumber = vehicleNumber;
        this.checkInDate = checkInDate;
        this.checkInTime = checkInTime;
        this.checkOutDate = checkOutDate;
        this.checkOutTime = checkOutTime;
        this.amount = amount;
        this.parkingArea = parkingArea;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
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
     * @return the checkInDate
     */
    public String getCheckInDate() {
        return checkInDate;
    }

    /**
     * @param checkInDate the checkInDate to set
     */
    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    /**
     * @return the checkInTime
     */
    public String getCheckInTime() {
        return checkInTime;
    }

    /**
     * @param checkInTime the checkInTime to set
     */
    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    /**
     * @return the checkOutDate
     */
    public String getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * @param checkOutDate the checkOutDate to set
     */
    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    /**
     * @return the checkOutTime
     */
    public String getCheckOutTime() {
        return checkOutTime;
    }

    /**
     * @param checkOutTime the checkOutTime to set
     */
    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    /**
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * @return the parkingArea
     */
    public String getParkingArea() {
        return parkingArea;
    }

    /**
     * @param parkingArea the parkingArea to set
     */
    public void setParkingArea(String parkingArea) {
        this.parkingArea = parkingArea;
    }

    
            
}
