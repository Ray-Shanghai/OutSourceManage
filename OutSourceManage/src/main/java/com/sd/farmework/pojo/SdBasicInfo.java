package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
public class SdBasicInfo extends BaseInfo{ 
	//基本类型信息主键 
	private String basicId; 
	//基本类型名称 
	private String basicName; 
	//基本类型（1订单状态） 
	private int basicType; 
	//类型顺序 
	private int basicIndex; 
	//是否是实状态
	private int isVirtual;
	//订单数量
	private Integer orderCount;
    
	public SdBasicInfo(){
	}
    public SdBasicInfo(String basicId,String basicName,int basicType,int basicIndex,int isVirtual){
		this.basicId=basicId;
		this.basicName=basicName;
		this.basicType=basicType;
		this.basicIndex=basicIndex;
		this.isVirtual = isVirtual;
	}
    public SdBasicInfo(String basicName,int basicType,int basicIndex,int isVirtual){
		this.basicName=basicName;
		this.basicType=basicType;
		this.basicIndex=basicIndex;
		this.isVirtual = isVirtual;
	}
	public void setbasicId(String basicId){ 
		this.basicId=basicId;
	}
	public String getbasicId(){ 
		return this.basicId;
	}
	public void setbasicName(String basicName){ 
		this.basicName=basicName;
	}
	public String getbasicName(){ 
		return this.basicName;
	}
	public void setbasicType(int basicType){ 
		this.basicType=basicType;
	}
	public int getbasicType(){ 
		return this.basicType;
	}
	public void setbasicIndex(int basicIndex){ 
		this.basicIndex=basicIndex;
	}
	public int getbasicIndex(){ 
		return this.basicIndex;
	}
	public int getIsVirtual() {
		return isVirtual;
	}
	public void setIsVirtual(int isVirtual) {
		this.isVirtual = isVirtual;
	}
	
	public Integer getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}
	@Override
	public String toString() {
		return "SdBasicInfo [basicId=" + basicId + ", basicName=" + basicName
				+ ", basicType=" + basicType + ", basicIndex=" + basicIndex
				+ ", isVirtual=" + isVirtual + "]";
	}
}