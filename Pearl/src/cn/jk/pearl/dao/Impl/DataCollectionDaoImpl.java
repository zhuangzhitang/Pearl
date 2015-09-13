package cn.jk.pearl.dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import cn.jk.pearl.dao.DataCollectionDao;
import cn.jk.pearl.pojo.DataCollection;

@Repository("dataCollectionDao")
@SuppressWarnings("unchecked")
public class DataCollectionDaoImpl extends BaseDaoImpl<DataCollection> implements DataCollectionDao{
	
	public List<DataCollection> queryNotCheckData(){
		Criteria cri=sessionFactory.getCurrentSession().createCriteria(DataCollection.class);
		cri.add(Restrictions.eq("dataCollectionIsCheck",0)).setFetchMode("parameter",FetchMode.JOIN);
		return cri.list();
	}
	public void updateDataIsCheck(List<DataCollection> listData){
		for(DataCollection data:listData){
			data.setDataCollectionIsCheck(1);
			this.update(data);
		}
	}
	public void deleteAllData(Integer parameterID){
		String hql="delete DataCollection d where d.parameter.parameterId=:id";
		sessionFactory.getCurrentSession().createQuery(hql).setInteger("id",parameterID).executeUpdate();
	}
}
