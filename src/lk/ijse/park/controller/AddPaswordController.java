/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import lk.ijse.park.dao.CrudUtil;
import lk.ijse.park.other.PasswordUtil;

/**
 * FXML Controller class
 *
 * @author asitha
 */
public class AddPaswordController implements Initializable {

    @FXML
    private JFXTextField textUserName;
    @FXML
    private JFXTextField textPasword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnAddOnAction(ActionEvent event) throws NoSuchAlgorithmException, Exception {
         try {
            String userName=textUserName.getText();
            String password=textPasword.getText();
            String salt=PasswordUtil.getSalt(30);
            String secPw=PasswordUtil.generateSecurePassword(password, salt);
            CrudUtil.executeUpdate("Insert into user values(?,?,?,?)", "001",userName,salt,secPw);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(lk.ijse.park.controller.AddPaswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
