/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom;

import java.util.ArrayList;
import lk.ijse.park.business.SuperBO;
import lk.ijse.park.model.CustomerDTO;

/**
 *
 * @author asitha
 */
public interface CustomerBO extends SuperBO {

    public boolean addCustomer(CustomerDTO customer) throws Exception;

    public boolean deleteCustomer(String customerId) throws Exception;

    public boolean updateCustomer(CustomerDTO customer) throws Exception;

    public CustomerDTO searchCustomer(String customerId) throws Exception;

    public ArrayList<CustomerDTO> getAllCustomers() throws Exception;

    public ArrayList<String> getAllCustomerIds() throws Exception;
    
   

}
