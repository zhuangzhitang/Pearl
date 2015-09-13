package cn.jk.pearl.pojo;



/**
 * SymptomPower entity. @author MyEclipse Persistence Tools
 */

public class SymptomPower  implements java.io.Serializable,Comparable<SymptomPower> {


    // Fields    

     private Integer symptompowerId;
     private Integer symptomId;
     private Integer diseaseId;
     private Integer symptompower;


    // Constructors

    /** default constructor */
    public SymptomPower() {
    }

    
    /** full constructor */
    public SymptomPower(Integer symptomId, Integer diseaseId, Integer symptompower) {
        this.symptomId = symptomId;
        this.diseaseId = diseaseId;
        this.symptompower = symptompower;
    }

   
    // Property accessors

    public Integer getSymptompowerId() {
        return this.symptompowerId;
    }
    
    public void setSymptompowerId(Integer symptompowerId) {
        this.symptompowerId = symptompowerId;
    }

    public Integer getSymptomId() {
        return this.symptomId;
    }
    
    public void setSymptomId(Integer symptomId) {
        this.symptomId = symptomId;
    }

    public Integer getDiseaseId() {
        return this.diseaseId;
    }
    
    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public Integer getSymptompower() {
        return this.symptompower;
    }
    
    public void setSymptompower(Integer symptompower) {
        this.symptompower = symptompower;
    }


	public int compareTo(SymptomPower symptomPower) {
		
		return symptomPower.getSymptompower().compareTo(this.getSymptompower());
	}

}