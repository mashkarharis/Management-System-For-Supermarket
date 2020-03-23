
package abc.sup.dao;

import abc.sup.dao.custom.impl.SUPPLIERSDAOimpl;
import abc.sup.dao.custom.impl.TRANSACTIONDAOimpl;
import abc.sup.dao.custom.impl.ItemDAOImpl;
import abc.sup.dao.custom.impl.CustomerDAOImpl;



public class DAOFactory {
    public  enum DAOTypes{
        CUSTOMER,ITEM,TRANSACTION,SUPPLIERS
    }
    
    private static DAOFactory daoFactory;

    public DAOFactory() {
    }
    public static DAOFactory getInstance(){
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    
    public SuperDAO getDAO(DAOTypes dAOTypes) throws Exception{
        switch(dAOTypes){
            case CUSTOMER : return new CustomerDAOImpl();
            case ITEM : return new ItemDAOImpl();
           
            case SUPPLIERS : return new SUPPLIERSDAOimpl();
            case TRANSACTION : return new TRANSACTIONDAOimpl();
            default:return null;
        }
    }
}
