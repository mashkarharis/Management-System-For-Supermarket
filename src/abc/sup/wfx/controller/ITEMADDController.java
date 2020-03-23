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
public class ITEMADDController implements Initializable {
        SuperBO supbo1;

    public ITEMADDController() throws Exception {
        
     
    }
    
    @FXML
    private TextField iname;

    @FXML
    private TextField idesc;

    @FXML
    private TextField iprice;

    @FXML
    private JFXButton iadd;

    @FXML
    private TextField iid;

     @FXML
    private ComboBox<String> icombobox;

   
  

    @FXML
    void selectitem(ActionEvent event) {
  

    }




    SuperBO supbo;

    /**
     * Initializes the controller class.
     * @throws java.lang.Exception
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        try {
            supbo1=BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEMS);  supbo=BOFactory.getInstance().getBO(BOFactory.BOTypes.SUPPLIERS);
            try {
                
                
                // Weekdays
                ArrayList<String> getsid=supbo.getAllCID();
                
                
                icombobox.setItems(FXCollections.observableArrayList(getsid));
                
                icombobox.getSelectionModel().selectFirst();
                
                
                
                
            } catch (Exception ex) {
                Logger.getLogger(CUSTOMEREDITController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        } catch (Exception ex) {
               Logger.getLogger(ITEMADDController.class.getName()).log(Level.SEVERE, null, ex);
           }
 
  
  
    }    
    

    @FXML
    void iadd(ActionEvent event) {
 //customerDTO customer=new customerDTO(cid.getText(), cdate.getText(), cregno.getText(), name.getText(), caddress.getText(), cemail.getText(), Integer.parseInt(ctel.getText()),Double.parseDouble(cpoints.getText()));
      //  customerDTO customer=new customerDTO(cid.getText().toString(), cdate.getText().toString(),cregno.getText().toString(), name.getText().toString(),caddress.getText().toString(), cemail.getText().toString(),  Integer.parseInt(ctel.getText().toString()),Double.parseDouble(cpoints.getText()+""));
    //  itemDTO item=new itemDTO(icombobox.getValue().toString(),iid.getText().toString(),iname.getText().toString(),idesc.getText().toString(),Double.parseDouble(iprice.getText()));
    itemDTO item=new itemDTO();
    item.setIid(iid.getText());
    item.setSid(icombobox.getValue());
            item.setName(iname.getText());
                    item.setDescription(idesc.getText());
                    item.setUnitprice(Double.parseDouble(iprice.getText()));
   
    supbo1.add(item);
    }}

  
