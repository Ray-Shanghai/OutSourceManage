package com.sd.farmework.service; 

import java.util.List;

import com.sd.farmework.pojo.SdOrderAssign;

/** 
 * test
 * @author Administrator 
 * 
 */ 
public interface SdOrderAssignService  extends BaseInfoService{ 
	/**
	 * 采购指派
	 * @param sdorderassign
	 * @param assignList
	 * @throws Exception
	 */
	public void addAssignOrder(SdOrderAssign sdorderassign,List<SdOrderAssign> assignList,String userNames)throws Exception; 
}