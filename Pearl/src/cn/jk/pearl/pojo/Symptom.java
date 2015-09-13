package cn.jk.pearl.pojo;



/**
 * Symptom entity. @author MyEclipse Persistence Tools
 */

public class Symptom  implements java.io.Serializable {


    // Fields    

     private Integer symptomId;
     private String symptomName;
     private String symptomPhoto;
     private SymptomGroup symptomGroup;


    // Constructors

    /** default constructor */
    public Symptom() {
    }

    // Property accessors

    public Integer getSymptomId() {
        return this.symptomId;
    }
    
    public void setSymptomId(Integer symptomId) {
        this.symptomId = symptomId;
    }

    public String getSymptomName() {
        return this.symptomName;
    }
    
    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    public String getSymptomPhoto() {
        return this.symptomPhoto;
    }
    
    public void setSymptomPhoto(String symptomPhoto) {
        this.symptomPhoto = symptomPhoto;
    }

	public SymptomGroup getSymptomGroup() {
		return symptomGroup;
	}

	public void setSymptomGroup(SymptomGroup symptomGroup) {
		this.symptomGroup = symptomGroup;
	}

}