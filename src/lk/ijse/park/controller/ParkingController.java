/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.park.business.BOFactory;
import lk.ijse.park.business.custom.CustomerBO;
import lk.ijse.park.business.custom.ParkingAreaBO;
import lk.ijse.park.business.custom.ParkingSlotBO;
import lk.ijse.park.business.custom.RegistrationBO;
import lk.ijse.park.business.custom.SlotBookingBO;
import lk.ijse.park.business.custom.TicketBO;
import lk.ijse.park.business.custom.VehicleBO;
import lk.ijse.park.db.DBConnection;
import lk.ijse.park.model.CustomerDTO;
import lk.ijse.park.model.ParkingAreaDTO;
import lk.ijse.park.model.ParkingSlotDTO;
import lk.ijse.park.model.ParkingTableDTO;
import lk.ijse.park.model.RegistrationDTO;
import lk.ijse.park.model.SlotBookingDTO;
import lk.ijse.park.model.TicketDTO;
import lk.ijse.park.model.VehicleDTO;
import lk.ijse.park.other.IDGenerator;
import lk.ijse.park.resources.CustomMethod;

/**
 * FXML Controller class
 *
 * @author asitha
 */
public class ParkingController implements Initializable {

    @FXML
    private AnchorPane pnlParkin;
    @FXML
    private ImageView immageDashboardHome;
    @FXML
    private ImageView imageAddParkin;
    @FXML
    private JFXButton btnDashboard;
    private ImageView imageParkinEdit;
    private ImageView imageParkinDelete;
    @FXML
    private ImageView imageParkinPrint;
    @FXML
    private ImageView imageLongVehicle;
    @FXML
    private ImageView imageBicycle;
    @FXML
    private JFXTextField textCustomerName;
    @FXML
    private JFXTextField textCustomerAddress;
    @FXML
    private JFXTextField textNIC;
    @FXML
    private JFXTextField textCustomerPhoneNumber;
    @FXML
    private JFXTextField textEmail;
    @FXML
    private JFXButton btnAddParking;
    @FXML
    private JFXTextField textVID;
    @FXML
    private JFXTextField textVehicleNumber;
    @FXML
    private ColorPicker ClpVehicleColor;
    @FXML
    private TableView<ParkingTableDTO> tblView;
    @FXML
    private TableColumn<ParkingTableDTO, String> colomeCustomerName;
    @FXML
    private TableColumn<ParkingTableDTO, String> colomeNIC;
    @FXML
    private TableColumn<ParkingTableDTO, String> colomeVehicleNumber;
    @FXML
    private TableColumn<ParkingTableDTO, String> colomeCheckInDate;
    @FXML
    private TableColumn<ParkingTableDTO, String> colomeCheckInTime;
    @FXML
    private TableColumn<ParkingTableDTO, String> colomeCheckOutTime;
    @FXML
    private TableColumn<ParkingTableDTO, String> colomeCheckOutDate;
    @FXML
    private TableColumn<ParkingTableDTO, Double> colomeAmount;
    @FXML
    private TableColumn<ParkingTableDTO, String> colomeParkingArea;
    @FXML
    private JFXTextField textCheckInDate;
    @FXML
    private JFXTextField textCheckInTime;
    @FXML
    private JFXButton btnPrintBill;
    @FXML
    private ImageView imagePrint;
    @FXML
    private JFXTextField textParkingArea;
    @FXML
    private Label lblLongVehicle;
    @FXML
    private Label lblBicycle;
    private Connection connection;
    CustomerDTO customer = new CustomerDTO();
    @FXML
    private ImageView imageCar;

