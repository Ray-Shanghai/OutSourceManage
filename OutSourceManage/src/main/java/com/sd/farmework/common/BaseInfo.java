package com.sd.farmework.common;

import java.io.Serializable;

import com.sd.farmework.common.util.StringUtil;

public class BaseInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6466958553629846190L;
	private int currPage=1;
	private int totalCount;
	private int pageSize=5;
	private int pageCount;
	@SuppressWarnings("unused")
	private int startRecod;
	
	public int getStartRecod() {
		
		return (currPage-1)*pageSize;
	}
	
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		
		if(getTotalCount()%pageSize!=0){
			pageCount=((getTotalCount()/pageSize)+1);
			}else{
				pageCount=(getTotalCount()/pageSize);
			}
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	

	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
	private String  createTime;//创建时间
	private String  createUserId;//创建人id
	private String  createUserName;//创建人姓名
	private String  updateTime;//更新时间
	private String  updateUserId;//更新人id
	private String  updateUserName;//更新人姓名
	private String  rowNumber;//行号
	

	
	private String remark;
	//状态（Y正常,N禁用）
	private String status;
	
 
    private String createDepartId;
    private String createDepartName;
    
    
    private String lastUpdateTime;
    private String lastUpdateUserId;
    private String lastUpdateUserName;
    
    private String lastUpdateDepartId;
    private String lastUpdateDepartName;
    
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	 

	public String getCreateDepartId() {
		return createDepartId;
	}

	public void setCreateDepartId(String createDepartId) {
		this.createDepartId = createDepartId;
	}

	public String getCreateDepartName() {
		return createDepartName;
	}

	public void setCreateDepartName(String createDepartName) {
		this.createDepartName = createDepartName;
	}

	 
	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getLastUpdateUserId() {
		return lastUpdateUserId;
	}

	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}

	public String getLastUpdateUserName() {
		return lastUpdateUserName;
	}

	public void setLastUpdateUserName(String lastUpdateUserName) {
		this.lastUpdateUserName = lastUpdateUserName;
	}

	 

	public String getLastUpdateDepartId() {
		return lastUpdateDepartId;
	}

	public void setLastUpdateDepartId(String lastUpdateDepartId) {
		this.lastUpdateDepartId = lastUpdateDepartId;
	}

	public String getLastUpdateDepartName() {
		return lastUpdateDepartName;
	}

	public void setLastUpdateDepartName(String lastUpdateDepartName) {
		this.lastUpdateDepartName = lastUpdateDepartName;
	}

	 

	public String getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getCreateTime() {
		
		if(StringUtil.isNotNullOrBlank(createTime)&&createTime.length()==21){
			createTime = createTime.substring(0, 19);
		}
		
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public void setStartRecod(int startRecod) {
		this.startRecod = startRecod;
	}

}
