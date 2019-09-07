package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * 附件信息表
 * @author LiYK
 * @date 2017年6月16日下午2:45:15
 *
 */
public class SysAttachmentInfo extends BaseInfo{

	 
	private static final long serialVersionUID = 1L; 
	 
	private String attachmentId ;	//主键
	private String attachmentName ;	//附件名称
	private String filePath ;		//附件存放路径
	private String sourceId;		//附件来源表主键
	private String sourceTable;		//附件表名
	
	
	public String getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}
	public String getAttachmentName() {
		return attachmentName;
	}
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getSourceTable() {
		return sourceTable;
	}
	public void setSourceTable(String sourceTable) {
		this.sourceTable = sourceTable;
	}
	
	 
}