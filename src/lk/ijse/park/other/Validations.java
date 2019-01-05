/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.other;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

/**
 *
 * @author asitha
 */
public class Validations {

    public static boolean textFieldNotEmpty(JFXTextField txtfield) {

        boolean b = false;

        if (txtfield.getText().length() != 0 || !txtfield.getText().isEmpty()) {

            b = true;
        }

        return b;
    }

    public static boolean textFieldNotEmpty(JFXTextField txtfield, Label lb, String error_Message) {

        boolean b = true;
        String msg = null;
        txtfield.getStyleClass().remove("error");
        if (!textFieldNotEmpty(txtfield)) {

            b = false;
            msg = error_Message;
            txtfield.getStyleClass().add("error");
        }
        lb.setText(msg);

        return b;
    }

    public static boolean istextFieldTypeNumber(JFXTextField txtfield) {

        boolean b = false;

        if (txtfield.getText().matches("^[0-9]{1,2}([,.][0-9]{1,2})?$")) {

            b = true;
        }

        return b;

    }

    public static boolean istextFieldTypeNumber(JFXTextField txtfield, Label lb, String error_Message) {

        boolean b = true;
        String msg = null;
        txtfield.getStyleClass().remove("error");
        if (!istextFieldTypeNumber(txtfield)) {

            b = true;
            msg = error_Message;
            txtfield.getStyleClass().add("error");
        }

        lb.setText(msg);
        return b;

    }

    public static boolean isPasswordFieldnotEmpty(JFXPasswordField passfield) {

        boolean b = false;

        if (passfield.getText().length() != 0 || !passfield.getText().isEmpty()) {

            b = true;
        }

        return b;
    }

    public static boolean isPasswordFieldnotEmpty(JFXPasswordField passfield, Label lb, String error_Message) {

        boolean b = true;
        String msg = null;
        passfield.getStyleClass().remove("error");
        if (!isPasswordFieldnotEmpty(passfield)) {

            b = true;
            msg = error_Message;
            passfield.getStyleClass().add("error");
        }

        lb.setText(msg);
        return b;

    }

    public static boolean isComboBoxnotEmpty(JFXComboBox<String> comboBox) {

        boolean b = false;

        if (!comboBox.getSelectionModel().isEmpty()) {

            b = true;
        }

        return b;
    }

    public static boolean isComboBoxnotEmpty(JFXComboBox<String> comboBox, Label lb, String error_Message) {

        boolean b = true;
        String msg = null;
        comboBox.getStyleClass().remove("error");
        if (!isComboBoxnotEmpty(comboBox)) {

            b = true;
            msg = error_Message;
            comboBox.getStyleClass().add("error");
        }

        lb.setText(msg);
        return b;

    }

    public static boolean isRadioButtonnotEmpty(RadioButton radioButton) {

        boolean b = false;

        if (radioButton.isSelected()) {

            b = true;
        }

        return b;
    }

    public static boolean isRadioButtonnotEmpty(RadioButton radioButton, Label lb, String error_Message) {

        boolean b = true;
        String msg = null;
        radioButton.getStyleClass().remove("error");
        if (!isRadioButtonnotEmpty(radioButton)) {

            b = true;
            msg = error_Message;
            radioButton.getStyleClass().add("error");
        }

        lb.setText(msg);
        return b;

    }

    public static boolean isDatePickerEmpty(DatePicker date) {

        boolean b = false;

        if (date.getValue()!= null) {

            b = true;
        }

        return b;
    }

    public static boolean isDatePickerEmpty(DatePicker date, Label lb, String error_Message) {

        boolean b = true;
        String msg = null;
        date.getStyleClass().remove("error");
        if (!isDatePickerEmpty(date)) {

            b = true;
            msg = error_Message;
            date.getStyleClass().add("error");
        }

        lb.setText(msg);
        return b;

    }
    public static boolean isNICFormatCorrect(JFXTextField txtfield) {

        boolean b = false;

        if (txtfield.getText().matches("^[0-9]{9}[a-zA-Z]$")) {

            b = true;
        }

        return b;

    }

