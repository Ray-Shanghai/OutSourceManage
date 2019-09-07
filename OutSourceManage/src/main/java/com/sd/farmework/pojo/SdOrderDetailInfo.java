package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
public class SdOrderDetailInfo extends BaseInfo{ 
	//订单明细主键 
	private int detailOrderId; 
	//订单主键 
	private int orderId; 
	//产品主键 
	private int productId; 
	//客户料号 
	private String customerSupplies; 
	//产品代码 
	private String productCode; 
	//产品名称 
	private String productName; 
	//长 
	private String detailLength; 
	//宽 
	private String detailWidth; 
	//高 
	private String detailHeight; 
	//是否带盖(0否,1是) 
	private String isLid; 
	//单价 
	private String price; 
	//数量 
	private String number; 
	//成本价 
	private String costPrice; 
	//类别(product_type.product_type_id) 
	private String productTypeId; 
	//材质(product_grade.product_grade_id) 
	private String productGradeId; 
	//即时库存 
	private String immediatelyInventory; 
	//整单折前金额 
	private String discountBeforeSum; 
	//金额 
	private String money; 
	//税率 
	private String taxRate; 
	//销售税额 
	private String sellTax; 
	//实际含税价 
	private String practicalSellPrice; 
	//价税合计 
	private String priceSellSum; 
	//关联数量 
	private String relevanceNumber; 
	//出库数量 
	private String takeOutNumber; 
	//BOM类别 
	private String bomType; 
	//附件上传地址 
	private String fileUrl; 
	//文件名称 
	private String fileName; 
	//系统框架主键 
	private String sdId; 
    public SdOrderDetailInfo(){
	}
    public SdOrderDetailInfo(int detailOrderId,int orderId,int productId,String customerSupplies,String productCode,String productName,String detailLength,String detailWidth,String detailHeight,String isLid,String price,String number,String costPrice,String productTypeId,String productGradeId,String immediatelyInventory,String discountBeforeSum,String money,String taxRate,String sellTax,String practicalSellPrice,String priceSellSum,String relevanceNumber,String takeOutNumber,String bomType,String fileUrl,String fileName,String sdId){
		this.detailOrderId=detailOrderId;
		this.orderId=orderId;
		this.productId=productId;
		this.customerSupplies=customerSupplies;
		this.productCode=productCode;
		this.productName=productName;
		this.detailLength=detailLength;
		this.detailWidth=detailWidth;
		this.detailHeight=detailHeight;
		this.isLid=isLid;
		this.price=price;
		this.number=number;
		this.costPrice=costPrice;
		this.productTypeId=productTypeId;
		this.productGradeId=productGradeId;
		this.immediatelyInventory=immediatelyInventory;
		this.discountBeforeSum=discountBeforeSum;
		this.money=money;
		this.taxRate=taxRate;
		this.sellTax=sellTax;
		this.practicalSellPrice=practicalSellPrice;
		this.priceSellSum=priceSellSum;
		this.relevanceNumber=relevanceNumber;
		this.takeOutNumber=takeOutNumber;
		this.bomType=bomType;
		this.fileUrl=fileUrl;
		this.fileName=fileName;
		this.sdId=sdId;
	}
    public SdOrderDetailInfo(int orderId,int productId,String customerSupplies,String productCode,String productName,String detailLength,String detailWidth,String detailHeight,String isLid,String price,String number,String costPrice,String productTypeId,String productGradeId,String immediatelyInventory,String discountBeforeSum,String money,String taxRate,String sellTax,String practicalSellPrice,String priceSellSum,String relevanceNumber,String takeOutNumber,String bomType,String fileUrl,String fileName,String sdId){
		this.orderId=orderId;
		this.productId=productId;
		this.customerSupplies=customerSupplies;
		this.productCode=productCode;
		this.productName=productName;
		this.detailLength=detailLength;
		this.detailWidth=detailWidth;
		this.detailHeight=detailHeight;
		this.isLid=isLid;
		this.price=price;
		this.number=number;
		this.costPrice=costPrice;
		this.productTypeId=productTypeId;
		this.productGradeId=productGradeId;
		this.immediatelyInventory=immediatelyInventory;
		this.discountBeforeSum=discountBeforeSum;
		this.money=money;
		this.taxRate=taxRate;
		this.sellTax=sellTax;
		this.practicalSellPrice=practicalSellPrice;
		this.priceSellSum=priceSellSum;
		this.relevanceNumber=relevanceNumber;
		this.takeOutNumber=takeOutNumber;
		this.bomType=bomType;
		this.fileUrl=fileUrl;
		this.fileName=fileName;
		this.sdId=sdId;
	}
	public void setdetailOrderId(int detailOrderId){ 
		this.detailOrderId=detailOrderId;
	}
	public int getdetailOrderId(){ 
		return this.detailOrderId;
	}
	public void setorderId(int orderId){ 
		this.orderId=orderId;
	}
	public int getorderId(){ 
		return this.orderId;
	}
	public void setproductId(int productId){ 
		this.productId=productId;
	}
	public int getproductId(){ 
		return this.productId;
	}
	public void setcustomerSupplies(String customerSupplies){ 
		this.customerSupplies=customerSupplies;
	}
	public String getcustomerSupplies(){ 
		return this.customerSupplies;
	}
	public void setproductCode(String productCode){ 
		this.productCode=productCode;
	}
	public String getproductCode(){ 
		return this.productCode;
	}
	public void setproductName(String productName){ 
		this.productName=productName;
	}
	public String getproductName(){ 
		return this.productName;
	}
	public void setdetailLength(String detailLength){ 
		this.detailLength=detailLength;
	}
	public String getdetailLength(){ 
		return this.detailLength;
	}
	public void setdetailWidth(String detailWidth){ 
		this.detailWidth=detailWidth;
	}
	public String getdetailWidth(){ 
		return this.detailWidth;
	}
	public void setdetailHeight(String detailHeight){ 
		this.detailHeight=detailHeight;
	}
	public String getdetailHeight(){ 
		return this.detailHeight;
	}
	public void setisLid(String isLid){ 
		this.isLid=isLid;
	}
	public String getisLid(){ 
		return this.isLid;
	}
	public void setprice(String price){ 
		this.price=price;
	}
	public String getprice(){ 
		return this.price;
	}
	public void setnumber(String number){ 
		this.number=number;
	}
	public String getnumber(){ 
		return this.number;
	}
	public void setcostPrice(String costPrice){ 
		this.costPrice=costPrice;
	}
	public String getcostPrice(){ 
		return this.costPrice;
	}
	public void setproductTypeId(String productTypeId){ 
		this.productTypeId=productTypeId;
	}
	public String getproductTypeId(){ 
		return this.productTypeId;
	}
	public void setproductGradeId(String productGradeId){ 
		this.productGradeId=productGradeId;
	}
	public String getproductGradeId(){ 
		return this.productGradeId;
	}
	public void setimmediatelyInventory(String immediatelyInventory){ 
		this.immediatelyInventory=immediatelyInventory;
	}
	public String getimmediatelyInventory(){ 
		return this.immediatelyInventory;
	}
	public void setdiscountBeforeSum(String discountBeforeSum){ 
		this.discountBeforeSum=discountBeforeSum;
	}
	public String getdiscountBeforeSum(){ 
		return this.discountBeforeSum;
	}
	public void setmoney(String money){ 
		this.money=money;
	}
	public String getmoney(){ 
		return this.money;
	}
	public void settaxRate(String taxRate){ 
		this.taxRate=taxRate;
	}
	public String gettaxRate(){ 
		return this.taxRate;
	}
	public void setsellTax(String sellTax){ 
		this.sellTax=sellTax;
	}
	public String getsellTax(){ 
		return this.sellTax;
	}
	public void setpracticalSellPrice(String practicalSellPrice){ 
		this.practicalSellPrice=practicalSellPrice;
	}
	public String getpracticalSellPrice(){ 
		return this.practicalSellPrice;
	}
	public void setpriceSellSum(String priceSellSum){ 
		this.priceSellSum=priceSellSum;
	}
	public String getpriceSellSum(){ 
		return this.priceSellSum;
	}
	public void setrelevanceNumber(String relevanceNumber){ 
		this.relevanceNumber=relevanceNumber;
	}
	public String getrelevanceNumber(){ 
		return this.relevanceNumber;
	}
	public void settakeOutNumber(String takeOutNumber){ 
		this.takeOutNumber=takeOutNumber;
	}
	public String gettakeOutNumber(){ 
		return this.takeOutNumber;
	}
	public void setbomType(String bomType){ 
		this.bomType=bomType;
	}
	public String getbomType(){ 
		return this.bomType;
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
	public void setsdId(String sdId){ 
		this.sdId=sdId;
	}
	public String getsdId(){ 
		return this.sdId;
	}
	@Override
	public String toString() {
		return "SdOrderDetailInfo[detailOrderId=" + detailOrderId+",orderId=" + orderId+",productId=" + productId+",customerSupplies=" + customerSupplies+",productCode=" + productCode+",productName=" + productName+",detailLength=" + detailLength+",detailWidth=" + detailWidth+",detailHeight=" + detailHeight+",isLid=" + isLid+",price=" + price+",number=" + number+",costPrice=" + costPrice+",productTypeId=" + productTypeId+",productGradeId=" + productGradeId+",immediatelyInventory=" + immediatelyInventory+",discountBeforeSum=" + discountBeforeSum+",money=" + money+",taxRate=" + taxRate+",sellTax=" + sellTax+",practicalSellPrice=" + practicalSellPrice+",priceSellSum=" + priceSellSum+",relevanceNumber=" + relevanceNumber+",takeOutNumber=" + takeOutNumber+",bomType=" + bomType+",fileUrl=" + fileUrl+",fileName=" + fileName+",sdId=" + sdId+"]";
	}
}