/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.sup.wfx.controller;

import abc.sup.bo.BOFactory;
import abc.sup.bo.SuperBO;
import abc.sup.dto.itemDTO;
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
public class ITEMREMOVEController implements Initializable {
    @FXML
    private TextField name;

    @FXML
    private TextField desc;

    @FXML
    private TextField up;

    @FXML
    private JFXButton remove;

    @FXML
    private TextField sid;

    @FXML
    private TextField qty;

    @FXML
    private ComboBox<String> iid;

    @FXML
    void iremove(ActionEvent event) {
itemDTO item=new itemDTO(iid.getValue().toString(),sid.getText().toString(),name.getText().toString(),desc.getText().toString(),Double.parseDouble(up.getText().toString()),Double.parseDouble(qty.getText().toString()));
supbo.remove(item);
    }
    SuperBO supbo;

    @FXML
    void select(ActionEvent event) throws Exception {
  ArrayList<itemDTO> getdto=supbo.getAll();
        for (itemDTO c:getdto) {
                
                if (c.getIid().endsWith(iid.getValue())){
                    
                sid.setText(c.getSid());
               
                name.setText(c.getName());
                desc.setText(c.getDescription()+"");
                up.setText(c.getUnitprice()+"");
                qty.setText(c.getQtyonhand()+"");
                              }
                
            }
    }

    /**
     * Initializes the controller class.
     */
    @Override
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public void initialize(URL url, ResourceBundle rb) {
         try { 
               supbo=BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEMS);
                   // Weekdays 
       ArrayList<String> getiid=supbo.getAllCID();
       ArrayList<itemDTO> getdto=supbo.getAll();
  
       iid.setItems(FXCollections.observableArrayList(getiid));
       
iid.getSelectionModel().selectFirst();
            for (itemDTO c:getdto) {
                
                if (c.getIid().endsWith(iid.getValue())){
                    
                sid.setText(c.getSid());
               
                name.setText(c.getName());
                desc.setText(c.getDescription()+"");
                up.setText(c.getUnitprice()+"");
                qty.setText(c.getQtyonhand()+"");
                              }
                
            }
  
        
               
           } catch (Exception ex) {
               Logger.getLogger(CUSTOMEREDITController.class.getName()).log(Level.SEVERE, null, ex);
           }    // TODO
  // TODO
    }    
    
}
