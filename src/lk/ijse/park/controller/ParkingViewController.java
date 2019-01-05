/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXMasonryPane;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.park.business.BOFactory;
import lk.ijse.park.business.custom.ParkingAreaBO;
import lk.ijse.park.business.custom.ParkingSlotBO;
import lk.ijse.park.business.custom.RegistrationBO;
import lk.ijse.park.business.custom.SlotBookingBO;
import lk.ijse.park.business.custom.TicketBO;
import lk.ijse.park.business.custom.VehicleBO;
import lk.ijse.park.model.ParkingSlotDTO;
import lk.ijse.park.model.SlotBookingDTO;
import lk.ijse.park.model.TicketDTO;
import lk.ijse.park.resources.CustomMethod;

/**
 * FXML Controller class
 *
 * @author asitha
 */
public class ParkingViewController implements Initializable {

    @FXML
    private AnchorPane pmlParkingView;
    @FXML
    private JFXMasonryPane paneHeavyVehicleSlots;

    private ParkingAreaBO parkingAreaBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.PARKINGAREA);
    private ParkingSlotBO parkingSlotBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.PARKINGSLOT);
    private SlotBookingBO slotBookingBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.SLOTBOOKING);
    private TicketBO ticketBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.TICKET);
    private RegistrationBO registrationBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.REGISTRATION);
    private VehicleBO vehicleBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.VEHICLE);
    @FXML
    private JFXMasonryPane paneLightVehicleSlots;
    @FXML
    private JFXMasonryPane paneBicycleVehicleSlots;
    @FXML
    private JFXTextField txtVehicleNumber;
    @FXML
    private JFXTextField txtCustomerName;
    @FXML
    private JFXTextField txtPhoneNumber;
    @FXML
    private JFXTextField txtCheckInDate;
    @FXML
    private JFXTextField txtTimeIn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            for (ParkingSlotDTO parkingSlotDTO : parkingSlotBO.getAllParkingSlot()) {
                if (parkingAreaBO.searchParkingArea(parkingSlotDTO.getPaID()).getVehicle_category().equalsIgnoreCase("Heavy")) {
                    createHeavyButton(parkingSlotDTO.getPsID());
                }
                if (parkingAreaBO.searchParkingArea(parkingSlotDTO.getPaID()).getVehicle_category().equalsIgnoreCase("Light")) {
                    createLightButton(parkingSlotDTO.getPsID());
                }
                if (parkingAreaBO.searchParkingArea(parkingSlotDTO.getPaID()).getVehicle_category().equalsIgnoreCase("Bicycle")) {
                    createBicycleButton(parkingSlotDTO.getPsID());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ParkingViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void createHeavyButton(String id) throws Exception {
        JFXButton btn = new JFXButton(id);
        btn.setCursor(Cursor.HAND);
        paneHeavyVehicleSlots.setCellHeight(50);
        paneHeavyVehicleSlots.setCellWidth(50);
        paneHeavyVehicleSlots.getChildren().add(btn);
        SlotBookingDTO searchSlotBooking = slotBookingBO.searchSlotBooking(id);
        System.out.println("ID : " + id);
        System.out.println("slot Booking : " + searchSlotBooking);

        if (searchSlotBooking != null && searchSlotBooking.isBooked()) {
            btn.setStyle("-fx-background-color:#F00;");
            btn.setOnAction((ActionEvent event) -> {
                try {
                    TicketDTO searchTicket = ticketBO.searchTicket(searchSlotBooking.gettID());
                    txtCheckInDate.setText(searchTicket.getCheck_In_Date());
                    txtCustomerName.setText(searchTicket.getCustomer_Name());
                    txtPhoneNumber.setText(searchTicket.getPhone_Number());
                    txtTimeIn.setText(searchTicket.getCheck_In_Time());
                    txtVehicleNumber.setText(vehicleBO.searchVehicle(registrationBO.searchRegistration(searchTicket.getrID()).getvID()).getVehicleNumber());
                } catch (Exception ex) {
                    Logger.getLogger(ParkingViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } else {
            btn.setStyle("-fx-background-color:#87D37C;");
            btn.setOnAction((ActionEvent event) -> {
                CustomMethod.parkingSlot = id;
                ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
            });

        }
    }

    public void createLightButton(String id) throws Exception {
         JFXButton btn = new JFXButton(id);
        btn.setCursor(Cursor.HAND);
        paneLightVehicleSlots.setCellHeight(50);
        paneLightVehicleSlots.setCellWidth(50);
        paneLightVehicleSlots.getChildren().add(btn);
        SlotBookingDTO searchSlotBooking = slotBookingBO.searchSlotBooking(id);
        System.out.println("ID : " + id);
        System.out.println("slot Booking : " + searchSlotBooking);

        if (searchSlotBooking != null && searchSlotBooking.isBooked()) {
            btn.setStyle("-fx-background-color:#F00;");
            btn.setOnAction((ActionEvent event) -> {
                try {
                    TicketDTO searchTicket = ticketBO.searchTicket(searchSlotBooking.gettID());
                    txtCheckInDate.setText(searchTicket.getCheck_In_Date());
                    txtCustomerName.setText(searchTicket.getCustomer_Name());
                    txtPhoneNumber.setText(searchTicket.getPhone_Number());
                    txtTimeIn.setText(searchTicket.getCheck_In_Time());
                    txtVehicleNumber.setText(vehicleBO.searchVehicle(registrationBO.searchRegistration(searchTicket.getrID()).getvID()).getVehicleNumber());
                } catch (Exception ex) {
                    Logger.getLogger(ParkingViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } else {
            btn.setStyle("-fx-background-color:#87D37C;");
            btn.setOnAction((ActionEvent event) -> {
                CustomMethod.parkingSlot = id;
                ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
            });

        }

    }

    public void createBicycleButton(String id) {
        JFXButton btn = new JFXButton(id);
        btn.setStyle("-fx-background-color:#87D37C;");
        btn.setCursor(Cursor.HAND);
        paneBicycleVehicleSlots.setCellHeight(50);
        paneBicycleVehicleSlots.setCellWidth(50);
        paneBicycleVehicleSlots.getChildren().add(btn);

        btn.setOnAction((ActionEvent event) -> {
            CustomMethod.parkingSlot = id;
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        });

    }
}
