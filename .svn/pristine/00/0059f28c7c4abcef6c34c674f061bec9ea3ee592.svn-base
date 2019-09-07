package com.sd.farmework.mapper; 

import java.util.List;

import com.sd.farmework.common.BaseInfo;

/** 
 * 审批待办任务表
 * @author Administrator 
 * 
 */ 
public interface SysApprovenTaskMapper  extends BaseMapper{ 
	public List<BaseInfo> queryAllApprovenTaskList(BaseInfo obj);
	public List<BaseInfo> queryRemainderTaskList(BaseInfo obj);
	public void updateNextApprovenPerosn(BaseInfo ojb);
	
	public List<BaseInfo> queryAllApprovenTaskListForMysql(BaseInfo obj);
	public List<BaseInfo> queryRemainderTaskListForMysql(BaseInfo obj);
	public void updateNextApprovenPerosnForMysql(BaseInfo ojb);
	
	public List<BaseInfo> queryAllApprovenTaskListForSqlserver(BaseInfo obj);
	public List<BaseInfo> queryRemainderTaskListForSqlserver(BaseInfo obj);
	public void updateNextApprovenPerosnForSqlserver(BaseInfo ojb);
	
	public BaseInfo queryFirstPersonForMysql(BaseInfo ojb) throws Exception;
}