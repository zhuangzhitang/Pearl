package cn.jk.pearl.pojo;

import java.util.Set;



/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// Fields    

     private Integer userId;
     private String userName;
     private String userPass;
     private String userEmail;
     private Integer userIsmanager;
     private String userLevel;
     private String userImagepath;
     private Integer userIsstopspeak;
     private Set<Post> collectPostSet;

    // Constructors

    /** default constructor */
    public User() {
    }

    
    /** full constructor */
    public User(String userName, String userPass, String userEmail, Integer userIsmanager, String userLevel, String userImagepath, Integer userIsstopspeak,Set<Post> collectPostSet) {
        this.userName = userName;
        this.userPass = userPass;
        this.userEmail = userEmail;
        this.userIsmanager = userIsmanager;
        this.userLevel = userLevel;
        this.userImagepath = userImagepath;
        this.userIsstopspeak = userIsstopspeak;
        this.setCollectPostSet(collectPostSet);
    }

   
    // Property accessors

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return this.userPass;
    }
    
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserEmail() {
        return this.userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserIsmanager() {
        return this.userIsmanager;
    }
    
    public void setUserIsmanager(Integer userIsmanager) {
        this.userIsmanager = userIsmanager;
    }

    public String getUserLevel() {
        return this.userLevel;
    }
    
    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserImagepath() {
        return this.userImagepath;
    }
    
    public void setUserImagepath(String userImagepath) {
        this.userImagepath = userImagepath;
    }

    public Integer getUserIsstopspeak() {
        return this.userIsstopspeak;
    }
    
    public void setUserIsstopspeak(Integer userIsstopspeak) {
        this.userIsstopspeak = userIsstopspeak;
    }


	public Set<Post> getCollectPostSet() {
		return collectPostSet;
	}


	public void setCollectPostSet(Set<Post> collectPostSet) {
		this.collectPostSet = collectPostSet;
	}
   








}