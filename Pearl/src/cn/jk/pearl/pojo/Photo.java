package cn.jk.pearl.pojo;

/**
 * Photo entity. @author MyEclipse Persistence Tools
 */

public class Photo implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer photoId;
	private String photoPath;
	private PhotoGallery photoGallery;

	// Constructors

	/** default constructor */
	public Photo() {
	}

	/** full constructor */
	public Photo(String photoPath, PhotoGallery photoGallery) {
		this.photoPath = photoPath;
		this.setPhotoGallery(photoGallery);
	}

	// Property accessors

	public Integer getPhotoId() {
		return this.photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public String getPhotoPath() {
		return this.photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public PhotoGallery getPhotoGallery() {
		return photoGallery;
	}

	public void setPhotoGallery(PhotoGallery photoGallery) {
		this.photoGallery = photoGallery;
	}

}