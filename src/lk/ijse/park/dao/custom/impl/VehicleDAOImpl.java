/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.park.dao.CrudUtil;
import lk.ijse.park.dao.custom.VehicleDAO;
import lk.ijse.park.entity.Vehicle;

public class VehicleDAOImpl implements VehicleDAO {

    @Override
    public boolean save(Vehicle entity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO vehicle VALUES(?,?,?,?)", entity.getvID(), entity.getVehicleNumber(), entity.getVehicleColour(), entity.getVehicleCategory()) > 0;
    }

    @Override
    public ArrayList<Vehicle> getAll() throws Exception {
        ArrayList<Vehicle> alVehicles = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Vehicle");
        while (rst.next()) {
            alVehicles.add(new Vehicle(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)));
        }
        return alVehicles;
    }

    @Override
    public boolean update(Vehicle entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Vehicle SET  vehicleNumber=?, vehicleColour=? WHERE vID=?", entity.getVehicleNumber(), entity.getVehicleColour()) > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE From Vehicle where vID=(?)", id) > 0;
    }

    @Override
    public Vehicle search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * From Vehicle where vID=(?)", id);
        if (rst.next()) {
            return new Vehicle(rst.getString("vID"), rst.getString("vehicleCategory"), rst.getString("vehicleNumber"), rst.getString("vehicleColour"));
        } else {
            return null;
        }
    }

    @Override
    public Vehicle searchByVehicleNumber(String number) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * From Vehicle where vehicleNumber=(?)", number);
        if (rst.next()) {
            return new Vehicle(rst.getString("vID"), rst.getString("vehicleCategory"), rst.getString("vehicleNumber"), rst.getString("vehicleColour"));
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteFromVehicleNumber(String number)  throws Exception{
        return CrudUtil.executeUpdate("DELETE From Vehicle where vehicleNumber=(?)", number) > 0;
    }

}
