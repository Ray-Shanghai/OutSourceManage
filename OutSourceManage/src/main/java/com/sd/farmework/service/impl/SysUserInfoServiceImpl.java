package com.sd.farmework.service.impl; 

import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.SysUserInfoService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.mapper.SysUserInfoMapper; 

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * 组织架构表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysUserInfoServiceImpl extends BaseInfoServiceImpl implements SysUserInfoService{ 
    @Autowired
    private SysUserInfoMapper baseMapper;
    public SysUserInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysUserInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public void updateDepartPower(BaseInfo obj) {
		// TODO Auto-generated method stub
		if("mysql".equals(dbType)){
			  baseMapper.updateDepartPowerForMysql(obj);;
		}else if("oracle".equals(dbType)){
			  baseMapper.updateDepartPower(obj);
		}else if("sqlserver".equals(dbType)){
			  baseMapper.updateDepartPowerForSqlserver(obj);
		}
	}
	/**
	 * 重置密码
	 */
	@Override
	public void updatePwd(BaseInfo obj) {
		// TODO Auto-generated method stub
		if("mysql".equals(dbType)){
			  baseMapper.updatePwdForMysql(obj);;
		}else if("oracle".equals(dbType)){
			  baseMapper.updatePwd(obj);
		}else if("sqlserver".equals(dbType)){
			  baseMapper.updatePwdForSqlserver(obj);
		}
	}
	@Override
	public SysUserInfo queryUserByOpenId(SysUserInfo sysUserInfo)
			throws Exception {
		// TODO Auto-generated method stub
		return this.baseMapper.queryUserByOpenId(sysUserInfo);
	}
	@Override
	public void updateUser(SysUserInfo sysUserInfo) throws Exception {
		// TODO Auto-generated method stub
		this.baseMapper.updateUser(sysUserInfo);
	}
}