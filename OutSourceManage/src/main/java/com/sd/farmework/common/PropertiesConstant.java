package com.sd.farmework.common;



public class PropertiesConstant {
	
 

	public   String serverDomain ;
	public String filePath;
	public   String dbType = "oracle";

	public String getServerDomain() {
		return serverDomain;
	}

	public void setServerDomain(String serverDomain) {
		this.serverDomain = serverDomain;
	}

	/**
	 * @return the dbType
	 */
	public String getDbType() {
		PropertiesConstant PropertiesConstant =new PropertiesConstant();
		return PropertiesConstant.getDbType();
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	 
	

 
}
