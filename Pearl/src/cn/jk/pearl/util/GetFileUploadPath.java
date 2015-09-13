package cn.jk.pearl.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("getFileUploadPath")
public class GetFileUploadPath {
	@Value("#{public.basePath}#{public.FilePath}")
    private String fileUploadPath;
	public String getFileUploadPath(){
		return fileUploadPath;
	}
}
