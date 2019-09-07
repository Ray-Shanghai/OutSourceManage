package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
public class SdProductMaterials extends BaseInfo{ 
	//产品材料主键 
	private int productMaterialsId; 
	//成本核算主表编号 
	private String productMainId; 
	//主材/辅料 
	private int productMaterialsType; 
	//主材料名称 
	private String productMaterialsName; 
	//部位名称标识（1、2、3...） 
	private String productPositionName; 
	//主材料长 
	private String productMaterialsLength; 
	//主材料宽 
	private String productMaterialsWidth; 
	//主材料厚 
	private String productMaterialsHeight; 
	//数量 
	private String productMaterialsNumber; 
	//单位用量 
	private String productMaterialsUnitConsumption; 
	//含税单价 
	private String productMaterialsTaxPrice; 
	//未税单价 
	private String productMaterialsNoTaxPrice; 
	//单位成本 
	private String productMaterialsUnitCost; 
	// 
	private String sdId; 
    public SdProductMaterials(){
	}
    public SdProductMaterials(int productMaterialsId,String productMainId,int productMaterialsType,String productMaterialsName,String productPositionName,String productMaterialsLength,String productMaterialsWidth,String productMaterialsHeight,String productMaterialsNumber,String productMaterialsUnitConsumption,String productMaterialsTaxPrice,String productMaterialsNoTaxPrice,String productMaterialsUnitCost,String sdId){
		this.productMaterialsId=productMaterialsId;
		this.productMainId=productMainId;
		this.productMaterialsType=productMaterialsType;
		this.productMaterialsName=productMaterialsName;
		this.productPositionName=productPositionName;
		this.productMaterialsLength=productMaterialsLength;
		this.productMaterialsWidth=productMaterialsWidth;
		this.productMaterialsHeight=productMaterialsHeight;
		this.productMaterialsNumber=productMaterialsNumber;
		this.productMaterialsUnitConsumption=productMaterialsUnitConsumption;
		this.productMaterialsTaxPrice=productMaterialsTaxPrice;
		this.productMaterialsNoTaxPrice=productMaterialsNoTaxPrice;
		this.productMaterialsUnitCost=productMaterialsUnitCost;
		this.sdId=sdId;
	}
    public SdProductMaterials(String productMainId,int productMaterialsType,String productMaterialsName,String productPositionName,String productMaterialsLength,String productMaterialsWidth,String productMaterialsHeight,String productMaterialsNumber,String productMaterialsUnitConsumption,String productMaterialsTaxPrice,String productMaterialsNoTaxPrice,String productMaterialsUnitCost,String sdId){
		this.productMainId=productMainId;
		this.productMaterialsType=productMaterialsType;
		this.productMaterialsName=productMaterialsName;
		this.productPositionName=productPositionName;
		this.productMaterialsLength=productMaterialsLength;
		this.productMaterialsWidth=productMaterialsWidth;
		this.productMaterialsHeight=productMaterialsHeight;
		this.productMaterialsNumber=productMaterialsNumber;
		this.productMaterialsUnitConsumption=productMaterialsUnitConsumption;
		this.productMaterialsTaxPrice=productMaterialsTaxPrice;
		this.productMaterialsNoTaxPrice=productMaterialsNoTaxPrice;
		this.productMaterialsUnitCost=productMaterialsUnitCost;
		this.sdId=sdId;
	}
	public void setproductMaterialsId(int productMaterialsId){ 
		this.productMaterialsId=productMaterialsId;
	}
	public int getproductMaterialsId(){ 
		return this.productMaterialsId;
	}
	public void setproductMainId(String productMainId){ 
		this.productMainId=productMainId;
	}
	public String getproductMainId(){ 
		return this.productMainId;
	}
	public void setproductMaterialsType(int productMaterialsType){ 
		this.productMaterialsType=productMaterialsType;
	}
	public int getproductMaterialsType(){ 
		return this.productMaterialsType;
	}
	public void setproductMaterialsName(String productMaterialsName){ 
		this.productMaterialsName=productMaterialsName;
	}
	public String getproductMaterialsName(){ 
		return this.productMaterialsName;
	}
	public void setproductPositionName(String productPositionName){ 
		this.productPositionName=productPositionName;
	}
	public String getproductPositionName(){ 
		return this.productPositionName;
	}
	public void setproductMaterialsLength(String productMaterialsLength){ 
		this.productMaterialsLength=productMaterialsLength;
	}
	public String getproductMaterialsLength(){ 
		return this.productMaterialsLength;
	}
	public void setproductMaterialsWidth(String productMaterialsWidth){ 
		this.productMaterialsWidth=productMaterialsWidth;
	}
	public String getproductMaterialsWidth(){ 
		return this.productMaterialsWidth;
	}
	public void setproductMaterialsHeight(String productMaterialsHeight){ 
		this.productMaterialsHeight=productMaterialsHeight;
	}
	public String getproductMaterialsHeight(){ 
		return this.productMaterialsHeight;
	}
	public void setproductMaterialsNumber(String productMaterialsNumber){ 
		this.productMaterialsNumber=productMaterialsNumber;
	}
	public String getproductMaterialsNumber(){ 
		return this.productMaterialsNumber;
	}
	public void setproductMaterialsUnitConsumption(String productMaterialsUnitConsumption){ 
		this.productMaterialsUnitConsumption=productMaterialsUnitConsumption;
	}
	public String getproductMaterialsUnitConsumption(){ 
		return this.productMaterialsUnitConsumption;
	}
	public void setproductMaterialsTaxPrice(String productMaterialsTaxPrice){ 
		this.productMaterialsTaxPrice=productMaterialsTaxPrice;
	}
	public String getproductMaterialsTaxPrice(){ 
		return this.productMaterialsTaxPrice;
	}
	public void setproductMaterialsNoTaxPrice(String productMaterialsNoTaxPrice){ 
		this.productMaterialsNoTaxPrice=productMaterialsNoTaxPrice;
	}
	public String getproductMaterialsNoTaxPrice(){ 
		return this.productMaterialsNoTaxPrice;
	}
	public void setproductMaterialsUnitCost(String productMaterialsUnitCost){ 
		this.productMaterialsUnitCost=productMaterialsUnitCost;
	}
	public String getproductMaterialsUnitCost(){ 
		return this.productMaterialsUnitCost;
	}
	public void setsdId(String sdId){ 
		this.sdId=sdId;
	}
	public String getsdId(){ 
		return this.sdId;
	}
	@Override
	public String toString() {
		return "SdProductMaterials[productMaterialsId=" + productMaterialsId+",productMainId=" + productMainId+",productMaterialsType=" + productMaterialsType+",productMaterialsName=" + productMaterialsName+",productPositionName=" + productPositionName+",productMaterialsLength=" + productMaterialsLength+",productMaterialsWidth=" + productMaterialsWidth+",productMaterialsHeight=" + productMaterialsHeight+",productMaterialsNumber=" + productMaterialsNumber+",productMaterialsUnitConsumption=" + productMaterialsUnitConsumption+",productMaterialsTaxPrice=" + productMaterialsTaxPrice+",productMaterialsNoTaxPrice=" + productMaterialsNoTaxPrice+",productMaterialsUnitCost=" + productMaterialsUnitCost+",sdId=" + sdId+"]";
	}
}