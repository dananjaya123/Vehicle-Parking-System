/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.dao.custom;

import java.util.ArrayList;
import lk.ijse.park.dao.CrudDAO;
import lk.ijse.park.entity.ParkingSlot;

/**
 *
 * @author asitha
 */
public interface ParkingSlotDAO extends CrudDAO<ParkingSlot, String> {

    public ArrayList<ParkingSlot> getAllBypaID(String paid) throws Exception;
}
