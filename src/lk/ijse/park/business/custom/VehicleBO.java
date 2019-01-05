/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom;

import java.util.ArrayList;
import lk.ijse.park.business.SuperBO;
import lk.ijse.park.model.VehicleDTO;

/**
 *
 * @author asitha
 */
public interface VehicleBO extends SuperBO {

    public boolean addVehicle(VehicleDTO vehicleDTO) throws Exception;

    public boolean deleteFromVehicleNumber(String number) throws Exception;

   public VehicleDTO searchByVehicleNumber(String number) throws Exception;

   public boolean deleteVehicle(String customerId) throws Exception;

    public boolean updateVehicle(VehicleDTO vehicleDTO) throws Exception;

   public VehicleDTO searchVehicle(String id) throws Exception;

    public ArrayList<VehicleDTO> getAllVehicle() throws Exception;

    public ArrayList<String> getAllVehivleIds() throws Exception;
}
