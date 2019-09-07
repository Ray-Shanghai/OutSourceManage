package com.sd.farmework.service.impl; 

import java.util.List;
import java.util.Map;

import com.sd.farmework.pojo.SdBasicInfo;
import com.sd.farmework.pojo.SdOrderComplain;
import com.sd.farmework.service.SdOrderComplainService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.mapper.SdOrderComplainMapper; 

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
 @Service
public class SdOrderComplainServiceImpl extends BaseInfoServiceImpl implements SdOrderComplainService{ 
    @Autowired
    private SdOrderComplainMapper baseMapper;
    public SdOrderComplainMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SdOrderComplainMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
    @Override
    public List queryOrderCountByStatus(SdOrderComplain sdOrderComplain){
    	List list = getBaseMapper().queryOrderCountByStatusForMysql(sdOrderComplain);
    	return list;
    }
	@Override
	public List<Map<String, Object>> queryComplainForCount(
			Map<String, Object> map) {
		return this.baseMapper.queryComplainForCount(map);
	}
}