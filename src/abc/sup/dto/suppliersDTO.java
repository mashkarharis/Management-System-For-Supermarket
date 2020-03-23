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
public class suppliersDTO extends SuperDTO{
    private String sid;
    private String name;
    private String address;
    private String email;
    private int tele;
    private double amount;

    public suppliersDTO() {
    }

    public suppliersDTO(String sid, String name, String address, String email, int tele, double amount) {
        this.sid = sid;
        this.name = name;
        this.address = address;
        this.email = email;
        this.tele = tele;
        this.amount = amount;
    }

    public suppliersDTO(String a, String b, double c) {
        this.sid = a;
        this.name = b;
        this.amount = c;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the tele
     */
    public int getTele() {
        return tele;
    }

    /**
     * @param tele the tele to set
     */
    public void setTele(int tele) {
        this.tele = tele;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
}
