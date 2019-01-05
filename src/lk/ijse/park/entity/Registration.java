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
public class Registration {
    private String rID;
    private String vID;
    private String nic;
    private String date;

    public Registration() {
    }

    public Registration(String rID, String vID, String nic, String date) {
        this.rID = rID;
        this.vID = vID;
        this.nic = nic;
        this.date = date;
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
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

   
}
