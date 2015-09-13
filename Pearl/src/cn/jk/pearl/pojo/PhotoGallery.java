package cn.jk.pearl.pojo;



/**
 * PhotoGallery entity. @author MyEclipse Persistence Tools
 */

public class PhotoGallery  implements java.io.Serializable {


    // Fields    
	 private static final long serialVersionUID = 1L;
	 private Integer photogalleryId;
     private String photogalleryName;
     private long photoNum;

    // Constructors

    /** default constructor */
    public PhotoGallery() {
    }

    
    /** full constructor */
    public PhotoGallery(String photogalleryName) {
        this.photogalleryName = photogalleryName;
    }

   
    // Property accessors

    public Integer getPhotogalleryId() {
        return this.photogalleryId;
    }
    
    public void setPhotogalleryId(Integer photogalleryId) {
        this.photogalleryId = photogalleryId;
    }

    public String getPhotogalleryName() {
        return this.photogalleryName;
    }
    
    public void setPhotogalleryName(String photogalleryName) {
        this.photogalleryName = photogalleryName;
    }


	public long getPhotoNum() {
		return photoNum;
	}


	public void setPhotoNum(long photoNum) {
		this.photoNum = photoNum;
	}
   








}