    private final CustomerBO customerBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
    private final VehicleBO vehicleBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.VEHICLE);
    private final ParkingAreaBO parkingAreaBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.PARKINGAREA);
    private final ParkingSlotBO parkingSlotBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.PARKINGSLOT);
    private final RegistrationBO registrationBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.REGISTRATION);
    private final TicketBO ticketBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.TICKET);
    private final SlotBookingBO slotBookingBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.SLOTBOOKING);

    @FXML
    private JFXComboBox<String> cmboVehicleCategory;
    ObservableList<String> vehCateList;

    ObservableList<ParkingTableDTO> tblData = FXCollections.observableArrayList();
    @FXML
    private JFXTextField textSlotNumber;
    @FXML
    private Label lblLight;
    @FXML
    private JFXButton btnClear;
    @FXML
    private Label lblNic;
    @FXML
    private Label lblname;
    @FXML
    private Label lblAddress;
    @FXML
    private Label lblPhoneNumber;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblVehicleNumber;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            connection = DBConnection.getInstance().getConnection();
            setLabels();
        } catch (Exception ex) {
            Logger.getLogger(ParkingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVehicalId();

        vehCateList = FXCollections.observableArrayList();
        try {
            for (ParkingAreaDTO parkingAreaDTO : parkingAreaBO.getAllParkingArea()) {
                vehCateList.add(parkingAreaDTO.getVehicle_category());
            }
        } catch (Exception ex) {
            Logger.getLogger(ParkingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cmboVehicleCategory.setItems(vehCateList);

        tblView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        tblView.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("checkInDate"));
        tblView.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("checkInTime"));
        tblView.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("checkOutDate"));
        tblView.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("checkOutTime"));
        tblView.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("amount"));
        tblView.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("parkingArea"));

        tblView.setItems(tblData);

        try {
            loadTableData();
        } catch (Exception ex) {
            Logger.getLogger(ParkingController.class.getName()).log(Level.SEVERE, null, ex);
        }

        textCheckInDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
        textCheckInTime.setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));

    }

    @FXML
    private void immageDashboardHomeExited(MouseEvent event) {
        CustomMethod.imageDashboard(immageDashboardHome, 1.0);
    }

    @FXML
    private void immageDashboardHomeEntered(MouseEvent event) {
        CustomMethod.imageDashboard(immageDashboardHome, 1.2);

    }

    @FXML
    private void imageAddParkinExited(MouseEvent event) {
        CustomMethod.imageDashboard(imageAddParkin, 1.0);

    }

    @FXML
    private void imageAddParkinEntered(MouseEvent event) {
        CustomMethod.imageDashboard(imageAddParkin, 1.0);
    }

    @FXML
    private void btnManage2Clicked(MouseEvent event) {
    }

    private void imageParkinEditExited(MouseEvent event) {
        CustomMethod.imageDashboard(imageParkinEdit, 1.0);
    }

    private void imageParkinEditEnterd(MouseEvent event) {
        CustomMethod.imageDashboard(imageParkinEdit, 1.2);
    }

    private void imageParkinDeleteExited(MouseEvent event) {
        CustomMethod.imageDashboard(imageParkinDelete, 1.0);
    }

    private void imageParkinDeleteEntered(MouseEvent event) {
        CustomMethod.imageDashboard(imageParkinDelete, 1.2);
    }

    @FXML
    private void imagePaymentPrintExited(MouseEvent event) {
        CustomMethod.imageDashboard(imageParkinPrint, 1.0);
    }

    @FXML
    private void imageParkinPrintEntered(MouseEvent event) {
        CustomMethod.imageDashboard(imageParkinPrint, 1.2);
    }

    @FXML
    private void imageParkinPrintClicked(MouseEvent event) {
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
    private void btnAddParkingAction(ActionEvent event) throws Exception {
        if (isAddedSuccess()) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Added", ButtonType.OK);
            a.show();
            clearTextFields();
        } else {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "error IN ADD", ButtonType.OK);
            a.show();
        }

    }

    private boolean isAddedSuccess() throws SQLException, Exception {
        connection = DBConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);
            String nic = textNIC.getText();
            String name = textCustomerName.getText();
            String address = textCustomerAddress.getText();
            String phoneNumber = textCustomerPhoneNumber.getText();
            String email = textEmail.getText();

            String vid = textVID.getText();
            String vehicleNumber = textVehicleNumber.getText();
            String vehicleColour = ClpVehicleColor.getValue().toString();
            String vehicleCategory = cmboVehicleCategory.getSelectionModel().getSelectedItem();

            customer = new CustomerDTO(nic, name, address, phoneNumber, email);

            boolean adCustomer = customerBO.addCustomer(customer);

            if (!adCustomer) {
                connection.rollback();
                return false;
            }
            VehicleDTO vehicleDTO = new VehicleDTO(vid, vehicleNumber, vehicleColour, vehicleCategory);

            boolean addVehicle = vehicleBO.addVehicle(vehicleDTO);

            if (!addVehicle) {
                connection.rollback();
                return false;

            }
            String rid = IDGenerator.getNewID("registration", "rID", "R");
            RegistrationDTO registrationDTO = new RegistrationDTO(rid, vid, nic, textCheckInDate.getText());
            boolean addRegistration = registrationBO.addRegistration(registrationDTO);

            if (!addRegistration) {
                connection.rollback();
                return false;

            }
            String tID = IDGenerator.getNewID("ticket", "tID", "T");
            TicketDTO ticketDTO = new TicketDTO(
                    tID,
                    rid,
                    textSlotNumber.getText(),
                    parkingAreaBO.searchParkingAreaByVehicleCategory(vehicleCategory).getPaID(),
                    textCheckInTime.getText(),
                    textCheckInDate.getText(),
                    name,
                    phoneNumber,
                    null,
                    null
            );
            boolean addTicket = ticketBO.addTicket(ticketDTO);
            if (!addTicket) {
                connection.rollback();
                return false;

            }

            SlotBookingDTO slotBookingDTO = new SlotBookingDTO(textSlotNumber.getText(), true, tID);
            boolean slotBookingFunc;
            if (slotBookingBO.searchSlotBooking(textSlotNumber.getText()) == null) {
                slotBookingFunc = slotBookingBO.addSlotBooking(slotBookingDTO);
            } else {
                slotBookingFunc = slotBookingBO.updateSlotBooking(slotBookingDTO);
            }
            if (!slotBookingFunc) {
                connection.rollback();
                return false;

            }

            connection.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
            return false;
        } finally {

            connection.setAutoCommit(true);

        }

    }

    @FXML
    private void cmboVehicleCategoryOnAction(ActionEvent event) throws Exception {
        ParkingAreaDTO searchParkingArea = parkingAreaBO.searchParkingAreaByVehicleCategory(cmboVehicleCategory.getValue());
        textParkingArea.setText(searchParkingArea.getArea_Name());

    }
    
    @FXML
    private void btnParkSlotSelectOnAction(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/lk/ijse/park/view/ParkingView.fxml"));
        CustomMethod.modalset(parent, event);
        textSlotNumber.setText(CustomMethod.parkingSlot);
    }

    private void setVehicalId() {
        try {
            String vID;
            vID = IDGenerator.getNewID("vehicle", "vID", "V");
            textVID.setText(vID);
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    private void loadTableData() throws Exception {
        ArrayList<ParkingTableDTO> parkingTableDTOs = new ArrayList<>();
        for (TicketDTO ticketDTO : ticketBO.getAllTicket()) {
            RegistrationDTO searchRegistration = registrationBO.searchRegistration(ticketDTO.getrID());
            VehicleDTO searchVehicle = vehicleBO.searchVehicle(searchRegistration.getvID());
            parkingTableDTOs.add(new ParkingTableDTO(
                    ticketDTO.getCustomer_Name(),
                    searchRegistration.getNic(),
                    searchVehicle.getVehicleNumber(),
                    ticketDTO.getCheck_In_Date(),
                    ticketDTO.getCheck_In_Time(),
                    ticketDTO.getCheck_Out_Date(),
                    ticketDTO.getCheck_Out_Time(),
                    Double.NaN,
                    parkingAreaBO.searchParkingArea(ticketDTO.getPaID()).getArea_Name()
            ));
            tblData.setAll(parkingTableDTOs);
        }

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
        lblLongVehicle.setText(Integer.toString(heavy));
        lblLight.setText(Integer.toString(light));
    }

    @FXML
    private void btnClearOnAction(ActionEvent event) {
        textNIC.clear();
        cmboVehicleCategory.getSelectionModel().clearSelection();
        textCustomerName.clear();
        textCustomerAddress.clear();
        textCustomerPhoneNumber.clear();
        textEmail.clear();
        textVID.clear();
        textVehicleNumber.clear();
        textNIC.clear();
        textSlotNumber.clear();
        textParkingArea.clear();

    }

    @FXML
    private void textCustomerNameOnAction(ActionEvent event) {
        lblname.setVisible(false);
        if (textCustomerName.getText().matches("[A-Za-z .]+")) {
            textCustomerAddress.requestFocus();
        } else {
            lblname.setVisible(true);
            lblname.setText("Wrong Input");
            textCustomerName.selectAll();
            textCustomerName.requestFocus();
        }
    }

    @FXML
    private void textCustomerAddressOnAction(ActionEvent event) {
        lblAddress.setVisible(false);
        if (textCustomerAddress.getText().matches("[A-Za-z-0-9 .,]+")) {
            textCustomerPhoneNumber.requestFocus();
        } else {
            lblAddress.setVisible(true);
            lblAddress.setText("Wrong Input");
            textCustomerAddress.selectAll();
            textCustomerAddress.requestFocus();
        }
       
    }

    @FXML
    private void textNicOnAction(ActionEvent event) {
        lblNic.setVisible(false);
        if (textNIC.getText().matches("^[0-9]{9}[Vv]{1}")) {
            textCustomerName.requestFocus();
        } else {
            lblNic.setVisible(true);
            lblNic.setText("Wrong Input");
            textNIC.selectAll();
            textNIC.requestFocus();
        }
       
    }

    @FXML
    private void textCustomerPhoneNumberOnAction(ActionEvent event) {
        lblPhoneNumber.setVisible(false);
        if (textCustomerPhoneNumber.getText().matches("[0-9]{10}")) {
            textEmail.requestFocus();
        } else {
            lblPhoneNumber.setVisible(true);
            lblPhoneNumber.setText("Wrong Input");
            textCustomerPhoneNumber.selectAll();
            textCustomerPhoneNumber.requestFocus();
        }
    }

    @FXML
    private void textEmailOnAction(ActionEvent event) {
            textVehicleNumber.requestFocus();
        
    }

    @FXML
    private void textVehicleNumberOnAction(ActionEvent event) {
//        lblVehicleNumber.setVisible(false);
//        if (textVehicleNumber.getText().matches("[A-Za-z]-[0-9]{4}")) {
//            cmboVehicleCategory.requestFocus();
//        } else {
//            lblVehicleNumber.setVisible(true);
//            lblVehicleNumber.setText("Wrong Input");
//            textVehicleNumber.selectAll();
//            textVehicleNumber.requestFocus();
//        }
    }

    @FXML
    private void ClpVehicleColorOnAction(ActionEvent event) {
    }

    private void clearTextFields() {
        textNIC.clear();
        cmboVehicleCategory.getSelectionModel().clearSelection();
        textCustomerName.clear();
        textCustomerAddress.clear();
        textCustomerPhoneNumber.clear();
        textEmail.clear();
        textVID.clear();
        textVehicleNumber.clear();
        textNIC.clear();
        textSlotNumber.clear();
        textParkingArea.clear();
    }

    @FXML
    private void textNICOnKeyReleasd(KeyEvent event) {
    }

}
