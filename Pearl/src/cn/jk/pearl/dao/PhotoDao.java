package cn.jk.pearl.dao;

import java.util.List;

import cn.jk.pearl.pojo.Photo;
import cn.jk.pearl.pojo.PhotoGallery;

/**
 * 
 * @author zaopeng
 *
 */
public interface PhotoDao extends BaseDao<Photo>{
	 public List<Photo> getFirstPhoto(); 
	 public List<Photo> getAllPhoto(int photoGalleryId);
	 public void saveNewPhotoGallery(PhotoGallery photoGallery);
	 public long getPhotoGalleryNum(int photoGalleryId);
	 public void deleteAllPhoto(int photoGalleryId);
	 public void deleteOnePhoto(int photoGalleryId,int index);
	 public List<PhotoGallery> getAllPhotoGallery(int pageSize,int pageNum);
	 public long getAllPhotoGalleryPageNum(long pageSize);
}
