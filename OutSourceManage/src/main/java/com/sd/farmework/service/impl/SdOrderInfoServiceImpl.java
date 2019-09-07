package com.sd.farmework.service.impl; 

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.farmework.pojo.SdCustomerInfo;
import com.sd.farmework.pojo.SdOrderComplain;
import com.sd.farmework.pojo.SdOrderDetailInfo;
import com.sd.farmework.pojo.SdOrderInfo;
import com.sd.farmework.pojo.SdOrderTrack;
import com.sd.farmework.pojo.SdProductInfo;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.SdOrderInfoService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.mapper.SdCustomerInfoMapper;
import com.sd.farmework.mapper.SdOrderAssignMapper;
import com.sd.farmework.mapper.SdOrderComplainMapper;
import com.sd.farmework.mapper.SdOrderDetailInfoMapper;
import com.sd.farmework.mapper.SdOrderInfoMapper; 
import com.sd.farmework.mapper.SdOrderTrackMapper;
import com.sd.farmework.mapper.SdProductInfoMapper;
import com.sd.farmework.mapper.SysUserInfoMapper;

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
 @Service
public class SdOrderInfoServiceImpl extends BaseInfoServiceImpl implements SdOrderInfoService{ 
    @Autowired
    private SdOrderInfoMapper baseMapper;
    @Autowired
    private SdOrderDetailInfoMapper sdOrderDetailInfoMapper;
    @Autowired
    private SdProductInfoMapper sdProductInfoMapper;
    @Autowired
    private SdCustomerInfoMapper  sdCustomerInfoMapper;
    @Autowired
    private SdOrderTrackMapper sdOrderTrackMapper;
    @Autowired
    private SdOrderComplainMapper sdOrderComplainMapper;
    @Autowired
    private SdOrderAssignMapper sdOrderAssignMapper;
    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;
    public SdOrderInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SdOrderInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public  Map<String,String> addOrder(SdOrderInfo sdorderinfo,
			SdOrderDetailInfo sdOrderDetailInfo, SdProductInfo sdProductInfo)
			throws Exception {
		SdCustomerInfo sdCustomerInfo=new SdCustomerInfo();
		sdCustomerInfo.setcustomerName(sdorderinfo.getcustomerName());
		String customerId="";
		List<SdCustomerInfo> customerList=this.sdCustomerInfoMapper.queryForMysql(sdCustomerInfo);
		if(customerList==null||customerList.size()==0){
			sdCustomerInfo.setcustomerAddress(sdorderinfo.getcustomerAddress());
			sdCustomerInfo.setCreateUserId(sdorderinfo.getCreateUserId());
			sdCustomerInfo.setCreateUserName(sdorderinfo.getCreateUserName());
			sdCustomerInfo.setCreateDepartId(sdorderinfo.getCreateDepartId());
			sdCustomerInfo.setCreateDepartName(sdorderinfo.getCreateDepartName());
			this.sdCustomerInfoMapper.addForMysql(sdCustomerInfo);
			customerId=sdCustomerInfo.getcustomerId()+"";
		}else{
			customerId=customerList.get(0).getcustomerId()+"";
		}
		//1添加订单 可获取主键值
		String orderCostPrice=sdorderinfo.getcostPrice().split(",")[0];//订单表中的成本价格
		sdorderinfo.setorderNuber(getNowNumber()); //订单编号
		sdorderinfo.setcostPrice(orderCostPrice);
		sdorderinfo.setdataState("2");
		sdorderinfo.setcustomerId(customerId);
		this.baseMapper.addForMysql(sdorderinfo);
		//2添加产品信息 可获取主键值
		String detailCostPrice=sdOrderDetailInfo.getcostPrice().substring(sdOrderDetailInfo.getcostPrice().indexOf(",")+1); //产品成本
		List<SdProductInfo> productList=new ArrayList<SdProductInfo>();
		
		for (int i = 0; i < detailCostPrice.split(",").length; i++) {
			SdProductInfo sdProductInfo2=sdProductInfoMapper.queryProductByName(sdProductInfo.getproductName().split(",")[i]);
			if(sdProductInfo2==null){//如果不存在此产品那么添加
				SdProductInfo newProductInfo=new SdProductInfo();
				if(sdProductInfo.getproductCode().lastIndexOf(",")==sdProductInfo.getproductCode().length()-1){//最后一个没有值
					newProductInfo.setproductCode("");//那么设置为空
				}else{
					newProductInfo.setproductCode(sdProductInfo.getproductCode().split(",")[i]);
				}
				if(sdProductInfo.getcustomerSupplies().lastIndexOf(",")==sdProductInfo.getcustomerSupplies().length()-1){
					newProductInfo.setcustomerSupplies("");
				}else{
					newProductInfo.setcustomerSupplies(sdProductInfo.getcustomerSupplies().split(",")[i]);
				}
				if(sdProductInfo.getproductName().lastIndexOf(",")==sdProductInfo.getproductName().length()-1){
					newProductInfo.setproductName("");
				}else{
					newProductInfo.setproductName(sdProductInfo.getproductName().split(",")[i]);
				}
				if(sdProductInfo.getproductStandard().lastIndexOf(",")==sdProductInfo.getproductStandard().length()-1){
					newProductInfo.setproductStandard(""); //产品规格
				}else{
					newProductInfo.setproductStandard(sdProductInfo.getproductStandard().split(",")[i]); //产品规格
				}
				if(sdProductInfo.getproductOther().lastIndexOf(",")==sdProductInfo.getproductOther().length()-1){
					newProductInfo.setproductOther("");
				}else{
					newProductInfo.setproductOther(sdProductInfo.getproductOther().split(",")[i]);
				}
				if(sdProductInfo.getproductInnerLength().lastIndexOf(",")==sdProductInfo.getproductInnerLength().length()-1){
					newProductInfo.setproductInnerLength("");//内径余量长宽高
				}else{
					newProductInfo.setproductInnerLength(sdProductInfo.getproductInnerLength().split(",")[i]);//内径余量长宽高
				}
				if(sdProductInfo.getproductInnerWidth().lastIndexOf(",")==sdProductInfo.getproductInnerWidth().length()-1){
					newProductInfo.setproductInnerWidth("");
				}else{
					newProductInfo.setproductInnerWidth(sdProductInfo.getproductInnerWidth().split(",")[i]);
				}	
				if(sdProductInfo.getproductInnerHeight().lastIndexOf(",")==sdProductInfo.getproductInnerHeight().length()-1){
					newProductInfo.setproductInnerHeight("");
				}else{
					newProductInfo.setproductInnerHeight(sdProductInfo.getproductInnerHeight().split(",")[i]);
				}	
				//if(!sdProductInfo.getproductStandard().equals(",")){
				//}
				if(sdProductInfo.getproductLength().lastIndexOf(",")==sdProductInfo.getproductLength().length()-1){
					newProductInfo.setproductLength("");
				}else{
					newProductInfo.setproductLength(sdProductInfo.getproductLength().split(",")[i]);
				}
				if(sdProductInfo.getproductWidth().lastIndexOf(",")==sdProductInfo.getproductWidth().length()-1){
					newProductInfo.setproductWidth("");
				}else{
					newProductInfo.setproductWidth(sdProductInfo.getproductWidth().split(",")[i]);
				}
				if(sdProductInfo.getproductHeight().lastIndexOf(",")==sdProductInfo.getproductHeight().length()-1){
					newProductInfo.setproductHeight("");
				}else{
					newProductInfo.setproductHeight(sdProductInfo.getproductHeight().split(",")[i]);
				}
				if(sdProductInfo.getisLid().lastIndexOf(",")==sdProductInfo.getisLid().length()-1){
					newProductInfo.setisLid("");
				}else{
					newProductInfo.setisLid(sdProductInfo.getisLid().split(",")[i]);
				}
				if(detailCostPrice.lastIndexOf(",")==detailCostPrice.length()-1){
					newProductInfo.setcostPrice("");
				}else{
					newProductInfo.setcostPrice(detailCostPrice.split(",")[i]);
				}
				if(sdProductInfo.getproductTypeId().lastIndexOf(",")==sdProductInfo.getproductTypeId().length()-1){
					newProductInfo.setproductTypeId("");
				}else{
					newProductInfo.setproductTypeId(sdProductInfo.getproductTypeId().split(",")[i]);
				}
				if(sdProductInfo.getproductGradeId().lastIndexOf(",")==sdProductInfo.getproductGradeId().length()-1){
					newProductInfo.setproductGradeId("");
				}else{
					newProductInfo.setproductGradeId(sdProductInfo.getproductGradeId().split(",")[i]);
				}
				newProductInfo.setCreateUserId(sdProductInfo.getCreateUserId());
				newProductInfo.setCreateUserName(sdProductInfo.getCreateUserName());
				newProductInfo.setCreateDepartId(sdProductInfo.getCreateDepartId());
				newProductInfo.setCreateDepartName(sdProductInfo.getCreateDepartName());
				this.sdProductInfoMapper.addForMysql(newProductInfo);
				productList.add(newProductInfo);
			}else{
				productList.add(sdProductInfo2);
			}
			
		}
		for (int j = 0; j < productList.size(); j++) {
			//3.添加订单详情
			SdOrderDetailInfo newSdOrderDetailInfo=new SdOrderDetailInfo();
			newSdOrderDetailInfo.setorderId(sdorderinfo.getorderId());
			newSdOrderDetailInfo.setproductId(productList.get(j).getproductId());
			if(sdOrderDetailInfo.getcustomerSupplies().lastIndexOf(",")==sdOrderDetailInfo.getcustomerSupplies().length()-1){
				newSdOrderDetailInfo.setcustomerSupplies("");
			}else{
				newSdOrderDetailInfo.setcustomerSupplies(sdOrderDetailInfo.getcustomerSupplies().split(",")[j]);
			}
			if(sdOrderDetailInfo.getproductCode().lastIndexOf(",")==sdOrderDetailInfo.getproductCode().length()-1){
				newSdOrderDetailInfo.setproductCode("");
			}else{
				newSdOrderDetailInfo.setproductCode(sdOrderDetailInfo.getproductCode().split(",")[j]);
			}
			if(sdOrderDetailInfo.getproductName().lastIndexOf(",")==sdOrderDetailInfo.getproductName().length()-1){
				newSdOrderDetailInfo.setproductName("");
			}else{
				newSdOrderDetailInfo.setproductName(sdOrderDetailInfo.getproductName().split(",")[j]);
			}
			
			newSdOrderDetailInfo.setdetailLength(productList.get(j).getproductLength());
			newSdOrderDetailInfo.setdetailWidth(productList.get(j).getproductWidth());
			newSdOrderDetailInfo.setdetailHeight(productList.get(j).getproductHeight());
			if(sdOrderDetailInfo.getisLid().lastIndexOf(",")==sdOrderDetailInfo.getisLid().length()-1){
				newSdOrderDetailInfo.setisLid("");
			}else{
				newSdOrderDetailInfo.setisLid(sdOrderDetailInfo.getisLid().split(",")[j]);
			}
			if(sdOrderDetailInfo.getprice().lastIndexOf(",")==sdOrderDetailInfo.getprice().length()-1){
				newSdOrderDetailInfo.setprice("");
			}else{
				newSdOrderDetailInfo.setprice(sdOrderDetailInfo.getprice().split(",")[j]);
			}
			if(sdOrderDetailInfo.getnumber().lastIndexOf(",")==sdOrderDetailInfo.getnumber().length()-1){
				newSdOrderDetailInfo.setnumber("");
			}else{
				newSdOrderDetailInfo.setnumber(sdOrderDetailInfo.getnumber().split(",")[j]);
			}
			newSdOrderDetailInfo.setcostPrice(productList.get(j).getcostPrice());
			if(sdOrderDetailInfo.getproductTypeId().lastIndexOf(",")==sdOrderDetailInfo.getproductTypeId().length()-1){
				newSdOrderDetailInfo.setproductTypeId("");
			}else{
				newSdOrderDetailInfo.setproductTypeId(sdOrderDetailInfo.getproductTypeId().split(",")[j]);
			}
			if(sdOrderDetailInfo.getproductGradeId().lastIndexOf(",")==sdOrderDetailInfo.getproductGradeId().length()-1){
				newSdOrderDetailInfo.setproductGradeId("");
			}else{
				newSdOrderDetailInfo.setproductGradeId(sdOrderDetailInfo.getproductGradeId().split(",")[j]);
			}
			if(sdOrderDetailInfo.getimmediatelyInventory().lastIndexOf(",")==sdOrderDetailInfo.getimmediatelyInventory().length()-1){
				newSdOrderDetailInfo.setimmediatelyInventory("");
			}else{
				newSdOrderDetailInfo.setimmediatelyInventory(sdOrderDetailInfo.getimmediatelyInventory().split(",")[j]);
			}
			if(sdOrderDetailInfo.getdiscountBeforeSum().lastIndexOf(",")==sdOrderDetailInfo.getdiscountBeforeSum().length()-1){
				newSdOrderDetailInfo.setdiscountBeforeSum("");
			}else{
				newSdOrderDetailInfo.setdiscountBeforeSum(sdOrderDetailInfo.getdiscountBeforeSum().split(",")[j]);
			}
			if(sdOrderDetailInfo.getmoney().lastIndexOf(",")==sdOrderDetailInfo.getmoney().length()-1){
				newSdOrderDetailInfo.setmoney("");
			}else{
				newSdOrderDetailInfo.setmoney(sdOrderDetailInfo.getmoney().split(",")[j]);
			}
			if(sdOrderDetailInfo.gettaxRate().lastIndexOf(",")==sdOrderDetailInfo.gettaxRate().length()-1){
				newSdOrderDetailInfo.settaxRate("");
			}else{
				newSdOrderDetailInfo.settaxRate(sdOrderDetailInfo.gettaxRate().split(",")[j]);
			}
			if(sdOrderDetailInfo.getsellTax().lastIndexOf(",")==sdOrderDetailInfo.getsellTax().length()-1){
				newSdOrderDetailInfo.setsellTax("");
			}else{
				newSdOrderDetailInfo.setsellTax(sdOrderDetailInfo.getsellTax().split(",")[j]);
			}
			if(sdOrderDetailInfo.getpracticalSellPrice().lastIndexOf(",")==sdOrderDetailInfo.getpracticalSellPrice().length()-1){
				newSdOrderDetailInfo.setpracticalSellPrice("");
			}else{
				newSdOrderDetailInfo.setpracticalSellPrice(sdOrderDetailInfo.getpracticalSellPrice().split(",")[j]);
			}
			if(sdOrderDetailInfo.getpriceSellSum().lastIndexOf(",")==sdOrderDetailInfo.getpriceSellSum().length()-1){
				newSdOrderDetailInfo.setpriceSellSum("");
			}else{
				newSdOrderDetailInfo.setpriceSellSum(sdOrderDetailInfo.getpriceSellSum().split(",")[j]);
			}
			if(sdOrderDetailInfo.getrelevanceNumber().lastIndexOf(",")==sdOrderDetailInfo.getrelevanceNumber().length()-1){
				newSdOrderDetailInfo.setrelevanceNumber("");
			}else{
				newSdOrderDetailInfo.setrelevanceNumber(sdOrderDetailInfo.getrelevanceNumber().split(",")[j]);
			}
			if(sdOrderDetailInfo.gettakeOutNumber().lastIndexOf(",")==sdOrderDetailInfo.gettakeOutNumber().length()-1){
				newSdOrderDetailInfo.settakeOutNumber("");
			}else{
				newSdOrderDetailInfo.settakeOutNumber(sdOrderDetailInfo.gettakeOutNumber().split(",")[j]);
			}
			if(sdOrderDetailInfo.getbomType().lastIndexOf(",")==sdOrderDetailInfo.getbomType().length()-1){
				newSdOrderDetailInfo.setbomType("");
			}else{
				newSdOrderDetailInfo.setbomType(sdOrderDetailInfo.getbomType().split(",")[j]);
			}
			//如果没有上传文件那么不添加文件信息
			if(StringUtil.isNotNullOrBlank(sdOrderDetailInfo.getfileUrl())&&StringUtil.isNotNullOrBlank(sdOrderDetailInfo.getfileName())){
				if(sdOrderDetailInfo.getfileUrl().lastIndexOf(",")==sdOrderDetailInfo.getfileUrl().length()-1){
					newSdOrderDetailInfo.setfileUrl("");
				}else{
					newSdOrderDetailInfo.setfileUrl(sdOrderDetailInfo.getfileUrl().split(",")[j]);
				}
				if(sdOrderDetailInfo.getfileName().lastIndexOf(",")==sdOrderDetailInfo.getfileName().length()-1){
					newSdOrderDetailInfo.setfileName("");
				}else{
					newSdOrderDetailInfo.setfileName(sdOrderDetailInfo.getfileName().split(",")[j]);
				}
			}
			newSdOrderDetailInfo.setCreateUserId(sdOrderDetailInfo.getCreateUserId());
			newSdOrderDetailInfo.setCreateUserName(sdOrderDetailInfo.getCreateUserName());
			newSdOrderDetailInfo.setCreateDepartId(sdOrderDetailInfo.getCreateDepartId());
			newSdOrderDetailInfo.setCreateDepartName(sdOrderDetailInfo.getCreateDepartName());
			this.sdOrderDetailInfoMapper.addForMysql(newSdOrderDetailInfo);
		}
		
		//订单跟踪
			SdOrderTrack sdOrderTrack=new SdOrderTrack();
			sdOrderTrack.setorderId(sdorderinfo.getorderId()+"");
			sdOrderTrack.setCreateUserId(sdorderinfo.getLastUpdateUserId());
			sdOrderTrack.setCreateUserName(sdorderinfo.getLastUpdateUserName());
			sdOrderTrack.setdataState("2");
			SysUserInfo jianyanUser=(SysUserInfo) this.sysUserInfoMapper.queryByPkIdForMysql(sdorderinfo.getcheckoutUserId());//检验经理
			SysUserInfo caigouUser=(SysUserInfo) this.sysUserInfoMapper.queryByPkIdForMysql(sdorderinfo.getprocurementUserId());//采购经理
			sdOrderTrack.setdataStateName("新建订单(采购经理："+caigouUser.getUserName()+",检验经理："+jianyanUser.getUserName()+")");
			sdOrderTrackMapper.addForMysql(sdOrderTrack);
			
			 Map<String,String> map =new HashMap<String, String>();
			 map.put("code", "000");
			 map.put("msg", "success");
			 return map;
	}
	/**
	 * 获取订单编号
	 * */
	public String getNowNumber()throws Exception{
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyMMdd");
			String nowdate="AJ"+sdf.format(date);
			String orderNuber=this.baseMapper.queryMaxOrderNuber(nowdate);
			String newOrderNuber="";
			if(StringUtil.isNotNullOrBlank(orderNuber)){
				newOrderNuber=orderNuber.substring(8);
				int i=Integer.parseInt(newOrderNuber);
				String str=(i+1)+"";
				if(str.length()==1){
					newOrderNuber=nowdate+"00"+str;
				}else if(str.length()==2){
					newOrderNuber=nowdate+"0"+str;
				}else{
					newOrderNuber=nowdate+str;
				}
			}else{
				newOrderNuber=nowdate+"001";
			}
			return newOrderNuber; 
	}
	@Override
	public Map<String,String> addcomfirmOrderInfo(SdOrderInfo sdorderinfo) throws Exception {
		//订单确认
		sdorderinfo.setConfirmUserId(sdorderinfo.getLastUpdateUserId());//获取确认人编号
		this.baseMapper.updateForMysql(sdorderinfo);
		//订单跟踪
		SdOrderTrack sdOrderTrack=new SdOrderTrack();
		sdOrderTrack.setorderId(sdorderinfo.getorderId()+"");
		sdOrderTrack.setCreateUserId(sdorderinfo.getLastUpdateUserId());
		sdOrderTrack.setCreateUserName(sdorderinfo.getLastUpdateUserName());
		sdOrderTrack.setdataState("2");
		sdOrderTrack.setdataStateName("订单确认");
		sdOrderTrackMapper.addForMysql(sdOrderTrack);
		 Map<String,String> map =new HashMap<String, String>();
		 map.put("code", "000");
		 map.put("msg", "success");
		 return map;
	}
	@Override
	public Map<String,String> editOrder(SdOrderInfo sdorderinfo,SdOrderComplain sdOrderComplain) throws Exception {
		
		//订单跟踪
		SdOrderTrack sdOrderTrack=new SdOrderTrack();
		sdOrderTrack.setorderId(sdorderinfo.getorderId()+"");
		sdOrderTrack.setRemark(sdorderinfo.getRemark());
		sdOrderTrack.setCreateUserId(sdorderinfo.getLastUpdateUserId());
		sdOrderTrack.setCreateUserName(sdorderinfo.getLastUpdateUserName());
		int state=Integer.parseInt(sdorderinfo.getdataState());
		switch (state) {
		case 7:
			sdOrderTrack.setdataState("7");
			sdOrderTrack.setdataStateName("配料");
			sdOrderComplain.setdataState("7");
			sdOrderComplain.setdataStateName("配料");
			sdorderinfo.setdataState("7");
			break;
		case 8:
			sdOrderTrack.setdataState("8");
			sdOrderTrack.setdataStateName("裁切");
			sdOrderComplain.setdataState("8");
			sdOrderComplain.setdataStateName("裁切");
			sdorderinfo.setdataState("8");
			break;
		case 9:
			sdOrderTrack.setdataState("9");
			sdOrderTrack.setdataStateName("生产");
			sdOrderComplain.setdataState("9");
			sdOrderComplain.setdataStateName("生产");
			sdorderinfo.setdataState("9");
			break;
		case 10:
			sdOrderTrack.setdataState("10");
			sdOrderTrack.setdataStateName("完成");
			sdOrderComplain.setdataState("10");
			sdOrderComplain.setdataStateName("完成");
			sdorderinfo.setdataState("10");
			break;
		case 11:
			sdOrderTrack.setdataState("11");
			sdOrderTrack.setdataStateName("验收通过");
			sdOrderComplain.setdataState("11");
			sdOrderComplain.setdataStateName("验收通过");
			sdorderinfo.setdataState("11");
			break;
		case 12:
			sdOrderTrack.setdataState("12");
			sdOrderTrack.setdataStateName("完结");
			sdOrderComplain.setdataState("12");
			sdOrderComplain.setdataStateName("完结");
			//如果完结将状态设为N
			sdorderinfo.setStatus("N");
			break;
		case 13:
			sdOrderTrack.setdataState("13");
			sdOrderTrack.setdataStateName("订单异常");
			//如果订单异常那么订单重新进入核价阶段
			sdorderinfo.setdataState("5");
			sdOrderComplain.setdataState("13");
			sdOrderComplain.setdataStateName("订单异常");
			break;
		default:
			sdOrderTrack.setdataState("14");
			sdOrderTrack.setdataStateName("验收不通过");
			//如果验收不通过那么状态回到验收阶段
			sdorderinfo.setdataState("14");
			sdOrderComplain.setdataState("14");
			sdOrderComplain.setdataStateName("验收不通过");
			break;
		}
		sdOrderTrackMapper.addForMysql(sdOrderTrack);
		//投诉建议
		if(StringUtil.isNotNullOrBlank(sdOrderComplain.getcomplainContent())){//判断建议内容是否为空
			sdOrderComplain.setorderId(sdorderinfo.getorderId()+"");
			sdOrderComplainMapper.addForMysql(sdOrderComplain);
		}
		//修改订单信息
		this.baseMapper.updateForMysql(sdorderinfo);
		 Map<String,String> map =new HashMap<String, String>();
		 map.put("code", "000");
		 map.put("msg", "success");
		 return map;
	}
	@Override
	public List<SdOrderInfo> queryListByTrack(SdOrderInfo sdOrderInfo)
			throws Exception {
		return this.baseMapper.queryListByTrack(sdOrderInfo);
	}
	@Override
	public Integer queryCountByTrack(SdOrderInfo sdOrderInfo) throws Exception {
		return this.baseMapper.queryCountByTrack(sdOrderInfo);
	}
	
