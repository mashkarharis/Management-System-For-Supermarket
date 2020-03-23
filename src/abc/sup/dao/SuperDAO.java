/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.sup.dao;

import abc.sup.dto.SuperDTO;
import abc.sup.dto.customerDTO;
import abc.sup.dto.itemDTO;
import abc.sup.dto.suppliersDTO;
import java.util.ArrayList;


public interface SuperDAO <T extends SuperDTO>{

    public ArrayList<T> getAll();

    public boolean add(T customer);

    public boolean remove(T customer);

    public ArrayList<String> getAllCID();

    public void print(T customer);

    public int EDIT(T customer);

    public T EDIT(String value);

    /**
     *
     * @return
     */
   
   
}
