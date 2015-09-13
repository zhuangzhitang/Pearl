package cn.jk.pearl.pojo;

import java.sql.Time;
import java.util.Date;

/**
 * DataCollection entity. @author MyEclipse Persistence Tools
 */

public class DataCollection implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer dataCollectionId;
	private Date dataCollectionDate;
	private Time dataCollectionTime;
	private Float dataCollectionResult;
	private Parameter parameter;
    private Integer dataCollectionIsCheck;
	// Constructors

	/** default constructor */
	public DataCollection() {
	}

	/** full constructor */
	public DataCollection(Date dataCollectionDate, Time dataCollectionTime,
			Float dataCollectionResult,Parameter parameter,Integer dataCollectionIsCheck) {
		this.dataCollectionDate = dataCollectionDate;
		this.dataCollectionTime = dataCollectionTime;
		this.dataCollectionResult = dataCollectionResult;
	    this.setParameter(parameter);
	    this.setDataCollectionIsCheck(dataCollectionIsCheck);
	}

	// Property accessors

	public Integer getDataCollectionId() {
		return this.dataCollectionId;
	}

	public void setDataCollectionId(Integer dataCollectionId) {
		this.dataCollectionId = dataCollectionId;
	}

	public Date getDataCollectionDate() {
		return this.dataCollectionDate;
	}

	public void setDataCollectionDate(Date dataCollectionDate) {
		this.dataCollectionDate = dataCollectionDate;
	}

	public Time getDataCollectionTime() {
		return this.dataCollectionTime;
	}

	public void setDataCollectionTime(Time dataCollectionTime) {
		this.dataCollectionTime = dataCollectionTime;
	}

	public Float getDataCollectionResult() {
		return this.dataCollectionResult;
	}

	public void setDataCollectionResult(Float dataCollectionResult) {
		this.dataCollectionResult = dataCollectionResult;
	}

	public Parameter getParameter() {
		return parameter;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}

	public Integer getDataCollectionIsCheck() {
		return dataCollectionIsCheck;
	}

	public void setDataCollectionIsCheck(Integer dataCollectionIsCheck) {
		this.dataCollectionIsCheck = dataCollectionIsCheck;
	}

	

}