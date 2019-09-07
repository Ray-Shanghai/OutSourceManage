package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
public class SdCustomerInfo extends BaseInfo{ 
	//客户主键 
	private int customerId; 
	//客户名称 
	private String customerName; 
	//客户地址 
	private String customerAddress; 
	// 
	private String sdId; 
    public SdCustomerInfo(){
	}
    public SdCustomerInfo(int customerId,String customerName,String customerAddress,String sdId){
		this.customerId=customerId;
		this.customerName=customerName;
		this.customerAddress=customerAddress;
		this.sdId=sdId;
	}
    public SdCustomerInfo(String customerName,String customerAddress,String sdId){
		this.customerName=customerName;
		this.customerAddress=customerAddress;
		this.sdId=sdId;
	}
	public void setcustomerId(int customerId){ 
		this.customerId=customerId;
	}
	public int getcustomerId(){ 
		return this.customerId;
	}
	public void setcustomerName(String customerName){ 
		this.customerName=customerName;
	}
	public String getcustomerName(){ 
		return this.customerName;
	}
	public void setcustomerAddress(String customerAddress){ 
		this.customerAddress=customerAddress;
	}
	public String getcustomerAddress(){ 
		return this.customerAddress;
	}
	public void setsdId(String sdId){ 
		this.sdId=sdId;
	}
	public String getsdId(){ 
		return this.sdId;
	}
	@Override
	public String toString() {
		return "SdCustomerInfo[customerId=" + customerId+",customerName=" + customerName+",customerAddress=" + customerAddress+",sdId=" + sdId+"]";
	}
}