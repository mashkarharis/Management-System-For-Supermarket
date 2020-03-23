/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.sup.dao.custom.impl;

import abc.sup.dao.SuperDAO;
import abc.sup.dao.custom.TransactionDAO;
import abc.sup.dto.TransactionDTO;
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
public class TRANSACTIONDAOimpl implements TransactionDAO {

    public TRANSACTIONDAOimpl() {
    }

    @Override
    public ArrayList getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(TransactionDTO customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(TransactionDTO customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllCID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print(TransactionDTO customer) {
       try {
        JasperDesign js = JRXmlLoader.load(this.getClass().getResourceAsStream("/abc/sup/jspr/ER3.jrxml"));
        JasperReport jasperReport = JasperCompileManager.compileReport(js);
        JasperPrint jasperPrint;
        

            HashMap hm= new HashMap();
            hm.put("customerid",customer.getTid());
            hm.put("date",customer.getCid());
            hm.put("amount",customer.getTotal()+"");
            hm.put("billid",customer.getIid());
          
          


        
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
    public int EDIT(TransactionDTO customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TransactionDTO EDIT(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
