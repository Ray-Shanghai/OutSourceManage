package com.sd.farmework.mapper; 

import java.util.List;

import com.sd.farmework.common.BaseInfo;

/** 
 * 角色权限表
 * @author Administrator 
 * 
 */ 
@SuppressWarnings("rawtypes")
public interface SysRoleInfoMapper  extends BaseMapper{ 
	/**
	 * 查询某个用户对应的角色
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<BaseInfo> queryFunction(BaseInfo obj) throws Exception;
	/**
	 * 修改操作权限信息
	 * @param user
	 * @throws Exception
	 */
	public void updatePower(BaseInfo obj) throws Exception;
	
	/**
	 * 通过用户编号获取用户所有角色信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List queryUserRoleByUserId(BaseInfo obj) throws Exception;
	/**
	 * 通过用户编号获取用户所有角色信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int queryUserRoleByUserIdCount(BaseInfo obj) throws Exception;
	
	
	
	/**
	 * 查询某个用户对应的角色
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<BaseInfo> queryFunctionForMysql(BaseInfo obj) throws Exception;
	/**
	 * 修改操作权限信息
	 * @param user
	 * @throws Exception
	 */
	public void updatePowerForMysql(BaseInfo obj) throws Exception;
	
	/**
	 * 通过用户编号获取用户所有角色信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List queryUserRoleByUserIdForMysql(BaseInfo obj) throws Exception;
	/**
	 * 通过用户编号获取用户所有角色信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int queryUserRoleByUserIdCountForMysql(BaseInfo obj) throws Exception;
	
	
	
	/**
	 * 查询某个用户对应的角色
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<BaseInfo> queryFunctionForSqlserver(BaseInfo obj) throws Exception;
	/**
	 * 修改操作权限信息
	 * @param user
	 * @throws Exception
	 */
	public void updatePowerForSqlserver(BaseInfo obj) throws Exception;
	
	/**
	 * 通过用户编号获取用户所有角色信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List queryUserRoleByUserIdForSqlserver(BaseInfo obj) throws Exception;
	/**
	 * 通过用户编号获取用户所有角色信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int queryUserRoleByUserIdCountForSqlserver(BaseInfo obj) throws Exception;
}