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
public class Fee {
    public String fID;
    public String fee;
    public String paID;

    public Fee() {
    }

    public Fee(String fID, String fee, String paID) {
        this.fID = fID;
        this.fee = fee;
        this.paID = paID;
    }

    /**
     * @return the fID
     */
    public String getfID() {
        return fID;
    }

    /**
     * @param fID the fID to set
     */
    public void setfID(String fID) {
        this.fID = fID;
    }

    /**
     * @return the fee
     */
    public String getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(String fee) {
        this.fee = fee;
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

   
   
}
