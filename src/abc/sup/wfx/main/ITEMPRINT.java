/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.sup.wfx.main;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author U s E r ™
 */
public class ITEMPRINT extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
             Parent p=FXMLLoader.load(this.getClass().getResource("../viewandimg/ITEMPRINT.fxml"));
       Scene temp=new Scene(p);
       primaryStage.setScene(temp);
       primaryStage.setTitle("CUSTOMEREDIT");
       primaryStage.setResizable(true);primaryStage.show();
       primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
   
    
}
