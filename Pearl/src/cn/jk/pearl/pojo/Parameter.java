package cn.jk.pearl.pojo;

import java.util.Set;



/**
 * Parameter entity. @author MyEclipse Persistence Tools
 */

public class Parameter  implements java.io.Serializable {


    // Fields  
	private static final long serialVersionUID = 1L;
	private Integer parameterId;
     private String parameterName;
     private Float parameterMin;
     private Float parameterMax;
     private String parameterMinharm;
     private String parameterMinmeasure;
     private String parameterMaxharm;
     private String parameterMaxmeasure;
     private Farmer farmer;
     private Set<DataCollection> dataCollectionSet;

    // Constructors

    /** default constructor */
    public Parameter() {
    }
    public Parameter(String parameterName,Float parameterMin,Float parameterMax,Farmer farmer){
    	this.parameterName=parameterName;
    	this.parameterMin=parameterMin;
    	this.parameterMax=parameterMax;
    	this.farmer=farmer;
    }
    /** full constructor */
    public Parameter(String parameterName, Float parameterMin, Float parameterMax, String parameterMinharm, String parameterMinmeasure, String parameterMaxharm, String parameterMaxmeasure,Farmer farmer) {
        this.parameterName = parameterName;
        this.parameterMin = parameterMin;
        this.parameterMax = parameterMax;
        this.parameterMinharm = parameterMinharm;
        this.parameterMinmeasure = parameterMinmeasure;
        this.parameterMaxharm = parameterMaxharm;
        this.parameterMaxmeasure = parameterMaxmeasure;
        this.setFarmer(farmer);
    }

   
    // Property accessors

    public Integer getParameterId() {
        return this.parameterId;
    }
    
    public void setParameterId(Integer parameterId) {
        this.parameterId = parameterId;
    }

    public String getParameterName() {
        return this.parameterName;
    }
    
    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public Float getParameterMin() {
        return this.parameterMin;
    }
    
    public void setParameterMin(Float parameterMin) {
        this.parameterMin = parameterMin;
    }

    public Float getParameterMax() {
        return this.parameterMax;
    }
    
    public void setParameterMax(Float parameterMax) {
        this.parameterMax = parameterMax;
    }

    public String getParameterMinharm() {
        return this.parameterMinharm;
    }
    
    public void setParameterMinharm(String parameterMinharm) {
        this.parameterMinharm = parameterMinharm;
    }

    public String getParameterMinmeasure() {
        return this.parameterMinmeasure;
    }
    
    public void setParameterMinmeasure(String parameterMinmeasure) {
        this.parameterMinmeasure = parameterMinmeasure;
    }

    public String getParameterMaxharm() {
        return this.parameterMaxharm;
    }
    
    public void setParameterMaxharm(String parameterMaxharm) {
        this.parameterMaxharm = parameterMaxharm;
    }

    public String getParameterMaxmeasure() {
        return this.parameterMaxmeasure;
    }
    
    public void setParameterMaxmeasure(String parameterMaxmeasure) {
        this.parameterMaxmeasure = parameterMaxmeasure;
    }


	public Farmer getFarmer() {
		return farmer;
	}


	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
	public Set<DataCollection> getDataCollectionSet() {
		return dataCollectionSet;
	}
	public void setDataCollectionSet(Set<DataCollection> dataCollectionSet) {
		this.dataCollectionSet = dataCollectionSet;
	}
   








}