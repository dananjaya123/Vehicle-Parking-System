/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom;

import java.util.ArrayList;
import lk.ijse.park.business.SuperBO;
import lk.ijse.park.model.ParkingAreaDTO;

/**
 *
 * @author asitha
 */
public interface ParkingAreaBO extends SuperBO{
    
    public boolean addParkingArea(ParkingAreaDTO  parkingArea) throws Exception;

    public boolean deleteParkingArea(String parkingAreaId) throws Exception;

    public boolean updateParkingArea(ParkingAreaDTO  parkingArea) throws Exception;

    public ParkingAreaDTO searchParkingArea(String parkingAreaId) throws Exception;
    public ParkingAreaDTO searchParkingAreaByVehicleCategory(String vehicleCategory) throws Exception;

    public ArrayList<ParkingAreaDTO> getAllParkingArea() throws Exception;

    public ArrayList<String> getAllParkingAreaIds() throws Exception;

}
