package cn.jk.pearl.pojo;



/**
 * SuperUser entity. @author MyEclipse Persistence Tools
 */

public class SuperUser  implements java.io.Serializable {


    // Fields    

     private Integer superId;
     private String superName;
     private String superPass;


    // Constructors

    /** default constructor */
    public SuperUser() {
    }

    
    /** full constructor */
    public SuperUser(String superName, String superPass) {
        this.superName = superName;
        this.superPass = superPass;
    }

   
    // Property accessors

    public Integer getSuperId() {
        return this.superId;
    }
    
    public void setSuperId(Integer superId) {
        this.superId = superId;
    }

    public String getSuperName() {
        return this.superName;
    }
    
    public void setSuperName(String superName) {
        this.superName = superName;
    }

    public String getSuperPass() {
        return this.superPass;
    }
    
    public void setSuperPass(String superPass) {
        this.superPass = superPass;
    }
   








}