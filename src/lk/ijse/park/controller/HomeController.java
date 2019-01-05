/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.park.resources.CustomMethod;

/**
 * FXML Controller class
 *
 * @author asitha
 */
public class HomeController implements Initializable {

    @FXML
    private JFXButton btnDashboard;
    @FXML
    private JFXButton btnParkin;
    @FXML
    private JFXButton btnDetails;
    @FXML
    private JFXButton btnReport;
    @FXML
    private JFXButton btnLogout;
    @FXML
    private JFXButton btnPayment;
    @FXML
    private ImageView imageDashboard;
    private ImageView imageUser;
    @FXML
    private ImageView immageParkin;
    @FXML
    private ImageView imagePayment;
    @FXML
    private ImageView imageFee;
    @FXML
    private ImageView imageReport;
    private ImageView imageSetting;
    @FXML
    private ImageView imageLogout;
    @FXML
    private AnchorPane pnlMain;
    @FXML
    private Label lblDate;

    @FXML
    private JFXButton btnFacebook;

    @FXML
    private JFXButton btnInsta;

    @FXML
    private JFXButton btnGoogle;

    @FXML
    private JFXButton btnGPS;

    private boolean pressedValue = false;
    @FXML
    private Label btnClose;
    @FXML
    private ImageView btnMini;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTooltips();

        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/park/view/Dashbord.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        pnlMain.getChildren().setAll(pane);

        lblDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
        //lblTime.setText(new SimpleDateFormat("HH:ss").format(new Date()));

    }

    @FXML
    private void dashboardClicked(MouseEvent event) throws IOException {
        btnSelected(btnDashboard);

        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/park/view/Dashbord.fxml"));
        pnlMain.getChildren().setAll(pane);

    }

    private void btnUserClicked(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/park/view/User.fxml"));
        pnlMain.getChildren().setAll(pane);
    }

    @FXML
    private void btnParkinClicked(MouseEvent event) throws IOException {
        btnSelected(btnParkin);
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/park/view/Parking.fxml"));
        pnlMain.getChildren().setAll(pane);
    }

    @FXML
    private void btnDetailsClicked(MouseEvent event) throws IOException {
        btnSelected(btnDetails);
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/park/view/ManageDetails.fxml"));
        pnlMain.getChildren().setAll(pane);
    }

    @FXML
    private void btnReportClicked(MouseEvent event) {
    }


    @FXML
    private void btnLogoutClicked(MouseEvent event) {
    }

    @FXML
    private void btnPaymentClicked(MouseEvent event) throws IOException {
        btnSelected(btnPayment);
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/park/view/Payment.fxml"));
        pnlMain.getChildren().setAll(pane);
    }

    @FXML
    private void imageDashboardExited(MouseEvent event) {
        CustomMethod.imageDashboard(imageDashboard, 1.2);
    }

    @FXML
    private void imageDashboardEntered(MouseEvent event) {
        CustomMethod.imageDashboard(imageDashboard, 1.2);
    }

    private void imageUserExited(MouseEvent event) {
        CustomMethod.imageDashboard(imageUser, 1.0);
    }

    private void imageUserEntered(MouseEvent event) {
        CustomMethod.imageDashboard(imageUser, 1.2);
    }

    @FXML
    private void immageParkinExited(MouseEvent event) {
        CustomMethod.imageDashboard(immageParkin, 1.0);
    }

    @FXML
    private void immageParkinEntered(MouseEvent event) {
        CustomMethod.imageDashboard(immageParkin, 1.2);

    }

    @FXML
    private void imagePaymentExited(MouseEvent event) {
        CustomMethod.imageDashboard(imagePayment, 1.0);
    }

    @FXML
    private void imagePaymentEntered(MouseEvent event) {
        CustomMethod.imageDashboard(imagePayment, 1.2);
    }

    @FXML
    private void imageFeeExited(MouseEvent event) {
        CustomMethod.imageDashboard(imageFee, 1.0);
    }

    @FXML
    private void imageFeeEntered(MouseEvent event) {
        CustomMethod.imageDashboard(imageFee, 1.2);
    }

    @FXML
    private void imageReportExited(MouseEvent event) {
        CustomMethod.imageDashboard(imageReport, 1.0);
    }

    @FXML
    private void imageReportEntered(MouseEvent event) {
        CustomMethod.imageDashboard(imageReport, 1.2);
    }

    private void imageSettingExited(MouseEvent event) {
        CustomMethod.imageDashboard(imageSetting, 1.0);
    }

    private void imageSettingEntered(MouseEvent event) {
        CustomMethod.imageDashboard(imageSetting, 1.2);
    }

    @FXML
    private void imageLogoutExited(MouseEvent event) {
        CustomMethod.imageDashboard(imageLogout, 1.0);
    }

    @FXML
    private void imageLogoutEntered(MouseEvent event) {
        CustomMethod.imageDashboard(imageLogout, 1.2);

    }

    @FXML
    void systemIfoOnClick(MouseEvent event) {
        pressedValue = !pressedValue;

        if (pressedValue) {
            btnFacebook.setVisible(true);
            btnInsta.setVisible(true);
            btnGoogle.setVisible(true);
            btnGPS.setVisible(true);
        } else {

            btnFacebook.setVisible(false);
            btnInsta.setVisible(false);
            btnGoogle.setVisible(false);
            btnGPS.setVisible(false);
        }
    }

    private void setvID() throws Exception {

    }

    private void setTooltips() {
        Tooltip dashboard = new Tooltip();
        dashboard.setText("Click to load Dash Board");
        btnDashboard.setTooltip(dashboard);

        Tooltip parking = new Tooltip();
        parking.setText("Click to load Parking");
        btnParkin.setTooltip(parking);

        Tooltip details = new Tooltip();
        details.setText("Click to load Manage Details");
        btnDetails.setTooltip(details);

        Tooltip reports = new Tooltip();
        reports.setText("Click to load Reports");
        btnReport.setTooltip(reports);

        Tooltip payment = new Tooltip();
        payment.setText("Click to load Payment");
        btnPayment.setTooltip(payment);

        Tooltip logout = new Tooltip();
        logout.setText("Click to load Logout");
        btnLogout.setTooltip(logout);

    }

    private void btnSelected(JFXButton btn) {
        JFXButton btns[] = {btnDashboard, btnDetails, btnLogout, btnParkin, btnPayment, btnReport};
        for (JFXButton button : btns) {
            button.getStylesheets().add("/lk/ijse/park/css/Home.css");
            button.getStyleClass().remove("selected");       
        }
        btn.getStyleClass().add("selected");

    }

}
