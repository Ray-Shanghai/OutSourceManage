package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * 审批待办任务表
 * @author Administrator 
 * 
 */ 
public class SysApprovenTask extends BaseInfo{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 7443944784476435026L;
	//null 
	private String taskId; 
	//任务名称 
	private String taskName; 
	//审批人规则id（sys_approven_rule.approven_rule_id） 
	private String approvenPersonId; 
	//规则id（sys_approven_rule.approven_rule_id） 
	private String approvenRuleId; 
	//规则名称（sys_approven_rule.approven_rule_name） 
	private String approvenRuleName; 
	//审批功能编号（sys_approven_function.approven_function_id） 
	private String approvenFunctionId; 
	//审批功能名称（sys_approven_function.approven_function_name） 
	private String approvenFunctionName; 
	//审批人id(sys_user_info.user_id) 
	private String approvenUserId; 
	//审批人姓名(sys_user_info.user_name) 
	private String approvenUserName; 
	
	private String approvenTeamId;
	private String approvenTeamName;
	
	private String approvenDepartId;
	private String approvenDepartName;
	
	private String approvenUnitId;
	private String approvenUnitName;
	//审批人顺序 
	private int ruleOrder; 
	//审批发起时间 
	private String approvenSendTime; 
	//审批完成时间 
	private String approvenEndTime; 
	//审批结果（1，通过，2不通过，3暂不处理） 
	private String approvenResult; 
	//当前状态（1：未审批、2已审批） 
	private String approvenStatus; 
	//数据来源表名称(具体业务表名) 
	private String sourceTable; 
	//数据来源表主键列名称(具体业务表名.主键) 
	private String sourceTablePkColumnName; 
	//数据来源表主键列对应数据(具体业务表名.主键对应数据) 
	private String sourceTablePkColumnValue; 
	//审批意见 
	private String approvenRemark; 
	//原始序号 
	private int ruleOrderOld; 
	
	
	
    public SysApprovenTask(){
	}
    public SysApprovenTask(String taskId,String taskName,String approvenPersonId,String approvenRuleId,String approvenRuleName,String approvenFunctionId,String approvenFunctionName,String approvenUserId,String approvenUserName,int ruleOrder,String approvenSendTime,String approvenEndTime,String approvenResult,String approvenStatus,String sourceTable,String sourceTablePkColumnName,String sourceTablePkColumnValue,String approvenRemark,int ruleOrderOld){
		this.taskId=taskId;
		this.taskName=taskName;
		this.approvenPersonId=approvenPersonId;
		this.approvenRuleId=approvenRuleId;
		this.approvenRuleName=approvenRuleName;
		this.approvenFunctionId=approvenFunctionId;
		this.approvenFunctionName=approvenFunctionName;
		this.approvenUserId=approvenUserId;
		this.approvenUserName=approvenUserName;
		this.ruleOrder=ruleOrder;
		this.approvenSendTime=approvenSendTime;
		this.approvenEndTime=approvenEndTime;
		this.approvenResult=approvenResult;
		this.approvenStatus=approvenStatus;
		this.sourceTable=sourceTable;
		this.sourceTablePkColumnName=sourceTablePkColumnName;
		this.sourceTablePkColumnValue=sourceTablePkColumnValue;
		this.approvenRemark=approvenRemark;
		this.ruleOrderOld=ruleOrderOld;
	}
    public SysApprovenTask(String taskName,String approvenPersonId,String approvenRuleId,String approvenRuleName,String approvenFunctionId,String approvenFunctionName,String approvenUserId,String approvenUserName,int ruleOrder,String approvenSendTime,String approvenEndTime,String approvenResult,String approvenStatus,String sourceTable,String sourceTablePkColumnName,String sourceTablePkColumnValue,String approvenRemark,int ruleOrderOld){
		this.taskName=taskName;
		this.approvenPersonId=approvenPersonId;
		this.approvenRuleId=approvenRuleId;
		this.approvenRuleName=approvenRuleName;
		this.approvenFunctionId=approvenFunctionId;
		this.approvenFunctionName=approvenFunctionName;
		this.approvenUserId=approvenUserId;
		this.approvenUserName=approvenUserName;
		this.ruleOrder=ruleOrder;
		this.approvenSendTime=approvenSendTime;
		this.approvenEndTime=approvenEndTime;
		this.approvenResult=approvenResult;
		this.approvenStatus=approvenStatus;
		this.sourceTable=sourceTable;
		this.sourceTablePkColumnName=sourceTablePkColumnName;
		this.sourceTablePkColumnValue=sourceTablePkColumnValue;
		this.approvenRemark=approvenRemark;
		this.ruleOrderOld=ruleOrderOld;
	}
    
