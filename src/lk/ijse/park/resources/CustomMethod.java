/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.resources;

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

/**
 *
 * @author asitha
 */
public class CustomMethod {

    public static String parkingSlot;

    public static void modalset(Parent modalWindow, ActionEvent event) throws IOException {
        Window theStage = ((Node) event.getSource()).getScene().getWindow();
        FadeTransition ft = new FadeTransition(Duration.millis(500), modalWindow);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        Stage dialog = new Stage();
        Scene scene = new Scene(modalWindow);

        dialog.setScene(scene);
        dialog.initOwner(theStage);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.centerOnScreen();
        dialog.showAndWait();
    }

    public static void imageDashboard(ImageView image, double d) {
        ScaleTransition temp = new ScaleTransition(Duration.millis(300), image);
        temp.setToX(d);
        temp.setToY(d);
        temp.play();

    }
}
