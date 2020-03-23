/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.sup.dao.custom.impl;

import abc.sup.dao.SuperDAO;
import abc.sup.dao.custom.CustomerDAO;
import abc.sup.db.DBConnection;
import abc.sup.dto.customerDTO;
import abc.sup.dto.itemDTO;

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
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author U s E r ™
 */
public class CustomerDAOImpl implements CustomerDAO {
Statement connectionstm;
    Connection con;
    public CustomerDAOImpl() throws Exception {connectionstm=  DBConnection.getInstance().getConnection().createStatement();
    con=DBConnection.getInstance().getConnection();
    }

    @Override
    public ArrayList<customerDTO> getAll() {
         ArrayList<customerDTO> list1=null;
    
        try {
            Statement stm=connectionstm;
            String SQL="select * from customers";
            ResultSet rst = stm.executeQuery(SQL);
            ArrayList<customerDTO> list= new ArrayList<>();
            while(rst.next()){
               customerDTO llist= new customerDTO(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getString(5),
                        rst.getString(6),
                        rst.getInt(7),
                        rst.getDouble(8)
                        
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
    public boolean add(customerDTO customer) {
        int r=0;
    try {
        String SQL="insert into customers values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(SQL);
        ps.setString(1, customer.getCid());
        ps.setString(2, customer.getMembershipdate());
        ps.setString(3, customer.getRegno());
        ps.setString(4, customer.getName());
        ps.setString(5, customer.getAddress());
        ps.setString(6, customer.getEmail());
        ps.setInt(7, customer.getTele());
        ps.setDouble(8, customer.getPoints());
        int result = ps.executeUpdate();
        r=result;
        
    } catch (SQLException ex) {
        Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
    }return (r>0);
   
    }

    @Override
    public boolean remove(customerDTO customer) {
   boolean r=false;
    try {
        Statement statement = con.createStatement();
        String SQL= "Delete From Customers where cid ='"+customer.getCid()+"'";
        r= statement.executeUpdate(SQL)>0;
    } catch (SQLException ex) {
        Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
   return r;
    }

    @Override
    public ArrayList<String> getAllCID() {
          ArrayList<String> list1=null;
    
        try {
            Statement stm=connectionstm;
            String SQL="select cid from customers";
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

    /**
     *
     * @param customer
     */
    @Override
    public void print(customerDTO customer){
    try {
        JasperDesign js = JRXmlLoader.load(this.getClass().getResourceAsStream("/abc/sup/jspr/ER.jrxml"));
        JasperReport jasperReport = JasperCompileManager.compileReport(js);
        JasperPrint jasperPrint;
        

            HashMap hm= new HashMap();
            hm.put("cid",customer.getCid());
            hm.put("name",customer.getName());
            hm.put("address",customer.getAddress());
            hm.put("tel",customer.getTele()+"");
            hm.put("regno",customer.getRegno());
            hm.put("email",customer.getEmail());
            hm.put("date",customer.getMembershipdate());
            hm.put("points",customer.getPoints()+"");


        
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
    public int EDIT(customerDTO customer) {
        int a=0;
    try {
        String SQL="update Customers set name=?, address=? ,email=?, tele=?  where cid=?";
        PreparedStatement ps= con.prepareStatement(SQL);
        ps.setString(1,customer.getName());
        ps.setString(2, customer.getAddress());
        ps.setString(3, customer.getEmail());
        ps.setInt(4,customer.getTele());
        ps.setString(5,customer.getCid());
        int result = ps.executeUpdate();
        a=result;
                } catch (SQLException ex) {
        Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
    }return (a);
    }

    @Override
    public customerDTO EDIT(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
 
    
    
    