package cn.jk.pearl.service;

import java.util.Date;
import java.util.List;

import cn.jk.pearl.pojo.Parameter;

public interface ParameterService {
	/**
	 * 查询出某个养殖场的所有参数指标
	 * @param farmerId 养殖场的ID值
	 * @return
	 */
    public List<Parameter> queryAllParameterMessage(int farmerId);
    /**
     * 更新修改养殖场的参数指标，前台必须做一个是否改变的验证，只有改变了的参数才传入进行修改
     * @param parameters
     */
    public void updateParameter(List<Parameter> parameters);
    /**
     * 添加参数指标。
     * @param parameter
     */
    public void insertParmeter(Parameter parameter);
    /**
     * 删除参数指标
     * @param parameter
     */
    public void deleteParmeter(List<Parameter> parameter);
    /**
     * 根据传入的日期和养殖场ID值，生成折线图，并把折线图保存。
     * @param date 日期
     * @param farmerId 养殖场ID值
     * @return 折线图路径的集合
     */
    public List<String> getCurveChart(Date date,int farmerId);
}
