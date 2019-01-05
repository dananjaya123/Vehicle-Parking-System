/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.dao;

import lk.ijse.park.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.park.dao.custom.impl.ParkinAreaDAOImpl;
import lk.ijse.park.dao.custom.impl.ParkingSlotDAOImpl;
import lk.ijse.park.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.park.dao.custom.impl.PaymentTypeDAOImpl;
import lk.ijse.park.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.park.dao.custom.impl.SlotBookingDAOImpl;
import lk.ijse.park.dao.custom.impl.TicketDAOImpl;
import lk.ijse.park.dao.custom.impl.VehicleDAOImpl;

/**
 *
 * @author asitha
 */
public class DAOFactory {

    public enum DAOTypes {
        CUSTOMER, PARKINGAREA, PARKINGSLOT, PAYMENENT, PAYMENTTYPE, REGISTRATION, TICKET, VEHICLE, SLOTBOOKING;
    }

    private static DAOFactory dAOFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (dAOFactory == null) {
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoType) {
        switch (daoType) {
            case CUSTOMER:
                return (T) new CustomerDAOImpl();

            case PARKINGAREA:
                return (T) new ParkinAreaDAOImpl();
            case PARKINGSLOT:
                return (T) new ParkingSlotDAOImpl();
            case PAYMENENT:
                return (T) new PaymentDAOImpl();
            case PAYMENTTYPE:
                return (T) new PaymentTypeDAOImpl();
            case TICKET:
                return (T) new TicketDAOImpl();
            case VEHICLE:
                return (T) new VehicleDAOImpl();
            case REGISTRATION:
                return (T) new RegistrationDAOImpl();
            case SLOTBOOKING:
                return (T) new SlotBookingDAOImpl();

//            
            default:
                return null;
        }
    }

}
