package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
public class SdOrderAssign extends BaseInfo{ 
	//订单指派主键 
	private int orderAssignId; 
	//订单主键 
	private String orderId; 
	//指派人 
	private String assignUserId; 
	//接受人 
	private String acceptUserName; 
	//是否查看(0否1是) 
	private String isLook; 
	//查看日期 
	private String lookDate; 
	//指派类型（1采购指派，2检验指派） 
	private String assignType; 
	//系统框架主键 
	private String sdId; 
    public SdOrderAssign(){
	}
    public SdOrderAssign(int orderAssignId,String orderId,String assignUserId,String acceptUserName,String isLook,String lookDate,String assignType,String sdId){
		this.orderAssignId=orderAssignId;
		this.orderId=orderId;
		this.assignUserId=assignUserId;
		this.acceptUserName=acceptUserName;
		this.isLook=isLook;
		this.lookDate=lookDate;
		this.assignType=assignType;
		this.sdId=sdId;
	}
    public SdOrderAssign(String orderId,String assignUserId,String acceptUserName,String isLook,String lookDate,String assignType,String sdId){
		this.orderId=orderId;
		this.assignUserId=assignUserId;
		this.acceptUserName=acceptUserName;
		this.isLook=isLook;
		this.lookDate=lookDate;
		this.assignType=assignType;
		this.sdId=sdId;
	}
	public void setorderAssignId(int orderAssignId){ 
		this.orderAssignId=orderAssignId;
	}
	public int getorderAssignId(){ 
		return this.orderAssignId;
	}
	public void setorderId(String orderId){ 
		this.orderId=orderId;
	}
	public String getorderId(){ 
		return this.orderId;
	}
	public void setassignUserId(String assignUserId){ 
		this.assignUserId=assignUserId;
	}
	public String getassignUserId(){ 
		return this.assignUserId;
	}
	public void setacceptUserName(String acceptUserName){ 
		this.acceptUserName=acceptUserName;
	}
	public String getacceptUserName(){ 
		return this.acceptUserName;
	}
	public void setisLook(String isLook){ 
		this.isLook=isLook;
	}
	public String getisLook(){ 
		return this.isLook;
	}
	public void setlookDate(String lookDate){ 
		this.lookDate=lookDate;
	}
	public String getlookDate(){ 
		return this.lookDate;
	}
	public void setassignType(String assignType){ 
		this.assignType=assignType;
	}
	public String getassignType(){ 
		return this.assignType;
	}
	public void setsdId(String sdId){ 
		this.sdId=sdId;
	}
	public String getsdId(){ 
		return this.sdId;
	}
	@Override
	public String toString() {
		return "SdOrderAssign[orderAssignId=" + orderAssignId+",orderId=" + orderId+",assignUserId=" + assignUserId+",acceptUserName=" + acceptUserName+",isLook=" + isLook+",lookDate=" + lookDate+",assignType=" + assignType+",sdId=" + sdId+"]";
	}
}