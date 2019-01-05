/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.park.business.BOFactory;
import lk.ijse.park.business.custom.ParkingAreaBO;
import lk.ijse.park.business.custom.ParkingSlotBO;
//import lk.ijse.park.business.custom.VehicleCategoryBO;
import lk.ijse.park.model.ParkingAreaDTO;
import lk.ijse.park.model.ParkingSlotDTO;
import lk.ijse.park.other.IDGenerator;
import lk.ijse.park.resources.CustomMethod;
//import lk.ijse.park.model.VehicleCategoryDTO;

/**
 * FXML Controller class
 *
 * @author asitha
 */
public class ManageDeatilsController implements Initializable {

    private ImageView imageAddFee;

    private ImageView imageFeeDelete;

    @FXML
    private ImageView imagePakinSlot;

    @FXML
    private AnchorPane pnlAdd;
    @FXML
    private ImageView imageFeeDelete1;
    @FXML
    private JFXButton btnAddManage;
    @FXML
    private AnchorPane pnlFee;
    @FXML
    private JFXTextField txtFee;
    @FXML
    private JFXComboBox<String> cmboParkingArea2;
    @FXML
    private JFXTextField txtSlotName;
    @FXML
    private JFXTextField txtWidth;
    @FXML
    private JFXTextField txtLength;
    @FXML
    private JFXTextField txtPSID;

    @FXML
    private JFXTextField txtPAID;
    @FXML
    private JFXTextField txtParkingArea;
    @FXML
    private ImageView imageFeeDelete111;
    @FXML
    private ImageView imagePakinSlot121;

