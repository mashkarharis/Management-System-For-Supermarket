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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author U s E r ™
 */
public class SUPPLIERADDController implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private TextField address;

    @FXML
    private TextField tel;

    @FXML
    private TextField email;

    @FXML
    private TextField amount;

    @FXML
    private JFXButton add;

    @FXML
    private TextField sid;

    @FXML
    void addbutton(ActionEvent event) {
            suppliersDTO sup=new suppliersDTO(sid.getText(), name.getText(), address.getText(), email.getText(), Integer.parseInt(tel.getText()),Double.parseDouble(amount.getText()));
    supbo.add(sup);
    
    
    }
    /**
     * Initializes the controller class.
     */SuperBO supbo;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            supbo=BOFactory.getInstance().getBO(BOFactory.BOTypes.SUPPLIERS) ;// TODO
        } catch (Exception ex) {
            Logger.getLogger(SUPPLIERADDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
