package cn.jk.pearl.dao;

import java.util.Date;
import java.util.List;

import cn.jk.pearl.pojo.Farmer;
import cn.jk.pearl.pojo.Parameter;

public interface ParameterDao extends BaseDao<Parameter>{
   public List<Parameter> queryAllParameterMessage(Integer farmerId);
   public void savePersonalParameter(Farmer farmer);
   public void updateParameter(List<Parameter> parameterList);
   public List<Parameter> queryAllDataByDate(Date date,int farmerId);
   public List<Parameter> queryAllParameter();
}
