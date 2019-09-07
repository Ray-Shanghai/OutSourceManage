package com.sd.farmework.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.farmework.common.BaseInfo;

/**
 * 用户管理
 * @author yanxiaosan
 * 2016-09-05 15:25:10
 */

@SuppressWarnings("rawtypes")
public interface BaseInfoMapService{
	/**
	 * 查询单一信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List query(Map obj) throws Exception;
	/**
	 * 查询所有条数
	 */
 	public int queryCount(Map obj) throws Exception;
	/**
	 * 查询所有后台信息
	 */
 	public List queryList(Map obj) throws Exception;
	
	/**
	 * 查询所有后台信息分页时使用
	 */
 	public List<Map> queryListByPage(Map obj) throws Exception;
 
 	/**
	 * 添加信息
	 * @param user
	 * @throws Exception
	 */
	public void add(Map obj) throws Exception;
	/**
	 * 修改信息
	 * @param user
	 * @throws Exception
	 */
	public void update(Map obj) throws Exception;
	
	 
  
	/**
	 * 批量写入
	 * @param obj
	 * @throws Exception
	 */
	public void addBatch(List  obj) throws Exception;
	/**
	 * 批量写入
	 * @param obj
	 * @throws Exception
	 */
	public void updateBatch(List  obj) throws Exception;
	
	/**
	 * 删除数据
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public void delete(Map obj) throws Exception;
	 
 
	/**
	 * 查询基本信息通过ID
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Map queryByPkId(Map obj) throws Exception;
	/**
	 * 更新状态
	 * @param obj
	 * @throws Exception
	 */
	public void updateStatus(Map  obj) throws Exception;
}
