package cn.jk.pearl.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("fileUploadUtil")
public class FileUploadUtil {
	@Value("#{public.basePath}#{public.FilePath}")
    private String fileUploadPath;
	public String fileUpload(String FileOldName,File file) {
		//获取后缀名
		String ext=FilenameUtils.getExtension(FileOldName);
		//生成新的名字
		String newName=UUID.randomUUID().toString()+"."+ext;
		//上传文件
		try {
			FileUtils.copyFile(file,new File(fileUploadPath,newName));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}finally{
			file.delete();
		}
		return newName;
	}
}


