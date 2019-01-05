/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.park.business.custom.SlotBookingBO;
import lk.ijse.park.dao.DAOFactory;
import lk.ijse.park.dao.custom.SlotBookingDAO;
import lk.ijse.park.entity.SlotBooking;
import lk.ijse.park.model.SlotBookingDTO;

public class SlotBookingBOImpl implements SlotBookingBO {

    private final SlotBookingDAO slotBookingDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SLOTBOOKING);

    @Override
    public boolean addSlotBooking(SlotBookingDTO slotBookingDTO) throws Exception {
        return slotBookingDAO.save(new SlotBooking(slotBookingDTO.getPsID(), slotBookingDTO.isBooked(), slotBookingDTO.gettID()));
    }

    @Override
    public boolean deleteSlotBooking(String psid) throws Exception {
        return slotBookingDAO.delete(psid);
    }

    @Override
    public boolean updateSlotBooking(SlotBookingDTO slotBookingDTO) throws Exception {
        return slotBookingDAO.update(new SlotBooking(slotBookingDTO.getPsID(), slotBookingDTO.isBooked(), slotBookingDTO.gettID()));
    }

    @Override
    public SlotBookingDTO searchSlotBooking(String psid) throws Exception {
        SlotBooking search = slotBookingDAO.search(psid);
        if (search != null) {
            return new SlotBookingDTO(search.getPsID(), search.isBooked(), search.gettID());
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<SlotBookingDTO> getAllSlotBookings() throws Exception {
        ArrayList<SlotBooking> slotBookings = slotBookingDAO.getAll();
        ArrayList<SlotBookingDTO> dtos = new ArrayList<>();
        slotBookings.stream().forEach((e) -> {
            dtos.add(new SlotBookingDTO(e.getPsID(), e.isBooked(), e.gettID()));
        });
        return dtos;
    }

    @Override
    public ArrayList<String> getAllSlotBookingIds() throws Exception {
        ArrayList<SlotBooking> all = slotBookingDAO.getAll();
        ArrayList<String> allIds = new ArrayList<>();
        for (SlotBooking slotBooking : all) {
            allIds.add(slotBooking.getPsID());
        }
        return allIds;
    }

}
