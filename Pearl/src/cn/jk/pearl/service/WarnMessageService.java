package cn.jk.pearl.service;

import java.util.List;

import cn.jk.pearl.pojo.WarnMessage;

public interface WarnMessageService {
   public List<WarnMessage> queryAllWarnMessageByFarmerId(Integer farmerId);
   public void deleteWarnMessage(int warnMessageId);
}
