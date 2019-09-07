package com.sd.farmework.service.impl; 

import com.sd.farmework.service.SysApprovenFunctionService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.mapper.SysApprovenFunctionMapper; 

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * 审批功能表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysApprovenFunctionServiceImpl extends BaseInfoServiceImpl implements SysApprovenFunctionService{ 
    @Autowired
    private SysApprovenFunctionMapper baseMapper;
    public SysApprovenFunctionMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysApprovenFunctionMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
}