package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * 数据字典表
 * @author Administrator 
 * 
 */ 
public class SysDictionaryInfo extends BaseInfo{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = -3298630389124389175L;
	//字典主键 
	private String dictionaryId; 
	//字典名称 
	private String dictionaryName; 
	//字典内容描述 
	private String dictionaryDesc; 
	//字典内容类型 
	private String dictionaryTypeId; 

    public SysDictionaryInfo(){
	}
     
	public void setDictionaryId(String dictionaryId){ 
		this.dictionaryId=dictionaryId;
	}
	public String getDictionaryId(){ 
		return this.dictionaryId;
	}
	public void setDictionaryName(String dictionaryName){ 
		this.dictionaryName=dictionaryName;
	}
	public String getDictionaryName(){ 
		return this.dictionaryName;
	}
	public void setDictionaryDesc(String dictionaryDesc){ 
		this.dictionaryDesc=dictionaryDesc;
	}
	public String getDictionaryDesc(){ 
		return this.dictionaryDesc;
	}

	public String getDictionaryTypeId() {
		return dictionaryTypeId;
	}

	public void setDictionaryTypeId(String dictionaryTypeId) {
		this.dictionaryTypeId = dictionaryTypeId;
	}

	@Override
	public String toString() {
		return "SysDictionaryInfo [dictionaryId=" + dictionaryId
				+ ", dictionaryName=" + dictionaryName + ", dictionaryDesc="
				+ dictionaryDesc + ", dictionaryTypeId=" + dictionaryTypeId
				+ "]";
	}
	
 
	 
}