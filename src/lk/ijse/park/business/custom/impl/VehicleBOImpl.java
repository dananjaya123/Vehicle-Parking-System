/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.park.business.custom.VehicleBO;
import lk.ijse.park.dao.DAOFactory;
import lk.ijse.park.dao.custom.VehicleDAO;
import lk.ijse.park.entity.Vehicle;
import lk.ijse.park.model.VehicleDTO;

/**
 *
 * @author asitha
 */
public class VehicleBOImpl implements VehicleBO {

    private VehicleDAO vehicleDAO;

    public VehicleBOImpl() {
        this.vehicleDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.VEHICLE);
    }

    @Override
    public boolean addVehicle(VehicleDTO vehicleDTO) throws Exception {
        return vehicleDAO.save(new Vehicle(vehicleDTO.getvID(),vehicleDTO.getVehicleNumber(),vehicleDTO.getVehicleColour(),vehicleDTO.getVehicleCategory()));
    }

 

    @Override
    public boolean deleteVehicle(String customerId) throws Exception {
        return vehicleDAO.delete(customerId);
    }

    @Override
    public boolean updateVehicle(VehicleDTO vehicleDTO) throws Exception {
        return vehicleDAO.update(new Vehicle(vehicleDTO.getvID(), vehicleDTO.getVehicleNumber(), vehicleDTO.getVehicleColour(), vehicleDTO.getVehicleCategory()));
    }


    @Override
    public ArrayList<VehicleDTO> getAllVehicle() throws Exception {
        ArrayList<Vehicle> vehicles = vehicleDAO.getAll();
        ArrayList<VehicleDTO> dtos = new ArrayList<>();
        vehicles.stream().forEach((e) -> {
            dtos.add(new VehicleDTO(e.getvID(),e.getVehicleNumber(), e.getVehicleColour(),e.getVehicleCategory()));
            });
        return dtos;
    }

    @Override
    public ArrayList<String> getAllVehivleIds() throws Exception {
        ArrayList<Vehicle> vehicles = vehicleDAO.getAll();
        ArrayList<String> ids = new ArrayList<>();
        vehicles.stream().forEach((e) -> {
            ids.add(e.getvID());
        });
        return ids;
    }

    @Override
    public boolean deleteFromVehicleNumber(String number) throws Exception {
      return vehicleDAO.deleteFromVehicleNumber(number);
    }

    @Override
    public VehicleDTO searchByVehicleNumber(String number) throws Exception {
         Vehicle vehicle = vehicleDAO.searchByVehicleNumber(number);
        return new VehicleDTO(vehicle.getvID(),vehicle.getVehicleNumber(), vehicle.getVehicleColour(),vehicle.getVehicleCategory());
    }

   
    @Override
    public VehicleDTO searchVehicle(String id) throws Exception {
      Vehicle vehicle = vehicleDAO.search(id);
       return new VehicleDTO(vehicle.getvID(), vehicle.getVehicleNumber(), vehicle.getVehicleColour(),vehicle.getVehicleCategory());
   
    }

}
