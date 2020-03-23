/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.sup.dao.custom.impl;

import abc.sup.dao.SuperDAO;
import abc.sup.dao.custom.SuppliersDAO;
import abc.sup.db.DBConnection;
import abc.sup.dto.suppliersDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author U s E r ™
 */
public class SUPPLIERSDAOimpl implements SuppliersDAO{
    Statement connectionstm;
    PreparedStatement ps;
    
       
       
  
    Connection connection;
    public SUPPLIERSDAOimpl() throws Exception {
       connection= DBConnection.getInstance().getConnection();
        connectionstm=  DBConnection.getInstance().getConnection().createStatement();
    }

    @Override
    public ArrayList getAll() {
        ArrayList<suppliersDTO> list1=null;
    
        try {
            Statement stm=connection.createStatement();
            String SQL="select * from suppliers";
            ResultSet rst = stm.executeQuery(SQL);
            ArrayList<suppliersDTO> list= new ArrayList<>();
            while(rst.next()){
                suppliersDTO llist= new suppliersDTO(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getInt(5),
                        rst.getDouble(6)
                        
                );
                list.add(llist);
                list1=list;
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(SUPPLIERSDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list1;
    }

    @Override
    public boolean add(suppliersDTO customer) {
             int r=0;
    try {
        
        String SQL="insert into suppliers values(?,?,?,?,?,?)";
        ps=  DBConnection.getInstance().getConnection().prepareStatement(SQL);
        ps.setString(1, customer.getSid());
        ps.setString(2, customer.getName());
        ps.setString(3, customer.getAddress());
        ps.setString(4, customer.getEmail());
        ps.setInt(5, customer.getTele());
         ps.setDouble(6, 00.00);
       
        int result = ps.executeUpdate();
        r=result;
        
    } catch (SQLException ex) {
        Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (Exception ex) {
            Logger.getLogger(ItemDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
return (r>0);
    }

    @Override
    public boolean remove(suppliersDTO customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllCID() {
             ArrayList<String> list1=null;
    
        try {
            Statement stm=connection.createStatement();
            String SQL="select sid from suppliers";
            ResultSet rst = stm.executeQuery(SQL);
            ArrayList<String> list= new ArrayList<>();
            while(rst.next()){
               String llist= rst.getString(1);
                        
                
                list.add(llist);
                
            }
            list1=list;
        } catch (SQLException ex) {
            Logger.getLogger(SUPPLIERSDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list1;
     
       
    }

    @Override
    public void print(suppliersDTO customer) {
       try {
        JasperDesign js = JRXmlLoader.load(this.getClass().getResourceAsStream("/abc/sup/jspr/ER2.jrxml"));
        JasperReport jasperReport = JasperCompileManager.compileReport(js);
        JasperPrint jasperPrint;
        

            HashMap hm= new HashMap();
            hm.put("sid",customer.getSid());
            hm.put("name",customer.getName());
            hm.put("address",customer.getAddress());
            hm.put("email",customer.getEmail());
            hm.put("tele",customer.getTele()+"");
            hm.put("amount",customer.getAmount()+"");
          


        
        jasperPrint = JasperFillManager
                .fillReport(
                        jasperReport,
                        hm,
                        new JREmptyDataSource());
        JasperViewer.viewReport(jasperPrint,false);

    } catch (JRException ex) {
    ex.printStackTrace();
        Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }

    @Override
    public int EDIT(suppliersDTO customer) {
                 int a=0;
    try {
        String SQL="update suppliers set  amount=? ,name=?, address=?,email=?,tele=?  where sid=?";
        ps= DBConnection.getInstance().getConnection().prepareStatement(SQL);
        ps.setDouble(1,customer.getAmount());
        ps.setString(2, customer.getName());
        ps.setString(3, customer.getAddress());
        ps.setString(4,customer.getEmail());
        ps.setInt(5,customer.getTele());
        ps.setString(6,customer.getSid());
        int result = ps.executeUpdate();
        a=result;
                } catch (SQLException ex) {
        Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (Exception ex) {
            Logger.getLogger(ItemDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
return (a);
    
    }

    @Override
    public suppliersDTO EDIT(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

