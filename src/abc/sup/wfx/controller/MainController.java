/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.sup.wfx.controller;

import abc.sup.bo.BOFactory;
import abc.sup.bo.SuperBO;
import abc.sup.bo.custom.ItemBO;

import abc.sup.dto.TransactionDTO;
import abc.sup.dto.customerDTO;
import abc.sup.dto.itemDTO;
import abc.sup.dto.suppliersDTO;
import abc.sup.wfx.main.CUSTOMER;
import abc.sup.wfx.main.CUSTOMEREDIT;
import abc.sup.wfx.main.CUSTOMERPRINT;
import abc.sup.wfx.main.CUSTOMERREMOVE;
import abc.sup.wfx.main.ITEMADD;
import abc.sup.wfx.main.ITEMEDIT;
import abc.sup.wfx.main.ITEMPRINT;
import abc.sup.wfx.main.ITEMREMOVE;
import abc.sup.wfx.main.SUPPLIERADD;
import abc.sup.wfx.main.SUPPLIEREDIT;
import abc.sup.wfx.main.SUPPLIERPRINT;
import com.jfoenix.controls.JFXButton;
import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * FXML Controller class
 *
 * @author U s E r ™
 */
@SuppressWarnings("InitializerMayBeStatic")
public class MainController implements Initializable  {

    @FXML
    private JFXButton s5add;
    @FXML
    private JFXButton s5print;
    @FXML
    private JFXButton s5remove;
    @FXML
    private JFXButton s5edit;
    @FXML
    private JFXButton s6add;
    @FXML
    private JFXButton s6print;
    @FXML
    private JFXButton s6remove;
    @FXML
    private JFXButton s6edit;
    @FXML
    private JFXButton s1add;
    @FXML
    private JFXButton s1print;
    @FXML
    private JFXButton s1edit;
    @FXML
    private JFXButton S4SAVE;
    @FXML
    private JFXButton S4REMOVEITEM;
     @FXML
    private TableView<suppliersDTO> S2SUPPLIERTABLE;
  

    @FXML
    private TableColumn<suppliersDTO,String> sid;

    @FXML
    private TableColumn<suppliersDTO,String> name;

    @FXML
    private TableColumn<suppliersDTO,String> amount;
    @FXML // fx:id="table2"
    private TableView<itemDTO> table2; // Value injected by FXMLLoader

    @FXML // fx:id="iid"
    private TableColumn<itemDTO, String> iid; // Value injected by FXMLLoader

    @FXML // fx:id="iname"
    private TableColumn<itemDTO, String> iname; // Value injected by FXMLLoader

    @FXML // fx:id="iup"
    private TableColumn<itemDTO, String> iup; // Value injected by FXMLLoader
 @FXML // fx:id="ccid"
    private TableColumn<customerDTO,String> ccid; // Value injected by FXMLLoader

    @FXML // fx:id="cname"
    private TableColumn<customerDTO,String> cname; // Value injected by FXMLLoader

    @FXML // fx:id="ctel"
    private TableColumn<customerDTO,String> ctel; // Value injected by FXMLLoader
   @FXML // fx:id="table3"
    private TableView<customerDTO> table3; // Value injected by FXMLLoader
   @FXML
    private TextField s3cname;

    @FXML
    private TextField s3cdate;

    @FXML
    private TextField s3iname;

    @FXML
    private TextField s3ionhand;

    @FXML
    private TextField s3iqty;

    @FXML
    private TextField s3idesc;

    @FXML
    private TextField s3iprice;

    @FXML
    private TableView<TransactionDTO> s3transtable;
    
     
  @FXML
    private TableColumn<TransactionDTO,String> tname;
    @FXML
    private TableColumn<TransactionDTO,String> tiid;

    @FXML
    private TableColumn<TransactionDTO, String> tqty;

    @FXML
    private TableColumn<TransactionDTO, String> tup;

    @FXML
    private TableColumn<TransactionDTO, String> tamount;


    @FXML
    private TextField s4transtot;
 @FXML
    private TextField billidd;
    @FXML
    private ComboBox<String> s3cid;

    @FXML
    private ComboBox<String> s3iid;
    @FXML
    private JFXButton se;

    @FXML
    private JFXButton ch;
       @FXML
            
   customerDTO newcus;
 
