package com.sd.farmework.common.generate;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyOfReverse {
	static String fgf = File.separator;
	
	
	static	List<String> distinctColumnList = new ArrayList();
	static Map<String, String> dataColumnTypeMap = new HashMap<String, String>();
  
	public static Connection getConnection(String driver,String  jdbcStr ,String userName,String password ) throws Exception {
		Class.forName(driver);

		return DriverManager.getConnection(jdbcStr, userName, password);
	}

     public static void main(String[] args) {
    	 
    	 
    	 try {
    		 
    		 
    		 
    		 
    		    String driver = "oracle.jdbc.driver.OracleDriver";
    			String jdbcStr = "jdbc:oracle:thin:@192.168.1.250:1521:orcl";
    			String userName = "SoftwareFactory";
    			String password = "SoftwareFactory";
    		 
    			//Connection conn=  getConnection(driver,jdbcStr,userName,password);
    		 
	    		String contentName ="TestManage";
	    		String filePath ="d:/testCreate/"+contentName;
				String content ="/.project";
				StringBuffer sb  = new StringBuffer();
				
				
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
				sb.append("	<projectDescription>\n");
				sb.append("	<name>"+contentName+"</name>\n");
				sb.append("		<comment></comment>\n");
				sb.append("		<projects></projects>\n");
				sb.append("		<buildSpec></buildSpec>\n");
				sb.append("		<natures>\n");
				sb.append("	</natures>\n");
				sb.append("</projectDescription>\n");
				UtilTools.isExist(filePath+content,sb);
				
				sb =new StringBuffer();
				
				String fileName[] = {"org.eclipse.jdt.core.prefs",
									 "org.eclipse.m2e.core.prefs",
									 "org.eclipse.m2e.wtp.prefs",
									 "org.eclipse.core.resources.prefs",
									 "org.eclipse.wst.common.component",
									 "org.eclipse.wst.common.project.facet.core.xml",
									 "org.eclipse.wst.validation.prefs"};
				
				
				for (String string : fileName) {
					UtilTools.isExist(filePath+"/.settings/"+string,sb);
					UtilTools.copyFile( "D:/work/TargetMaster/TargetMaster/farmework/.settings/"+string,filePath+"/.settings/"+string, true);
				}
			
			
			
			 
                 
			
			
			
			
			
//    		Connection conn=   getConnection();
//			PreparedStatement pre=conn.prepareStatement(" select system_info_id, system_name, system_webcontext, db_type, db_name, db_username, db_userpwd, remark, status, create_time, create_user_id, create_user_name, create_depart_id, create_depart_name, last_update_time, last_update_user_id, last_update_user_name, last_update_depart_id, last_update_depart_name from sd_system_info");
//			ResultSet sta= pre.getResultSet();
//		 
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			 while(sta.next()){
//				 Connection conn1=   getConnection();
//					PreparedStatement pre1=conn1.prepareStatement(" select system_info_id, system_name, system_webcontext, db_type, db_name, db_username, db_userpwd, remark, status, create_time, create_user_id, create_user_name, create_depart_id, create_depart_name, last_update_time, last_update_user_id, last_update_user_name, last_update_depart_id, last_update_depart_name from sd_system_info");
//					ResultSet sta1= pre1.getResultSet();
//				 
//				 
//				 
//			 }
			 
			 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
