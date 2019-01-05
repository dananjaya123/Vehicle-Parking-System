/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom;

import java.util.ArrayList;
import lk.ijse.park.business.SuperBO;
import lk.ijse.park.model.ParkingSlotDTO;

/**
 *
 * @author asitha
 */
public interface ParkingSlotBO extends SuperBO {

    public boolean addParkingSlot(ParkingSlotDTO parkingSlot) throws Exception;

    public boolean deleteParkingSlot(String parkingSlotId) throws Exception;

    public boolean updateParkingSlot(ParkingSlotDTO parkingSlot) throws Exception;

    public ParkingSlotDTO searchParkingSlot(String vehicleCategoriesId) throws Exception;

    public ArrayList<ParkingSlotDTO> getAllParkingSlot() throws Exception;

    public ArrayList<ParkingSlotDTO> getAllParkingSlotsIds(String paid) throws Exception;

}
