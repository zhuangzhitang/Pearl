package cn.jk.pearl.pojo;

import java.sql.Timestamp;


/**
 * MovieComment entity. @author MyEclipse Persistence Tools
 */

public class MovieComment  implements java.io.Serializable {


    // Fields    

     private Integer moviecommentId;
     private String moviecommentContent;
     private Integer moviecommentStarcount;
     private Timestamp moviecommentTime;
     private User user;
     private Movie movie;


    // Constructors

    /** default constructor */
    public MovieComment() {
    }

    
  

   
    // Property accessors

    public Integer getMoviecommentId() {
        return this.moviecommentId;
    }
    
    public void setMoviecommentId(Integer moviecommentId) {
        this.moviecommentId = moviecommentId;
    }

    public String getMoviecommentContent() {
        return this.moviecommentContent;
    }
    
    public void setMoviecommentContent(String moviecommentContent) {
        this.moviecommentContent = moviecommentContent;
    }

    public Integer getMoviecommentStarcount() {
        return this.moviecommentStarcount;
    }
    
    public void setMoviecommentStarcount(Integer moviecommentStarcount) {
        this.moviecommentStarcount = moviecommentStarcount;
    }

    public Timestamp getMoviecommentTime() {
        return this.moviecommentTime;
    }
    
    public void setMoviecommentTime(Timestamp moviecommentTime) {
        this.moviecommentTime = moviecommentTime;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}