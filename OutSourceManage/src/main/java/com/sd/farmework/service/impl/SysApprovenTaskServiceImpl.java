package com.sd.farmework.service.impl; 

import java.util.List;

import com.sd.farmework.service.SysApprovenTaskService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.mapper.SysApprovenTaskMapper; 

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * 审批待办任务表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysApprovenTaskServiceImpl extends BaseInfoServiceImpl implements SysApprovenTaskService{ 
    @Autowired
    private SysApprovenTaskMapper baseMapper;
    public SysApprovenTaskMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysApprovenTaskMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public List<BaseInfo> queryAllApprovenTaskList(BaseInfo obj) {
		// TODO Auto-generated method stub
		
		
		if("mysql".equals(dbType)){
			return baseMapper.queryAllApprovenTaskListForMysql(obj);
		}else if("oracle".equals(dbType)){
			return baseMapper.queryAllApprovenTaskList(obj);
		}else if("sqlserver".equals(dbType)){
			return baseMapper.queryAllApprovenTaskListForSqlserver(obj);
		}
		return null;
		
	}
	@Override
	public List<BaseInfo> queryRemainderTaskList(BaseInfo obj) {
		// TODO Auto-generated method stub
		if("mysql".equals(dbType)){
			return baseMapper.queryRemainderTaskListForMysql(obj);
		}else if("oracle".equals(dbType)){
			return baseMapper.queryRemainderTaskList(obj);
		}else if("sqlserver".equals(dbType)){
			return baseMapper.queryRemainderTaskListForSqlserver(obj);
		}
		return null;
	}
	@Override
	public void updateNextApprovenPerosn(BaseInfo obj) {
		// TODO Auto-generated method stub
		  
		  if("mysql".equals(dbType)){
			  baseMapper.updateNextApprovenPerosnForMysql(obj);
			}else if("oracle".equals(dbType)){
				baseMapper.updateNextApprovenPerosn(obj);
			}else if("sqlserver".equals(dbType)){
				baseMapper.updateNextApprovenPerosnForSqlserver(obj);
			}
	}
    
}