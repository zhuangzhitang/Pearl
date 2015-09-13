package cn.jk.pearl.pojo;



/**
 * FileDocument entity. @author MyEclipse Persistence Tools
 */

public class FileDocument  implements java.io.Serializable {


    // Fields    

     private Integer fileId;
     private String fileTitle;
     private String fileResource;
     private String fileSize;
     private String filePath;
     private Integer fileReadcount;
     private Integer fileDownloadcount;


    // Constructors

    /** default constructor */
    public FileDocument() {
    }

    
    /** full constructor */
    public FileDocument(String fileTitle, String fileResource, String fileSize, String filePath, Integer fileReadcount, Integer fileDownloadcount) {
        this.fileTitle = fileTitle;
        this.fileResource = fileResource;
        this.fileSize = fileSize;
        this.filePath = filePath;
        this.fileReadcount = fileReadcount;
        this.fileDownloadcount = fileDownloadcount;
    }

   
    // Property accessors

    public Integer getFileId() {
        return this.fileId;
    }
    
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileTitle() {
        return this.fileTitle;
    }
    
    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public String getFileResource() {
        return this.fileResource;
    }
    
    public void setFileResource(String fileResource) {
        this.fileResource = fileResource;
    }

    public String getFileSize() {
        return this.fileSize;
    }
    
    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePath() {
        return this.filePath;
    }
    
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getFileReadcount() {
        return this.fileReadcount;
    }
    
    public void setFileReadcount(Integer fileReadcount) {
        this.fileReadcount = fileReadcount;
    }

    public Integer getFileDownloadcount() {
        return this.fileDownloadcount;
    }
    
    public void setFileDownloadcount(Integer fileDownloadcount) {
        this.fileDownloadcount = fileDownloadcount;
    }
   








}