package cn.jk.pearl.pojo;



/**
 * SystemMessage entity. @author MyEclipse Persistence Tools
 */

public class SystemMessage  implements java.io.Serializable {


    // Fields  
	private static final long serialVersionUID = 1L;
	private Integer systemMessageId;
     private String systemMessageContent;
     private User user;
 


    // Constructors

    /** default constructor */
    public SystemMessage() {
    }

    
    /** full constructor */
    public SystemMessage(String systemMessageContent,User user) {
        this.systemMessageContent = systemMessageContent;
        this.setUser(user);
    }

   
    // Property accessors

    public Integer getSystemMessageId() {
        return this.systemMessageId;
    }
    
    public void setSystemMessageId(Integer systemMessageId) {
        this.systemMessageId = systemMessageId;
    }

    public String getSystemMessageContent() {
        return this.systemMessageContent;
    }
    
    public void setSystemMessageContent(String systemMessageContent) {
        this.systemMessageContent = systemMessageContent;
    }

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
   








}