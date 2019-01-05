/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.dao.custom;

import lk.ijse.park.dao.CrudDAO;
import lk.ijse.park.entity.Vehicle;

/**
 *
 * @author asitha
 */
public interface VehicleDAO extends CrudDAO<Vehicle, String> {

    public boolean deleteFromVehicleNumber(String number) throws Exception;

    public Vehicle searchByVehicleNumber(String number) throws Exception;

}
