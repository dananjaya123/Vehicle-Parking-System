/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import lk.ijse.park.dao.CrudUtil;
import lk.ijse.park.other.PasswordUtil;
import lk.ijse.park.resources.CustomMethod;

/**
 * FXML Controller class
 *
 * @author asitha
 */
public class AdminLoginController implements Initializable {

    @FXML
    private JFXTextField textUsername;
    @FXML
    private Label lblUserName;
    @FXML
    private JFXPasswordField pwsField;
    @FXML
    private Label lblPassword;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private AnchorPane pnlLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTooltips ();
        // TODO
    }    

    @FXML
    private void handleLogin(ActionEvent event) throws SQLException, ClassNotFoundException, IOException, Exception {
        
        ResultSet rst = CrudUtil.executeQuery("Select * from user");
        if(rst.next()){
            String userName=rst.getString(2);
            String salt=rst.getString(3);
            String secPw=rst.getString(4);
            
            String passwod=rst.getString(4);
            
            boolean ifPasswordMatches=PasswordUtil.verifyUserPassword(pwsField.getText(), secPw, salt);
            if (ifPasswordMatches && textUsername.getText().equals(userName)) {

  
            Parent root=FXMLLoader.load(getClass().getResource("/lk/ijse/park/view/Home.fxml"));
            
            Node node=(Node)event.getSource();
            Stage stage=(Stage)node.getScene().getWindow();
            
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
            } else {
                JOptionPane.showMessageDialog(null, "Error in username password combination!");
            }
        }
     
    }

    private void SignUpOnAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/lk/ijse/park/view/User Registration.fxml"));
        CustomMethod.modalset(parent, event);
    }

    @FXML
    private void userNameOnAction(ActionEvent event) {
        pwsField.requestFocus();
    }

    @FXML
    private void passwordOnAtion(ActionEvent event) {
        btnLogin.requestFocus();
        
    }

    private void setTooltips() {
        Tooltip loginButton=new  Tooltip();
        loginButton.setText("Login Button");
        btnLogin.setTooltip(loginButton);
        
        Tooltip userNameText=new  Tooltip();
        userNameText.setText("User Name field");
        textUsername.setTooltip(userNameText);
        
        Tooltip password=new  Tooltip();
        password.setText("password");
        pwsField.setTooltip(password);
    }
    
}
