package com.sd.farmework.service; 

import java.util.List;

import com.sd.farmework.pojo.SysDepartInfo;
import com.sd.farmework.pojo.SysRoleInfo;

/** 
 * 团队组织机构表
 * @author Administrator 
 * 
 */ 
public interface SysDepartInfoService  extends BaseInfoService{ 
	public List<SysDepartInfo> getDepartInfoByParentId(SysDepartInfo sysDepartInfo);
	public int getDepartInfoByParentIdCount(SysDepartInfo sysDepartInfo);
	public int getDepartInfoByLikeParentIdCount(SysDepartInfo sysDepartInfo);
	public void addUnit(SysDepartInfo sysdepartInfo);
	public void addUnitDepart(SysDepartInfo sysdepartInfo);
	public void addUnitRole(SysDepartInfo sysdepartInfo);
	public void addDepart(SysDepartInfo sysdepartInfo);
	public void addDepartTeam(SysDepartInfo sysdepartInfo);
	public void addDepartRole(SysDepartInfo sysdepartInfo);
	
	public void addTeam(SysDepartInfo sysdepartInfo);
	public void addTeamRole(SysDepartInfo sysdepartInfo);
	
	public void addRoleUnitRole(SysDepartInfo sysdepartInfo,SysRoleInfo sysRoleInfo ) throws Exception;
	public void updateRole(SysDepartInfo sysdepartInfo,SysRoleInfo sysRoleInfo ,String functionType) throws Exception;

}