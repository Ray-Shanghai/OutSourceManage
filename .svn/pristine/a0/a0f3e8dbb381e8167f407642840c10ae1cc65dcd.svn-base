package com.sd.farmework.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.mapper.SysFunctionModuleRuleBaseMapper;
import com.sd.farmework.mapper.SysFunctionModuleRuleMapper;
import com.sd.farmework.pojo.SysFunctionModuleRule;
import com.sd.farmework.pojo.SysFunctionModuleRuleBase;
import com.sd.farmework.service.SysFunctionModuleRuleService;

/** 
 * 用户定制
 * @author Administrator 
 * 
 */ 
 @Service
public class SysFunctionModuleRuleServiceImpl extends BaseInfoServiceImpl implements SysFunctionModuleRuleService{ 
    @Autowired
    private SysFunctionModuleRuleMapper baseMapper;
    @Autowired
    private SysFunctionModuleRuleBaseMapper ruleBaseMapper;
    public SysFunctionModuleRuleMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysFunctionModuleRuleMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public void saveFunctionModule(List list,SysFunctionModuleRuleBase ruleBase) throws Exception {
		// TODO Auto-generated method stub
		if(StringUtil.isNullOrBlank(ruleBase.getFunctionModuleRuleBaseId())){
			ruleBaseMapper.add(ruleBase);
		}else{
			this.baseMapper.delete(ruleBase.getFunctionModuleRuleBaseId());
		}
		List<SysFunctionModuleRule>ruleList=list;
		for (SysFunctionModuleRule rule : ruleList) {
			rule.setFunctionModuleRuleBaseId(ruleBase.getFunctionModuleRuleBaseId());
		}
		
		baseMapper.addBatch(ruleList);
	}
}