/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.sup.dto;

import abc.sup.bo.BOFactory;
import abc.sup.bo.custom.ItemBO;
import abc.sup.dao.custom.ItemDAO;

/**
 *
 * @author U s E r ™
 */
public class TransactionDTO extends SuperDTO{
   
    private String tid;
    private String iid;
    private String cid;
    private int qty;
    private Double total;
    private Double up;
    private String name;
    private String date;
    public TransactionDTO() {
    }

    public TransactionDTO(String tid, String iid, String cid, int qty, Double total) {
        this.tid = tid;
        this.iid = iid;
        this.cid = cid;
        this.qty = qty;
        this.total = total;
    }

    /**
     * @return the tid
     */
    public String getTid() {
        return tid;
    }

    /**
     * @param tid the tid to set
     */
    public void setTid(String tid) {
        this.tid = tid;
    }

    /**
     * @return the iid
     */
    public String getIid() {
        return iid;
    }

    /**
     * @param iid the iid to set
     */
    public void setIid(String iid) {
        this.iid = iid;
    }

    /**
     * @return the cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the up
     */
    public Double getUp() {
        return this.total/this.qty;
    }

    /**
     * @param up the up to set
     */
    public void setUp(Double up) {
        this.up = up;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    
}
