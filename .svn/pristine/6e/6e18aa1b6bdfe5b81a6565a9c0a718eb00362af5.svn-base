package com.sd.farmework.service.impl; 

import java.util.List;
import com.sd.farmework.pojo.SdBasicInfo;
import com.sd.farmework.service.SdBasicInfoService; 
import org.springframework.stereotype.Service; 
import com.sd.farmework.mapper.SdBasicInfoMapper; 
import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
 @Service
public class SdBasicInfoServiceImpl extends BaseInfoServiceImpl implements SdBasicInfoService{ 
    @Autowired
    private SdBasicInfoMapper baseMapper;
    public SdBasicInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SdBasicInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
    @Override
    public List queryOrderCountByStatus(SdBasicInfo sdBasicInfo){
    	List list = getBaseMapper().queryOrderCountByStatusForMysql(sdBasicInfo);
    	return list;
    }
}