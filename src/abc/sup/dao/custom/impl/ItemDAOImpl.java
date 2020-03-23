/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.sup.dao.custom.impl;

import abc.sup.dao.SuperDAO;
import abc.sup.dao.custom.ItemDAO;
import abc.sup.db.DBConnection;
import abc.sup.dto.itemDTO;
import abc.sup.dto.suppliersDTO;
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
import sun.rmi.transport.Connection;

/**
 *
 * @author U s E r ™
 */
public class ItemDAOImpl implements ItemDAO {
    Statement connectionstm;
    PreparedStatement ps;
    public ItemDAOImpl() throws Exception {
        connectionstm=  DBConnection.getInstance().getConnection().createStatement();
       
    }

 

    @Override
    public ArrayList getAll() {
         ArrayList<itemDTO> list1=null;
    
        try {
            Statement stm=connectionstm;
            String SQL="select * from items";
            ResultSet rst = stm.executeQuery(SQL);
            ArrayList<itemDTO> list= new ArrayList<>();
            while(rst.next()){
               itemDTO llist= new itemDTO(
                        rst.getString(1),rst.getString(2),
                        rst.getString(3),rst.getString(4),
                        rst.getDouble(5),rst.getDouble(6)
                        
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
    public boolean add(itemDTO customer) {
          int r=0;
    try {
        
        String SQL="insert into items values(?,?,?,?,?,?)";
        ps=  DBConnection.getInstance().getConnection().prepareStatement(SQL);
        ps.setString(1, customer.getIid());
        ps.setString(2, customer.getSid());
        ps.setString(3, customer.getName());
        ps.setString(4, customer.getDescription());
        ps.setDouble(5, customer.getUnitprice());
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
    public boolean remove(itemDTO customer) {
        boolean r=false;
    try {
        Statement statement = connectionstm;
        String SQL= "Delete From items where iid ='"+customer.getIid()+"'";
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
            String SQL="select iid from items";
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
    public void print(itemDTO customer) {
      try {
        JasperDesign js = JRXmlLoader.load(this.getClass().getResourceAsStream("/abc/sup/jspr/ER1.jrxml"));
        JasperReport jasperReport = JasperCompileManager.compileReport(js);
        JasperPrint jasperPrint;
        

            HashMap hm= new HashMap();
            hm.put("iid",customer.getIid());
            hm.put("sid",customer.getSid());
            hm.put("name",customer.getName());
            hm.put("desc",customer.getDescription()+"");
            hm.put("unitprice",customer.getUnitprice()+"");
            hm.put("qty",customer.getQtyonhand()+"");
          


        
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
    public int EDIT(itemDTO customer) {
             int a=0;
    try {
        String SQL="update items set  sid=? ,name=?, description=?,unitprice=?,qtyonhand=?  where iid=?";
        ps= DBConnection.getInstance().getConnection().prepareStatement(SQL);
        ps.setString(1,customer.getSid());
        ps.setString(2, customer.getName());
        ps.setString(3, customer.getDescription());
        ps.setDouble(4,customer.getUnitprice());
        ps.setDouble(5,customer.getQtyonhand());
        ps.setString(6,customer.getIid());
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
    public itemDTO EDIT(String value) {
       
       itemDTO a=null;
        try {
            Statement stm = connectionstm;
            ResultSet rst = stm.executeQuery("select * from items where iid='"+value+"'");
            if (rst.next()) {
                a= new itemDTO(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getDouble(5),
                        rst.getDouble(6)
                );
                
            }else{
                a=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       return a;
}
    
}
