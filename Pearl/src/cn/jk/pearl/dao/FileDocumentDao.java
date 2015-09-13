package cn.jk.pearl.dao;
import java.util.List;

import cn.jk.pearl.pojo.FileDocument;
/**
 * 
 *  对 FileDocument表的操作
 * @author ZheTang
 * @date 2014-12-9
 *
 */
public interface FileDocumentDao extends BaseDao<FileDocument> {
	//更改下载量
	public void updateDownloadCount(int file_id ,int count);
	//更改阅读量
	public void updateReadCount(int file_id,int readcount);
	//获得前几条的文档
	public List<FileDocument> topMovies(int topCount);
}
