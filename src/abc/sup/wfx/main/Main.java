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
import net.sf.jasperreports.web.servlets.Controller;

/**
 *
 * @author U s E r ™
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
             Parent p=FXMLLoader.load(this.getClass().getResource("../viewandimg/Main.fxml"));
       Scene temp=new Scene(p);
       primaryStage.setScene(temp);
       primaryStage.setTitle("CUSTOMEREDIT");
       primaryStage.setResizable(true);primaryStage.show();
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
