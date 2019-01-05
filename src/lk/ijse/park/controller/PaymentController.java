/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author asitha
 */
public class PaymentController implements Initializable {

    @FXML
    private AnchorPane pnlParkin;
    @FXML
    private ImageView immageDashboardHome;
    @FXML
    private ImageView imageParkinPrint;
    @FXML
    private ImageView imageParkinEdit;
    @FXML
    private ImageView imageParkinDelete;
    @FXML
    private ImageView imageParkinPrint1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void immageDashboardHomeExited(MouseEvent event) {
    }

    @FXML
    private void immageDashboardHomeEntered(MouseEvent event) {
    }

    @FXML
    private void imagePaymentPrintExited(MouseEvent event) {
    }

    @FXML
    private void imageParkinPrintEntered(MouseEvent event) {
    }

    @FXML
    private void imageParkinPrintClicked(MouseEvent event) {
    }

    @FXML
    private void imageParkinEditExited(MouseEvent event) {
    }

    @FXML
    private void imageParkinEditEnterd(MouseEvent event) {
    }

    @FXML
    private void imageParkinDeleteExited(MouseEvent event) {
    }

    @FXML
    private void imageParkinDeleteEntered(MouseEvent event) {
    }
    
}
