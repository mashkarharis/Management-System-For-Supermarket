/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.sup.wfx.controller;

import abc.sup.bo.BOFactory;
import abc.sup.bo.SuperBO;
import abc.sup.dto.suppliersDTO;
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
public class SUPPLIERPRINTController implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private TextField address;

    @FXML
    private TextField tel;

    @FXML
    private JFXButton print;

   

  
    @FXML
    private TextField email;

    @FXML
    private TextField amount;

    @FXML
    private ComboBox<String> sid;
SuperBO supbo;
    @FXML
    void change(ActionEvent event) throws Exception { ArrayList<suppliersDTO> getdto=supbo.getAll();
    for (suppliersDTO c:getdto) {
                
                if (c.getSid().endsWith(sid.getValue())){
                name.setText(c.getName());
                address.setText(c.getAddress()+"");
                tel.setText(c.getTele()+"");
                email.setText(c.getEmail()+"");
                amount.setText(c.getAmount()+"");
                              }
                
            }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try { 
               supbo=BOFactory.getInstance().getBO(BOFactory.BOTypes.SUPPLIERS);
                   // Weekdays 
       ArrayList<String> getiid=supbo.getAllCID();
       ArrayList<suppliersDTO> getdto=supbo.getAll();
  
       sid.setItems(FXCollections.observableArrayList(getiid));
       
sid.getSelectionModel().selectFirst();
            for (suppliersDTO c:getdto) {
               
                
               if (c.getSid().endsWith(sid.getValue())){ 
                name.setText(c.getName());
                address.setText(c.getAddress()+"");
                tel.setText(c.getTele()+"");
                email.setText(c.getEmail()+"");
                amount.setText(c.getAmount()+"");
                              }
                
            }
  
        
               
           } catch (Exception ex) {
               Logger.getLogger(CUSTOMEREDITController.class.getName()).log(Level.SEVERE, null, ex);
           }
 
  
  // TODO
    }  
      @FXML
    void getprint(ActionEvent event) {
        suppliersDTO sup=new suppliersDTO(sid.getValue(), name.getText(), address.getText(), email.getText(), Integer.parseInt(tel.getText()), Double.parseDouble(amount.getText()));
        supbo.print(sup);

    }
    
}
