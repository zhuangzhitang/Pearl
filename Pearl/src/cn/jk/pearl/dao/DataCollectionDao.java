package cn.jk.pearl.dao;

import java.util.List;

import cn.jk.pearl.pojo.DataCollection;

public interface DataCollectionDao extends BaseDao<DataCollection>{
	public List<DataCollection> queryNotCheckData();
	public void updateDataIsCheck(List<DataCollection> listData);
	public void deleteAllData(Integer parameterID);
}
