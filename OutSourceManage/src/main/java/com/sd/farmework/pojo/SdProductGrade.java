package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
public class SdProductGrade extends BaseInfo{ 
	//产品材质主键 
	private int productGradeId; 
	//材质名称 
	private String productGradeName; 
	//材质序号 
	private String productGradeIndex; 
	// 
	private String sdId; 
    public SdProductGrade(){
	}
    public SdProductGrade(int productGradeId,String productGradeName,String productGradeIndex,String sdId){
		this.productGradeId=productGradeId;
		this.productGradeName=productGradeName;
		this.productGradeIndex=productGradeIndex;
		this.sdId=sdId;
	}
    public SdProductGrade(String productGradeName,String productGradeIndex,String sdId){
		this.productGradeName=productGradeName;
		this.productGradeIndex=productGradeIndex;
		this.sdId=sdId;
	}
	public void setproductGradeId(int productGradeId){ 
		this.productGradeId=productGradeId;
	}
	public int getproductGradeId(){ 
		return this.productGradeId;
	}
	public void setproductGradeName(String productGradeName){ 
		this.productGradeName=productGradeName;
	}
	public String getproductGradeName(){ 
		return this.productGradeName;
	}
	public void setproductGradeIndex(String productGradeIndex){ 
		this.productGradeIndex=productGradeIndex;
	}
	public String getproductGradeIndex(){ 
		return this.productGradeIndex;
	}
	public void setsdId(String sdId){ 
		this.sdId=sdId;
	}
	public String getsdId(){ 
		return this.sdId;
	}
	@Override
	public String toString() {
		return "SdProductGrade[productGradeId=" + productGradeId+",productGradeName=" + productGradeName+",productGradeIndex=" + productGradeIndex+",sdId=" + sdId+"]";
	}
}