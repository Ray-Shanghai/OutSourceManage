package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
public class SdProductInfo extends BaseInfo{ 
	//产品主键 
	private int productId; 
	//客户料号 
	private String customerSupplies; 
	//产品代码 
	private String productCode; 
	//产品名称 
	private String productName; 
	//产品规格 
	private String productStandard; 
	//长 
	private String productLength; 
	//宽 
	private String productWidth; 
	//高 
	private String productHeight; 
	//是否带盖(0否,1是) 
	private String isLid; 
	//成本价 
	private String costPrice; 
	//其他 
	private String productOther; 
	//产品类别编号 
	private String productTypeId; 
	//产品材质编号 
	private String productGradeId; 
	//内径余量长 
	private String productInnerLength; 
	//内径余量宽 
	private String productInnerWidth; 
	//内径余量高 
	private String productInnerHeight; 
	// 
	private String sdId; 
    public SdProductInfo(){
	}
    public SdProductInfo(int productId,String customerSupplies,String productCode,String productName,String productStandard,String productLength,String productWidth,String productHeight,String isLid,String costPrice,String productOther,String productTypeId,String productGradeId,String productInnerLength,String productInnerWidth,String productInnerHeight,String sdId){
		this.productId=productId;
		this.customerSupplies=customerSupplies;
		this.productCode=productCode;
		this.productName=productName;
		this.productStandard=productStandard;
		this.productLength=productLength;
		this.productWidth=productWidth;
		this.productHeight=productHeight;
		this.isLid=isLid;
		this.costPrice=costPrice;
		this.productOther=productOther;
		this.productTypeId=productTypeId;
		this.productGradeId=productGradeId;
		this.productInnerLength=productInnerLength;
		this.productInnerWidth=productInnerWidth;
		this.productInnerHeight=productInnerHeight;
		this.sdId=sdId;
	}
    public SdProductInfo(String customerSupplies,String productCode,String productName,String productStandard,String productLength,String productWidth,String productHeight,String isLid,String costPrice,String productOther,String productTypeId,String productGradeId,String productInnerLength,String productInnerWidth,String productInnerHeight,String sdId){
		this.customerSupplies=customerSupplies;
		this.productCode=productCode;
		this.productName=productName;
		this.productStandard=productStandard;
		this.productLength=productLength;
		this.productWidth=productWidth;
		this.productHeight=productHeight;
		this.isLid=isLid;
		this.costPrice=costPrice;
		this.productOther=productOther;
		this.productTypeId=productTypeId;
		this.productGradeId=productGradeId;
		this.productInnerLength=productInnerLength;
		this.productInnerWidth=productInnerWidth;
		this.productInnerHeight=productInnerHeight;
		this.sdId=sdId;
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
	public void setproductStandard(String productStandard){ 
		this.productStandard=productStandard;
	}
	public String getproductStandard(){ 
		return this.productStandard;
	}
	public void setproductLength(String productLength){ 
		this.productLength=productLength;
	}
	public String getproductLength(){ 
		return this.productLength;
	}
	public void setproductWidth(String productWidth){ 
		this.productWidth=productWidth;
	}
	public String getproductWidth(){ 
		return this.productWidth;
	}
	public void setproductHeight(String productHeight){ 
		this.productHeight=productHeight;
	}
	public String getproductHeight(){ 
		return this.productHeight;
	}
	public void setisLid(String isLid){ 
		this.isLid=isLid;
	}
	public String getisLid(){ 
		return this.isLid;
	}
	public void setcostPrice(String costPrice){ 
		this.costPrice=costPrice;
	}
	public String getcostPrice(){ 
		return this.costPrice;
	}
	public void setproductOther(String productOther){ 
		this.productOther=productOther;
	}
	public String getproductOther(){ 
		return this.productOther;
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
	public void setproductInnerLength(String productInnerLength){ 
		this.productInnerLength=productInnerLength;
	}
	public String getproductInnerLength(){ 
		return this.productInnerLength;
	}
	public void setproductInnerWidth(String productInnerWidth){ 
		this.productInnerWidth=productInnerWidth;
	}
	public String getproductInnerWidth(){ 
		return this.productInnerWidth;
	}
	public void setproductInnerHeight(String productInnerHeight){ 
		this.productInnerHeight=productInnerHeight;
	}
	public String getproductInnerHeight(){ 
		return this.productInnerHeight;
	}
	public void setsdId(String sdId){ 
		this.sdId=sdId;
	}
	public String getsdId(){ 
		return this.sdId;
	}
	@Override
	public String toString() {
		return "SdProductInfo[productId=" + productId+",customerSupplies=" + customerSupplies+",productCode=" + productCode+",productName=" + productName+",productStandard=" + productStandard+",productLength=" + productLength+",productWidth=" + productWidth+",productHeight=" + productHeight+",isLid=" + isLid+",costPrice=" + costPrice+",productOther=" + productOther+",productTypeId=" + productTypeId+",productGradeId=" + productGradeId+",productInnerLength=" + productInnerLength+",productInnerWidth=" + productInnerWidth+",productInnerHeight=" + productInnerHeight+",sdId=" + sdId+"]";
	}
}