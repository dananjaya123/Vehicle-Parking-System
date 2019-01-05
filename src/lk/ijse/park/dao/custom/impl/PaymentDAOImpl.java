/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import lk.ijse.park.dao.CrudUtil;
import lk.ijse.park.dao.custom.PaymentDAO;
import lk.ijse.park.entity.Payment;


public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public boolean save(Payment entity) throws Exception {
         return CrudUtil.executeUpdate("INSERT INTO Payment VALUES (?,?,?,?)", entity.getpID(), entity.getPtID(), entity.getDate(),entity.getAmount()) > 0;
    }

    @Override
    public boolean update(Payment entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Payment SET PtID=? , Date=?, amount=? WHERE PID=?", entity.getPtID(), entity.getDate(),entity.getAmount(),entity.getpID()) > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE From Payment where PID=(?)",id) > 0;
    }

    @Override
    public Payment search(String id) throws Exception {
       ResultSet rst = CrudUtil.executeQuery("Select * From Payment where PID=(?)", id);
        if (rst.next()) {
            return new Payment(rst.getString("PID"), rst.getString("PtID"), new Date(rst.getString("date")), rst.getDouble("amount"));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Payment> getAll() throws Exception {
        ArrayList<Payment> alPayments = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM ParkinArea");
        while (rst.next()) {
            alPayments.add(new Payment(rst.getString(1),
                    rst.getString(2),
                    rst.getDate(3),
                    rst.getDouble(4)));
        }
        return alPayments;
    }
    
}
