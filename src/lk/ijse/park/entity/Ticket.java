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
public class Ticket {
    private String tID;
    private String rID;
    private String psID;
    private String paID;
    private String check_In_Time;
    private String check_In_Date;
    private String customer_Name;
    private String phone_Number;
    private String check_Out_Time;
    private String check_Out_Date;

    public Ticket() {
    }

    public Ticket(String tID, String rID, String psID, String paID, String check_In_Time, String check_In_Date, String customer_Name, String phone_Number, String check_Out_Time, String check_Out_Date) {
        this.tID = tID;
        this.rID = rID;
        this.psID = psID;
        this.paID = paID;
        this.check_In_Time = check_In_Time;
        this.check_In_Date = check_In_Date;
        this.customer_Name = customer_Name;
        this.phone_Number = phone_Number;
        this.check_Out_Time = check_Out_Time;
        this.check_Out_Date = check_Out_Date;
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

    /**
     * @return the rID
     */
    public String getrID() {
        return rID;
    }

    /**
     * @param rID the rID to set
     */
    public void setrID(String rID) {
        this.rID = rID;
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
     * @return the check_In_Time
     */
    public String getCheck_In_Time() {
        return check_In_Time;
    }

    /**
     * @param check_In_Time the check_In_Time to set
     */
    public void setCheck_In_Time(String check_In_Time) {
        this.check_In_Time = check_In_Time;
    }

    /**
     * @return the check_In_Date
     */
    public String getCheck_In_Date() {
        return check_In_Date;
    }

    /**
     * @param check_In_Date the check_In_Date to set
     */
    public void setCheck_In_Date(String check_In_Date) {
        this.check_In_Date = check_In_Date;
    }

    /**
     * @return the customer_Name
     */
    public String getCustomer_Name() {
        return customer_Name;
    }

    /**
     * @param customer_Name the customer_Name to set
     */
    public void setCustomer_Name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    /**
     * @return the phone_Number
     */
    public String getPhone_Number() {
        return phone_Number;
    }

    /**
     * @param phone_Number the phone_Number to set
     */
    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    /**
     * @return the check_Out_Time
     */
    public String getCheck_Out_Time() {
        return check_Out_Time;
    }

    /**
     * @param check_Out_Time the check_Out_Time to set
     */
    public void setCheck_Out_Time(String check_Out_Time) {
        this.check_Out_Time = check_Out_Time;
    }

    /**
     * @return the check_Out_Date
     */
    public String getCheck_Out_Date() {
        return check_Out_Date;
    }

    /**
     * @param check_Out_Date the check_Out_Date to set
     */
    public void setCheck_Out_Date(String check_Out_Date) {
        this.check_Out_Date = check_Out_Date;
    }

}
