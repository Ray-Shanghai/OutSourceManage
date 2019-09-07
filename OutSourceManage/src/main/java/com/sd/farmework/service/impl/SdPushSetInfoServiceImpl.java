package com.sd.farmework.service.impl; 

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service; 
import org.springframework.beans.factory.annotation.Autowired; 

import com.sd.farmework.mapper.SdPushSetInfoMapper;
import com.sd.farmework.service.SdPushSetInfoService;

/** 
 * test
 * @author Administrator 
 * 
 */ 
 @Service
public class SdPushSetInfoServiceImpl extends BaseInfoServiceImpl implements SdPushSetInfoService{ 
    @Autowired
    private SdPushSetInfoMapper baseMapper;
    public SdPushSetInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SdPushSetInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public List<Map<String, Object>> queryUserByOrderOnPush(
			Map<String, Object> strMap) {
		return this.baseMapper.queryUserByOrderOnPush(strMap);
	}
}