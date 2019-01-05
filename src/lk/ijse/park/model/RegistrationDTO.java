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
public class RegistrationDTO {
    private String rID;
    private String vID;
    private String nic;
    private String date;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String rID, String vID, String nic, String date) {
        this.rID = rID;
        this.vID = vID;
        this.nic = nic;
        this.date = date;
    }
    

    @Override
    public String toString() {
        return "RegistrationDTO{" + "rID=" + getrID() + ", vID=" + getvID() + ", nic=" + getNic() + ", date=" + getDate() + '}';
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
