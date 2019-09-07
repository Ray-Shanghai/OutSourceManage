package com.sd.farmework.mapper; 

import java.util.List;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.pojo.SysFlowTask;

/** 
 * 数据库对应表字段
 * @author Administrator 
 * 
 */ 
public interface SysFlowTaskMapper  extends BaseMapper{ 
	public int addTasked(SysFlowTask sysFlowTask);
	
	/**
	 * 查询所有后台信息
	 */
 	public List<BaseInfo> queryTaskedList(BaseInfo obj) throws Exception;
 	
 	
 	public int addTaskedForMysql(SysFlowTask sysFlowTask);
 	
 	/**
 	 * 查询所有后台信息
 	 */
 	public List<BaseInfo> queryTaskedListForMysql(BaseInfo obj) throws Exception;
 	
 	
 	
 	public int addTaskedForSqlserver(SysFlowTask sysFlowTask);
 	
 	/**
 	 * 查询所有后台信息
 	 */
 	public List<BaseInfo> queryTaskedListForSqlserver(BaseInfo obj) throws Exception;
 	
}