package cn.jk.pearl.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jk.pearl.dao.FileDocumentDao;
import cn.jk.pearl.pojo.FileDocument;
import cn.jk.pearl.service.FileDocumentService;
/**
 * 
 *  文档的管理
 * @author ZheTang
 * @date 2014-12-9
 *
 */
@Service(value = "fileDocumentService")
public class FileDocumentServiceImpl implements FileDocumentService {
	@Resource
	FileDocumentDao fileDocumentDao = null;
	
	/*
	 * @param topCount : 前几条
	 * return 返回热门文档集合
	 */
	public List<FileDocument> topFileDocuments(int topCount) {
		
		return fileDocumentDao.topMovies(topCount);
	}
	
	/*
	 * @param pageSize : 页面要展示文档的条数
	 * @param pageNow : 当前页面所在的页数
	 * return 返回当前页面的文档集合
	 */
	public List<FileDocument> getFileDocumentsByPage(int pageSize, int pageNow) {

		return fileDocumentDao.getContentByPage(pageSize, pageNow);
	}
	
	/*
	 * @param pageSize: 页面要展示文档的条数
	 * return 文档的总页数 
	 */
	public long getPageCount(int pageSize) {
		long movieCount = fileDocumentDao.getCount();//视频总数
		long pageCount = 0; 
		if(movieCount%pageSize==0){
			pageCount = movieCount/pageSize;
		}else{
			pageCount = movieCount/pageSize+1;
		}
		return pageCount;
	}
	
	/*
	 * @param fileDocumentId :文档Id
	 * return :返回文档Id对应的文档实体
	 */
	public FileDocument getFileDocumentById(int fileDocumentId) {
		
		return fileDocumentDao.get(fileDocumentId);
	}
	
	/*
	 * 修改文档的阅读数
	 * @param FDId : 对应文档的id
	 * @param num :文档即将要修改成的阅读数
	 */
	public void addFDReadNum(int FDId, int num) {
		
		fileDocumentDao.updateReadCount(FDId, num);
	}
	
	/*
	 * 修改文档的下载数
	 * @param FDId : 对应文档的id
	 * @param num :文档即将要修改成的下载数
	 */
	public void addFDdownloadNum(int FDId, int num) {
		
		fileDocumentDao.updateDownloadCount(FDId, num);
	}
	
	/*
	 * 添加文档
	 */
	public void uploadFileDocument(FileDocument fileDocument) {
		
		fileDocumentDao.save(fileDocument);
	}
	
	/*
	 * 删除文档
	 */
	public void deleteFileDocumentById(int fileDocumentId) {
		
		fileDocumentDao.delete(fileDocumentId);
	}
	
	/*
	 * 编辑文档
	 */
	public void editFileDocument(FileDocument fileDocument) {
		
		fileDocumentDao.update(fileDocument);
	}

}
