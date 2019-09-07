package com.sd.farmework.service.impl; 

import com.sd.farmework.service.SysLogInfoService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.mapper.SysLogInfoMapper; 

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * 系统日志表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysLogInfoServiceImpl extends BaseInfoServiceImpl implements SysLogInfoService{ 
    @Autowired
    private SysLogInfoMapper baseMapper;
    public SysLogInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysLogInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
}