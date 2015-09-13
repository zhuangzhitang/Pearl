package cn.jk.pearl.pojo;



/**
 * NewsCategory entity. @author MyEclipse Persistence Tools
 */

public class NewsCategory  implements java.io.Serializable {


    // Fields  
	private static final long serialVersionUID = 1L;
	private Integer newsCategoryId;
     private String newsCategoryName;


    // Constructors

    /** default constructor */
    public NewsCategory() {
    }

    
    /** full constructor */
    public NewsCategory(String newsCategoryName) {
        this.newsCategoryName = newsCategoryName;
    }

   
    // Property accessors

    public Integer getNewsCategoryId() {
        return this.newsCategoryId;
    }
    
    public void setNewsCategoryId(Integer newsCategoryId) {
        this.newsCategoryId = newsCategoryId;
    }

    public String getNewsCategoryName() {
        return this.newsCategoryName;
    }
    
    public void setNewsCategoryName(String newsCategoryName) {
        this.newsCategoryName = newsCategoryName;
    }
   








}