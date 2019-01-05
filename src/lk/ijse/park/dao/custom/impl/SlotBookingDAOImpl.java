/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.park.dao.CrudUtil;
import lk.ijse.park.dao.custom.SlotBookingDAO;
import lk.ijse.park.entity.Customer;
import lk.ijse.park.entity.SlotBooking;

public class SlotBookingDAOImpl implements SlotBookingDAO {

    @Override
    public boolean save(SlotBooking entity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO slotbooking VALUES (?,?,?)", entity.getPsID(), entity.isBooked(), entity.gettID()) > 0;
    }

    @Override
    public boolean update(SlotBooking entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE slotbooking SET booked=?,tid=? WHERE psid=?", entity.isBooked(), entity.gettID(), entity.getPsID()) > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE From slotbooking where psid=(?)", id) > 0;
    }

    @Override
    public SlotBooking search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * From slotbooking where psid=(?)", id);
        if (rst.next()) {
            return new SlotBooking(rst.getString(1), rst.getBoolean(2), rst.getString(3));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<SlotBooking> getAll() throws Exception {
        ArrayList<SlotBooking> slotBookings = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM slotbooking");
        while (rst.next()) {
            slotBookings.add(new SlotBooking(rst.getString(1), rst.getBoolean(2), rst.getString(3)));
        }
        return slotBookings;
    }

}
