package com.sd.farmework.service.impl; 

import com.sd.farmework.service.SdProductTypeService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.mapper.SdProductTypeMapper; 

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
 @Service
public class SdProductTypeServiceImpl extends BaseInfoServiceImpl implements SdProductTypeService{ 
    @Autowired
    private SdProductTypeMapper baseMapper;
    public SdProductTypeMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SdProductTypeMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
}