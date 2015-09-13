package cn.jk.pearl.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jk.pearl.dao.PhotoDao;
import cn.jk.pearl.pojo.Photo;
import cn.jk.pearl.pojo.PhotoGallery;
import cn.jk.pearl.service.PhotoService;

/**
 * 
 * @author zaopeng
 * 图片管理的service实现类
 *
 */
@Service("photoService")
public class PhotoServiceImpl implements PhotoService{
	@Resource
    private PhotoDao photoDao;
	//获取每一个图片集的首张图片。（包括图片集的名字）
	public List<Photo> getFirstPhoto(){
		return photoDao.getFirstPhoto();
	}
    //获取某一个图片集的所有的图片的集合
	public List<Photo> getAllPhoto(int photoGalleryId) {
		return photoDao.getAllPhoto(photoGalleryId);
	}
    //创建一个新的图片集
	public void saveNewPhotoGallery(PhotoGallery photoGallery) {
	      photoDao.saveNewPhotoGallery(photoGallery);
	}
    /**
     * 把把某一张图片加入到某一个图片集中去
     * fileName--图片的名字（路径）
     */
	public void saveNewPhotoToGallery(String fileName, Photo photo) {
		photo.setPhotoPath(fileName);
		photoDao.save(photo);
	}
    //删除某个图片集的所有图片
	public void deleteAllPhoto(int photoGalleryId) {
	   photoDao.deleteAllPhoto(photoGalleryId);
	}
   /**
    * 删除某个图片集的某一张图片。
    * photoGalleryId---表示图片集的id值
    * index---表示该图片集的第几张图片
    */
	public void deleteOnePhoto(int photoGalleryId, int index) {
		photoDao.deleteOnePhoto(photoGalleryId, index);
	}
   //获取所有的图片集，获取的信息包括图片集的名字，图片集的图片数
	public List<PhotoGallery> getAllPhotoGallery(int pageSize,int pageNum) {
		return photoDao.getAllPhotoGallery(pageSize,pageNum);
	}
    public long getAllPhotoGalleryPageNum(long pageSize){
    	return photoDao.getAllPhotoGalleryPageNum(pageSize);
    	
    }
}
