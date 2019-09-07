package com.sd.farmework.pojo;

import com.sd.farmework.common.BaseInfo;

/**
 * 用户功能定制表
 * @author Administrator 
 */
public class SysFunctionModuleRuleBase extends BaseInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7484523123564823066L;
	private String functionModuleRuleBaseId; 
	private String userIds;
	public String getFunctionModuleRuleBaseId() {
		return functionModuleRuleBaseId;
	}
	public void setFunctionModuleRuleBaseId(String functionModuleRuleBaseId) {
		this.functionModuleRuleBaseId = functionModuleRuleBaseId;
	}
	public String getUserIds() {
		return userIds;
	}
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "SysFunctionModuleRuleBase [functionModuleRuleBaseId="
				+ functionModuleRuleBaseId + ", userIds=" + userIds + "]";
	}
	
}
