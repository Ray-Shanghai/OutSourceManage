package com.sd.farmework.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.mapper.SdFlowConditionDetailMapper;
import com.sd.farmework.mapper.SdFlowInfoMapper;
import com.sd.farmework.mapper.SdFlowDetailMapper;
import com.sd.farmework.mapper.SysFlowTaskMapper;
import com.sd.farmework.pojo.SdFlowConditionDetail;
import com.sd.farmework.pojo.SdFlowDetail;
import com.sd.farmework.pojo.SdFlowInfo;
import com.sd.farmework.pojo.SysFlowTask;
import com.sd.farmework.service.SdFlowDetailService;
import com.sd.farmework.service.SysFlowTaskService;

/** 
 * 系统对用功能表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysFlowTaskServiceImpl extends BaseInfoServiceImpl implements SysFlowTaskService{ 
	 @Autowired
	private SysFlowTaskMapper baseMapper;
    
     
    public SysFlowTaskMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysFlowTaskMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public int addTasked(SysFlowTask sysFlowTask) {
		// TODO Auto-generated method stub
		return baseMapper.addTasked(sysFlowTask);
	}
	@Override
	public List<BaseInfo> queryTaskedList(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		return baseMapper.queryTaskedList( obj);
	}
	 
}