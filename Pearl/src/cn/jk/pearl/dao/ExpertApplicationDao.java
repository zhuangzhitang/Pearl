package cn.jk.pearl.dao;

import java.util.List;

import cn.jk.pearl.pojo.ExpertApplication;

public interface ExpertApplicationDao extends BaseDao<ExpertApplication>{
    public void deleteExpertApplicationTiming();
    public boolean isApplicateExpert(Integer userId);
    public List<ExpertApplication> queryAllExpertMessage();
    public ExpertApplication queryExpertApplication(int expertApplicationId);
    public void updateExpertApplicationIsHandle(int expertApplicationId);
}
