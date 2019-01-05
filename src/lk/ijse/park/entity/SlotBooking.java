/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.entity;

/**
 *
 * @author Kasun
 */
public class SlotBooking {
    private String psID;
    private boolean booked;
    private String tID;
    

    public SlotBooking() {
    }

    public SlotBooking(String psID, boolean booked, String tID) {
        this.psID = psID;
        this.booked = booked;
        this.tID = tID;
    }

    /**
     * @return the psID
     */
    public String getPsID() {
        return psID;
    }

    /**
     * @param psID the psID to set
     */
    public void setPsID(String psID) {
        this.psID = psID;
    }

    /**
     * @return the booked
     */
    public boolean isBooked() {
        return booked;
    }

    /**
     * @param booked the booked to set
     */
    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    /**
     * @return the tID
     */
    public String gettID() {
        return tID;
    }

    /**
     * @param tID the tID to set
     */
    public void settID(String tID) {
        this.tID = tID;
    }

    
}
