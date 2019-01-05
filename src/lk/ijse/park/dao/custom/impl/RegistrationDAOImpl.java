/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.park.dao.CrudUtil;
import lk.ijse.park.dao.custom.RegistrationDAO;
import lk.ijse.park.entity.Registration;

public class RegistrationDAOImpl implements RegistrationDAO {

    @Override
    public boolean save(Registration entity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Registration VALUES (?,?,?,?)", entity.getrID(), entity.getvID(), entity.getNic(), entity.getDate()) > 0;
    }

    @Override
    public boolean update(Registration entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Registration SET vID=?, Nic=? ,Date=? WHERE RID=?", entity.getvID(), entity.getNic(), entity.getDate(), entity.getrID()) > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE From Registration where Rid=(?)", id) > 0;
    }

    @Override
    public Registration search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * From Registration where Rid=(?)", id);
        if (rst.next()) {
            return new Registration(rst.getString("rID"), rst.getString("vID"), rst.getString("nic"), rst.getString("date"));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Registration> getAll() throws Exception {
        ArrayList<Registration> alRegistrations = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Customer");
        while (rst.next()) {
            alRegistrations.add(new Registration(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)));
        }
        return alRegistrations;
    }

}
