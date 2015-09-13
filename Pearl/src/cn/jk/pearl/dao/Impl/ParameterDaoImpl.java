package cn.jk.pearl.dao.Impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import cn.jk.pearl.dao.ParameterDao;
import cn.jk.pearl.pojo.Farmer;
import cn.jk.pearl.pojo.Parameter;

@Repository("parameterDao")
@SuppressWarnings("unchecked")
public class ParameterDaoImpl extends BaseDaoImpl<Parameter> implements ParameterDao{

	
	public List<Parameter> queryAllParameterMessage(Integer farmerId) {
		String alias="p";
		DetachedCriteria dc = DetachedCriteria.forClass(Parameter.class,alias);  
		ProjectionList pList = Projections.projectionList();  
		pList.add(Projections.property("p.parameterId").as("parameterId"));  
		pList.add(Projections.property("p.parameterName").as("parameterName"));  
		pList.add(Projections.property("p.parameterMin").as("parameterMin"));  
		pList.add(Projections.property("p.parameterMax").as("parameterMax"));  
		dc.setProjection(pList);  
		dc.setResultTransformer(Transformers.aliasToBean(Parameter.class)); 
	    dc.createCriteria("farmer").add(Restrictions.eq("farmerId",farmerId));
		return dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
	}
   
	public void updateParameter(List<Parameter> parameterList){
		for(Parameter p:parameterList){
			if(p.getParameterMin()!=null){
				String hql="update Parameter p set p.parameterMin=:min where p.parameterId=:id";
				sessionFactory.getCurrentSession().createQuery(hql).setFloat("min",p.getParameterMin()).setInteger("id",p.getParameterId()).executeUpdate();
			}
			if(p.getParameterMax()!=null){
				String hql="update Parameter p set p.parameterMax=:max where p.parameterId=:id";
				sessionFactory.getCurrentSession().createQuery(hql).setFloat("max",p.getParameterMax()).setInteger("id",p.getParameterId()).executeUpdate();
			}
		}
	}
	public void savePersonalParameter(Farmer farmer){
		   Criteria cri=sessionFactory.getCurrentSession().createCriteria(Parameter.class);
		   cri.createCriteria("farmer").add(Restrictions.eq("farmerId",1));
		   List<Parameter> listP=cri.list();
		   System.out.println(listP.size());
		   for(Parameter p:listP){
			  Parameter newp=new Parameter(p.getParameterName(),p.getParameterMin(), p.getParameterMax(), p.getParameterMinharm(),p.getParameterMinmeasure(),p.getParameterMaxharm(),p.getParameterMaxmeasure(), farmer);
			  this.save(newp);
		  }
   }

	public List<Parameter> queryAllDataByDate(Date date, int farmerId) {
		Criteria cri=sessionFactory.getCurrentSession().createCriteria(Parameter.class,"p");
		cri.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).createCriteria("p.dataCollectionSet").add(Restrictions.eq("dataCollectionDate",date))
		   .createCriteria("p.farmer").add(Restrictions.eq("farmerId",farmerId));
		return cri.list();
	}
	
	public List<Parameter> queryAllParameter(){
		Criteria cri=sessionFactory.getCurrentSession().createCriteria(Parameter.class);
		return cri.createCriteria("farmer").add(Restrictions.gt("farmerId",1)).list();
	}
}
