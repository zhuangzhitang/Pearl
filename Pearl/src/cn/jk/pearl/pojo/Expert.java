package cn.jk.pearl.pojo;



/**
 * Expert entity. @author MyEclipse Persistence Tools
 */

public class Expert  implements java.io.Serializable {


    // Fields    
	 private static final long serialVersionUID = 1L;
	 private Integer expertId;
     private String expertName;
     private String expertSex;
     private String expertPhone;
     private String expertQq;
     private String expertJob;
     private String expertJobarea;
     private String expertJobpalace;
     private String expeertHonor;
     private User user;


    // Constructors

    /** default constructor */
    public Expert() {
    }

    
    /** full constructor */
    public Expert(String expertName, String expertSex, String expertPhone, String expertQq, String expertJob, String expertJobarea, String expertJobpalace, String expeertHonor,User user) {
        this.expertName = expertName;
        this.expertSex = expertSex;
        this.expertPhone = expertPhone;
        this.expertQq = expertQq;
        this.expertJob = expertJob;
        this.expertJobarea = expertJobarea;
        this.expertJobpalace = expertJobpalace;
        this.expeertHonor = expeertHonor;
        this.setUser(user);
    }

   
    // Property accessors

    public Integer getExpertId() {
        return this.expertId;
    }
    
    public void setExpertId(Integer expertId) {
        this.expertId = expertId;
    }

    public String getExpertName() {
        return this.expertName;
    }
    
    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }

    public String getExpertSex() {
        return this.expertSex;
    }
    
    public void setExpertSex(String expertSex) {
        this.expertSex = expertSex;
    }

    public String getExpertPhone() {
        return this.expertPhone;
    }
    
    public void setExpertPhone(String expertPhone) {
        this.expertPhone = expertPhone;
    }

    public String getExpertQq() {
        return this.expertQq;
    }
    
    public void setExpertQq(String expertQq) {
        this.expertQq = expertQq;
    }

    public String getExpertJob() {
        return this.expertJob;
    }
    
    public void setExpertJob(String expertJob) {
        this.expertJob = expertJob;
    }

    public String getExpertJobarea() {
        return this.expertJobarea;
    }
    
    public void setExpertJobarea(String expertJobarea) {
        this.expertJobarea = expertJobarea;
    }

    public String getExpertJobpalace() {
        return this.expertJobpalace;
    }
    
    public void setExpertJobpalace(String expertJobpalace) {
        this.expertJobpalace = expertJobpalace;
    }

    public String getExpeertHonor() {
        return this.expeertHonor;
    }
    
    public void setExpeertHonor(String expeertHonor) {
        this.expeertHonor = expeertHonor;
    }


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

    
   








}