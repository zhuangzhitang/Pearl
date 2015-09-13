package cn.jk.pearl.pojo;



/**
 * SymptomGroup entity. @author MyEclipse Persistence Tools
 */

public class SymptomGroup  implements java.io.Serializable {


    // Fields    

     private Integer symptomGroupId;
     private String symptomGroupName;


    // Constructors

    /** default constructor */
    public SymptomGroup() {
    }

    
    /** full constructor */
    public SymptomGroup(String symptomGroupName) {
        this.symptomGroupName = symptomGroupName;
    }

   
    // Property accessors

    public Integer getSymptomGroupId() {
        return this.symptomGroupId;
    }
    
    public void setSymptomGroupId(Integer symptomGroupId) {
        this.symptomGroupId = symptomGroupId;
    }

    public String getSymptomGroupName() {
        return this.symptomGroupName;
    }
    
    public void setSymptomGroupName(String symptomGroupName) {
        this.symptomGroupName = symptomGroupName;
    }
   








}