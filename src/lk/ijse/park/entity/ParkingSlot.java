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
public class ParkingSlot {
    public String psID;
    public String paID;
    public String slot_Name;
    public String Length;
    public String widch;

    public ParkingSlot() {
    }

    public ParkingSlot(String psID, String paID, String slot_Name, String Length, String widch) {
        this.psID = psID;
        this.paID = paID;
        this.slot_Name = slot_Name;
        this.Length = Length;
        this.widch = widch;
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
     * @return the slot_Name
     */
    public String getSlot_Name() {
        return slot_Name;
    }

    /**
     * @param slot_Name the slot_Name to set
     */
    public void setSlot_Name(String slot_Name) {
        this.slot_Name = slot_Name;
    }

    /**
     * @return the Length
     */
    public String getLength() {
        return Length;
    }

    /**
     * @param Length the Length to set
     */
    public void setLength(String Length) {
        this.Length = Length;
    }

    /**
     * @return the widch
     */
    public String getWidch() {
        return widch;
    }

    /**
     * @param widch the widch to set
     */
    public void setWidch(String widch) {
        this.widch = widch;
    }
    
}
