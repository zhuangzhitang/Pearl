package cn.jk.pearl.service;

import java.util.List;

import cn.jk.pearl.pojo.Photo;
import cn.jk.pearl.pojo.PhotoGallery;

public interface PhotoService {
   public List<Photo> getFirstPhoto();
   public List<Photo> getAllPhoto(int photoGalleryId);
   public List<PhotoGallery> getAllPhotoGallery(int pageSize,int pageNum);
   public void saveNewPhotoGallery(PhotoGallery photoGallery);
   public void saveNewPhotoToGallery(String fileName,Photo photo);
   public void deleteAllPhoto(int photoGalleryId);
   public void deleteOnePhoto(int photoGalleryId,int index);
   public long getAllPhotoGalleryPageNum(long pageSize);
}
