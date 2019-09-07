package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * 流程信息表
 * @author Administrator 
 * 
 */ 
public class SysFlowTask extends BaseInfo{  
	
	private String sourceId;
	private String stepOrder;
	private String step;
	private String isDisposed;
	private String stepDesc;
	private String functionId;
	private String  flowOpearteFunctionId;
	//流程关联字段
	private String flowUnionFiled;
		
	public String getFlowUnionFiled() {
			return flowUnionFiled;
		}
		public void setFlowUnionFiled(String flowUnionFiled) {
			this.flowUnionFiled = flowUnionFiled;
		}
	public String getFlowOpearteFunctionId() {
		return flowOpearteFunctionId;
	}
	public void setFlowOpearteFunctionId(String flowOpearteFunctionId) {
		this.flowOpearteFunctionId = flowOpearteFunctionId;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getStepOrder() {
		return stepOrder;
	}
	public void setStepOrder(String stepOrder) {
		this.stepOrder = stepOrder;
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public String getIsDisposed() {
		return isDisposed;
	}
	public void setIsDisposed(String isDisposed) {
		this.isDisposed = isDisposed;
	}
	public String getStepDesc() {
		return stepDesc;
	}
	public void setStepDesc(String stepDesc) {
		this.stepDesc = stepDesc;
	}
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	
	
}