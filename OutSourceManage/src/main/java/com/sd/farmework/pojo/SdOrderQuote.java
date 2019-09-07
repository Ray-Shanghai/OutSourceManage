package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
public class SdOrderQuote extends BaseInfo{ 
	//供应商报价主键 
	private int orderQuoteId; 
	//订单主键 
	private String orderId; 
	//接收人信息主键 
	private String orderAssignId; 
	//供应商主键 
	private String providerId; 
	//供应商名称 
	private String providerName; 
	//报价 
	private String doQuote; 
	//附件 
	private String fileUrl; 
	//附件名称 
	private String fileName; 
	//是否成交(0否1是) 
	private String isMake; 
	//成交日期 
	private String makeDate; 
	//系统框架主键 
	private String sdId; 
    public SdOrderQuote(){
	}
    public SdOrderQuote(int orderQuoteId,String orderId,String orderAssignId,String providerId,String providerName,String doQuote,String fileUrl,String fileName,String isMake,String makeDate,String sdId){
		this.orderQuoteId=orderQuoteId;
		this.orderId=orderId;
		this.orderAssignId=orderAssignId;
		this.providerId=providerId;
		this.providerName=providerName;
		this.doQuote=doQuote;
		this.fileUrl=fileUrl;
		this.fileName=fileName;
		this.isMake=isMake;
		this.makeDate=makeDate;
		this.sdId=sdId;
	}
    public SdOrderQuote(String orderId,String orderAssignId,String providerId,String providerName,String doQuote,String fileUrl,String fileName,String isMake,String makeDate,String sdId){
		this.orderId=orderId;
		this.orderAssignId=orderAssignId;
		this.providerId=providerId;
		this.providerName=providerName;
		this.doQuote=doQuote;
		this.fileUrl=fileUrl;
		this.fileName=fileName;
		this.isMake=isMake;
		this.makeDate=makeDate;
		this.sdId=sdId;
	}
	public void setorderQuoteId(int orderQuoteId){ 
		this.orderQuoteId=orderQuoteId;
	}
	public int getorderQuoteId(){ 
		return this.orderQuoteId;
	}
	public void setorderId(String orderId){ 
		this.orderId=orderId;
	}
	public String getorderId(){ 
		return this.orderId;
	}
	public void setorderAssignId(String orderAssignId){ 
		this.orderAssignId=orderAssignId;
	}
	public String getorderAssignId(){ 
		return this.orderAssignId;
	}
	public void setproviderId(String providerId){ 
		this.providerId=providerId;
	}
	public String getproviderId(){ 
		return this.providerId;
	}
	public void setproviderName(String providerName){ 
		this.providerName=providerName;
	}
	public String getproviderName(){ 
		return this.providerName;
	}
	public void setdoQuote(String doQuote){ 
		this.doQuote=doQuote;
	}
	public String getdoQuote(){ 
		return this.doQuote;
	}
	public void setfileUrl(String fileUrl){ 
		this.fileUrl=fileUrl;
	}
	public String getfileUrl(){ 
		return this.fileUrl;
	}
	public void setfileName(String fileName){ 
		this.fileName=fileName;
	}
	public String getfileName(){ 
		return this.fileName;
	}
	public void setisMake(String isMake){ 
		this.isMake=isMake;
	}
	public String getisMake(){ 
		return this.isMake;
	}
	public void setmakeDate(String makeDate){ 
		this.makeDate=makeDate;
	}
	public String getmakeDate(){ 
		return this.makeDate;
	}
	public void setsdId(String sdId){ 
		this.sdId=sdId;
	}
	public String getsdId(){ 
		return this.sdId;
	}
	@Override
	public String toString() {
		return "SdOrderQuote[orderQuoteId=" + orderQuoteId+",orderId=" + orderId+",orderAssignId=" + orderAssignId+",providerId=" + providerId+",providerName=" + providerName+",doQuote=" + doQuote+",fileUrl=" + fileUrl+",fileName=" + fileName+",isMake=" + isMake+",makeDate=" + makeDate+",sdId=" + sdId+"]";
	}
}