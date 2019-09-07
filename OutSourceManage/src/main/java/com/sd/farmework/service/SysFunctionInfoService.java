package com.sd.farmework.service; 

import java.util.List;

import com.sd.farmework.pojo.SysFunctionInfo;

/** 
 * 功能菜单信息表
 * @author Administrator 
 * 
 */ 
@SuppressWarnings("rawtypes")
public interface SysFunctionInfoService  extends BaseInfoService{ 
 	/**
	 * 添加信息
	 * @param user
	 * @throws Exception
	 */
	public void add(SysFunctionInfo obj,String [] powers) throws Exception;
	
	/**
	 * 添加信息
	 * @param user
	 * @throws Exception
	 */
	public void update(SysFunctionInfo obj,String [] powers) throws Exception;
	
	/**
	 * 通过父节点获取子节点信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List queryByPkparentFunctionId(String obj) throws Exception;
	
	

}