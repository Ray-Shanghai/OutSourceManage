package com.sd.farmework.service; 

import java.util.List;

import com.sd.farmework.common.BaseInfo;

/** 
 * 审批待办任务表
 * @author Administrator 
 * 
 */ 
public interface SysApprovenTaskService  extends BaseInfoService{ 
	public List<BaseInfo> queryAllApprovenTaskList(BaseInfo obj);
	public List<BaseInfo> queryRemainderTaskList(BaseInfo obj);
	public void updateNextApprovenPerosn(BaseInfo ojb);
}