package cn.jk.pearl.service.Impl;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jk.pearl.dao.DataCollectionDao;
import cn.jk.pearl.dao.ParameterDao;
import cn.jk.pearl.dao.WarnMessageDao;
import cn.jk.pearl.pojo.DataCollection;
import cn.jk.pearl.pojo.Parameter;
import cn.jk.pearl.pojo.WarnMessage;
import cn.jk.pearl.service.DataCollectionService;
import cn.jk.pearl.util.SendMessageUtil;

@Service("dataCollectionService")
public class DataCollectionServiceImpl implements DataCollectionService{
	@Resource
	private DataCollectionDao dataCollectionDao;
	@Resource
	private ParameterDao parameterDao;
	@Resource
	private WarnMessageDao warnMeaageDao;
	@Resource
	private SendMessageUtil send;
    public void saveDataFromSensor(){
     List<Parameter> listParameter=parameterDao.queryAllParameter();
     for(Parameter p:listParameter){
    	 Float minfloat=p.getParameterMin();
    	 Float maxfloat=p.getParameterMax();
    	 if(minfloat!=null&&maxfloat!=null){
	    	 int min=(int) ((float)minfloat*1000);
	    	 int max=(int) ((float)maxfloat*1000);
	    	 Random random=new Random();
	    	 for(int i=0;i<4;i++){
	    	   int ranInt=random.nextInt(max-min+(max-min));
	    	   float r=(float)(min-(max-min)/2+ranInt);
	    	   float result=r/1000;
	    	   DataCollection data=new DataCollection();
	    	   java.util.Date utilDate=new java.util.Date();
	   		   java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
	   	       data.setDataCollectionDate(sqlDate);
	   	       data.setDataCollectionTime(new Time(utilDate.getTime()));
	   	       data.setDataCollectionIsCheck(0);
	   	       data.setDataCollectionResult(result);
	   	       data.setParameter(p);
	   	       dataCollectionDao.save(data);
	    	 }
    	 }
     }
     }
	public void checkData() {
		List<DataCollection> dataList=dataCollectionDao.queryNotCheckData();
		List<DataCollection> checkList=new ArrayList<DataCollection>();
		for(int i=0;i<dataList.size();i++){
			DataCollection data=dataList.get(i);
			Float result=data.getDataCollectionResult();
	    	Float min=data.getParameter().getParameterMin();
	    	Float max=data.getParameter().getParameterMax();
	    	String message="";
	       if(result<min){
	    	    message="目前养殖池"+data.getParameter().getParameterName()+"小于该参数设定的最小警戒值。";
	    		if(data.getParameter().getParameterMinharm()!=null&&data.getParameter().getParameterMinmeasure()!=null){
	    			message=message+"   危害："+data.getParameter().getParameterMinharm()+"    应采取的措施："+data.getParameter().getParameterMinmeasure();
	    		}
	    		
	    	}else if(result>max){
	    	    message="目前养殖池"+data.getParameter().getParameterName()+"大于该参数设定的最大警戒值。";
	    		if(data.getParameter().getParameterMaxharm()!=null&&data.getParameter().getParameterMaxmeasure()!=null){
	    			message=message+"   危害："+data.getParameter().getParameterMaxharm()+"    应采取的措施："+data.getParameter().getParameterMaxmeasure();
	    		}
	    	}
	       if(!message.equals("")){
	    	   System.out.println(data.getParameter().getFarmer().getFarmerPhone());
	    	   int code=send.sendMessage(data.getParameter().getFarmer().getFarmerPhone(),message);
	    	   if(code==1){
	    	     warnMeaageDao.save(new WarnMessage(message,data.getParameter().getFarmer()));
	    	     checkList.add(data);
	    	   }
	    	  }
	   	}
		dataCollectionDao.updateDataIsCheck(checkList);
	}
	
    
}
