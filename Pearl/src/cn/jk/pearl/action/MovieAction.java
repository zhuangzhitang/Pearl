package cn.jk.pearl.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import cn.jk.pearl.dao.MovieDao;
import cn.jk.pearl.pojo.Movie;

@Controller
public class MovieAction extends  BaseAction<Movie>{
	private Integer pageNow;
	public void setPageNum(Integer pageNow) {
		this.pageNow = pageNow;
	}
	@Resource
	MovieDao movieDao;
	public String showMovie(){
		List<Movie> movies=movieDao.getContentByPage(3, 1);
		requestMap.put("movies", movies);
		requestMap.put("pageNow", pageNow);
		return "showMovie";
	}
}
