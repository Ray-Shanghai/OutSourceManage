package com.sd.farmework.service.impl; 

import com.sd.farmework.service.SysDictionaryInfoService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.mapper.SysDictionaryInfoMapper; 

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * 数据字典表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysDictionaryInfoServiceImpl extends BaseInfoServiceImpl implements SysDictionaryInfoService{ 
    @Autowired
    private SysDictionaryInfoMapper baseMapper;
    public SysDictionaryInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysDictionaryInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
}