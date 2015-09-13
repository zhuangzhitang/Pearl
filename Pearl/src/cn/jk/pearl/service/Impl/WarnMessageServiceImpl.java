package cn.jk.pearl.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jk.pearl.dao.WarnMessageDao;
import cn.jk.pearl.pojo.WarnMessage;
import cn.jk.pearl.service.WarnMessageService;

@Service("warnMessageService")
public class WarnMessageServiceImpl implements WarnMessageService{
	@Resource
    private WarnMessageDao warnMessageDao;
	public List<WarnMessage> queryAllWarnMessageByFarmerId(Integer farmerId) {
		return warnMessageDao.queryAllWarnMessageByFarmerId(farmerId);
	}

	public void deleteWarnMessage(int warnMessageId) {
	   warnMessageDao.deleteWarnMessage(warnMessageId);
	}
   
}
