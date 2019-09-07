package com.sd.farmework.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.mapper.SdFlowConditionDetailMapper;
import com.sd.farmework.mapper.SdFlowDetailMapper;
import com.sd.farmework.mapper.SdFlowInfoMapper;
import com.sd.farmework.pojo.SdFlowConditionDetail;
import com.sd.farmework.pojo.SdFlowDetail;
import com.sd.farmework.pojo.SdFlowInfo;
import com.sd.farmework.service.SdFlowInfoService;

/** 
 * 系统对用功能表
 * @author Administrator 
 * 
 */ 
 @Service
public class SdFlowInfoServiceImpl extends BaseInfoServiceImpl implements SdFlowInfoService{ 
    @Autowired
    private SdFlowInfoMapper baseMapper;
    @Autowired
    private SdFlowDetailMapper sdFlowDetailMapper;
    @Autowired
    private SdFlowConditionDetailMapper sdFlowConditionDetailMapper;
    public SdFlowInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SdFlowInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
    
    @Override
	public void delete(BaseInfo obj) throws Exception {
		SdFlowInfo sdFlowInfo=(SdFlowInfo) obj;
		this.baseMapper.delete(sdFlowInfo);
		SdFlowDetail sdFlowDetail=new SdFlowDetail();
		sdFlowDetail.setFlowBaseId(sdFlowInfo.getFlowBaseId());
		List<BaseInfo>list=this.sdFlowDetailMapper.queryList(sdFlowDetail);
		this.sdFlowDetailMapper.delete(sdFlowDetail);
		for (BaseInfo baseInfo : list) {
			SdFlowDetail sdFlowDetail2=(SdFlowDetail) baseInfo;
			SdFlowConditionDetail sdFlowConditionDetail=new SdFlowConditionDetail();
			sdFlowConditionDetail.setFlowDetailId(sdFlowDetail2.getFlowDetailId());
			this.sdFlowConditionDetailMapper.delete(sdFlowConditionDetail);
		}
	}
}