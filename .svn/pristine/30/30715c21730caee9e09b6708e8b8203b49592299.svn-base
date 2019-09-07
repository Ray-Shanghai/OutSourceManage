package com.sd.farmework.common;

 
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by shhao.
 * Date: 14-9-1
 * Time:下午4:12
 */
public class FileUpload {


	//文件上传
    public static String uploadFile(PropertiesConstant propertiesConstant,MultipartFile file, HttpServletRequest request) throws IOException {
        String fileName = file.getOriginalFilename();
        File tempFile = new File(propertiesConstant.getFilePath(), /*new Date().getTime() + */String.valueOf(fileName));
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdir();
        }
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        return "download.do?fileName=" + tempFile.getName();
    }
    
    public static File getFile(PropertiesConstant propertiesConstant,String fileName) {
    	System.out.println(propertiesConstant.getFilePath()+"---"+fileName);
        return new File(propertiesConstant.getFilePath(), fileName);
    }
    
	//文件上传
    public static String getPathUploadFile(PropertiesConstant propertiesConstant,MultipartFile file, HttpServletRequest request) throws IOException {
        String fileName = file.getOriginalFilename();
        String name =   new Date().getTime() + String.valueOf(fileName);
        File tempFile = new File(propertiesConstant.getFilePath(),name);
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdir();
        }
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        return propertiesConstant.getFilePath()+name;
    }
    
}
