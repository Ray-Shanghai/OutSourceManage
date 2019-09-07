package com.sd.farmework.service.impl; 

import java.util.List;

import com.sd.farmework.pojo.SdOrderAssign;
import com.sd.farmework.pojo.SdOrderInfo;
import com.sd.farmework.pojo.SdOrderTrack;
import com.sd.farmework.service.SdOrderAssignService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.mapper.SdOrderAssignMapper; 
import com.sd.farmework.mapper.SdOrderInfoMapper;
import com.sd.farmework.mapper.SdOrderTrackMapper;

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
 @Service
public class SdOrderAssignServiceImpl extends BaseInfoServiceImpl implements SdOrderAssignService{ 
    @Autowired
    private SdOrderAssignMapper baseMapper;
    @Autowired
    private SdOrderTrackMapper sdOrderTrackMapper;
    @Autowired
    private SdOrderInfoMapper sdOrderInfoMapper;
    public SdOrderAssignMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SdOrderAssignMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public void addAssignOrder(SdOrderAssign sdorderassign,
			List<SdOrderAssign> assignList,String userNames) throws Exception {
		//添加指派信息
		this.baseMapper.addBatchForMysql(assignList);
		//修改订单状态
		if(sdorderassign.getassignType().equals("2")){
			SdOrderInfo sdOrderInfo=new SdOrderInfo();
			sdOrderInfo.setorderId(Integer.parseInt(sdorderassign.getorderId()));
			sdOrderInfo.setdataState("7");
			this.sdOrderInfoMapper.updateForMysql(sdOrderInfo);
		}else{
			SdOrderInfo sdOrderInfo=new SdOrderInfo();
			sdOrderInfo.setorderId(Integer.parseInt(sdorderassign.getorderId()));
			sdOrderInfo.setdataState("4");
			this.sdOrderInfoMapper.updateForMysql(sdOrderInfo);
		}
		//订单跟踪
		if(sdorderassign.getassignType().equals("2")){
			SdOrderTrack sdOrderTrack=new SdOrderTrack();
			sdOrderTrack.setorderId(sdorderassign.getorderId());
			sdOrderTrack.setCreateUserId(sdorderassign.getLastUpdateUserId());
			sdOrderTrack.setCreateUserName(sdorderassign.getLastUpdateUserName());
			sdOrderTrack.setdataState("6");
			sdOrderTrack.setdataStateName("检验指派("+userNames+")");
			sdOrderTrackMapper.addForMysql(sdOrderTrack);
		}else{
			SdOrderTrack sdOrderTrack=new SdOrderTrack();
			sdOrderTrack.setorderId(sdorderassign.getorderId());
			sdOrderTrack.setCreateUserId(sdorderassign.getLastUpdateUserId());
			sdOrderTrack.setCreateUserName(sdorderassign.getLastUpdateUserName());
			sdOrderTrack.setdataState("3");
			sdOrderTrack.setdataStateName("采购指派("+userNames+")");
			sdOrderTrackMapper.addForMysql(sdOrderTrack);
		}
	}
}