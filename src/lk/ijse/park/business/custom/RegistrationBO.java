/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom;

import java.util.ArrayList;
import lk.ijse.park.business.SuperBO;
import lk.ijse.park.model.RegistrationDTO;

/**
 *
 * @author asitha
 */
public interface RegistrationBO extends SuperBO {
    
    public boolean addRegistration(RegistrationDTO registration) throws Exception;

    public boolean deleteRegistration(String registrationId) throws Exception;

    public boolean updateRegistration(RegistrationDTO registration) throws Exception;

    public RegistrationDTO searchRegistration(String registrationId) throws Exception;

    public ArrayList<RegistrationDTO> getAllRegistration() throws Exception;

    public ArrayList<String> getAllRegistrationIds() throws Exception;
}
