
package abc.sup.bo;
import abc.sup.dto.SuperDTO;
import abc.sup.dto.customerDTO;
import java.util.ArrayList;


public interface SuperBO<T extends SuperDTO>{
   public ArrayList<T> getAll()throws Exception;

    public boolean add(T customer);

    public boolean remove(T customer);

    public ArrayList<String> getAllCID();

    public void print(T customer);

    public int EDIT(T customer);

    public SuperDTO getdetails(String value);

    
}
