package cn.jk.pearl.pojo;

import java.sql.Timestamp;


/**
 * Farmer entity. @author MyEclipse Persistence Tools
 */

public class Farmer  implements java.io.Serializable {


    // Fields    
	private static final long serialVersionUID = 1L;
	private Integer farmerId;
     private String farmerName;
     private String farmerPass;
     private String farmerCompany;
     private String farmerPhone;
     private String farmerAddress;
     private String farmerEmail;
     private Timestamp farmerRegistertime;


    // Constructors

    /** default constructor */
    public Farmer() {
    }

    /** full constructor */
    public Farmer(String farmerName, String farmerPass, String farmerCompany, String farmerPhone, String farmerAddress, String farmerEmail, Timestamp farmerRegistertime) {
        this.farmerName = farmerName;
        this.farmerPass = farmerPass;
        this.farmerCompany = farmerCompany;
        this.farmerPhone = farmerPhone;
        this.farmerAddress = farmerAddress;
        this.farmerEmail = farmerEmail;
        this.farmerRegistertime = farmerRegistertime;
    }

   
    // Property accessors

    public Integer getFarmerId() {
        return this.farmerId;
    }
    
    public void setFarmerId(Integer farmerId) {
        this.farmerId = farmerId;
    }

    public String getFarmerName() {
        return this.farmerName;
    }
    
    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getFarmerPass() {
        return this.farmerPass;
    }
    
    public void setFarmerPass(String farmerPass) {
        this.farmerPass = farmerPass;
    }

    public String getFarmerCompany() {
        return this.farmerCompany;
    }
    
    public void setFarmerCompany(String farmerCompany) {
        this.farmerCompany = farmerCompany;
    }

    public String getFarmerPhone() {
        return this.farmerPhone;
    }
    
    public void setFarmerPhone(String farmerPhone) {
        this.farmerPhone = farmerPhone;
    }

    public String getFarmerAddress() {
        return this.farmerAddress;
    }
    
    public void setFarmerAddress(String farmerAddress) {
        this.farmerAddress = farmerAddress;
    }

    public String getFarmerEmail() {
        return this.farmerEmail;
    }
    
    public void setFarmerEmail(String farmerEmail) {
        this.farmerEmail = farmerEmail;
    }

    public Timestamp getFarmerRegistertime() {
        return this.farmerRegistertime;
    }
    
    public void setFarmerRegistertime(Timestamp farmerRegistertime) {
        this.farmerRegistertime = farmerRegistertime;
    }
   








}