    public static boolean isNICFormatCorrect(JFXTextField txtfield, Label lb, String error_Message) {

        boolean b = true;
        String msg = null;
        txtfield.getStyleClass().remove("error");
        if (!isNICFormatCorrect(txtfield)) {

            b = true;
            msg = error_Message;
            txtfield.getStyleClass().add("error");
        }

        lb.setText(msg);
        return b;

    }
    

    public static boolean isTimeFormatCorrect(JFXTextField txtfield) {

        boolean b = false;

        if (txtfield.getText().matches("((?:(?:[0-1][0-9])|(?:[2][0-3])|(?:[0-9])):(?:[0-5][0-9])(?::[0-5][0-9])?(?:\\s?(?:am|AM|pm|PM)))")) {

            b = true;
        }

        return b;

    }

    public static boolean isTimeFormatCorrect(JFXTextField txtfield, Label lb, String error_Message) {

        boolean b = true;
        String msg = null;
        txtfield.getStyleClass().remove("error");
        if (!isNICFormatCorrect(txtfield)) {

            b = true;
            msg = error_Message;
            txtfield.getStyleClass().add("error");
        }

        lb.setText(msg);
        return b;

    }
    public static boolean ismobileDigit10(JFXTextField txtfield) {

        boolean b = false;

        if (txtfield.getText().matches("^[0-9]{2}[0-9]{8}$")) {

            b = true;
        }

        return b;

    }

    public static boolean ismobileDigit10(JFXTextField txtfield, Label lb, String error_Message) {

        boolean b = true;
        String msg = null;
        txtfield.getStyleClass().remove("error");
        if (!isNICFormatCorrect(txtfield)) {

            b = true;
            msg = error_Message;
            txtfield.getStyleClass().add("error");
        }

        lb.setText(msg);
        return b;

    }
    public static boolean isnameCorrect(JFXTextField txtfield) {

        boolean b = false;

        if (txtfield.getText().matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$")) {

            b = true;
        }

        return b;

    }

    public static boolean isnameCorrect(JFXTextField txtfield, Label lb, String error_Message) {

        boolean b = true;
        String msg = null;
        txtfield.getStyleClass().remove("error");
        if (!isnameCorrect(txtfield)) {

            b = true;
            msg = error_Message;
            txtfield.getStyleClass().add("error");
        }

        lb.setText(msg);
        return b;

    }
    public static boolean issmcCorrect(JFXTextField txtfield) {

        boolean b = false;

        if (txtfield.getText().matches("[a-zA-Z]{3}\\d{3}")) {

            b = true;
        }

        return b;

    }

    public static boolean issmcCorrect(JFXTextField txtfield, Label lb, String error_Message) {

        boolean b = true;
        String msg = null;
        txtfield.getStyleClass().remove("error");
        if (!issmcCorrect(txtfield)) {

            b = true;
            msg = error_Message;
            txtfield.getStyleClass().add("error");
        }

        lb.setText(msg);
        return b;

    }
    
    public static boolean texFieldNotEmpty(JFXTextField txtFld){
        
        boolean b=false;
        if(txtFld.getText().length() !=0 || !txtFld.getText().isEmpty()){
            b=true;
        }
        return b;
    }
    


    public static boolean texFieldNotEmpty(JFXTextField txtFld,Label lb,String error_Massage){
    
         boolean b=true;
         String msg=null;
         txtFld.getStyleClass().remove("error");
         if(!texFieldNotEmpty(txtFld)){
        
         b = false;
         msg = error_Massage;
         txtFld.getStyleClass().add("error");
         
        }
         
        lb.setText(msg);
        return b;
    }

    public static boolean texFieldNotEmpty(JFXPasswordField jFXPasswordField, Label lblPassword, String password_is_Empty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

 