    private final ParkingAreaBO parkingAreaBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.PARKINGAREA);

    private final ParkingSlotBO parkingSlotBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.PARKINGSLOT);
    @FXML
    private JFXTextField txtVehicleCategory;
    @FXML
    private JFXButton btnViewSlot;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         setVehicalId();
         setVehicalIds();
         setTooltips();
         
        try {
            loadParkingAreaCombo();
        } catch (Exception ex) {
            Logger.getLogger(ManageDeatilsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void imageAddFeeExited(MouseEvent event) throws IOException {
        CustomMethod.imageDashboard(imageAddFee, 1.0);
      
    }

    private void imageAddFeeEntered(MouseEvent event) throws IOException {
        CustomMethod.imageDashboard(imageAddFee, 1.2);
       
    }

    @FXML
    private void imageFeeDeleteExited(MouseEvent event) throws IOException {
        CustomMethod.imageDashboard(imageFeeDelete, 1.0);
        
    }

    @FXML
    private void imageFeeDeleteEntered(MouseEvent event) throws IOException {
        CustomMethod.imageDashboard(imageFeeDelete, 1.2);
        
    }

    @FXML
    private void imagePakinSlotExited(MouseEvent event) throws IOException {
        CustomMethod.imageDashboard(imagePakinSlot, 1.0);
       

    }

    @FXML
    private void imagePakinSlotEntered(MouseEvent event) throws IOException {
        CustomMethod.imageDashboard(imagePakinSlot, 1.2);
        
    }

    @FXML
    private void btnAddManageClicked(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/park/view/ManageView.fxml"));
        pnlFee.getChildren().setAll(pane);
    }

    @FXML
    private void cmboParkingArea2OnAction(ActionEvent event) {
        txtSlotName.requestFocus();
        
    }

    @FXML
    private void btnSlotAddOnAction(ActionEvent event) throws Exception {
        if (parkingSlotBO.addParkingSlot(new ParkingSlotDTO(txtPSID.getText(), cmboParkingArea2.getSelectionModel().getSelectedItem(), txtSlotName.getText(), txtLength.getText(), txtWidth.getText()))) {
            new Alert(Alert.AlertType.CONFIRMATION, "SUCCESS", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.ERROR, "ERROR", ButtonType.OK).show();
        }
    }

    @FXML
    private void btnParkingAreaAddOnAction(ActionEvent event) throws Exception {
        ParkingAreaDTO parkingAreaDTO = new ParkingAreaDTO(txtPAID.getText(), txtParkingArea.getText(), Double.parseDouble(txtFee.getText()), txtVehicleCategory.getText());
        if (parkingAreaBO.addParkingArea(parkingAreaDTO)) {
            new Alert(Alert.AlertType.CONFIRMATION, "SUCCESS", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.ERROR, "ERROR", ButtonType.OK).show();
        }
    }

    private void btnParkingAreaDeleteOnAction(ActionEvent event) throws Exception {
        if (parkingAreaBO.deleteParkingArea(txtPAID.getText())) {
            new Alert(Alert.AlertType.CONFIRMATION, "SUCCESS", ButtonType.OK).show();
            loadParkingAreaCombo();
        } else {
            new Alert(Alert.AlertType.ERROR, "ERROR", ButtonType.OK).show();
        }
    }

    private void loadParkingAreaCombo() throws Exception {
        for (ParkingAreaDTO parkingAreaDTO : parkingAreaBO.getAllParkingArea()) {

            cmboParkingArea2.getItems().add(parkingAreaDTO.getPaID());

        }
    }

    @FXML
    private void btnSlotUpdateOnAction(ActionEvent event) throws Exception {
        if (parkingSlotBO.updateParkingSlot(new ParkingSlotDTO(txtPSID.getText(), cmboParkingArea2.getSelectionModel().getSelectedItem(), txtSlotName.getText(), txtLength.getText(), txtWidth.getText()))) {
            new Alert(Alert.AlertType.CONFIRMATION, "SUCCESS", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.ERROR, "ERROR", ButtonType.OK).show();
        }
    }

    @FXML
    private void PSIDSearchOnAction(ActionEvent event) throws Exception {
        ParkingSlotDTO searchParkingSlot = parkingSlotBO.searchParkingSlot(txtPSID.getText());
        if (searchParkingSlot != null) {
            txtLength.setText(searchParkingSlot.getLength());
            cmboParkingArea2.setValue(searchParkingSlot.getPaID());
            txtPSID.setText(searchParkingSlot.getPsID());
            txtSlotName.setText(searchParkingSlot.getSlot_Name());
            txtWidth.setText(searchParkingSlot.getWidch());
        }
    }

    @FXML
    private void PAIDSearchOnAction(ActionEvent event) throws Exception {
        ParkingAreaDTO searchParkingArea = parkingAreaBO.searchParkingArea(txtPAID.getText());
        if (searchParkingArea != null) {
            txtPAID.setText(searchParkingArea.getPaID());
            txtParkingArea.setText(searchParkingArea.getArea_Name());
            txtFee.setText(Double.toString(searchParkingArea.getFee()));
            txtVehicleCategory.setText(searchParkingArea.getVehicle_category());
        }
    }

    @FXML
    private void btnParkingAreaUpdateOnAction(ActionEvent event) throws Exception {
        ParkingAreaDTO parkingAreaDTO = new ParkingAreaDTO(txtPAID.getText(), txtParkingArea.getText(), Double.parseDouble(txtFee.getText()), txtVehicleCategory.getText());
        if (parkingAreaBO.updateParkingArea(parkingAreaDTO)) {
            new Alert(Alert.AlertType.CONFIRMATION, "SUCCESS", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.ERROR, "ERROR", ButtonType.OK).show();
        }
    }

    @FXML
    private void btnViewSlotonAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/lk/ijse/park/view/ParkingView.fxml"));
        CustomMethod.modalset(parent, event);
    }

    private void setVehicalId() {
            try {
            String paID;
            paID = IDGenerator.getNewID("parkingArea", "paID", "PA");
            txtPAID.setText(paID);
        } catch (SQLException ex) {
           
        } catch (ClassNotFoundException ex) {
            
        }
    }

    private void setVehicalIds() {
        try {
            String psID;
            psID = IDGenerator.getNewID("parkingSlot", "psID", "PS");
            txtPSID.setText(psID);
        } catch (SQLException ex) {
           
        } catch (ClassNotFoundException ex) {
            
        }
    }

    @FXML
    private void slotOnAction(ActionEvent event) {
        txtLength.requestFocus();
    }

    @FXML
    private void widthOnaction(ActionEvent event) {
    }

    @FXML
    private void lengthOnAction(ActionEvent event) {
        txtWidth.requestFocus();
    }

    @FXML
    private void parkingAreaOnAction(ActionEvent event) {
        txtFee.requestFocus();
    }

    @FXML
    private void feeOnAction(ActionEvent event) {
        txtVehicleCategory.requestFocus();
    }

    @FXML
    private void vehicleCategoryOnAction(ActionEvent event) {
    }

    private void setTooltips() {
        Tooltip manage = new Tooltip();
        manage.setText("Click to load manage");
        btnAddManage.setTooltip(manage);
    }
}
    



    


