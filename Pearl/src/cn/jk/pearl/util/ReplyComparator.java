package cn.jk.pearl.util;

import java.util.Comparator;

import cn.jk.pearl.pojo.Reply;

public class ReplyComparator implements Comparator<Reply>{

	public int compare(Reply o1, Reply o2) {
	    if(o1.getReplyTime().compareTo(o2.getReplyTime())<0){
	    	return  -1;
	    }else if(o1.getReplyTime().compareTo(o2.getReplyTime())==0){
	    	return 0;
	    }else if(o1.getReplyTime().compareTo(o2.getReplyTime())>0){
	    	return 1;
	    }
		return 0;
	}

}
