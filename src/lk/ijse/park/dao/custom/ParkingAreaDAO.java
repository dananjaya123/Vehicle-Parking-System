/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.dao.custom;

import lk.ijse.park.dao.CrudDAO;
import lk.ijse.park.entity.ParkingArea;

/**
 *
 * @author asitha
 */
public interface ParkingAreaDAO extends CrudDAO<ParkingArea, String> {
     public ParkingArea searchParkingAreaByVehicleCategory(String vehicleCategory) throws Exception;
}
