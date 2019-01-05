/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.park.business.BOFactory;
import lk.ijse.park.business.custom.ParkingAreaBO;
import lk.ijse.park.business.custom.ParkingSlotBO;
import lk.ijse.park.business.custom.RegistrationBO;
import lk.ijse.park.business.custom.SlotBookingBO;
import lk.ijse.park.business.custom.TicketBO;
import lk.ijse.park.business.custom.VehicleBO;
import lk.ijse.park.model.ParkingSlotDTO;
import lk.ijse.park.resources.CustomMethod;

/**
 * FXML Controller class
 *
 * @author asitha
 */
public class DashbordController implements Initializable {

    @FXML
    private AnchorPane pnlDashboard;
    @FXML
    private ImageView imageCar;
    @FXML
    private ImageView imageLongVehicle;
    @FXML
    private ImageView imageBicycle;
    @FXML
    private ImageView immageDashboardHome;
    @FXML
    private LineChart<?, ?> linechartParkingRate;
    @FXML
    private Label lblLight;
    @FXML
    private Label lblHeavy;
    @FXML
    private Label lblBicycle;

    private ParkingAreaBO parkingAreaBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.PARKINGAREA);
    private ParkingSlotBO parkingSlotBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.PARKINGSLOT);
    private SlotBookingBO slotBookingBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.SLOTBOOKING);
    private TicketBO ticketBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.TICKET);
    private RegistrationBO registrationBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.REGISTRATION);
    private VehicleBO vehicleBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.VEHICLE);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            setParkingRate();
            setLabels();
        } catch (Exception ex) {
            Logger.getLogger(DashbordController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void imageCarExited(MouseEvent event) {
        CustomMethod.imageDashboard(imageCar, 1.0);
        
    }

    @FXML
    private void imageCarEntered(MouseEvent event) {
        CustomMethod.imageDashboard(imageCar, 1.2);
        
    }

    @FXML
    private void imageLongVehicleExited(MouseEvent event) {
        CustomMethod.imageDashboard(imageLongVehicle, 1.0);
        
    }

    @FXML
    private void imageLongVehicleEntered(MouseEvent event) {
        CustomMethod.imageDashboard(imageLongVehicle, 1.2);
        
    }

    @FXML
    private void imageBicycleExited(MouseEvent event) {
        CustomMethod.imageDashboard(imageBicycle, 1.0);
       
    }

    @FXML
    private void imageBicycleEntered(MouseEvent event) {
        CustomMethod.imageDashboard(imageBicycle, 1.2);
        
    }

    @FXML
    private void immageDashboardHomeExited(MouseEvent event) {
        CustomMethod.imageDashboard(immageDashboardHome, 1.0);
        
    }

    @FXML
    private void immageDashboardHomeEntered(MouseEvent event) {
        CustomMethod.imageDashboard(immageDashboardHome, 1.2);
       
    }

    private void btnManage2Clicked(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/park/view/Manage.fxml"));
        pnlDashboard.getChildren().setAll(pane);

    }

    private void setParkingRate() {
        XYChart.Series series = new XYChart.Series<>();
        series.setName("Parking Rate");
        series.getData().add(new XYChart.Data<>("January", 10));
        series.getData().add(new XYChart.Data<>("February", 4));
        series.getData().add(new XYChart.Data<>("March", 5));
        series.getData().add(new XYChart.Data<>("April", 14));
        series.getData().add(new XYChart.Data<>("May", 24));
        series.getData().add(new XYChart.Data<>("June", 11));
        series.getData().add(new XYChart.Data<>("July", 15));
        series.getData().add(new XYChart.Data<>("August", 5));
        series.getData().add(new XYChart.Data<>("September", 7));
        series.getData().add(new XYChart.Data<>("October", 20));
        series.getData().add(new XYChart.Data<>("November", 18));
        series.getData().add(new XYChart.Data<>("December", 1));

        linechartParkingRate.getData().addAll(series);

    }

    private void setLabels() throws Exception {
        int light = 0;
        int heavy = 0;
        int bicycle = 0;
        for (ParkingSlotDTO parkingSlotDTO : parkingSlotBO.getAllParkingSlot()) {
            if (parkingAreaBO.searchParkingArea(parkingSlotDTO.getPaID()).getVehicle_category().equalsIgnoreCase("Heavy")) {
                if (slotBookingBO.searchSlotBooking(parkingSlotDTO.getPsID()) == null || !slotBookingBO.searchSlotBooking(parkingSlotDTO.getPsID()).isBooked()) {
                    heavy++;
                }
            }
            if (parkingAreaBO.searchParkingArea(parkingSlotDTO.getPaID()).getVehicle_category().equalsIgnoreCase("Light")) {
                if (slotBookingBO.searchSlotBooking(parkingSlotDTO.getPsID()) == null || !slotBookingBO.searchSlotBooking(parkingSlotDTO.getPsID()).isBooked()) {
                    light++;
                }
            }
            if (parkingAreaBO.searchParkingArea(parkingSlotDTO.getPaID()).getVehicle_category().equalsIgnoreCase("Bicycle")) {
                if (slotBookingBO.searchSlotBooking(parkingSlotDTO.getPsID()) == null || !slotBookingBO.searchSlotBooking(parkingSlotDTO.getPsID()).isBooked()) {
                    bicycle++;
                }
            }
        }
        lblBicycle.setText(Integer.toString(bicycle));
        lblHeavy.setText(Integer.toString(heavy));
        lblLight.setText(Integer.toString(light));
    }

}
