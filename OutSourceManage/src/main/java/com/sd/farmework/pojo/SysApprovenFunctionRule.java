package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * 审批功能规则表
 * @author Administrator 
 * 
 */ 
public class SysApprovenFunctionRule extends BaseInfo{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = -4577545554004523651L;
	//规则编号 
	private String approvenRuleId; 
	//规则名称 
	private String approvenRuleName; 
	//审批功能编号 
	private String approvenFunctionId; 
	//审批功能编号 
	private String approvenFunctionName; 
	//师傅按序审批(1：有序审批、2、无序审批) 
	private String ruleIsOrderly; 
	//审批功能描述 
	private String approvenRemark; 
	//审批班组编号(SYS_DEPART_INFO.DEPART_ID) 
	private String approvenTeamId; 
	//审批班组名称(SYS_DEPART_INFO.DEPART_NAME) 
	private String approvenTeamName; 
	//审批科室编号(SYS_DEPART_INFO.DEPART_ID) 
	private String approvenDepartId; 
	//审批科室名称(SYS_DEPART_INFO.DEPART_NAME) 
	private String approvenDepartName; 
	//审批单位编号(SYS_DEPART_INFO.DEPART_ID) 
	private String approvenUnitId; 
	//审批单位名称(SYS_DEPART_INFO.DEPART_NAME) 
	private String approvenUnitName; 
	
	//审批规则表达式 
	private String ruleExp; 
	//审批类型 
	private String ruleType; 
    public SysApprovenFunctionRule(){
	}
    public SysApprovenFunctionRule(String approvenRuleId,String approvenRuleName,String approvenFunctionId,String approvenFunctionName,String ruleIsOrderly,String approvenRemark,String approvenTeamId,String approvenTeamName,String approvenDepartId,String approvenDepartName,String approvenUnitId,String approvenUnitName){
		this.approvenRuleId=approvenRuleId;
		this.approvenRuleName=approvenRuleName;
		this.approvenFunctionId=approvenFunctionId;
		this.approvenFunctionName=approvenFunctionName;
		this.ruleIsOrderly=ruleIsOrderly;
		this.approvenRemark=approvenRemark;
		this.approvenTeamId=approvenTeamId;
		this.approvenTeamName=approvenTeamName;
		this.approvenDepartId=approvenDepartId;
		this.approvenDepartName=approvenDepartName;
		this.approvenUnitId=approvenUnitId;
		this.approvenUnitName=approvenUnitName;
	}
    public SysApprovenFunctionRule(String approvenRuleName,String approvenFunctionId,String approvenFunctionName,String ruleIsOrderly,String approvenRemark,String approvenTeamId,String approvenTeamName,String approvenDepartId,String approvenDepartName,String approvenUnitId,String approvenUnitName){
		this.approvenRuleName=approvenRuleName;
		this.approvenFunctionId=approvenFunctionId;
		this.approvenFunctionName=approvenFunctionName;
		this.ruleIsOrderly=ruleIsOrderly;
		this.approvenRemark=approvenRemark;
		this.approvenTeamId=approvenTeamId;
		this.approvenTeamName=approvenTeamName;
		this.approvenDepartId=approvenDepartId;
		this.approvenDepartName=approvenDepartName;
		this.approvenUnitId=approvenUnitId;
		this.approvenUnitName=approvenUnitName;
	}
    
	public String getRuleExp() {
		return ruleExp;
	}
	public void setRuleExp(String ruleExp) {
		this.ruleExp = ruleExp;
	}
	public String getRuleType() {
		return ruleType;
	}
	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}
	public void setApprovenRuleId(String approvenRuleId){ 
		this.approvenRuleId=approvenRuleId;
	}
	public String getApprovenRuleId(){ 
		return this.approvenRuleId;
	}
	public void setApprovenRuleName(String approvenRuleName){ 
		this.approvenRuleName=approvenRuleName;
	}
	public String getApprovenRuleName(){ 
		return this.approvenRuleName;
	}
	public void setApprovenFunctionId(String approvenFunctionId){ 
		this.approvenFunctionId=approvenFunctionId;
	}
	public String getApprovenFunctionId(){ 
		return this.approvenFunctionId;
	}
	public void setApprovenFunctionName(String approvenFunctionName){ 
		this.approvenFunctionName=approvenFunctionName;
	}
	public String getApprovenFunctionName(){ 
		return this.approvenFunctionName;
	}
	public void setRuleIsOrderly(String ruleIsOrderly){ 
		this.ruleIsOrderly=ruleIsOrderly;
	}
	public String getRuleIsOrderly(){ 
		return this.ruleIsOrderly;
	}
	public void setApprovenRemark(String approvenRemark){ 
		this.approvenRemark=approvenRemark;
	}
	public String getApprovenRemark(){ 
		return this.approvenRemark;
	}
	public void setApprovenTeamId(String approvenTeamId){ 
		this.approvenTeamId=approvenTeamId;
	}
	public String getApprovenTeamId(){ 
		return this.approvenTeamId;
	}
	public void setApprovenTeamName(String approvenTeamName){ 
		this.approvenTeamName=approvenTeamName;
	}
	public String getApprovenTeamName(){ 
		return this.approvenTeamName;
	}
	public void setApprovenDepartId(String approvenDepartId){ 
		this.approvenDepartId=approvenDepartId;
	}
	public String getApprovenDepartId(){ 
		return this.approvenDepartId;
	}
	public void setApprovenDepartName(String approvenDepartName){ 
		this.approvenDepartName=approvenDepartName;
	}
	public String getApprovenDepartName(){ 
		return this.approvenDepartName;
	}
	public void setApprovenUnitId(String approvenUnitId){ 
		this.approvenUnitId=approvenUnitId;
	}
	public String getApprovenUnitId(){ 
		return this.approvenUnitId;
	}
	public void setApprovenUnitName(String approvenUnitName){ 
		this.approvenUnitName=approvenUnitName;
	}
	public String getApprovenUnitName(){ 
		return this.approvenUnitName;
	}
	@Override
	public String toString() {
		return "SysApprovenFunctionRule [approvenRuleId=" + approvenRuleId
				+ ", approvenRuleName=" + approvenRuleName
				+ ", approvenFunctionId=" + approvenFunctionId
				+ ", approvenFunctionName=" + approvenFunctionName
				+ ", ruleIsOrderly=" + ruleIsOrderly + ", approvenRemark="
				+ approvenRemark + ", approvenTeamId=" + approvenTeamId
				+ ", approvenTeamName=" + approvenTeamName
				+ ", approvenDepartId=" + approvenDepartId
				+ ", approvenDepartName=" + approvenDepartName
				+ ", approvenUnitId=" + approvenUnitId + ", approvenUnitName="
				+ approvenUnitName + ", ruleExp=" + ruleExp + ", ruleType="
				+ ruleType + "]";
	}
 
}