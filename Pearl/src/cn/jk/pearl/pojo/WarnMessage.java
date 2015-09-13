package cn.jk.pearl.pojo;



/**
 * WarnMessage entity. @author MyEclipse Persistence Tools
 */

public class WarnMessage implements java.io.Serializable {


    // Fields
	private static final long serialVersionUID = 1L;
	private Integer warnMessageId;
     private String warnMessageContent;
     private Farmer farmer;


    // Constructors

    /** default constructor */
    public WarnMessage() {
    }

    
    /** full constructor */
    public WarnMessage(String warnMessageContent,Farmer farmer) {
        this.warnMessageContent = warnMessageContent;
        this.setFarmer(farmer);
    }

   
    // Property accessors

    public Integer getWarnMessageId() {
        return this.warnMessageId;
    }
    
    public void setWarnMessageId(Integer warnMessageId) {
        this.warnMessageId = warnMessageId;
    }

    public String getWarnMessageContent() {
        return this.warnMessageContent;
    }
    
    public void setWarnMessageContent(String warnMessageContent) {
        this.warnMessageContent = warnMessageContent;
    }


	public Farmer getFarmer() {
		return farmer;
	}


	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

   
   








}