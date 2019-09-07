package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * 流程信息表
 * @author Administrator 
 * 
 */ 
public class SdFlowInfo extends BaseInfo{ 
	 
	private String flowBaseId;
	private String flowName;
	private String flowDesc;
	private  String systemInfoId;
	public String getFlowBaseId() {
		return flowBaseId;
	}
	public void setFlowBaseId(String flowBaseId) {
		this.flowBaseId = flowBaseId;
	}
	public String getFlowName() {
		return flowName;
	}
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	public String getFlowDesc() {
		return flowDesc;
	}
	public void setFlowDesc(String flowDesc) {
		this.flowDesc = flowDesc;
	}
	public String getSystemInfoId() {
		return systemInfoId;
	}
	public void setSystemInfoId(String systemInfoId) {
		this.systemInfoId = systemInfoId;
	}
	@Override
	public String toString() {
		return "SdFlowInfo [flowBaseId=" + flowBaseId + ", flowName="
				+ flowName + ", flowDesc=" + flowDesc + ", systemInfoId="
				+ systemInfoId + "]";
	}
	
}