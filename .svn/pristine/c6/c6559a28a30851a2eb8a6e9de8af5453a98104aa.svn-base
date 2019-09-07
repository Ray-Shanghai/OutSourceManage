package com.sd.farmework.service; 

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.pojo.SysUserInfo;

/** 
 * 组织架构表
 * @author Administrator 
 * 
 */ 
public interface SysUserInfoService  extends BaseInfoService{ 
	/**
	 * 设置部门权限
	 * @param obj
	 */
	public void updateDepartPower(BaseInfo obj);
	public void updatePwd(BaseInfo obj);
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