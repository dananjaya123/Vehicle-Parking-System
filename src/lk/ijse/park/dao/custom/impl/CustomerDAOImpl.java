/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.park.dao.CrudUtil;
import lk.ijse.park.dao.custom.CustomerDAO;
import lk.ijse.park.entity.Customer;

/**
 *
 * @author asitha
 */
public class CustomerDAOImpl implements CustomerDAO{
    
    @Override
    public boolean save(Customer customer) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Customer VALUES (?,?,?,?,?)", customer.getNic(), customer.getName(), customer.getAddress(),customer.getTel(), customer.getEmail()) > 0;
    }

    @Override
    public boolean update(Customer entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Customer SET name=?, address=?, salary=? WHERE Nic=?", entity.getName(), entity.getAddress(), entity.getEmail(), entity.getNic()) > 0;
    }

    @Override
    public boolean delete(String Nic) throws Exception {
        return CrudUtil.executeUpdate("DELETE From Customer where Nic=(?)",Nic) > 0;
    }

    @Override
    public Customer search(String Nic) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * From Customer where Nic=(?)", Nic);
        if (rst.next()) {
            return new Customer(rst.getString("Nic"), rst.getString("name"), rst.getString("address"), rst.getString("Email"), rst.getString("phoneNumber"));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        ArrayList<Customer> alCustomers = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Customer");
        while (rst.next()) {
            alCustomers.add(new Customer(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)));
        }
        return alCustomers;
    }

   
}
