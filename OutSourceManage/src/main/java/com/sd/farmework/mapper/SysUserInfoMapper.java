package com.sd.farmework.mapper; 

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.pojo.SysUserInfo;

/** 
 * 组织架构表
 * @author Administrator 
 * 
 */ 
public interface SysUserInfoMapper  extends BaseMapper{ 
	/**
	 * 设置部门权限
	 * @param obj
	 */
	public void updateDepartPower(BaseInfo obj);
	public void updatePwd(BaseInfo obj);
	public void deleteUserByParm(BaseInfo obj);
	public void updateUserByParm(BaseInfo obj);
	
	
	public void updateDepartPowerForMysql(BaseInfo obj);
	public void updatePwdForMysql(BaseInfo obj);
	public void deleteUserByParmForMysql(BaseInfo obj);
	public void updateUserByParmForMysql(BaseInfo obj);

	
	public void updateDepartPowerForSqlserver(BaseInfo obj);
	public void updatePwdForSqlserver(BaseInfo obj);
	public void deleteUserByParmForSqlserver(BaseInfo obj);
	public void updateUserByParmForSqlserver(BaseInfo obj);
	/**
	 * 根据wxOpenId查询用户
	 * @param sysUserInfo
	 * @return
	 */
	public SysUserInfo queryUserByOpenId(SysUserInfo sysUserInfo)throws Exception;
	/**
	 * 更新openid
	 * @param sysUserInfo
	 * @throws Exception
	 */
	public void updateUser(SysUserInfo sysUserInfo)throws Exception;
	
}