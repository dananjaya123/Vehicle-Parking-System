/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business;

import lk.ijse.park.business.custom.impl.CustomerBOImpl;
import lk.ijse.park.business.custom.impl.ParkingAreaBOImpl;
import lk.ijse.park.business.custom.impl.ParkingSlotBOImpl;
import lk.ijse.park.business.custom.impl.PaymentBOImpl;
import lk.ijse.park.business.custom.impl.PaymentTypeBOImpl;
import lk.ijse.park.business.custom.impl.RegistrationBOImpl;
import lk.ijse.park.business.custom.impl.SlotBookingBOImpl;
import lk.ijse.park.business.custom.impl.TicketBOImpl;
import lk.ijse.park.business.custom.impl.VehicleBOImpl;

/**
 *
 * @author asitha
 */
public class BOFactory {

    public enum BOTypes {
        CUSTOMER, PARKINGAREA, PARKINGSLOT, PAYMENENT, PAYMENTTYPE, REGISTRATION, TICKET, VEHICLE, SLOTBOOKING;
    }

    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public <T extends SuperBO> T getBO(BOTypes boType) {
        switch (boType) {
            case CUSTOMER:
                return (T) new CustomerBOImpl();

            case PARKINGAREA:
                return (T) new ParkingAreaBOImpl();
            case PARKINGSLOT:
                return (T) new ParkingSlotBOImpl();
            case PAYMENENT:
                return (T) new PaymentBOImpl();
            case PAYMENTTYPE:
                return (T) new PaymentTypeBOImpl();
            case REGISTRATION:
                return (T) new RegistrationBOImpl();
            case TICKET:
                return (T) new TicketBOImpl();
            case VEHICLE:
                return (T) new VehicleBOImpl();
            case SLOTBOOKING:
                return (T) new SlotBookingBOImpl();

            default:
                return null;
        }
    }

}