   ArrayList<TransactionDTO> listt;
    @FXML
    void se(ActionEvent event) {
        newcus=new customerDTO();
        newcus.setCid(s3cid.getValue());
        newcus.setName(s3cname.getText());
        listt=new ArrayList<TransactionDTO>();
        qqty.setDisable(false);
       se.setDisable(true);
       ch.setDisable(false);
        s3cid.setDisable(true);
        tot=0;
        refreshtable_qty_total();     qtyrefresh();
            
    }
   @FXML
    void ch(ActionEvent event) { newcus=null;
       tot=0;
        listt=null;
        qqty.setDisable(true);
      se.setDisable(false);
       ch.setDisable(true);
        s3cid.setDisable(false);
refreshtable_qty_total();     qtyrefresh();
    }
    String gettransid(){
      return s3iid.getValue()+""+billidd.getText();
}

    
     @FXML
    private Button qqty;

             
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
public void initialize(URL url, ResourceBundle rb) {
     try { billidd.setText(OffsetDateTime.now()+"");
               SuperBOii=BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMERS);
                   // Weekdays 
       ArrayList<String> getcid=SuperBOii.getAllCID();
       ArrayList<customerDTO> getdto=SuperBOii.getAll();
  ch.setDisable(true);
       s3cid.setItems(FXCollections.observableArrayList(getcid));
       
s3cid.getSelectionModel().selectFirst();
            for (customerDTO c:getdto) {
                
                if (c.getCid().endsWith(s3cid.getValue())){
                    
                  s3cname.setText(c.getName());
                s3cdate.setText(LocalDate.now()+"");
                
                qqty.setDisable(true);
                              }
                
            }
  
        
               
           } catch (Exception ex) {
               Logger.getLogger(CUSTOMEREDITController.class.getName()).log(Level.SEVERE, null, ex);
           }
        try {
            S2REFRESH();
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }  try { 
               SuperBOi=BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEMS);
                   // Weekdays 
       ArrayList<String> getiid=SuperBOi.getAllCID();
       ArrayList<itemDTO> getdto=SuperBOi.getAll();
  
       s3iid.setItems(FXCollections.observableArrayList(getiid));
       
s3iid.getSelectionModel().selectFirst();
            for (itemDTO c:getdto) {
                
                if (c.getIid().endsWith(s3iid.getValue())){
                    
                s3iname.setText(c.getName());
               
                s3idesc.setText(c.getDescription());
                s3ionhand.setText(c.getQtyonhand()+"");
                s3iprice.setText(c.getUnitprice()+"");
               
                              }
                
            }
  
        
               
           } catch (Exception ex) {
               Logger.getLogger(CUSTOMEREDITController.class.getName()).log(Level.SEVERE, null, ex);
           } 

}
 

    /**
     *
     * @throws java.io.IOException
     */
    @FXML
public void s5edit() throws IOException{
      new CUSTOMEREDIT().start(new Stage());
    
}
public void s5add() throws IOException{
      new CUSTOMER().start(new Stage());
    
}
public void s5print() throws IOException{
      new CUSTOMERPRINT().start(new Stage());
    
}
public void s5remove() throws IOException{
      new CUSTOMERREMOVE().start(new Stage());
    
}
public void S6ADD() throws IOException{
      new ITEMADD().start(new Stage());
    
}
public void S6REMOVE() throws IOException{
      new ITEMREMOVE().start(new Stage());
    
}
public void S6PRINT() throws IOException{
      new ITEMPRINT().start(new Stage());
    
}
public void S6EDIT() throws IOException{
      new ITEMEDIT().start(new Stage());
    
}
public void S4EDIT() throws IOException{
      new SUPPLIEREDIT().start(new Stage());
    
}
public void S4PRINT() throws IOException{
      new SUPPLIERPRINT().start(new Stage());
    
}
public void S4ADD() throws IOException{
      new SUPPLIERADD().start(new Stage());
    
}
SuperBO SuperBO;
SuperBO SuperBOi;
SuperBO SuperBOii;
SuperBO SuperBOiii;
    int tot=0;
    public MainController() throws Exception {
   SuperBO =BOFactory.getInstance().getBO(BOFactory.BOTypes.SUPPLIERS);
   SuperBOi =BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEMS);
   SuperBOii=BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMERS);
    SuperBOiii=BOFactory.getInstance().getBO(BOFactory.BOTypes.TRANSACTIONS);

    }

