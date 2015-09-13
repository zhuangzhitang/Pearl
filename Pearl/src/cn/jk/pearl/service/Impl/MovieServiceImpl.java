package cn.jk.pearl.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jk.pearl.dao.MovieDao;
import cn.jk.pearl.pojo.Movie;
import cn.jk.pearl.service.MovieService;
/**
 * 
 *  This is a description text 
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Service(value = "movieService")
public class MovieServiceImpl implements MovieService {
	
	@Resource
	private MovieDao movieDao;
	
	/*
	 *返回当前页面的视频消息
	 *@param pageSize:该页视频条数 
	 *@param pageNUm：当前的页数
	 *return 返回当前页数中的视频消息 
	 */
	public List<Movie> getMoviesByPage(int pageSize, int pageNUm) {
	
		return movieDao.getContentByPage(pageSize, pageNUm);
	}

	/*
	 * @param topCount :热门视频的前几条
	 * return ：返回热门视频信息
	 */
	public List<Movie> topMovies(int topCount) {
		
		return movieDao.topMovies(topCount);
	}
	
	/*
	 * @param pageSize :页面要显示的视频的数量
	 * return 总页数
	 */
	public long getPageCount(int pageSize) {
		long movieCount = movieDao.getCount();//视频总数
		long pageCount = 0; 
		System.out.println("movieCount"+movieCount);
		if(movieCount%pageSize==0){
			pageCount = movieCount/pageSize;
		}else{
			pageCount = movieCount/pageSize+1;
		}
		return pageCount;
	}
	
	/*
	 * param movieId : 视频Id
	 * return 返回视频Id对应的视频信息
	 */
	public Movie getMovieById(int movieId) {
		
		return movieDao.get(movieId);
	}
	
	/*
	 * 更改某一视频的播放数
	 * param movieId : 视频的Id
	 * param num： 变量
	 */
	public void addMoviePlayNum(int movieId,int num) {
		
		movieDao.updateReadCount(movieId, num);
	}
	
	/*
	 * 上传视频
	 * 
	 */
	public void uploadMovie(Movie movie) {
		
		movieDao.save(movie);
	}
	
	/*
	 * 删除视频
	 */
	public void deleteMovieById(int movieId) {
		
		movieDao.delete(movieId);
	}

	/*
	 * 编辑视频信息
	 */
	public void editMovie(Movie movie) {
		
		movieDao.update(movie);
	}

}