	public String getApprovenTeamId() {
		return approvenTeamId;
	}
	public void setApprovenTeamId(String approvenTeamId) {
		this.approvenTeamId = approvenTeamId;
	}
	public String getApprovenTeamName() {
		return approvenTeamName;
	}
	public void setApprovenTeamName(String approvenTeamName) {
		this.approvenTeamName = approvenTeamName;
	}
	public String getApprovenDepartId() {
		return approvenDepartId;
	}
	public void setApprovenDepartId(String approvenDepartId) {
		this.approvenDepartId = approvenDepartId;
	}
	public String getApprovenDepartName() {
		return approvenDepartName;
	}
	public void setApprovenDepartName(String approvenDepartName) {
		this.approvenDepartName = approvenDepartName;
	}
	public String getApprovenUnitId() {
		return approvenUnitId;
	}
	public void setApprovenUnitId(String approvenUnitId) {
		this.approvenUnitId = approvenUnitId;
	}
	public String getApprovenUnitName() {
		return approvenUnitName;
	}
	public void setApprovenUnitName(String approvenUnitName) {
		this.approvenUnitName = approvenUnitName;
	}
	public void setTaskId(String taskId){ 
		this.taskId=taskId;
	}
	public String getTaskId(){ 
		return this.taskId;
	}
	public void setTaskName(String taskName){ 
		this.taskName=taskName;
	}
	public String getTaskName(){ 
		return this.taskName;
	}
	public void setApprovenPersonId(String approvenPersonId){ 
		this.approvenPersonId=approvenPersonId;
	}
	public String getApprovenPersonId(){ 
		return this.approvenPersonId;
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
	public void setApprovenUserId(String approvenUserId){ 
		this.approvenUserId=approvenUserId;
	}
	public String getApprovenUserId(){ 
		return this.approvenUserId;
	}
	public void setApprovenUserName(String approvenUserName){ 
		this.approvenUserName=approvenUserName;
	}
	public String getApprovenUserName(){ 
		return this.approvenUserName;
	}
	public void setRuleOrder(int ruleOrder){ 
		this.ruleOrder=ruleOrder;
	}
	public int getRuleOrder(){ 
		return this.ruleOrder;
	}
	public void setApprovenSendTime(String approvenSendTime){ 
		this.approvenSendTime=approvenSendTime;
	}
	public String getApprovenSendTime(){ 
		return this.approvenSendTime;
	}
	public void setApprovenEndTime(String approvenEndTime){ 
		this.approvenEndTime=approvenEndTime;
	}
	public String getApprovenEndTime(){ 
		return this.approvenEndTime;
	}
	public void setApprovenResult(String approvenResult){ 
		this.approvenResult=approvenResult;
	}
	public String getApprovenResult(){ 
		return this.approvenResult;
	}
	public void setApprovenStatus(String approvenStatus){ 
		this.approvenStatus=approvenStatus;
	}
	public String getApprovenStatus(){ 
		return this.approvenStatus;
	}
	public void setSourceTable(String sourceTable){ 
		this.sourceTable=sourceTable;
	}
	public String getSourceTable(){ 
		return this.sourceTable;
	}
	public void setSourceTablePkColumnName(String sourceTablePkColumnName){ 
		this.sourceTablePkColumnName=sourceTablePkColumnName;
	}
	public String getSourceTablePkColumnName(){ 
		return this.sourceTablePkColumnName;
	}
	public void setSourceTablePkColumnValue(String sourceTablePkColumnValue){ 
		this.sourceTablePkColumnValue=sourceTablePkColumnValue;
	}
	public String getSourceTablePkColumnValue(){ 
		return this.sourceTablePkColumnValue;
	}
	public void setApprovenRemark(String approvenRemark){ 
		this.approvenRemark=approvenRemark;
	}
	public String getApprovenRemark(){ 
		return this.approvenRemark;
	}
	public void setRuleOrderOld(int ruleOrderOld){ 
		this.ruleOrderOld=ruleOrderOld;
	}
	public int getRuleOrderOld(){ 
		return this.ruleOrderOld;
	}
	@Override
	public String toString() {
		return "SysApprovenTask[taskId=" + taskId+",taskName=" + taskName+",approvenPersonId=" + approvenPersonId+",approvenRuleId=" + approvenRuleId+",approvenRuleName=" + approvenRuleName+",approvenFunctionId=" + approvenFunctionId+",approvenFunctionName=" + approvenFunctionName+",approvenUserId=" + approvenUserId+",approvenUserName=" + approvenUserName+",ruleOrder=" + ruleOrder+",approvenSendTime=" + approvenSendTime+",approvenEndTime=" + approvenEndTime+",approvenResult=" + approvenResult+",approvenStatus=" + approvenStatus+",sourceTable=" + sourceTable+",sourceTablePkColumnName=" + sourceTablePkColumnName+",sourceTablePkColumnValue=" + sourceTablePkColumnValue+",approvenRemark=" + approvenRemark+",ruleOrderOld=" + ruleOrderOld+"]";
	}
}