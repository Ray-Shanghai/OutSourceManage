package com.sd.farmework.service.impl; 


import com.sd.farmework.service.SdSigninInfoService;

import org.springframework.stereotype.Service; 

import com.sd.farmework.mapper.SdBasicInfoMapper; 
import com.sd.farmework.mapper.SdSigninInfoMapper;

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
 @Service
public class SdSigninInfoServiceImpl extends BaseInfoServiceImpl implements SdSigninInfoService{ 
    @Autowired
    private SdSigninInfoMapper baseMapper;
    public SdSigninInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SdSigninInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
}