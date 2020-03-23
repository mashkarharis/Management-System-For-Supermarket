
package abc.sup.bo.custom.impl;

import abc.sup.bo.SuperBO;
import abc.sup.bo.custom.TransactionBO;
import abc.sup.dao.DAOFactory;
import abc.sup.dao.SuperDAO;
import abc.sup.dao.custom.SuppliersDAO;
import abc.sup.dto.TransactionDTO;
import java.util.ArrayList;

/**
 *
 * @author U s E r ™

*/
public class TransactionBOimpl implements TransactionBO {
 SuperDAO superDAO;

    public TransactionBOimpl() throws Exception {
        superDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.TRANSACTION);
    }
    @Override
    public ArrayList getAll() throws Exception {
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
       superDAO.print(customer);
    }

    @Override
    public int EDIT(TransactionDTO customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TransactionDTO getdetails(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
