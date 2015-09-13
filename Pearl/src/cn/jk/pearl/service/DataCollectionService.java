package cn.jk.pearl.service;



public interface DataCollectionService {
	/**
	 * 模拟随机生成从传感器传送而来的数据
	 */
	public void saveDataFromSensor();
	/**
	 * 监测数据是否在正常范围以内，超出发送短信，并且把短信记录到数据库去
	 */
	public void checkData();
	
}
