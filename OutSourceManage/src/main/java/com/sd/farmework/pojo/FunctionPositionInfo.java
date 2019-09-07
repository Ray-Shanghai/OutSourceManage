package com.sd.farmework.pojo;

import com.sd.farmework.common.BaseInfo;
/**
 * @author yanxiaosan
 * 职位权限设置
 *
 */
public class FunctionPositionInfo extends BaseInfo{

	private static final long serialVersionUID = -20169237771177761L;
	private  String functionId;//权限ID
	private  String functionName;//操作名称
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	 
	
}
