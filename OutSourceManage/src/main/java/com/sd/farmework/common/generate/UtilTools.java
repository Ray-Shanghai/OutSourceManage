package com.sd.farmework.common.generate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class UtilTools {
	 
	public static Connection getConnection(String driver,String  jdbcStr ,String userName,String password ) throws Exception {
		Class.forName(driver);

		return DriverManager.getConnection(jdbcStr, userName, password);
	}

	public static void createFile(String filePath) {
		String paths[] = filePath.split("/");
		for (int k = 0; k < paths.length; k++) {
			String dir = paths[k];
			for (int i = 0; i < paths.length - 2; i++) {
				try {
					dir = dir + "/" + paths[i + 1];
					File dirFile = new File(dir);
					if (!dirFile.exists()) {
						dirFile.mkdir();
						System.out.println("创建目录为：" + dir);
					}
				} catch (Exception err) {
					System.err.println("ELS - Chart : 文件夹创建发生异常");
				}
			}
			
			
		}
		
	}
	public static void createFloder(String filePath) {
		String paths[] = filePath.split("/");
		for (int k = 0; k < paths.length; k++) {
			String dir = paths[k];
			for (int i = 0; i < paths.length ; i++) {
				try {
					dir = dir + "/" + paths[i + 1];
					File dirFile = new File(dir);
					if (!dirFile.exists()) {
						dirFile.mkdir();
						System.out.println("创建目录为：" + dir);
					}
				} catch (Exception err) {
					System.err.println("ELS - Chart : 文件夹创建发生异常");
				}
			}
			
			
		}
		
	}
	 
	
	
	 public static boolean copyFile(String srcFileName, String destFileName,  
	            boolean overlay) {  
	        File srcFile = new File(srcFileName);  
	  
	        
	  
	        // 判断目标文件是否存在  
	        File destFile = new File(destFileName);  
	        if (destFile.exists()) {  
	            // 如果目标文件存在并允许覆盖  
	            if (overlay) {  
	                // 删除已经存在的目标文件，无论目标文件是目录还是单个文件  
	                new File(destFileName).delete();  
	            }  
	        } else {  
	            // 如果目标文件所在目录不存在，则创建目录  
	            if (!destFile.getParentFile().exists()) {  
	                // 目标文件所在目录不存在  
	                if (!destFile.getParentFile().mkdirs()) {  
	                    // 复制文件失败：创建目标文件所在目录失败  
	                    return false;  
	                }  
	            }  
	        }  
	  
	        // 复制文件  
	        int byteread = 0; // 读取的字节数  
	        InputStream in = null;  
	        OutputStream out = null;  
	  
	        try {  
	            in = new FileInputStream(srcFile);  
	            out = new FileOutputStream(destFile);  
	            byte[] buffer = new byte[1024];  
	  
	            while ((byteread = in.read(buffer)) != -1) {  
	                out.write(buffer, 0, byteread);  
	            }  
	            return true;  
	        } catch (FileNotFoundException e) {  
	            return false;  
	        } catch (IOException e) {  
	            return false;  
	        } finally {  
	            try {  
	                if (out != null)  
	                    out.close();  
	                if (in != null)  
	                    in.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    }  
	  
	
	

	public static void isExist(String filePath, StringBuffer sb) {
		try {
			createFile(filePath);
			File fp = new File(filePath);
			if (!fp.exists()) {
				OutputStreamWriter pw = new OutputStreamWriter(
						new FileOutputStream(filePath), "UTF-8");
				pw.close();
			}
			OutputStreamWriter pw = null;// 定义一个流
			pw = new OutputStreamWriter(new FileOutputStream(filePath), "utf-8");// 确认流的输出文件和编码格式，此过程创建了“test.txt”实例
			pw.write(sb.toString());// 将要写入文件的内容，可以多次write
			pw.close();// 关闭流

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String changeWordToFirstUpper(String name) {
		String first = (name.charAt(0) + "").toUpperCase();
		String other = name.substring(1).toLowerCase();
		return first + other;
	}
	
	public static String changeWordToFirstLower(String name) {
		String first = (name.charAt(0) + "").toLowerCase();
		String other = name.substring(1).toLowerCase();
		return first + other;
	}

	public static String getWord(String str) {
		String[] strArray = str.split("_");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strArray.length; i++) {
			String st = strArray[i];
			if (i != 0) {
				st = st.substring(0, 1).toUpperCase() + st.substring(1);
			}
			sb.append(st);
		}
		return sb.toString();
	}

	 
	
	public static void main(String[] args) {
		System.out.println(changeWordToFirstUpper("Twerew"));
	}
	
}
