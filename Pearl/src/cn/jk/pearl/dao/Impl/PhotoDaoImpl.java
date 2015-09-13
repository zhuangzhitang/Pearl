package cn.jk.pearl.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import cn.jk.pearl.dao.PhotoDao;
import cn.jk.pearl.pojo.Photo;
import cn.jk.pearl.pojo.PhotoGallery;

@SuppressWarnings("unchecked")
@Repository("photoDao")
/**
 * 
 * @author zaopeng
 *
 */
public class PhotoDaoImpl extends BaseDaoImpl<Photo> implements PhotoDao{

	public List<Photo> getFirstPhoto() {
		String idhql="from PhotoGallery";
		List<PhotoGallery> pgList=sessionFactory.getCurrentSession().createQuery(idhql).list();
		List<Photo> photoList=new ArrayList<Photo>();
		for(PhotoGallery pg:pgList){
	       String minsql="select min(p.photoId) from Photo p where p.photoGallery.photogalleryId=:pgid";
	       Integer id=(Integer)sessionFactory.getCurrentSession().createQuery(minsql).setInteger("pgid",pg.getPhotogalleryId()).uniqueResult();
	       if(id!=null){
			   String hql="from Photo p left join fetch p.photoGallery where "+
					   "p.photoId=:id";
			   photoList.add((Photo) sessionFactory.getCurrentSession().createQuery(hql)
					     .setInteger("id",id).uniqueResult());
	       }
		}
		return photoList;
	}

	public List<Photo> getAllPhoto(int photoGalleryId) {
		//默认升序
		String hql="from Photo p where p.photoGallery.photogalleryId=:id order by p.photoId";
		return sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",photoGalleryId).list();
	}

	public void saveNewPhotoGallery(PhotoGallery photoGallery) {
		sessionFactory.getCurrentSession().save(photoGallery);
	}

	public long getPhotoGalleryNum(int photoGalleryId) {
		String hql="select count(p.photoPath) from Photo p where p.photoGallery.photogalleryId=:id";
		long lang=(Long) sessionFactory.getCurrentSession().createQuery(hql)
				.setInteger("id",photoGalleryId).uniqueResult();
		   return lang;
	}

	public void deleteAllPhoto(int photoGalleryId) {
		String hql="delete from Photo p where p.photoGallery.photogalleryId=:id";
		sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",photoGalleryId).executeUpdate();
    }

	public void deleteOnePhoto(int photoGalleryId, int index){
		String hql="from Photo p where p.photoGallery.photogalleryId=:id order by p.photoId";
		List<Photo> list=sessionFactory.getCurrentSession().createQuery(hql)
		                                  .setInteger("id",photoGalleryId).list();
		sessionFactory.getCurrentSession().delete(list.get(index-1));                                
	}

	public List<PhotoGallery> getAllPhotoGallery(int pageSize,int pageNum) {
		String hql="from PhotoGallery pg";
		int firstmovie = (pageNum - 1) * pageSize;
		List<PhotoGallery> list=sessionFactory.getCurrentSession().createQuery(hql)
				                .setFirstResult(firstmovie).setMaxResults(pageSize).list();
		for(PhotoGallery pg:list){
			pg.setPhotoNum(this.getPhotoGalleryNum(pg.getPhotogalleryId()));
		}
		return list;
	}

	public long getAllPhotoGalleryPageNum(long pageSize) {
		String hql="select count(pg.photogalleryName) from PhotoGallery pg";
		Long countNum=(Long)sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		long pageNum=countNum/pageSize;
		if(countNum%pageSize!=0){
			pageNum=pageNum+1;
		}
		return pageNum;
	}

}
