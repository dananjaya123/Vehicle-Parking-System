/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.model;

/**
 *
 * @author asitha
 */
public class FeeDTO {

    private String feeID;
    private String fee;
    private String paID;

    public FeeDTO() {
    }

    public FeeDTO(String feeID, String fee, String paID) {
        this.feeID = feeID;
        this.fee = fee;
        this.paID = paID;
    }

    /**
     * @return the feeID
     */
    public String getFeeID() {
        return feeID;
    }

    /**
     * @param feeID the feeID to set
     */
    public void setFeeID(String feeID) {
        this.feeID = feeID;
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
