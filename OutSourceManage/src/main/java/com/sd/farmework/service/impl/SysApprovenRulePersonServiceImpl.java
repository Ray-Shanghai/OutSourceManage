package com.sd.farmework.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.mapper.SysApprovenRulePersonMapper;
import com.sd.farmework.pojo.SysApprovenRulePerson;
import com.sd.farmework.service.SysApprovenRulePersonService;

/** 
 * 审批规则对应审批人表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysApprovenRulePersonServiceImpl extends BaseInfoServiceImpl implements SysApprovenRulePersonService{ 
    @Autowired
    private SysApprovenRulePersonMapper baseMapper;
    public SysApprovenRulePersonMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysApprovenRulePersonMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public int queryPersonCount(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		if("mysql".equals(dbType)){
			return baseMapper.queryPersonCountForMysql(obj);
		}else if("oracle".equals(dbType)){
			return baseMapper.queryPersonCount(obj);
		}else if("sqlserver".equals(dbType)){
			return baseMapper.queryPersonCountForSqlserver(obj);
		}
		return 0;
	}
	@Override
	public void deleteAndOrder(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		
		if("mysql".equals(dbType)){
			this.baseMapper.deleteForMysql(obj);
			List<BaseInfo>list=this.baseMapper.queryListForMysql(obj);
			if(list.size()>0&&list!=null){
				baseMapper.updateBatchForMysql(list);
			}
		}else if("oracle".equals(dbType)){
			this.baseMapper.delete(obj);
			List<BaseInfo>list=this.baseMapper.queryList(obj);
			if(list.size()>0&&list!=null){
				baseMapper.updateBatch(list);
			}
		}else if("sqlserver".equals(dbType)){
			this.baseMapper.deleteForSqlserver(obj);
			List<BaseInfo>list=this.baseMapper.queryListForSqlserver(obj);
			if(list.size()>0&&list!=null){
				baseMapper.updateBatchForSqlserver(list);
			}
		}
	}
	@Override
	public void updateOrder(String[] obj,String oper,String approvenPersonId) throws Exception {
		// TODO Auto-generated method stub
		SysApprovenRulePerson  sysApprovenRulePerson =null;
		
		
		 
			sysApprovenRulePerson = new SysApprovenRulePerson();
			if("delete".equals(oper)){
				sysApprovenRulePerson.setApprovenPersonId(approvenPersonId);
				if("mysql".equals(dbType)){
					this.baseMapper.deleteForMysql(sysApprovenRulePerson);
				}else if("oracle".equals(dbType)){
					this.baseMapper.delete(sysApprovenRulePerson);
				}else if("sqlserver".equals(dbType)){
					this.baseMapper.deleteForSqlserver(sysApprovenRulePerson);
				}
				
			}
			for (int i = 0; i < obj.length; i++) {
				sysApprovenRulePerson = new SysApprovenRulePerson();
				sysApprovenRulePerson.setApprovenPersonId(obj[i]);
				sysApprovenRulePerson.setRuleOrder(""+(i+1));
				if("mysql".equals(dbType)){
					this.baseMapper.updateForMysql(sysApprovenRulePerson);
				}else if("oracle".equals(dbType)){
					this.baseMapper.update(sysApprovenRulePerson);
				}else if("sqlserver".equals(dbType)){
					this.baseMapper.updateForSqlserver(sysApprovenRulePerson);
				}
			}
		 
		
	}
}