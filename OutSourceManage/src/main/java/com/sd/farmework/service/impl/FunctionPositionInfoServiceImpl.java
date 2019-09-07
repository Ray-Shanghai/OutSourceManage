package com.sd.farmework.service.impl; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.mapper.PowerPositionInfoMapper;
import com.sd.farmework.service.PowerPositionInfoService;

/** 
 * 系统对用功能表
 * @author Administrator 
 * 
 */ 
 @Service
public class FunctionPositionInfoServiceImpl extends BaseInfoServiceImpl implements PowerPositionInfoService{ 
    @Autowired
    private PowerPositionInfoMapper baseMapper;

	public PowerPositionInfoMapper getBaseMapper() {
		return baseMapper;
	}

	public void setBaseMapper(PowerPositionInfoMapper baseMapper) {
		this.baseMapper = baseMapper;
	}
    
}