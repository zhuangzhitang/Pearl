package cn.jk.pearl.pojo;



/**
 * PostCollected entity. @author MyEclipse Persistence Tools
 */

public class PostCollected  implements java.io.Serializable {


    // Fields  
	private static final long serialVersionUID = 1L;
	private Integer postCollectedId;
     private Integer postCollectedPostid;
     private Integer userid;


    // Constructors

    /** default constructor */
    public PostCollected() {
    }

    
    /** full constructor */
    public PostCollected(Integer postCollectedPostid, Integer userid) {
        this.postCollectedPostid = postCollectedPostid;
        this.userid = userid;
    }

   
    // Property accessors

    public Integer getPostCollectedId() {
        return this.postCollectedId;
    }
    
    public void setPostCollectedId(Integer postCollectedId) {
        this.postCollectedId = postCollectedId;
    }

    public Integer getPostCollectedPostid() {
        return this.postCollectedPostid;
    }
    
    public void setPostCollectedPostid(Integer postCollectedPostid) {
        this.postCollectedPostid = postCollectedPostid;
    }

    public Integer getUserid() {
        return this.userid;
    }
    
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
   








}