public  void S2REFRESH() throws IOException, Exception{
    S2SUPPLIERTABLE.refresh();
     ObservableList<suppliersDTO> list=FXCollections.observableArrayList(
    SuperBO.getAll());
    sid.setCellValueFactory(new PropertyValueFactory<suppliersDTO,String>("sid"));
    name.setCellValueFactory(new PropertyValueFactory<suppliersDTO,String>("name"));
    amount.setCellValueFactory(new PropertyValueFactory<suppliersDTO,String>("amount"));
    S2SUPPLIERTABLE.setItems(list);
    
     ObservableList<itemDTO> ilist=FXCollections.observableArrayList(
    SuperBOi.getAll());
    iid.setCellValueFactory(new PropertyValueFactory<itemDTO,String>("iid"));
    iname.setCellValueFactory(new PropertyValueFactory<itemDTO,String>("name"));
    iup.setCellValueFactory(new PropertyValueFactory<itemDTO,String>("unitprice"));
    table2.setItems(ilist);
    
     ObservableList<customerDTO> listt=FXCollections.observableArrayList(
    SuperBOii.getAll());
    ccid.setCellValueFactory(new PropertyValueFactory<customerDTO,String>("cid"));
    cname.setCellValueFactory(new PropertyValueFactory<customerDTO,String>("name"));
    ctel.setCellValueFactory(new PropertyValueFactory<customerDTO,String>("tele"));
    table3.setItems(listt);
     S2SUPPLIERTABLE.refresh(); }
      @FXML
    void add(ActionEvent event) {
         int index=0;
      String tr=s3iid.getValue();
      int qty=0;
        for (TransactionDTO transactionDTO : listt) {
            if(tr==transactionDTO.getIid()){
                qty+=transactionDTO.getQty();
                tot-=transactionDTO.getTotal();
                listt.remove(index);
                refreshtable_qty_total();
                break;
            
            }else{index+=1;}
        }
        
        int aa;
        TransactionDTO a=new TransactionDTO();
        a.setCid(newcus.getCid());
        a.setIid( s3iid.getValue());
        a.setQty((int) Double.parseDouble(s3iqty.getText())+qty);
        aa=(int) Double.parseDouble(s3iqty.getText())+qty;
        a.setTid(gettransid());
        tot+=Double.parseDouble(""+aa)*SuperBOi.getdetails(s3iid.getValue()).getUnitprice();
        a.setTotal(Double.parseDouble(""+aa)*SuperBOi.getdetails(s3iid.getValue()).getUnitprice());
        a.setName(SuperBOi.getdetails(s3iid.getValue()).getName());
    listt.add(a);
     refreshtable_qty_total();     qtyrefresh();
       
        

    }

    @FXML
    void s4cselect(ActionEvent event) throws Exception {
           ArrayList<customerDTO> getdto=SuperBOii.getAll();
        for (customerDTO c:getdto) {
                
                if (c.getCid().endsWith(s3cid.getValue())){
                
                s3cname.setText(c.getName());
                s3cdate.setText(LocalDate.now()+"");
               
                              }
                
            }

    }

    @FXML
    void s4iselect(ActionEvent event) throws Exception {
       
ArrayList<itemDTO> getdto=SuperBOi.getAll();
         for (itemDTO c:getdto) {
                
                if (c.getIid().endsWith(s3iid.getValue())){
                    
                s3iname.setText(c.getName());
               
                s3idesc.setText(c.getDescription());
                s3ionhand.setText(c.getQtyonhand()+"");
                s3iprice.setText(c.getUnitprice()+"");
               
                              } qtyrefresh();
                
            }
    }

    @FXML
    void s4trancesaveprint(ActionEvent event) {
        
           TransactionDTO tr=new TransactionDTO(s3cid.getValue(),billidd.getText(),s3cdate.getText(), 0, Double.parseDouble(s4transtot.getText()));
           SuperBOiii.print(tr);
            billidd.setText(OffsetDateTime.now()+"");
            ch(); qtyrefresh();
            
       
               

    }

    @FXML
    void s4transremove(ActionEvent event) {
      int index=0;
      TransactionDTO tr=s3transtable.getSelectionModel().getSelectedItem();
        for (TransactionDTO transactionDTO : listt) {
            if(tr.getIid()==transactionDTO.getIid()){
                tot-=transactionDTO.getTotal();
                listt.remove(index);
                refreshtable_qty_total();qtyrefresh();
                break;
            
            }else{index+=1;} 
        }
   

    
            

}

    private void refreshtable_qty_total(){
   
        s4transtot.setText(tot+"");
        s3transtable.refresh();
        if(listt!=null){
     ObservableList<TransactionDTO> list=FXCollections.observableArrayList(
   listt);
    tiid.setCellValueFactory(new PropertyValueFactory<TransactionDTO,String>("iid"));
    tqty.setCellValueFactory(new PropertyValueFactory<TransactionDTO,String>("qty"));
    tup.setCellValueFactory(new PropertyValueFactory<TransactionDTO,String>("up"));
  tname.setCellValueFactory(new PropertyValueFactory<TransactionDTO,String>("name"));
     tamount.setCellValueFactory(new PropertyValueFactory<TransactionDTO,String>("total"));
  
s3transtable.setItems(list);}else{s3transtable.setItems(null);}
s3transtable.refresh();
    }

    private void ch() {
       tot=0;
        listt=null;
        qqty.setDisable(true);
      se.setDisable(false);
       ch.setDisable(true);
        s3cid.setDisable(false);
refreshtable_qty_total();     qtyrefresh();
    }

   

    
void qtyrefresh(){
        Double qty=SuperBOi.getdetails(s3iid.getValue()).getQtyonhand();
  
     if (listt!=null){
        for (TransactionDTO transactionDTO : listt) {
            if(s3iid.getValue()==transactionDTO.getIid()){
                qty-=transactionDTO.getQty();
            }
            }
        }
s3ionhand.setText(""+qty);



}


}