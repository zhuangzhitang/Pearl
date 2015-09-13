package cn.jk.pearl.pojo;



/**
 * Movie entity. @author MyEclipse Persistence Tools
 */

public class Movie  implements java.io.Serializable {


    // Fields    

     private Integer movieId;
     private String movieTitle;
     private String movieResoure;
     private String moviePicturepath;
     private String movieSize;
     private String moviePath;
     private Integer moviePlaynumber;


    // Constructors

    /** default constructor */
    public Movie() {
    }

    
    /** full constructor */
    public Movie(String movieTitle, String movieResoure, String moviePicturepath, String movieSize, String moviePath, Integer moviePlaynumber) {
        this.movieTitle = movieTitle;
        this.movieResoure = movieResoure;
        this.moviePicturepath = moviePicturepath;
        this.movieSize = movieSize;
        this.moviePath = moviePath;
        this.moviePlaynumber = moviePlaynumber;
    }

   
    // Property accessors

    public Integer getMovieId() {
        return this.movieId;
    }
    
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return this.movieTitle;
    }
    
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieResoure() {
        return this.movieResoure;
    }
    
    public void setMovieResoure(String movieResoure) {
        this.movieResoure = movieResoure;
    }

    public String getMoviePicturepath() {
        return this.moviePicturepath;
    }
    
    public void setMoviePicturepath(String moviePicturepath) {
        this.moviePicturepath = moviePicturepath;
    }

    public String getMovieSize() {
        return this.movieSize;
    }
    
    public void setMovieSize(String movieSize) {
        this.movieSize = movieSize;
    }

    public String getMoviePath() {
        return this.moviePath;
    }
    
    public void setMoviePath(String moviePath) {
        this.moviePath = moviePath;
    }

    public Integer getMoviePlaynumber() {
        return this.moviePlaynumber;
    }
    
    public void setMoviePlaynumber(Integer moviePlaynumber) {
        this.moviePlaynumber = moviePlaynumber;
    }
   








}