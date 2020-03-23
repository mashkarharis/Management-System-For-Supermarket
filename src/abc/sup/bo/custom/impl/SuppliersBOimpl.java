
package abc.sup.bo.custom.impl;

import abc.sup.bo.SuperBO;
import abc.sup.bo.custom.SupplierBO;
import abc.sup.dao.DAOFactory;
import abc.sup.dao.SuperDAO;
import abc.sup.dao.custom.SuppliersDAO;
import abc.sup.dto.suppliersDTO;
import java.util.ArrayList;




import abc.sup.bo.SuperBO;
import abc.sup.bo.custom.SupplierBO;
import abc.sup.dao.DAOFactory;
import abc.sup.dao.SuperDAO;
import abc.sup.dao.custom.SuppliersDAO;
import java.util.ArrayList;


public class SuppliersBOimpl implements SupplierBO{ 
SuppliersDAO suppliersDAO;
    SuperDAO superDAO;

    public SuppliersBOimpl() throws Exception {
        suppliersDAO=(SuppliersDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUPPLIERS);
        superDAO=(SuperDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUPPLIERS);
    }

    @Override
    public ArrayList<suppliersDTO> getAll() throws Exception {
        return superDAO.getAll();
    }

    @Override
    public boolean add(suppliersDTO customer) {
       return superDAO.add(customer);
    }

    @Override
    public boolean remove(suppliersDTO customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllCID() {
        return superDAO.getAllCID(); }

    @Override
    public void print(suppliersDTO customer) {
       superDAO.print(customer);
    }

    @Override
    public int EDIT(suppliersDTO customer) {
        return superDAO.EDIT(customer);
    }

    @Override
    public suppliersDTO getdetails(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

