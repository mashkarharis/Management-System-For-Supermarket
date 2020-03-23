
package abc.sup.bo;

import abc.sup.bo.custom.impl.SuppliersBOimpl;
import abc.sup.bo.custom.impl.TransactionBOimpl;
import abc.sup.bo.custom.impl.ItemBOImpl;
import abc.sup.bo.custom.impl.CustomerBOImpl;



public class BOFactory {
    
    public  enum BOTypes{
        CUSTOMERS,ITEMS,TRANSACTIONS,SUPPLIERS
    }
    
    private static BOFactory bOFactory;

    public BOFactory() {
    }
    public static BOFactory getInstance(){
        if (bOFactory == null) {
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }
    
    public SuperBO getBO(BOTypes bOTypes) throws Exception{
        switch(bOTypes){
            case CUSTOMERS : return  new CustomerBOImpl();
            case ITEMS : return new ItemBOImpl();
             case TRANSACTIONS: return new TransactionBOimpl();
             case SUPPLIERS: return new SuppliersBOimpl();
            default:return null;
        }
    }
    
}
