package com.sd.farmework.mapper; 

import java.util.List;

/** 
 * 系统对用功能表
 * @author Administrator 
 * 
 */ 
@SuppressWarnings("rawtypes")
public interface SdFunctionInfoMapper  extends BaseMapper{ 
	/**
	 * 通过父节点获取子节点信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	
	public List queryByPkparentFunctionId(String obj) throws Exception;
	/**
	 * 通过父节点获取子节点信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List queryByPkparentFunctionIdForMysql(String obj) throws Exception;
	
	public void deleteId (Object obj) throws Exception;
}