/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.park.dao.CrudUtil;
import lk.ijse.park.dao.custom.PaymentTypeDAO;
import lk.ijse.park.entity.PaymentType;


public class PaymentTypeDAOImpl implements PaymentTypeDAO {

    @Override
    public boolean save(PaymentType entity) throws Exception {
         return CrudUtil.executeUpdate("INSERT INTO PaymentType VALUES (?,?)", entity.getPtID(), entity.getPayment_Tyep()) > 0;
    }

    @Override
    public boolean update(PaymentType entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE PaymentType SET Payment_Tyep=? WHERE PtID=?", entity.getPayment_Tyep(), entity.getPtID()) > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE From PaymentType where PtID=(?)",id) > 0;
    }

    @Override
    public PaymentType search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * From PaymentType where PtID=(?)", id);
        if (rst.next()) {
            return new PaymentType(rst.getString("PtID"), rst.getString("payment_Tyep"));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<PaymentType> getAll() throws Exception {
        ArrayList<PaymentType> alPaymentTypes = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM ParkinArea");
        while (rst.next()) {
            alPaymentTypes.add(new PaymentType(rst.getString(1),
                    rst.getString(2)));
        }
        return alPaymentTypes;
    }
}
