package cn.jk.pearl.pojo;

import java.util.Set;



/**
 * Disease entity. @author MyEclipse Persistence Tools
 */

public class Disease  implements java.io.Serializable {


    // Fields    

     private Integer diseaseId;
     private String diseaseName;
     private String diseasePathogeny;
     private String diseaseSymptom;
     private String diseaseCure;
     private Integer diseaseState;
     private Set<Symptom> symptoms;

    // Constructors

    public Set<Symptom> getSymptoms() {
		return symptoms;
	}


	public void setSymptoms(Set<Symptom> symptoms) {
		this.symptoms = symptoms;
	}


	public Integer getDiseaseState() {
		return diseaseState;
	}


	public void setDiseaseState(Integer diseaseState) {
		this.diseaseState = diseaseState;
	}


	/** default constructor */
    public Disease() {
    }

    
    /** full constructor */
    public Disease(String diseaseName, String diseasePathogeny, String diseaseSymptom, String diseaseCure) {
        this.diseaseName = diseaseName;
        this.diseasePathogeny = diseasePathogeny;
        this.diseaseSymptom = diseaseSymptom;
        this.diseaseCure = diseaseCure;
    }

   
    // Property accessors

    public Integer getDiseaseId() {
        return this.diseaseId;
    }
    
    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getDiseaseName() {
        return this.diseaseName;
    }
    
    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseasePathogeny() {
        return this.diseasePathogeny;
    }
    
    public void setDiseasePathogeny(String diseasePathogeny) {
        this.diseasePathogeny = diseasePathogeny;
    }

    public String getDiseaseSymptom() {
        return this.diseaseSymptom;
    }
    
    public void setDiseaseSymptom(String diseaseSymptom) {
        this.diseaseSymptom = diseaseSymptom;
    }

    public String getDiseaseCure() {
        return this.diseaseCure;
    }
    
    public void setDiseaseCure(String diseaseCure) {
        this.diseaseCure = diseaseCure;
    }
   








}