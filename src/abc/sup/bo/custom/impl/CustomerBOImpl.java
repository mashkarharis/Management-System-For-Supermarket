
package abc.sup.bo.custom.impl;

import abc.sup.bo.SuperBO;
import abc.sup.bo.custom.CustomerBO;
import abc.sup.dao.DAOFactory;
import abc.sup.dao.SuperDAO;
import abc.sup.dao.custom.CustomerDAO;
import abc.sup.dto.customerDTO;
import java.util.ArrayList;


public class CustomerBOImpl implements CustomerBO {
CustomerDAO customerDAO1;
SuperDAO customerDAO;

    public CustomerBOImpl() throws Exception {
    customerDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
   
    }

    @Override
    public ArrayList<customerDTO> getAll() throws Exception {
        return customerDAO.getAll();
        
        
    }

    @Override
    public boolean add(customerDTO customer) {
        return customerDAO.add(customer);
        
    }

    @Override
    public boolean remove(customerDTO customer) {
       return customerDAO.remove(customer);
    }

    @Override
    public ArrayList<String> getAllCID() {
        return customerDAO.getAllCID();
    }

    @Override
    public void print(customerDTO customer) {
       customerDAO.print(customer);
    }

    @Override
    public int EDIT(customerDTO customer) {
              return customerDAO.EDIT(customer);
    }

    @Override
    public customerDTO getdetails(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
