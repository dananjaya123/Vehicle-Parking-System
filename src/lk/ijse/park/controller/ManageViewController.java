/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.park.business.BOFactory;
import lk.ijse.park.business.custom.ParkingAreaBO;
import lk.ijse.park.business.custom.ParkingSlotBO;
import lk.ijse.park.model.ParkingAreaDTO;
import lk.ijse.park.model.ParkingSlotDTO;

/**
 * FXML Controller class
 *
 * @author asitha
 */
public class ManageViewController implements Initializable {

    @FXML
    private ImageView imageSlotPrint1;
    @FXML
    private ImageView imageFeeEdit1;
    @FXML
    private ImageView imageFeeDelete1;
    @FXML
    private ImageView imagePakinSlot1;
    @FXML
    private ImageView imageFeeEdit111;
    @FXML
    private ImageView imageFeeDelete111;
    @FXML
    private ImageView imageFeePrint1;
    @FXML
    private AnchorPane pnlManage;
    @FXML
    private JFXButton btnAddManage;
    @FXML
    private ImageView imageAddFee1;
    @FXML
    private TableView<ParkingSlotDTO> tableSlot;
    @FXML
    private TableView<ParkingAreaDTO> tableParking;
    @FXML
    private TableColumn<ParkingSlotDTO, String> colomeParkingSlotID;
    @FXML
    private TableColumn<ParkingSlotDTO, String> colomeParkingArea3;
    @FXML
    private TableColumn<ParkingSlotDTO, String> colomeAvailableSlot;
    @FXML
    private TableColumn<ParkingSlotDTO, String> colomeParkingSlotLength;
    @FXML
    private TableColumn<ParkingSlotDTO, String> colomeParkingSlotWidth;
    @FXML
    private TextField lblParkingSlotSearch;
    @FXML
    private TextField lblParkingAreaSearch;
    @FXML
    private TableColumn<ParkingAreaDTO, String> colomeParkingAreaID;
    @FXML
    private TableColumn<ParkingAreaDTO, String> colomeParkingArea1;

    private ParkingAreaBO parkingAreaBO;

    private ParkingSlotBO parkingSlotBO;
    @FXML
    private TableColumn<ParkingAreaDTO, String> colomeParkingFee;
    @FXML
    private TableColumn<ParkingAreaDTO, String> colomeParkingVehicleCategory;

    /**
     * Initializes the controller class.
     */
    public ManageViewController() {
        parkingAreaBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.PARKINGAREA);

        parkingSlotBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.PARKINGSLOT);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTooltips();
        
        try {
            loadDataFromDatabase();
            loadTableColumn();
        } catch (Exception ex) {
            Logger.getLogger(ManageViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadDataFromDatabase() throws SQLException, Exception {
        try {
            ArrayList<ParkingAreaDTO> parkingAreaDTOs = parkingAreaBO.getAllParkingArea();

            ArrayList<ParkingSlotDTO> allParkingSlot = parkingSlotBO.getAllParkingSlot();

            tableParking.setItems(FXCollections.observableArrayList(parkingAreaDTOs));

            tableSlot.setItems(FXCollections.observableArrayList(allParkingSlot));

        } catch (Exception ex) {
            Logger.getLogger(ManageViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadTableColumn() {
        colomeParkingAreaID.setCellValueFactory(new PropertyValueFactory<>("paID"));
        colomeParkingArea1.setCellValueFactory(new PropertyValueFactory<>("area_Name"));
        colomeParkingFee.setCellValueFactory(new PropertyValueFactory<>("fee"));
        colomeParkingVehicleCategory.setCellValueFactory(new PropertyValueFactory<>("vehicle_category"));
        
        colomeParkingSlotID.setCellValueFactory(new PropertyValueFactory<>("psID"));
        colomeParkingArea3.setCellValueFactory(new PropertyValueFactory<>("paID"));
        colomeAvailableSlot.setCellValueFactory(new PropertyValueFactory<>("slot_Name"));
        colomeParkingSlotLength.setCellValueFactory(new PropertyValueFactory<>("Length"));
        colomeParkingSlotWidth.setCellValueFactory(new PropertyValueFactory<>("widch"));

    }

    @FXML
    private void imageFeePrintExited(MouseEvent event) {
    }

    @FXML
    private void imageFeePrintEntered(MouseEvent event) {
    }

    @FXML
    private void imageFeePrintClicked(MouseEvent event) {
    }

    @FXML
    private void imageFeeEditExited(MouseEvent event) {
    }

    @FXML
    private void imageFeeEditEnterd(MouseEvent event) {
    }

    @FXML
    private void imageFeeDeleteExited(MouseEvent event) {
    }

    @FXML
    private void imageFeeDeleteEntered(MouseEvent event) {
    }

    @FXML
    private void imageAddFeeExited(MouseEvent event) {
    }

    @FXML
    private void imageAddFeeEntered(MouseEvent event) {
    }

    @FXML
    private void imageSlotPrintExited(MouseEvent event) {
    }

    @FXML
    private void imageSlotPrintEntered(MouseEvent event) {
    }

    @FXML
    private void imageSlotPrintClicked(MouseEvent event) {
    }

    @FXML
    private void imagePakinSlotExited(MouseEvent event) {
    }

    @FXML
    private void imagePakinSlotEntered(MouseEvent event) {
    }

    @FXML
    private void btnAddManage(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/park/view/ManageDetails.fxml"));
        pnlManage.getChildren().setAll(pane);

    }

    @FXML
    private void deleteParkngSlotOnAction(ActionEvent event) throws Exception {
        String psID = tableSlot.getSelectionModel().getSelectedItem().getPsID();
        if (parkingSlotBO.deleteParkingSlot(psID)) {
            new Alert(Alert.AlertType.CONFIRMATION, "SUCCESS DELETE", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.ERROR, "ERROR DELETE", ButtonType.OK).show();
        }
    }

    @FXML
    private void deleteParkingAreaOnAction(ActionEvent event) throws Exception {
        String paID = tableParking.getSelectionModel().getSelectedItem().getPaID();
        if (parkingAreaBO.deleteParkingArea(paID)) {
            new Alert(Alert.AlertType.CONFIRMATION, "SUCCESS DELETE", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.ERROR, "ERROR DELETE", ButtonType.OK).show();
        }
    }

    private void setTooltips() {
        Tooltip add = new Tooltip();
        add.setText("Click to load Add");
        btnAddManage.setTooltip(add);
    }
}
