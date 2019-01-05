 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.park.business.custom.CustomerBO;
import lk.ijse.park.dao.DAOFactory;
import lk.ijse.park.dao.custom.CustomerDAO;
import lk.ijse.park.entity.Customer;
import lk.ijse.park.model.CustomerDTO;

/**
 *
 * @author asitha
 */
public class CustomerBOImpl implements CustomerBO {
    

    private CustomerDAO customerDAO;

    public CustomerBOImpl() {
        this.customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    }

    @Override
    public boolean addCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.save(new Customer(customer.getNic(), customer.getName(), customer.getAddress(), customer.getTel(), customer.getEmail()));
    }

    @Override
    public boolean deleteCustomer(String customerId) throws Exception {
        return customerDAO.delete(customerId);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.update(new Customer(
                customer.getNic(),
                customer.getName(),
                customer.getAddress(),
                customer.getEmail(),
                customer.getTel()));
    }

    @Override
    public CustomerDTO searchCustomer(String customerId) throws Exception {
        Customer search = customerDAO.search(customerId);
        return new CustomerDTO(
                search.getNic(),
                search.getName(),
                search.getAddress(),
                search.getEmail(),
                search.getTel());
    }

    @Override
    public ArrayList<String> getAllCustomerIds() throws Exception {
        ArrayList<Customer> all = customerDAO.getAll();
        ArrayList<String> allIds = new ArrayList<>();
        for (Customer customer : all) {
            allIds.add(customer.getNic());
        }
        return allIds;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        ArrayList<Customer> customers = customerDAO.getAll();
        ArrayList<CustomerDTO> dtos = new ArrayList<>();
        customers.stream().forEach((e) -> {
            dtos.add(new CustomerDTO(e.getNic(), e.getName(), e.getAddress(), e.getTel(), e.getEmail()));
        });
        return dtos;
    }

    

}
