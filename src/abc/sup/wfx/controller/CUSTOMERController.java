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
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author U s E r ™
 */
public class CUSTOMERController implements Initializable {
    
    SuperBO supbo;

    public CUSTOMERController() throws Exception {
        
        supbo=BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMERS);
    }
    
    
    
    
       @FXML
    private TextField cid;

    @FXML
    private TextField cregno;

    @FXML
    private TextField name;

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
    private JFXButton cadd;
   

  

    @FXML
    public void addcustomer(ActionEvent event) {
        
        //customerDTO customer=new customerDTO(cid.getText(), cdate.getText(), cregno.getText(), name.getText(), caddress.getText(), cemail.getText(), Integer.parseInt(ctel.getText()),Double.parseDouble(cpoints.getText()));
        customerDTO customer=new customerDTO(cid.getText().toString(), cdate.getText().toString(),cregno.getText().toString(), name.getText().toString(),caddress.getText().toString(), cemail.getText().toString(),  Integer.parseInt(ctel.getText().toString()),Double.parseDouble(cpoints.getText()+""));
        System.out.println(supbo.add(customer));
    
    
    
    
    
    }


    /**
     * Initializes the controller class.
     */
    @Override
     public void initialize(URL url, ResourceBundle rb) {
        cdate.setText(LocalDate.now().toString());// TODO
    }    
    
}
