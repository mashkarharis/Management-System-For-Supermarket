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
public class customerDTO extends SuperDTO{
    private String cid;
    private String membershipdate;
    private String regno;
    private String name;
    private String address;
    private String email;
    private int tele;
    private Double points;

    public customerDTO() {
    }

    public customerDTO(String cid, String membershipdate, String regno, String name, String address, String email, int tele, Double points) {
        this.cid = cid;
        this.membershipdate = membershipdate;
        this.regno = regno;
        this.name = name;
        this.address = address;
        this.email = email;
        this.tele = tele;
        this.points = points;
    }

    public customerDTO(String a, String b, int c) {
      this.cid = a;this.name =b;this.tele = c;
    }

    public customerDTO(String a) {
        this.cid = a;
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
     * @return the membershipdate
     */
    public String getMembershipdate() {
        return membershipdate;
    }

    /**
     * @param membershipdate the membershipdate to set
     */
    public void setMembershipdate(String membershipdate) {
        this.membershipdate = membershipdate;
    }

    /**
     * @return the regno
     */
    public String getRegno() {
        return regno;
    }

    /**
     * @param regno the regno to set
     */
    public void setRegno(String regno) {
        this.regno = regno;
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
     * @return the points
     */
    public Double getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(Double points) {
        this.points = points;
    }
    
    
}
