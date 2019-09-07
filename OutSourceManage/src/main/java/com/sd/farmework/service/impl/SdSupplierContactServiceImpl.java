package com.sd.farmework.service.impl; 

import com.sd.farmework.service.SdSupplierContactService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.mapper.SdSupplierContactMapper; 

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
 @Service
public class SdSupplierContactServiceImpl extends BaseInfoServiceImpl implements SdSupplierContactService{ 
    @Autowired
    private SdSupplierContactMapper baseMapper;
    public SdSupplierContactMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SdSupplierContactMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
}