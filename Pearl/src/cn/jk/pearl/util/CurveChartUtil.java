package cn.jk.pearl.util;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.TimeSeriesDataItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.jfree.ui.RectangleInsets;

import cn.jk.pearl.pojo.DataCollection;
import cn.jk.pearl.pojo.Parameter;

@Component("curveChartUtil")
public class CurveChartUtil {
	@Value("#{public.basePath}#{public.FilePath}")
    private String fileUploadPath;
    @SuppressWarnings("deprecation")
	public  List<String> createCurveChart1(List<Parameter> list,Date date) throws IOException{
  	  List<String> listString=new ArrayList<String>();
  	  Font font=new Font("微软雅黑",Font.BOLD,18);
  	  for(Parameter p:list){
  	   String title="当天的"+p.getParameterName()+"变化图";
  	   String x="时间点";
  	   String y="参数的数值";
  	   TimeSeries chinaTs = new TimeSeries(p.getParameterName());
       Map<Time,Float> ht = new LinkedHashMap<Time,Float>();
       for(DataCollection data:p.getDataCollectionSet()){
  	     ht.put(data.getDataCollectionTime(),data.getDataCollectionResult());
       }
       for (Time time:ht.keySet()) {
         chinaTs.add(new TimeSeriesDataItem(new Minute(time),ht.get(time)));            
       }
      TimeSeriesCollection dataset = new TimeSeriesCollection();
      dataset.addSeries(chinaTs);
       //由ChartFactory  产生 JFreeChart 对象 
      JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(title,x,
              y, dataset, true, true, false);
      jfreechart.getTitle().setFont(font);
      XYPlot categoryplot = jfreechart.getXYPlot();
      ValueAxis domainAxis = categoryplot.getDomainAxis(); 
      ValueAxis numberaxis=categoryplot.getRangeAxis();
      /*------设置X轴坐标上的文字-----------*/ 
      domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
      /*------设置X轴的标题文字------------*/ 
      domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12)); 
      /*------设置Y轴坐标上的文字-----------*/ 
      numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
      /*------设置Y轴的标题文字------------*/
      numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 12)); 
      /*------这句代码解决了底部汉字乱码的问题-----------*/ 
      jfreechart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));
      jfreechart.setBackgroundPaint(Color.white);
      categoryplot.setBackgroundPaint(Color.lightGray); //设定图表数据显示部分背景色
      categoryplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D)); //设定坐标轴与图表数据显示部分距离
      categoryplot.setDomainGridlinePaint(Color.white); //网格线颜色
      categoryplot.setRangeGridlinePaint(Color.white); 
      XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer)categoryplot.getRenderer();
      xylineandshaperenderer.setShapesVisible(true); //数据点可见 
      xylineandshaperenderer.setShapesFilled(true); //数据点被填充即不是空心点
      NumberAxis numberaxis1 = (NumberAxis)categoryplot.getRangeAxis();
      numberaxis1.setStandardTickUnits(NumberAxis.createIntegerTickUnits());                   
      FileOutputStream fos_jpg = null; 
      SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
      String imageName=p.getParameterName()+".jpg";
      try{ 
  	   File file=new File(fileUploadPath+"/chart/"+format.format(date)+"/"+p.getFarmer().getFarmerId()+"/");
  	   if(!file.exists()){
  		   file.mkdirs();
  	   }
         fos_jpg = new FileOutputStream(new File(file,imageName)); 
         ChartUtilities.writeChartAsJPEG(fos_jpg,(float)0.8,jfreechart,400,300,null); 
         listString.add(format.format(date)+"/"+p.getFarmer().getFarmerId()+"/"+imageName);
       } finally{ 
         try{ 
             fos_jpg.close(); 
         } catch (Exception e) {} 
     } 
  	  }
  	     	return listString;
     }
  
}
