package cn.jk.pearl.service;

import java.util.List;

import cn.jk.pearl.pojo.Movie;
/*
 * 视频接口
 */
public interface MovieService {
	public List<Movie> topMovies(int topCount);//展示前几条热门视频，topCount:表示前几条
	public List<Movie> getMoviesByPage(int pageSize,int pageNow);//根据第几页返回该页的视频信息
	public long getPageCount(int pageSize);//获得视频信息展示的页面的总数
	public Movie getMovieById(int movieId);//根据视频Id获得该视频信息
	public void addMoviePlayNum(int movieId,int num);//添加视频播放数
	public void uploadMovie(Movie movie);//上传视频
	public void deleteMovieById(int movieId);//删除视频
	public void editMovie(Movie movie);//编辑视频信息
}
