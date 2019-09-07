package com.sd.farmework.service; 

import com.sd.farmework.common.BaseInfo;

/** 
 * 审批规则对应审批人表
 * @author Administrator 
 * 
 */ 
public interface SysApprovenRulePersonService  extends BaseInfoService{ 
	/**
	 * 查询当前审批人是否已经在审批规则中
	 */
 	public int queryPersonCount(BaseInfo obj) throws Exception;
 	
 	/**
 	 * 删除审批人并重新排序审批顺序
 	 */
 	public void deleteAndOrder(BaseInfo obj) throws Exception;
 	
 	/**
 	 * 审批人并重新排序审批顺序
 	 */
 	public void updateOrder(String[] obj,String oper,String approvenPersonId) throws Exception;
 	
}