	@Override
	public Map<String, Object> deleteOrderInfo(SdOrderInfo sdOrderInfo,SysUserInfo user)
			throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		/*this.sdOrderComplainMapper.deleteForMysql(sdOrderInfo);
		this.sdOrderTrackMapper.deleteForMysql(sdOrderInfo);
		this.sdOrderAssignMapper.deleteForMysql(sdOrderInfo);
		this.sdOrderDetailInfoMapper.deleteForMysql(sdOrderInfo);
		this.baseMapper.deleteForMysql(sdOrderInfo);*/
		//逻辑删除，修改订单状态为废弃
		sdOrderInfo.setStatus("F");
		sdOrderInfo.setdataState("16");
		this.baseMapper.updateForMysql(sdOrderInfo);
		//添加订单跟踪
		SdOrderTrack sdOrderTrack=new SdOrderTrack();
		sdOrderTrack.setorderId(sdOrderInfo.getorderId()+"");
		sdOrderTrack.setCreateUserId(user.getUserId());
		sdOrderTrack.setCreateUserName(user.getUserName());
		sdOrderTrack.setdataState("16");
		sdOrderTrack.setdataStateName("废弃订单");
		sdOrderTrackMapper.addForMysql(sdOrderTrack);
		map.put("code", "000");
		map.put("msg", "success");
		return map;
	}
	@Override
	public Map<String, Object> editOrderInfo(SdOrderInfo sdOrderInfo,SdOrderDetailInfo sdOrderDetailInfo,String detailIds,String position)
			throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		if("2".equals(position)||"3".equals(position)||"4".equals(position)||"5".equals(position)){//此职位人员无法修改成本价格
			sdOrderInfo.setcommercialPrice(null);
			sdOrderInfo.setCustomerNo(null);
			sdOrderInfo.setcostPrice(null);
		}else{
			sdOrderInfo.setcostPrice(sdOrderInfo.getcostPrice().split(",")[0]);//订单成本
		}
		this.baseMapper.updateOrderInfo(sdOrderInfo);
		
		if(StringUtil.isNotNullOrBlank(detailIds)){
			String[] detailId =detailIds.split(",");
			for (int j = 0; j < detailId.length; j++) {
				SdOrderDetailInfo newSdOrderDetailInfo=new SdOrderDetailInfo();
				newSdOrderDetailInfo.setdetailOrderId(Integer.parseInt(detailId[j]));
				if(sdOrderDetailInfo.getcustomerSupplies().lastIndexOf(",")==sdOrderDetailInfo.getcustomerSupplies().length()-1){
					newSdOrderDetailInfo.setcustomerSupplies("");
				}else{
					newSdOrderDetailInfo.setcustomerSupplies(sdOrderDetailInfo.getcustomerSupplies().split(",")[j]);
				}
				if(sdOrderDetailInfo.getproductCode().lastIndexOf(",")==sdOrderDetailInfo.getproductCode().length()-1){
					newSdOrderDetailInfo.setproductCode("");
				}else{
					newSdOrderDetailInfo.setproductCode(sdOrderDetailInfo.getproductCode().split(",")[j]);
				}
				if(sdOrderDetailInfo.getproductName().lastIndexOf(",")==sdOrderDetailInfo.getproductName().length()-1){
					newSdOrderDetailInfo.setproductName("");
				}else{
					newSdOrderDetailInfo.setproductName(sdOrderDetailInfo.getproductName().split(",")[j]);
				}
				if(sdOrderDetailInfo.getdetailLength().lastIndexOf(",")==sdOrderDetailInfo.getdetailLength().length()-1){
					newSdOrderDetailInfo.setdetailLength("");
				}else{
					newSdOrderDetailInfo.setdetailLength(sdOrderDetailInfo.getdetailLength().split(",")[j]);
				}
				if(sdOrderDetailInfo.getdetailWidth().lastIndexOf(",")==sdOrderDetailInfo.getdetailWidth().length()-1){
					newSdOrderDetailInfo.setdetailWidth("");
				}else{
					newSdOrderDetailInfo.setdetailWidth(sdOrderDetailInfo.getdetailWidth().split(",")[j]);
				}
				if(sdOrderDetailInfo.getdetailHeight().lastIndexOf(",")==sdOrderDetailInfo.getdetailHeight().length()-1){
					newSdOrderDetailInfo.setdetailHeight("");
				}else{
					newSdOrderDetailInfo.setdetailHeight(sdOrderDetailInfo.getdetailHeight().split(",")[j]);
				}
				if(sdOrderDetailInfo.getisLid().lastIndexOf(",")==sdOrderDetailInfo.getisLid().length()-1){
					newSdOrderDetailInfo.setisLid("");
				}else{
					newSdOrderDetailInfo.setisLid(sdOrderDetailInfo.getisLid().split(",")[j]);
				}
				if(sdOrderDetailInfo.getprice().lastIndexOf(",")==sdOrderDetailInfo.getprice().length()-1){
					newSdOrderDetailInfo.setprice("");
				}else{
					newSdOrderDetailInfo.setprice(sdOrderDetailInfo.getprice().split(",")[j]);
				}
				if(sdOrderDetailInfo.getnumber().lastIndexOf(",")==sdOrderDetailInfo.getnumber().length()-1){
					newSdOrderDetailInfo.setnumber("");
				}else{
					newSdOrderDetailInfo.setnumber(sdOrderDetailInfo.getnumber().split(",")[j]);
				}
				if("2".equals(position)||"3".equals(position)||"4".equals(position)||"5".equals(position)){//此职位人员无法修改成本价格
					newSdOrderDetailInfo.setcostPrice(null);
				}else{
					String detailCostPrice=sdOrderDetailInfo.getcostPrice().substring(sdOrderDetailInfo.getcostPrice().indexOf(",")+1);//详情成本
					newSdOrderDetailInfo.setcostPrice(detailCostPrice.split(",")[j]);
				}
				if(sdOrderDetailInfo.getproductTypeId().lastIndexOf(",")==sdOrderDetailInfo.getproductTypeId().length()-1){
					newSdOrderDetailInfo.setproductTypeId("");
				}else{
					newSdOrderDetailInfo.setproductTypeId(sdOrderDetailInfo.getproductTypeId().split(",")[j]);
				}
				if(sdOrderDetailInfo.getproductGradeId().lastIndexOf(",")==sdOrderDetailInfo.getproductGradeId().length()-1){
					newSdOrderDetailInfo.setproductGradeId("");
				}else{
					newSdOrderDetailInfo.setproductGradeId(sdOrderDetailInfo.getproductGradeId().split(",")[j]);
				}
				if(sdOrderDetailInfo.getimmediatelyInventory().lastIndexOf(",")==sdOrderDetailInfo.getimmediatelyInventory().length()-1){
					newSdOrderDetailInfo.setimmediatelyInventory("");
				}else{
					newSdOrderDetailInfo.setimmediatelyInventory(sdOrderDetailInfo.getimmediatelyInventory().split(",")[j]);
				}
				if(sdOrderDetailInfo.getdiscountBeforeSum().lastIndexOf(",")==sdOrderDetailInfo.getdiscountBeforeSum().length()-1){
					newSdOrderDetailInfo.setdiscountBeforeSum("");
				}else{
					newSdOrderDetailInfo.setdiscountBeforeSum(sdOrderDetailInfo.getdiscountBeforeSum().split(",")[j]);
				}
				if(sdOrderDetailInfo.getmoney().lastIndexOf(",")==sdOrderDetailInfo.getmoney().length()-1){
					newSdOrderDetailInfo.setmoney("");
				}else{
					newSdOrderDetailInfo.setmoney(sdOrderDetailInfo.getmoney().split(",")[j]);
				}
				if(sdOrderDetailInfo.gettaxRate().lastIndexOf(",")==sdOrderDetailInfo.gettaxRate().length()-1){
					newSdOrderDetailInfo.settaxRate("");
				}else{
					newSdOrderDetailInfo.settaxRate(sdOrderDetailInfo.gettaxRate().split(",")[j]);
				}
				if(sdOrderDetailInfo.getsellTax().lastIndexOf(",")==sdOrderDetailInfo.getsellTax().length()-1){
					newSdOrderDetailInfo.setsellTax("");
				}else{
					newSdOrderDetailInfo.setsellTax(sdOrderDetailInfo.getsellTax().split(",")[j]);
				}
				if(sdOrderDetailInfo.getpracticalSellPrice().lastIndexOf(",")==sdOrderDetailInfo.getpracticalSellPrice().length()-1){
					newSdOrderDetailInfo.setpracticalSellPrice("");
				}else{
					newSdOrderDetailInfo.setpracticalSellPrice(sdOrderDetailInfo.getpracticalSellPrice().split(",")[j]);
				}
				if(sdOrderDetailInfo.getpriceSellSum().lastIndexOf(",")==sdOrderDetailInfo.getpriceSellSum().length()-1){
					newSdOrderDetailInfo.setpriceSellSum("");
				}else{
					newSdOrderDetailInfo.setpriceSellSum(sdOrderDetailInfo.getpriceSellSum().split(",")[j]);
				}
				if(sdOrderDetailInfo.getrelevanceNumber().lastIndexOf(",")==sdOrderDetailInfo.getrelevanceNumber().length()-1){
					newSdOrderDetailInfo.setrelevanceNumber("");
				}else{
					newSdOrderDetailInfo.setrelevanceNumber(sdOrderDetailInfo.getrelevanceNumber().split(",")[j]);
				}
				if(sdOrderDetailInfo.gettakeOutNumber().lastIndexOf(",")==sdOrderDetailInfo.gettakeOutNumber().length()-1){
					newSdOrderDetailInfo.settakeOutNumber("");
				}else{
					newSdOrderDetailInfo.settakeOutNumber(sdOrderDetailInfo.gettakeOutNumber().split(",")[j]);
				}
				if(sdOrderDetailInfo.getbomType().lastIndexOf(",")==sdOrderDetailInfo.getbomType().length()-1){
					newSdOrderDetailInfo.setbomType("");
				}else{
					newSdOrderDetailInfo.setbomType(sdOrderDetailInfo.getbomType().split(",")[j]);
				}
				//如果没有上传文件那么不添加文件信息
				if(StringUtil.isNotNullOrBlank(sdOrderDetailInfo.getfileUrl())&&StringUtil.isNotNullOrBlank(sdOrderDetailInfo.getfileName())){
					if(sdOrderDetailInfo.getfileUrl().lastIndexOf(",")==sdOrderDetailInfo.getfileUrl().length()-1){
						newSdOrderDetailInfo.setfileUrl("");
					}else{
						newSdOrderDetailInfo.setfileUrl(sdOrderDetailInfo.getfileUrl().split(",")[j]);
					}
					if(sdOrderDetailInfo.getfileName().lastIndexOf(",")==sdOrderDetailInfo.getfileName().length()-1){
						newSdOrderDetailInfo.setfileName("");
					}else{
						newSdOrderDetailInfo.setfileName(sdOrderDetailInfo.getfileName().split(",")[j]);
					}
				}
				newSdOrderDetailInfo.setLastUpdateTime(sdOrderDetailInfo.getLastUpdateTime());
				newSdOrderDetailInfo.setLastUpdateUserId(sdOrderDetailInfo.getLastUpdateUserId());
				newSdOrderDetailInfo.setLastUpdateUserName(sdOrderDetailInfo.getLastUpdateUserName());
				this.sdOrderDetailInfoMapper.updateForMysql(newSdOrderDetailInfo);
			}
			
		}
		map.put("code", "000");
		map.put("msg", "success");
		return map;
	}
	@Override
	public List<SdOrderInfo> queryListByWxPage(SdOrderInfo sdOrderInfo)
			throws Exception {
		return this.baseMapper.queryListByWxPage(sdOrderInfo);
	}
	@Override
	public Integer queryCountByWxPage(SdOrderInfo sdOrderInfo) throws Exception {
		return this.baseMapper.queryCountByWxPage(sdOrderInfo);
	}
}