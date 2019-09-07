package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * 流程节点信息表
 * @author Administrator 
 * 
 */ 
public class SdFlowDetail extends BaseInfo{ 
	//主键
	private String flowDetailId;
	//流程节点名称
	private String flowDetailName;
	//流程主表（SD_FLOW_INFO.FLOW_BASE_ID）
	private String flowBaseId;
	//流程对应功能出发点编号（SD_FUNCTION_INFO.FUNCTION_ID）
	private String functionId;
	//流程顺序（顺序为1时，为起始流程）
	private String flowOrder;
	//流程操作节点
	private String flowOperateFunctionId;
	//流程关联字段
	private String flowUnionFiled;
	public String getFlowDetailId() {
		return flowDetailId;
	}
	public void setFlowDetailId(String flowDetailId) {
		this.flowDetailId = flowDetailId;
	}
	public String getFlowDetailName() {
		return flowDetailName;
	}
	public void setFlowDetailName(String flowDetailName) {
		this.flowDetailName = flowDetailName;
	}
	public String getFlowBaseId() {
		return flowBaseId;
	}
	public void setFlowBaseId(String flowBaseId) {
		this.flowBaseId = flowBaseId;
	}
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	public String getFlowOrder() {
		return flowOrder;
	}
	public void setFlowOrder(String flowOrder) {
		this.flowOrder = flowOrder;
	}
	public String getFlowOperateFunctionId() {
		return flowOperateFunctionId;
	}
	public void setFlowOperateFunctionId(String flowOperateFunctionId) {
		this.flowOperateFunctionId = flowOperateFunctionId;
	}
	public String getFlowUnionFiled() {
		return flowUnionFiled;
	}
	public void setFlowUnionFiled(String flowUnionFiled) {
		this.flowUnionFiled = flowUnionFiled;
	}
	@Override
	public String toString() {
		return "SdFlowDetail [flowDetailId=" + flowDetailId
				+ ", flowDetailName=" + flowDetailName + ", flowBaseId="
				+ flowBaseId + ", functionId=" + functionId + ", flowOrder="
				+ flowOrder + ", flowOperateFunctionId="
				+ flowOperateFunctionId + ", flowUnionFiled=" + flowUnionFiled
				+ "]";
	}
}