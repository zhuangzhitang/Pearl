package cn.jk.pearl.pojo;



/**
 * EmployInformation entity. @author MyEclipse Persistence Tools
 */

public class EmployInformation  implements java.io.Serializable {


    // Fields    

     private Integer employInformationId;
     private String employInformationContent;
     private Farmer farmer;


    // Constructors

    /** default constructor */
    public EmployInformation() {
    }

  
    // Property accessors

    public Integer getEmployInformationId() {
        return this.employInformationId;
    }
    
    public void setEmployInformationId(Integer employInformationId) {
        this.employInformationId = employInformationId;
    }

    public String getEmployInformationContent() {
        return this.employInformationContent;
    }
    
    public void setEmployInformationContent(String employInformationContent) {
        this.employInformationContent = employInformationContent;
    }


	public Farmer getFarmer() {
		return farmer;
	}


	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

}