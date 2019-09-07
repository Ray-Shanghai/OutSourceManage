package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * 用户角色映射表
 * @author Administrator 
 * 
 */ 
public class SysUserRole extends BaseInfo{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = -8920478027372601656L;
	//用户id 
	private String userId; 
	//角色id 
	private String roleId; 
    public SysUserRole(){
	}
    public SysUserRole(String userId,String roleId){
		this.userId=userId;
		this.roleId=roleId;
	}
    public SysUserRole(String roleId){
		this.roleId=roleId;
	}
	public void setUserId(String userId){ 
		this.userId=userId;
	}
	public String getUserId(){ 
		return this.userId;
	}
	public void setRoleId(String roleId){ 
		this.roleId=roleId;
	}
	public String getRoleId(){ 
		return this.roleId;
	}
	@Override
	public String toString() {
		return "SysUserRole[userId=" + userId+",roleId=" + roleId+"]";
	}
}