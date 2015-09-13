package cn.jk.pearl.service.Impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.jk.pearl.dao.DataCollectionDao;
import cn.jk.pearl.dao.ParameterDao;
import cn.jk.pearl.pojo.Parameter;
import cn.jk.pearl.service.ParameterService;
import cn.jk.pearl.util.CurveChartUtil;

@Service("parameterService")
public class ParameterServiceImpl implements ParameterService{
    @Resource
	private ParameterDao parameterDao;
    @Resource
    private DataCollectionDao dataDao;
    @Resource
    private CurveChartUtil cureChart;
    @Value("#{public.basePath}#{public.FilePath}")
    private String fileUploadPath;
	public List<Parameter> queryAllParameterMessage(int farmerId) {
		return parameterDao.queryAllParameterMessage(farmerId);
	}

	public void updateParameter(List<Parameter> parameters) {
		if(parameters.size()!=0){
			parameterDao.updateParameter(parameters);
		}
	}
	
	public void insertParmeter(Parameter parameter) {
		parameterDao.save(parameter);
	}

	public void deleteParmeter(List<Parameter> parameters){
		for(Parameter p:parameters){
			dataDao.deleteAllData(p.getParameterId());
			parameterDao.delete(p.getParameterId());
			
		}
	}
	public List<String> getCurveChart(Date date,int farmerId){
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		String dateString=format.format(date);
		String path=fileUploadPath+"/chart/"+dateString+"/"+farmerId+"/";
		File file=new File(path);
		if(file.exists()){
			List<String> list=new ArrayList<String>();
			for(String s:file.list()){
				list.add(dateString+"/"+farmerId+"/"+s);
				//listString.add(format.format(date)+"/"+p.getFarmer().getFarmerId()+"/"+imageName);
			}
			return list;
		}else{
			  List<Parameter> dataList=parameterDao.queryAllDataByDate(date, farmerId);
			  try {
				return cureChart.createCurveChart1(dataList, date);
			  } catch (IOException e) {
				 e.printStackTrace();
				 throw new RuntimeException(e);
			  }
		}	
	}
}
