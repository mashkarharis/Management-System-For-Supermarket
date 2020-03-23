/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.sup.wfx.controller;

import abc.sup.bo.BOFactory;
import abc.sup.bo.SuperBO;
import abc.sup.dto.customerDTO;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author U s E r ™
 */
public class CUSTOMEREDITController implements Initializable {

 
    @FXML
    private TextField regno;

    @FXML
    private TextField name;

    @FXML
    private TextField address;

    @FXML
    private TextField tel;

    @FXML
    private TextField email;

    @FXML
    private TextField points;

    @FXML
    private TextField date;

    @FXML
    private JFXButton edit;

    @FXML
    private ComboBox<String> ccid;

    @FXML
    void editedited(ActionEvent event) {
         customerDTO customer=new customerDTO(ccid.getValue(),date.getText(),regno.getText(),name.getText(),address.getText(),email.getText(),Integer.parseInt(tel.getText()),Double.parseDouble(points.getText()));
        int a=supbo.EDIT(customer);

    }
    SuperBO supbo;

    @FXML
    void editselect(ActionEvent event) throws Exception {
          ArrayList<customerDTO> getdto=supbo.getAll();
        for (customerDTO c:getdto) {
                
                if (c.getCid().endsWith(ccid.getValue())){
                
                address.setText(c.getAddress());
                date.setText(c.getMembershipdate());
                email.setText(c.getEmail());
                name.setText(c.getName());
                points.setText(c.getPoints()+"");
                regno.setText(c.getRegno());
                tel.setText(c.getTele()+"");
                              
                
            }

    }




    }

    /**
     * Initializes the controller class.
     * @throws java.lang.Exception
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
           
        try { 
               supbo=BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMERS);
                   // Weekdays 
       ArrayList<String> getcid=supbo.getAllCID();
       ArrayList<customerDTO> getdto=supbo.getAll();
  
       ccid.setItems(FXCollections.observableArrayList(getcid));
       
ccid.getSelectionModel().selectFirst();
            for (customerDTO c:getdto) {
                
                if (c.getCid().endsWith(ccid.getValue())){
                    
                address.setText(c.getAddress());
                date.setText(c.getMembershipdate());
                email.setText(c.getEmail());
                name.setText(c.getName());
                points.setText(c.getPoints()+"");
                regno.setText(c.getRegno());
                tel.setText(c.getTele()+"");
                              }
                
            }
  
        
               
           } catch (Exception ex) {
               Logger.getLogger(CUSTOMEREDITController.class.getName()).log(Level.SEVERE, null, ex);
           }
 
  
  
    }    
    
}
