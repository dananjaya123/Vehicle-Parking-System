/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom;

import java.util.ArrayList;
import lk.ijse.park.business.SuperBO;
import lk.ijse.park.model.SlotBookingDTO;

/**
 *
 * @author Kasun
 */
public interface SlotBookingBO extends SuperBO {

    public boolean addSlotBooking(SlotBookingDTO slotBookingDTO) throws Exception;

    public boolean deleteSlotBooking(String psid) throws Exception;

    public boolean updateSlotBooking(SlotBookingDTO slotBookingDTO) throws Exception;

    public SlotBookingDTO searchSlotBooking(String psid) throws Exception;

    public ArrayList<SlotBookingDTO> getAllSlotBookings() throws Exception;

    public ArrayList<String> getAllSlotBookingIds() throws Exception;
}
