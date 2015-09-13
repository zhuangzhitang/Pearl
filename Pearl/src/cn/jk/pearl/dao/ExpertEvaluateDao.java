package cn.jk.pearl.dao;

import cn.jk.pearl.pojo.ExpertEvaluate;

public interface ExpertEvaluateDao extends BaseDao<ExpertEvaluate>{
   public Double queryExpertEvaluateAvgScore(int expertId);
}
