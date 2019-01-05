/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.park.dao.CrudUtil;
import lk.ijse.park.entity.ParkingArea;
import lk.ijse.park.dao.custom.ParkingAreaDAO;
import lk.ijse.park.model.ParkingAreaDTO;

public class ParkinAreaDAOImpl implements ParkingAreaDAO {

    @Override
    public boolean save(ParkingArea entity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO ParkingArea VALUES (?,?,?,?)", entity.getPaID(), entity.getArea_Name(), entity.getFee(), entity.getVehicle_category()) > 0;
    }

    @Override
    public boolean update(ParkingArea entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE ParkingArea SET area_Name=?, fee=?,vehiclecategory=? WHERE PaID=(?)", entity.getArea_Name(), entity.getFee(), entity.getVehicle_category(), entity.getPaID()
        ) > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE From ParkingArea where PaID=(?)", id) > 0;
    }

    @Override
    public ParkingArea search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * From ParkingArea where PaID=(?)", id);
        if (rst.next()) {
            return new ParkingArea(rst.getString("PaID"), rst.getString("area_Name"), rst.getDouble("fee"), rst.getString("vehiclecategory"));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<ParkingArea> getAll() throws Exception {
        ArrayList<ParkingArea> alParkingArea = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM ParkingArea");
        while (rst.next()) {
            alParkingArea.add(new ParkingArea(rst.getString(1),
                    rst.getString(2), rst.getDouble(3), rst.getString(4)));
        }
        return alParkingArea;
    }

    @Override
    public ParkingArea searchParkingAreaByVehicleCategory(String vehicleCategory) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * From ParkingArea where vehiclecategory=(?)", vehicleCategory);
        if (rst.next()) {
            return new ParkingArea(rst.getString("PaID"), rst.getString("area_Name"), rst.getDouble("fee"), rst.getString("vehiclecategory"));
        } else {
            return null;
        }
    }

}
