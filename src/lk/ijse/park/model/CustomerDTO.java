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
public class CustomerDTO {
    private String nic;
    private String name;
    private String address;
    private String email;
    private String tel;
   

    public CustomerDTO() {
    }

    public CustomerDTO(String nic, String name, String address, String email, String tel) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.email = email;
        this.tel = tel;
    }

    

    @Override
    public String toString() {
        return "CustomerDTO{" + "nic=" + getNic() + ", name=" + getName() + ", address=" + getAddress() + ", email=" + getEmail() + '}';
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }
    
}
