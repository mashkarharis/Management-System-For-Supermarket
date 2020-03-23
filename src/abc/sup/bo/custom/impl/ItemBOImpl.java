
package abc.sup.bo.custom.impl;

import abc.sup.bo.SuperBO;
import abc.sup.bo.custom.ItemBO;
import abc.sup.dao.DAOFactory;
import abc.sup.dao.SuperDAO;
import abc.sup.dao.custom.ItemDAO;
import abc.sup.dto.SuperDTO;
import abc.sup.dto.itemDTO;
import java.util.ArrayList;


public class ItemBOImpl implements ItemBO {
ItemDAO itemDAO;
SuperDAO SuperDAO;
    public ItemBOImpl() throws Exception {
        SuperDAO=(SuperDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
        
    }

    @Override
    public ArrayList<itemDTO> getAll() throws Exception {
       return SuperDAO.getAll();
    
      }

    @Override
    public boolean add(itemDTO customer) {
   return SuperDAO.add(customer);
    }

    @Override
    public boolean remove(itemDTO customer) {
       return SuperDAO.remove(customer);
    }

    @Override
    public ArrayList<String> getAllCID() {
       return SuperDAO.getAllCID();
    }

    @Override
    public void print(itemDTO customer) {
        SuperDAO.print(customer);
    }

    @Override
    public int EDIT(itemDTO customer) {
       return SuperDAO.EDIT(customer);
    }

    @Override
    public SuperDTO getdetails(String value) {
        return SuperDAO.EDIT(value);
    }
    
}
