/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.park.business.custom.ParkingSlotBO;
import lk.ijse.park.dao.DAOFactory;
import lk.ijse.park.dao.custom.ParkingSlotDAO;
import lk.ijse.park.entity.ParkingSlot;
import lk.ijse.park.model.ParkingSlotDTO;

public class ParkingSlotBOImpl implements ParkingSlotBO {

    private final ParkingSlotDAO parkingSlotDAO;

    public ParkingSlotBOImpl() {
        this.parkingSlotDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PARKINGSLOT);
    }

    @Override
    public boolean addParkingSlot(ParkingSlotDTO parkingSlot) throws Exception {
        return parkingSlotDAO.save(new ParkingSlot(parkingSlot.getPsID(), parkingSlot.getPaID(), parkingSlot.getSlot_Name(), parkingSlot.getLength(), parkingSlot.getWidch()));
    }

    @Override
    public boolean deleteParkingSlot(String parkingSlotId) throws Exception {
        return parkingSlotDAO.delete(parkingSlotId);
    }

    @Override
    public boolean updateParkingSlot(ParkingSlotDTO parkingSlot) throws Exception {
        return parkingSlotDAO.update(new ParkingSlot(parkingSlot.getPsID(), parkingSlot.getPaID(), parkingSlot.getSlot_Name(), parkingSlot.getLength(), parkingSlot.getWidch()));
    }

    @Override
    public ParkingSlotDTO searchParkingSlot(String vehicleCategoriesId) throws Exception {
        ParkingSlot search = parkingSlotDAO.search(vehicleCategoriesId);
        return new ParkingSlotDTO(search.getPsID(), search.getPaID(), search.getSlot_Name(), search.getLength(), search.getWidch());
    }

    @Override
    public ArrayList<ParkingSlotDTO> getAllParkingSlot() throws Exception {
        ArrayList<ParkingSlot> fee = parkingSlotDAO.getAll();
        ArrayList<ParkingSlotDTO> dtos = new ArrayList<>();
        fee.stream().forEach((e) -> {
            dtos.add(new ParkingSlotDTO(e.getPsID(), e.getPaID(), e.getSlot_Name(), e.getLength(), e.getWidch()));
        });
        return dtos;
    }

    @Override
    public ArrayList<ParkingSlotDTO> getAllParkingSlotsIds(String paid) throws Exception {
        ArrayList<ParkingSlot> fee = parkingSlotDAO.getAllBypaID(paid);
        ArrayList<ParkingSlotDTO> dtos = new ArrayList<>();
        fee.stream().forEach((e) -> {
            dtos.add(new ParkingSlotDTO(e.getPsID(), e.getPaID(), e.getSlot_Name(), e.getLength(), e.getWidch()));
        });
        return dtos;
    }

}
