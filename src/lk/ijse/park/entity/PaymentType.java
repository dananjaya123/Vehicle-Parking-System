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
public class PaymentType {
    public String ptID;
    public String payment_Tyep;

    public PaymentType() {
    }

    public PaymentType(String ptID, String payment_Tyep) {
        this.ptID = ptID;
        this.payment_Tyep = payment_Tyep;
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
     * @return the payment_Tyep
     */
    public String getPayment_Tyep() {
        return payment_Tyep;
    }

    /**
     * @param payment_Tyep the payment_Tyep to set
     */
    public void setPayment_Tyep(String payment_Tyep) {
        this.payment_Tyep = payment_Tyep;
    }
    
}
