/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



/**
 *
 * @author asitha
 */
public class main extends Application{
    private static final int COUNT_LIMIT = 150000;
    @Override
    public void start(Stage primaryStage) throws Exception {
         Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/park/view/Home.fxml"));
         Scene root = new Scene(parent);
         primaryStage.setScene(root);
         primaryStage.initStyle(StageStyle.UNDECORATED);
         primaryStage.show();
        
    }
    
    
    @Override
    public void init(){
        
        
    }
    
    /**
     *
     * @param args
     */
    public static void main(String args[]){
        launch(args);

    }
    
    
}
