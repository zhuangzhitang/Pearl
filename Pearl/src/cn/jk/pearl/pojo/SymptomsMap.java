package cn.jk.pearl.pojo;



/**
 * SymptomsMap entity. @author MyEclipse Persistence Tools
 */

public class SymptomsMap  implements java.io.Serializable {


    // Fields    

     private Integer symptomsMapId;
     private String symptomsMapTitle;
     private String symptomsMapPicture;
     private Integer diseaseId;


    // Constructors

    /** default constructor */
    public SymptomsMap() {
    }

    
    /** full constructor */
    public SymptomsMap(String symptomsMapTitle, String symptomsMapPicture, Integer diseaseId) {
        this.symptomsMapTitle = symptomsMapTitle;
        this.symptomsMapPicture = symptomsMapPicture;
        this.diseaseId = diseaseId;
    }

   
    // Property accessors

    public Integer getSymptomsMapId() {
        return this.symptomsMapId;
    }
    
    public void setSymptomsMapId(Integer symptomsMapId) {
        this.symptomsMapId = symptomsMapId;
    }

    public String getSymptomsMapTitle() {
        return this.symptomsMapTitle;
    }
    
    public void setSymptomsMapTitle(String symptomsMapTitle) {
        this.symptomsMapTitle = symptomsMapTitle;
    }

    public String getSymptomsMapPicture() {
        return this.symptomsMapPicture;
    }
    
    public void setSymptomsMapPicture(String symptomsMapPicture) {
        this.symptomsMapPicture = symptomsMapPicture;
    }

    public Integer getDiseaseId() {
        return this.diseaseId;
    }
    
    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }
   








}