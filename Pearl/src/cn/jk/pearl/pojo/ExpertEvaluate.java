package cn.jk.pearl.pojo;



/**
 * ExpertEvaluate entity. @author MyEclipse Persistence Tools
 */

public class ExpertEvaluate  implements java.io.Serializable {


    // Fields    

     private Integer expertEvaluateId;
     private Integer expertEvaluateExpertid;
     private Integer expertEvaluatePoint;


    // Constructors

    /** default constructor */
    public ExpertEvaluate() {
    }

    
    /** full constructor */
    public ExpertEvaluate(Integer expertEvaluateExpertid, Integer expertEvaluatePoint) {
        this.expertEvaluateExpertid = expertEvaluateExpertid;
        this.expertEvaluatePoint = expertEvaluatePoint;
    }

   
    // Property accessors

    public Integer getExpertEvaluateId() {
        return this.expertEvaluateId;
    }
    
    public void setExpertEvaluateId(Integer expertEvaluateId) {
        this.expertEvaluateId = expertEvaluateId;
    }

    public Integer getExpertEvaluateExpertid() {
        return this.expertEvaluateExpertid;
    }
    
    public void setExpertEvaluateExpertid(Integer expertEvaluateExpertid) {
        this.expertEvaluateExpertid = expertEvaluateExpertid;
    }

    public Integer getExpertEvaluatePoint() {
        return this.expertEvaluatePoint;
    }
    
    public void setExpertEvaluatePoint(Integer expertEvaluatePoint) {
        this.expertEvaluatePoint = expertEvaluatePoint;
    }
   








}