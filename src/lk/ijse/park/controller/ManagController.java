/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.park.resources.CustomMethod;

/**
 * FXML Controller class
 *
 * @author asitha
 */
public class ManagController implements Initializable {

    @FXML
    private AnchorPane pnlManage;
    @FXML
    private ImageView imageParkinEdit;
    @FXML
    private ImageView imageParkinDelete;
    @FXML
    private ImageView imagePaymentPrint;
    @FXML
    private JFXButton btnManage;
    @FXML
    private ImageView imagePaymetEdit1;
    @FXML
    private ImageView imagePaymentDelete1;
    @FXML
    private ImageView imageParkinPrint;
    @FXML
    private JFXButton btnDashboard;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void imageParkinEditExited(MouseEvent event)throws IOException{
         CustomMethod.imageDashboard(imageParkinEdit, 1.0);
        
    }

    @FXML
    private void imageParkinEditEnterd(MouseEvent event)throws IOException {
         CustomMethod.imageDashboard(imageParkinEdit, 1.2);
       
    }

    @FXML
    private void imageParkinDeleteExited(MouseEvent event) throws IOException{
         CustomMethod.imageDashboard(imageParkinDelete, 1.0);
        
    }

    @FXML
    private void imageParkinDeleteEntered(MouseEvent event)throws IOException {
         CustomMethod.imageDashboard(imageParkinDelete, 1.2);
       
    }

    @FXML
    private void imagePaymentPrintExited(MouseEvent event)throws IOException {
         CustomMethod.imageDashboard(imagePaymentPrint, 1.0);
       ;
    }

    @FXML
    private void imagePaymentPrintEntered(MouseEvent event)throws IOException {
         CustomMethod.imageDashboard(imagePaymentPrint, 1.2);
       
    }

    @FXML
    private void imagePaymentPrintClicked(MouseEvent event) {
    }

    @FXML
    private void btnManageClicked(MouseEvent event) {
    }

    @FXML
    private void imagePaymetEditExited(MouseEvent event)throws IOException {
         CustomMethod.imageDashboard(imagePaymetEdit1, 1.0);
       
    }

    @FXML
    private void imagePaymetEditEntered(MouseEvent event)throws IOException {
         CustomMethod.imageDashboard(imagePaymetEdit1, 1.2);
       
    }

    @FXML
    private void imagePaymentDeleteExited(MouseEvent event)throws IOException {
         CustomMethod.imageDashboard(imagePaymentDelete1, 1.0);
        
    }

    @FXML
    private void imagePaymentDeleteEntered(MouseEvent event)throws IOException {
         CustomMethod.imageDashboard(imagePaymentDelete1, 1.2);
       
    }

    @FXML
    private void imageParkinPrintEntered(MouseEvent event) {
    }

    @FXML
    private void imageParkinPrintClicked(MouseEvent event) {
    }

    @FXML
    private void btnDashboardClicked(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/park/view/Dashbord.fxml"));
        pnlManage.getChildren().setAll(pane);
    }
    
}
