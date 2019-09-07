package com.sd.farmework.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.mapper.SdFlowConditionDetailMapper;
import com.sd.farmework.mapper.SdFlowInfoMapper;
import com.sd.farmework.mapper.SdFlowDetailMapper;
import com.sd.farmework.pojo.SdFlowConditionDetail;
import com.sd.farmework.pojo.SdFlowDetail;
import com.sd.farmework.pojo.SdFlowInfo;
import com.sd.farmework.service.SdFlowDetailService;

/** 
 * 系统对用功能表
 * @author Administrator 
 * 
 */ 
 @Service
public class SdFlowDetailServiceImpl extends BaseInfoServiceImpl implements SdFlowDetailService{ 
	 @Autowired
	private SdFlowInfoMapper sdFlowBaseInfoMapper;
    @Autowired
    private SdFlowDetailMapper baseMapper;
    @Autowired
    private SdFlowConditionDetailMapper sdFlowConditionDetailMapper;
    public SdFlowDetailMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SdFlowDetailMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public void updateAll(SdFlowInfo sdFlowInfo,List<SdFlowDetail> sdFlowDetailInfoList){
		// TODO Auto-generated method stub
	//	baseMapper.update(obj);
		
		try {
			String flowInfoId ="";
			if(StringUtil.isNotNullOrBlank(sdFlowInfo.getFlowBaseId())){
				sdFlowBaseInfoMapper.update(sdFlowInfo);
				flowInfoId = sdFlowInfo.getFlowBaseId();
				baseMapper.delete(flowInfoId);
			}else{
				sdFlowBaseInfoMapper.add(sdFlowInfo);
				flowInfoId = sdFlowInfo.getFlowBaseId();
			}
			for (int i = 0; i < sdFlowDetailInfoList.size(); i++) {
				SdFlowDetail sdFlowDetailInfo = sdFlowDetailInfoList.get(i);
				sdFlowDetailInfo.setFlowBaseId(flowInfoId);
				baseMapper.add(sdFlowDetailInfo);
				 
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(BaseInfo obj) throws Exception {
		SdFlowDetail sdFlowDetail=(SdFlowDetail) obj;
		this.baseMapper.delete(sdFlowDetail);
		SdFlowConditionDetail sdFlowConditionDetail=new SdFlowConditionDetail();
		sdFlowConditionDetail.setFlowDetailId(sdFlowDetail.getFlowDetailId());
		this.sdFlowConditionDetailMapper.delete(sdFlowConditionDetail);
	}
}