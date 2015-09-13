package cn.jk.pearl.dao;

import java.util.List;

import cn.jk.pearl.pojo.Movie;
/**
 * 对movie表的操作
 * @author ZheTang
 * @date 2014-12-9
 *
 */
public interface MovieDao extends BaseDao<Movie>{
	public List<Movie> topMovies(int topCount);//获得前几条的视频
	public void updateReadCount(int movie_id, int whatchcount);//更改播放数
	//public long getMovieCount();//获得视频的总数
}
