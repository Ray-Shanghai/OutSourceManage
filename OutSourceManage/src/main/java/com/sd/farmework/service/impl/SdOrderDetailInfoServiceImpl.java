package com.sd.farmework.service.impl; 

import com.sd.farmework.service.SdOrderDetailInfoService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.mapper.SdOrderDetailInfoMapper; 

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
 @Service
public class SdOrderDetailInfoServiceImpl extends BaseInfoServiceImpl implements SdOrderDetailInfoService{ 
    @Autowired
    private SdOrderDetailInfoMapper baseMapper;
    public SdOrderDetailInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SdOrderDetailInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
}