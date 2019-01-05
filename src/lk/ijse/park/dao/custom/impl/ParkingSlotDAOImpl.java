/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.park.dao.CrudUtil;
import lk.ijse.park.dao.custom.ParkingSlotDAO;
import lk.ijse.park.entity.ParkingSlot;

public class ParkingSlotDAOImpl implements ParkingSlotDAO {

    @Override
    public boolean save(ParkingSlot entity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO ParkingSlot VALUES (?,?,?,?,?)", entity.getPsID(), entity.getPaID(), entity.getSlot_Name(), entity.getLength(), entity.getWidch()) > 0;
    }

    @Override
    public boolean update(ParkingSlot entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE ParkingSlot SET PaID=?, Slot_Name=?, Length=? ,Widch=? WHERE PsID=?", entity.getPaID(), entity.getSlot_Name(), entity.getLength(), entity.getWidch()) > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE From ParkingSlot where psID=(?)", id) > 0;
    }

    @Override
    public ParkingSlot search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * From ParkingSlot where psID=(?)", id);
        if (rst.next()) {
            return new ParkingSlot(rst.getString("Nic"), rst.getString("name"), rst.getString("address"), rst.getString("Email"), rst.getString("phoneNumber"));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<ParkingSlot> getAll() throws Exception {
        ArrayList<ParkingSlot> alParkinSlots = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM ParkingSlot");
        while (rst.next()) {
            alParkinSlots.add(new ParkingSlot(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)));
        }
        return alParkinSlots;
    }

    @Override
    public ArrayList<ParkingSlot> getAllBypaID(String paid) throws Exception {
        ArrayList<ParkingSlot> alParkinSlots = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM ParkingSlot WHERE paID=(?)", paid);
        while (rst.next()) {
            alParkinSlots.add(new ParkingSlot(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)));
        }
        return alParkinSlots;
    }

}
