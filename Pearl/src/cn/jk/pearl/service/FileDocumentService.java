package cn.jk.pearl.service;

import java.util.List;

import cn.jk.pearl.pojo.FileDocument;
/*
 * 对文档操作的接口
 */
public interface FileDocumentService {
	public List<FileDocument> topFileDocuments(int topCount);//展示前几条热门文档，topCount:表示前几条
	public List<FileDocument> getFileDocumentsByPage(int pageSize,int pageNow);//根据第几页返回该页的视频信息
	public long getPageCount(int pageSize);//获得文档信息展示的页面的总数
	public FileDocument getFileDocumentById(int fileDocumentId);//根据文档Id获得该视频信息
	public void addFDReadNum(int FDId,int num);//添加文档阅读数
	public void addFDdownloadNum(int FDId,int num);//修改文档的下载数
	public void uploadFileDocument(FileDocument fileDocument);//上传文档
	public void deleteFileDocumentById(int fileDocumentId);//删除文档
	public void editFileDocument(FileDocument fileDocument);//编辑视频信息
}
