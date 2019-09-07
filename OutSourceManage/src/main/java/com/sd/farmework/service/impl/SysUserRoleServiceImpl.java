package com.sd.farmework.service.impl; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.mapper.SysUserRoleMapper;
import com.sd.farmework.service.SysUserRoleService;

/** 
 * 用户角色映射表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysUserRoleServiceImpl extends BaseInfoServiceImpl implements SysUserRoleService{ 
    @Autowired
    private SysUserRoleMapper baseMapper;
    public SysUserRoleMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysUserRoleMapper baseMapper){
    	this.baseMapper = baseMapper;
    }

}