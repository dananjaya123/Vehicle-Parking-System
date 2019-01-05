/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.entity;

import java.util.Date;

/**
 *
 * @author asitha
 */
public class Payment {
    public String pID;
    public String ptID;
    public Date date;
    public Double amount;

    public Payment() {
    }

    public Payment(String pID, String ptID, Date date, Double amount) {
        this.pID = pID;
        this.ptID = ptID;
        this.date = date;
        this.amount = amount;
    }

    /**
     * @return the pID
     */
    public String getpID() {
        return pID;
    }

    /**
     * @param pID the pID to set
     */
    public void setpID(String pID) {
        this.pID = pID;
    }

    /**
     * @return the ptID
     */
    public String getPtID() {
        return ptID;
    }

    /**
     * @param ptID the ptID to set
     */
    public void setPtID(String ptID) {
        this.ptID = ptID;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
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
    
}
