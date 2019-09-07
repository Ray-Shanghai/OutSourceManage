package com.sd.farmework.mapper; 

import java.util.List;

import com.sd.farmework.pojo.SysDepartInfo;

/** 
 * 团队组织机构表
 * @author Administrator 
 * 
 */ 
public interface SysDepartInfoMapper  extends BaseMapper{
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
	public void addRoleUnitRole(SysDepartInfo sysdepartInfo);
	
	
	public List<SysDepartInfo> getDepartInfoByParentIdForMysql(SysDepartInfo sysDepartInfo);
	public int getDepartInfoByParentIdCountForMysql(SysDepartInfo sysDepartInfo);
	public int getDepartInfoByLikeParentIdCountForMysql(SysDepartInfo sysDepartInfo);
	public void addUnitForMysql(SysDepartInfo sysdepartInfo);
	public void addUnitDepartForMysql(SysDepartInfo sysdepartInfo);
	public void addUnitRoleForMysql(SysDepartInfo sysdepartInfo);
	public void addDepartForMysql(SysDepartInfo sysdepartInfo);
	public void addDepartTeamForMysql(SysDepartInfo sysdepartInfo);
	public void addDepartRoleForMysql(SysDepartInfo sysdepartInfo);
	public void addTeamForMysql(SysDepartInfo sysdepartInfo);
	public void addTeamRoleForMysql(SysDepartInfo sysdepartInfo);
	public void addRoleUnitRoleForMysql(SysDepartInfo sysdepartInfo);
	
	public List<SysDepartInfo> getDepartInfoByParentIdForSqlserver(SysDepartInfo sysDepartInfo);
	public int getDepartInfoByParentIdCountForSqlserver(SysDepartInfo sysDepartInfo);
	public int getDepartInfoByLikeParentIdCountForSqlserver(SysDepartInfo sysDepartInfo);
	public void addUnitForSqlserver(SysDepartInfo sysdepartInfo);
	public void addUnitDepartForSqlserver(SysDepartInfo sysdepartInfo);
	public void addUnitRoleForSqlserver(SysDepartInfo sysdepartInfo);
	public void addDepartForSqlserver(SysDepartInfo sysdepartInfo);
	public void addDepartTeamForSqlserver(SysDepartInfo sysdepartInfo);
	public void addDepartRoleForSqlserver(SysDepartInfo sysdepartInfo);
	public void addTeamForSqlserver(SysDepartInfo sysdepartInfo);
	public void addTeamRoleForSqlserver(SysDepartInfo sysdepartInfo);
	public void addRoleUnitRoleForSqlserver(SysDepartInfo sysdepartInfo);
	 
	 
	
}