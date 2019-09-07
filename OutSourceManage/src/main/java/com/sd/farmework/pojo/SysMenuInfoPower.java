package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * 功能菜单按钮信息表
 * @author Administrator 
 * 
 */ 
public class SysMenuInfoPower extends BaseInfo{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = -8546121529765452021L;
	//主键 
	private String menuId; 
	//菜单名称 
	private String menuName; 
	//菜单描述 
	private String menuDesc; 
	//父菜单编号 
	private String parentFunctionId; 
	//菜单链接地址 
	private String menuUrl; 
	//菜单样式 
	private String menuStyle; 
	//菜单顺序 
	private String menuSeque; 
	//状态（Y正常/N禁用） 
	private String status; 
	//备注 
	private String remark; 
	//创建时间 
	private String createTime; 
	//创建人id 
	private String createUserId; 
	//创建人姓名 
	private String createUserName; 
	//修改时间 
	private String updateTime; 
	//修改人id 
	private String updateUserId; 
	//修改人姓名 
	private String updateUserName; 
    public SysMenuInfoPower(){
	}
    public SysMenuInfoPower(String menuId,String menuName,String menuDesc,String parentFunctionId,String menuUrl,String menuStyle,String menuSeque,String status,String remark,String createTime,String createUserId,String createUserName,String updateTime,String updateUserId,String updateUserName){
		this.menuId=menuId;
		this.menuName=menuName;
		this.menuDesc=menuDesc;
		this.parentFunctionId=parentFunctionId;
		this.menuUrl=menuUrl;
		this.menuStyle=menuStyle;
		this.menuSeque=menuSeque;
		this.status=status;
		this.remark=remark;
		this.createTime=createTime;
		this.createUserId=createUserId;
		this.createUserName=createUserName;
		this.updateTime=updateTime;
		this.updateUserId=updateUserId;
		this.updateUserName=updateUserName;
	}
    public SysMenuInfoPower(String menuName,String menuDesc,String parentFunctionId,String menuUrl,String menuStyle,String menuSeque,String status,String remark,String createTime,String createUserId,String createUserName,String updateTime,String updateUserId,String updateUserName){
		this.menuName=menuName;
		this.menuDesc=menuDesc;
		this.parentFunctionId=parentFunctionId;
		this.menuUrl=menuUrl;
		this.menuStyle=menuStyle;
		this.menuSeque=menuSeque;
		this.status=status;
		this.remark=remark;
		this.createTime=createTime;
		this.createUserId=createUserId;
		this.createUserName=createUserName;
		this.updateTime=updateTime;
		this.updateUserId=updateUserId;
		this.updateUserName=updateUserName;
	}
	public void setMenuId(String menuId){ 
		this.menuId=menuId;
	}
	public String getMenuId(){ 
		return this.menuId;
	}
	public void setMenuName(String menuName){ 
		this.menuName=menuName;
	}
	public String getMenuName(){ 
		return this.menuName;
	}
	public void setMenuDesc(String menuDesc){ 
		this.menuDesc=menuDesc;
	}
	public String getMenuDesc(){ 
		return this.menuDesc;
	}
	public void setParentFunctionId(String parentFunctionId){ 
		this.parentFunctionId=parentFunctionId;
	}
	public String getParentFunctionId(){ 
		return this.parentFunctionId;
	}
	public void setMenuUrl(String menuUrl){ 
		this.menuUrl=menuUrl;
	}
	public String getMenuUrl(){ 
		return this.menuUrl;
	}
	public void setMenuStyle(String menuStyle){ 
		this.menuStyle=menuStyle;
	}
	public String getMenuStyle(){ 
		return this.menuStyle;
	}
	public void setMenuSeque(String menuSeque){ 
		this.menuSeque=menuSeque;
	}
	public String getMenuSeque(){ 
		return this.menuSeque;
	}
	public void setStatus(String status){ 
		this.status=status;
	}
	public String getStatus(){ 
		return this.status;
	}
	public void setRemark(String remark){ 
		this.remark=remark;
	}
	public String getRemark(){ 
		return this.remark;
	}
	@Override
	public String toString() {
		return "SysMenuInfoPower[menuId=" + menuId+",menuName=" + menuName+",menuDesc=" + menuDesc+",parentFunctionId=" + parentFunctionId+",menuUrl=" + menuUrl+",menuStyle=" + menuStyle+",menuSeque=" + menuSeque+",status=" + status+",remark=" + remark+",createTime=" + createTime+",createUserId=" + createUserId+",createUserName=" + createUserName+",updateTime=" + updateTime+",updateUserId=" + updateUserId+",updateUserName=" + updateUserName+"]";
	}
}