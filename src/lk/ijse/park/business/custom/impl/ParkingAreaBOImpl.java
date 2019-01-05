/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.park.business.custom.ParkingAreaBO;
import lk.ijse.park.dao.DAOFactory;
import lk.ijse.park.dao.custom.ParkingAreaDAO;
import lk.ijse.park.entity.ParkingArea;
import lk.ijse.park.model.ParkingAreaDTO;

public class ParkingAreaBOImpl implements ParkingAreaBO {

    private final ParkingAreaDAO parkingAreaDAO;

    public ParkingAreaBOImpl() {
        this.parkingAreaDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PARKINGAREA);

    }

    @Override
    public boolean addParkingArea(ParkingAreaDTO parkingArea) throws Exception {
        return parkingAreaDAO.save(new ParkingArea(parkingArea.getPaID(), parkingArea.getArea_Name(), parkingArea.getFee(), parkingArea.getVehicle_category()));
    }

//    @Override
//    public boolean deleteParkingArea(String parkingAreaId) throws Exception {
//        return parkingAreaDAO.delete(parkingAreaId);
//    }
//
//    @Override
//    public boolean updateParkingArea(ParkingAreaDTO parkingArea) throws Exception {
//        return parkingAreaDAO.update(new ParkingArea(parkingArea.getPaID(), parkingArea.getArea_Name()));
//    }
//
//    @Override
//    public ParkingAreaDTO searchParkingArea(String parkingAreaId) throws Exception {
//        ParkingArea search = parkingAreaDAO.search(parkingAreaId);
//        return new ParkingAreaDTO(search.getPaID(), search.getArea_Name());
//    }
//
//    @Override
    public ArrayList<ParkingAreaDTO> getAllParkingArea() throws Exception {
        ArrayList<ParkingArea> fee = parkingAreaDAO.getAll();
        ArrayList<ParkingAreaDTO> dtos = new ArrayList<>();
        fee.stream().forEach((e) -> {
            dtos.add(new ParkingAreaDTO(e.getPaID(), e.getArea_Name(), e.getFee(), e.getVehicle_category()));
        });
        return dtos;
    }

    @Override
    public ArrayList<String> getAllParkingAreaIds() throws Exception {
        ArrayList<ParkingArea> all = parkingAreaDAO.getAll();
        ArrayList<String> allIds = new ArrayList<>();
        for (ParkingArea fee : all) {
            allIds.add(fee.getPaID());
        }
        return allIds;
    }

    @Override
    public boolean deleteParkingArea(String parkingAreaId) throws Exception {
        return parkingAreaDAO.delete(parkingAreaId);
    }

    @Override
    public boolean updateParkingArea(ParkingAreaDTO parkingArea) throws Exception {
        return parkingAreaDAO.update(new ParkingArea(parkingArea.getPaID(), parkingArea.getArea_Name(), parkingArea.getFee(), parkingArea.getVehicle_category()));
    }

    @Override
    public ParkingAreaDTO searchParkingArea(String parkingAreaId) throws Exception {
        ParkingArea search = parkingAreaDAO.search(parkingAreaId);
        return new ParkingAreaDTO(search.getPaID(), search.getArea_Name(), search.getFee(), search.getVehicle_category());
    }

    @Override
    public ParkingAreaDTO searchParkingAreaByVehicleCategory(String vehicleCategory) throws Exception {
        ParkingArea search = parkingAreaDAO.searchParkingAreaByVehicleCategory(vehicleCategory);
        return search==null?null:new ParkingAreaDTO(search.getPaID(), search.getArea_Name(), search.getFee(), search.getVehicle_category());
    }
}
