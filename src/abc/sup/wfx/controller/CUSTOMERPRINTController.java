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
public class CUSTOMERPRINTController implements Initializable {
        @FXML
    private TextField cregno;

    @FXML
    private TextField cname;

    @FXML
    private TextField caddress;

    @FXML
    private TextField ctel;

    @FXML
    private TextField cemail;

    @FXML
    private TextField cpoints;

    @FXML
    private TextField cdate;

    @FXML
    private JFXButton S5PRINT;

    @FXML
    private ComboBox<String> ccid;


SuperBO supbo;
    @FXML
    void SPRINT(ActionEvent event) {
        customerDTO customer=new customerDTO(ccid.getValue(),cdate.getText().toString(),cregno.getText().toString(),cname.getText().toString(),caddress.getText().toString(),cemail.getText().toString(),Integer.parseInt(ctel.getText().toString()),Double.parseDouble(cpoints.getText().toString()));
      supbo.print(customer);
    

    }

    @FXML
    void SELECT(ActionEvent event) throws Exception {
         ArrayList<customerDTO> getdto=supbo.getAll();
        for (customerDTO c:getdto) {
                
                if (c.getCid().endsWith(ccid.getValue())){
                
                caddress.setText(c.getAddress());
                cdate.setText(c.getMembershipdate());
                cemail.setText(c.getEmail());
                cname.setText(c.getName());
                cpoints.setText(c.getPoints()+"");
                cregno.setText(c.getRegno());
                ctel.setText(c.getTele()+"");
                              }
                
            }

    }




    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try { 
               supbo=BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMERS);
                   // Weekdays 
       ArrayList<String> getcid=supbo.getAllCID();
       ArrayList<customerDTO> getdto=supbo.getAll();
  
       ccid.setItems(FXCollections.observableArrayList(getcid));
       
ccid.getSelectionModel().selectFirst();
            for (customerDTO c:getdto) {
                
                if (c.getCid().endsWith(ccid.getValue())){
                    
                caddress.setText(c.getAddress());
                cdate.setText(c.getMembershipdate());
                cemail.setText(c.getEmail());
                cname.setText(c.getName());
                cpoints.setText(c.getPoints()+"");
                cregno.setText(c.getRegno());
                ctel.setText(c.getTele()+"");
                              }
                
            }
  
        
               
           } catch (Exception ex) {
               Logger.getLogger(CUSTOMEREDITController.class.getName()).log(Level.SEVERE, null, ex);
           }
 
        // TODO
    }    
    
}
