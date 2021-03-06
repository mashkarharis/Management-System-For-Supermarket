/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.sup.dto;

/**
 *
 * @author U s E r ™
 */
public class itemDTO extends SuperDTO{
    private String iid;
    private String sid;
    private String name;
    private String description;
    private Double unitprice;
    private Double qtyonhand;

    public itemDTO() {
    }

    public itemDTO(String iid, String sid, String name, String description, Double unitprice, Double qtyonhand) {
        this.iid = iid;
        this.sid = sid;
        this.name = name;
        this.description = description;
        this.unitprice = unitprice;
        this.qtyonhand = qtyonhand;
    }

    public itemDTO(String iid, String name, double unitprice) {
         this.iid = iid;
         this.name = name;
         this.unitprice = unitprice;
    }

    public itemDTO(String sid, String iid, String name, String desc, Double price) {this.iid = iid;
        this.sid = sid;
        this.name = name;
        this.description = desc;
        this.unitprice = price;
       }

    public itemDTO(String iid, String sid, String name, double unitprice) {
     this.iid = iid;
     this.sid=sid;
         this.name = name;
         this.unitprice = unitprice;
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
     * @return the sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * @param sid the sid to set
     */
    public void setSid(String sid) {
        this.sid = sid;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the unitprice
     */
    public Double getUnitprice() {
        return unitprice;
    }

    /**
     * @param unitprice the unitprice to set
     */
    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    /**
     * @return the qtyonhand
     */
    public Double getQtyonhand() {
        return qtyonhand;
    }

    /**
     * @param qtyonhand the qtyonhand to set
     */
    public void setQtyonhand(Double qtyonhand) {
        this.qtyonhand = qtyonhand;
    }
    
    
}
