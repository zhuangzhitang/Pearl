package cn.jk.pearl.pojo;

import java.sql.Timestamp;


/**
 * FileComment entity. @author MyEclipse Persistence Tools
 */

public class FileComment  implements java.io.Serializable {


    // Fields    

     private Integer filecommentId;
     private String filecommentContent;
     private Integer filecommentStarcount;
     private Timestamp filecommentTime;
     /*private Integer userId;*/
    /* private Integer fileId;*/
     private User user;
     private FileDocument fileDocument;


    // Constructors

    /** default constructor */
    public FileComment() {
    }

    
 

   
    // Property accessors

    public Integer getFilecommentId() {
        return this.filecommentId;
    }
    
    public void setFilecommentId(Integer filecommentId) {
        this.filecommentId = filecommentId;
    }

    public String getFilecommentContent() {
        return this.filecommentContent;
    }
    
    public void setFilecommentContent(String filecommentContent) {
        this.filecommentContent = filecommentContent;
    }

    public Integer getFilecommentStarcount() {
        return this.filecommentStarcount;
    }
    
    public void setFilecommentStarcount(Integer filecommentStarcount) {
        this.filecommentStarcount = filecommentStarcount;
    }

    public Timestamp getFilecommentTime() {
        return this.filecommentTime;
    }
    
    public void setFilecommentTime(Timestamp filecommentTime) {
        this.filecommentTime = filecommentTime;
    }





	public User getUser() {
		return user;
	}





	public void setUser(User user) {
		this.user = user;
	}





	public FileDocument getFileDocument() {
		return fileDocument;
	}





	public void setFileDocument(FileDocument fileDocument) {
		this.fileDocument = fileDocument;
	}





	public FileComment(String filecommentContent, Integer filecommentStarcount,
			Timestamp filecommentTime) {
		super();
		this.filecommentContent = filecommentContent;
		this.filecommentStarcount = filecommentStarcount;
		this.filecommentTime = filecommentTime;
	}

}