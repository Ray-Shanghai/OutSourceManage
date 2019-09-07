package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
public class SdOrderComplain extends BaseInfo{ 
	//订单意见投诉主键 
	private int orderComplainId; 
	//订单主键 
	private String orderId; 
	//投诉内容 
	private String complainContent; 
	//订单当前状态 
	private String dataState; 
	//订单当前状态名称 
	private String dataStateName; 
	//系统框架主键 
	private String sdId; 
	//订单数量
	private int complainCount;
	//连表查询订单编号
	private String orderNuber;
	
    
	public String getOrderNuber() {
		return orderNuber;
	}
	public void setOrderNuber(String orderNuber) {
		this.orderNuber = orderNuber;
	}
	public SdOrderComplain(){
	}
    public SdOrderComplain(int orderComplainId,String orderId,String complainContent,String dataState,String dataStateName,String sdId){
		this.orderComplainId=orderComplainId;
		this.orderId=orderId;
		this.complainContent=complainContent;
		this.dataState=dataState;
		this.dataStateName=dataStateName;
		this.sdId=sdId;
	}
    public SdOrderComplain(String orderId,String complainContent,String dataState,String dataStateName,String sdId){
		this.orderId=orderId;
		this.complainContent=complainContent;
		this.dataState=dataState;
		this.dataStateName=dataStateName;
		this.sdId=sdId;
	}
	public void setorderComplainId(int orderComplainId){ 
		this.orderComplainId=orderComplainId;
	}
	public int getorderComplainId(){ 
		return this.orderComplainId;
	}
	public void setorderId(String orderId){ 
		this.orderId=orderId;
	}
	public String getorderId(){ 
		return this.orderId;
	}
	public void setcomplainContent(String complainContent){ 
		this.complainContent=complainContent;
	}
	public String getcomplainContent(){ 
		return this.complainContent;
	}
	public void setdataState(String dataState){ 
		this.dataState=dataState;
	}
	public String getdataState(){ 
		return this.dataState;
	}
	public void setdataStateName(String dataStateName){ 
		this.dataStateName=dataStateName;
	}
	public String getdataStateName(){ 
		return this.dataStateName;
	}
	public void setsdId(String sdId){ 
		this.sdId=sdId;
	}
	public String getsdId(){ 
		return this.sdId;
	}
	public int getComplainCount() {
		return complainCount;
	}
	public void setComplainCount(int complainCount) {
		this.complainCount = complainCount;
	}
	@Override
	public String toString() {
		return "SdOrderComplain[orderComplainId=" + orderComplainId+",orderId=" + orderId+",complainContent=" + complainContent+",dataState=" + dataState+",dataStateName=" + dataStateName+",sdId=" + sdId+"]";
	}
}