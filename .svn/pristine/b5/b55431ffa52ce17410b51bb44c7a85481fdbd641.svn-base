package com.sd.farmework.service.impl; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.farmework.pojo.SdOrderInfo;
import com.sd.farmework.pojo.SdOrderQuote;
import com.sd.farmework.pojo.SdOrderTrack;
import com.sd.farmework.pojo.SdSupplierInfo;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.SdOrderQuoteService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.mapper.SdOrderInfoMapper;
import com.sd.farmework.mapper.SdOrderQuoteMapper; 
import com.sd.farmework.mapper.SdOrderTrackMapper;
import com.sd.farmework.mapper.SdSigninInfoMapper;
import com.sd.farmework.mapper.SdSupplierInfoMapper;
import com.sd.farmework.mapper.SysUserInfoMapper;

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
 @Service
public class SdOrderQuoteServiceImpl extends BaseInfoServiceImpl implements SdOrderQuoteService{ 
    @Autowired
    private SdOrderQuoteMapper baseMapper;
    @Autowired
    private SdOrderTrackMapper sdOrderTrackMapper;
    @Autowired
    private SdOrderInfoMapper sdOrderInfoMapper;
    @Autowired
    private SdSupplierInfoMapper sdSupplierInfoMapper;
    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;
    public SdOrderQuoteMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SdOrderQuoteMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public Map<String,Object> addOrderQuote(SdOrderQuote sdOrderQuote) throws Exception {
		//添加供应商报价信息
		//String[] providerIds= sdOrderQuote.getproviderId().split(",");
		String[] providerNames=sdOrderQuote.getproviderName().split(",");
		StringBuffer SupplierNames=new StringBuffer();//供应商名称
		String[] doQuotes=sdOrderQuote.getdoQuote().split(",");
		List<SdOrderQuote> quoteList=new ArrayList<SdOrderQuote>();
		for (int i = 0; i < doQuotes.length; i++) {
			SupplierNames.append(providerNames[i]);
			SdOrderQuote sdOrderQuote2=new SdOrderQuote();
			//查询该供应商是否存在
			SdSupplierInfo sdSupplierInfo=new SdSupplierInfo();
			sdSupplierInfo.setsupplierName(providerNames[i]);
			SdSupplierInfo oldsdSupplierInfo=(SdSupplierInfo) this.sdSupplierInfoMapper.queryByIdForMysql(sdSupplierInfo);
			if(oldsdSupplierInfo==null){//该供应商不存在那么添加
				sdSupplierInfo.setCreateUserId(sdOrderQuote.getCreateUserId());
				sdSupplierInfo.setCreateUserName(sdOrderQuote.getCreateUserName());
				this.sdSupplierInfoMapper.addForMysql(sdSupplierInfo);
				int providerId=sdSupplierInfo.getsupplierId();//新添加的供应商id
				sdOrderQuote2.setproviderId(providerId+"");
			}else{
				sdOrderQuote2.setproviderId(sdOrderQuote.getproviderId().split(",")[i]);
			}
			sdOrderQuote2.setorderId(sdOrderQuote.getorderId());
			sdOrderQuote2.setproviderName(providerNames[i]);
			sdOrderQuote2.setdoQuote(doQuotes[i]);
			if(StringUtil.isNotNullOrBlank(sdOrderQuote.getfileUrl())&&StringUtil.isNotNullOrBlank(sdOrderQuote.getfileName())){
				sdOrderQuote2.setfileUrl(sdOrderQuote.getfileUrl().split(",")[i]);
				sdOrderQuote2.setfileName(sdOrderQuote.getfileName().split(",")[i]);
			}
			sdOrderQuote2.setCreateUserId(sdOrderQuote.getCreateUserId());
			sdOrderQuote2.setCreateUserName(sdOrderQuote.getCreateUserName());
			quoteList.add(sdOrderQuote2);
		}
		this.baseMapper.addBatchForMysql(quoteList);
		//修改订单状态
		SdOrderInfo sdOrderInfo=new SdOrderInfo();
		sdOrderInfo.setorderId(Integer.parseInt(sdOrderQuote.getorderId()));
		sdOrderInfo.setQuoteStatus("Y");
		sdOrderInfo.setLastUpdateUserId(sdOrderQuote.getLastUpdateUserId());
		sdOrderInfo.setLastUpdateUserName(sdOrderQuote.getLastUpdateUserName());
		sdOrderInfo.setdataState("5");
		this.sdOrderInfoMapper.updateForMysql(sdOrderInfo);
		//订单跟踪
		SdOrderTrack sdOrderTrack=new SdOrderTrack();
		sdOrderTrack.setorderId(sdOrderQuote.getorderId()+"");
		sdOrderTrack.setCreateUserId(sdOrderQuote.getLastUpdateUserId());
		sdOrderTrack.setCreateUserName(sdOrderQuote.getLastUpdateUserName());
		sdOrderTrack.setdataState("4");
		sdOrderTrack.setdataStateName("报价成功(出价方："+SupplierNames.toString()+")");
		sdOrderTrackMapper.addForMysql(sdOrderTrack);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("code", "000");
		map.put("msg", "success");
		return map;
	}
	@Override
	public void updateOrderQuote(SdOrderQuote sdOrderQuote) throws Exception {
		//修改报价信息
		sdOrderQuote.setisMake("1");
		sdOrderQuote.setorderAssignId(sdOrderQuote.getCreateUserId());
		this.baseMapper.updateForMysql(sdOrderQuote);
		SdOrderQuote sdOrderQuote2=(SdOrderQuote) this.baseMapper.queryByIdForMysql(sdOrderQuote);
		//订单跟踪
		SdOrderTrack sdOrderTrack=new SdOrderTrack();
		sdOrderTrack.setorderId(sdOrderQuote.getorderId()+"");
		sdOrderTrack.setCreateUserId(sdOrderQuote.getLastUpdateUserId());
		sdOrderTrack.setCreateUserName(sdOrderQuote.getLastUpdateUserName());
		sdOrderTrack.setdataState("5");
		sdOrderTrack.setdataStateName("报价核定(核定成功："+sdOrderQuote2.getproviderName()+")");
		sdOrderTrackMapper.addForMysql(sdOrderTrack);
		//修改订单信息
		SdOrderInfo sdOrderInfo=new SdOrderInfo();
		sdOrderInfo.setorderId(Integer.parseInt(sdOrderQuote.getorderId()));
		sdOrderInfo.setLastUpdateUserId(sdOrderQuote.getLastUpdateUserId());
		sdOrderInfo.setLastUpdateUserName(sdOrderQuote.getLastUpdateUserName());
		sdOrderInfo.setdataState("6");
		this.sdOrderInfoMapper.updateForMysql(sdOrderInfo);
	}
}