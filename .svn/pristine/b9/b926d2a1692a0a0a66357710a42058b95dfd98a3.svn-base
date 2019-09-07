package com.sd.farmework.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sd.farmework.common.util.DateUtil;
import com.sd.farmework.mapper.SysApprovenFunctionRuleMapper;
import com.sd.farmework.mapper.SysApprovenRulePersonMapper;
import com.sd.farmework.mapper.SysApprovenTaskMapper;
import com.sd.farmework.mapper.SysApprovenTaskedMapper;
import com.sd.farmework.pojo.SysApprovenFunctionRule;
import com.sd.farmework.pojo.SysApprovenRulePerson;
import com.sd.farmework.pojo.SysApprovenTask;
import com.sd.farmework.pojo.SysUserInfo;

public class ApprovenUtil {
	/**
	 * 添加审批任务
	 * @param approvenRuleId
	 * @param sysTaskP
	 * @param sysApprovenTaskService
	 * @param ruleServices
	 */
	@SuppressWarnings("rawtypes")
	public Map<String,String> addApprovenTask(HttpSession session ,HttpServletRequest request,
			HttpServletResponse response,String approvenFunctionId, SysApprovenTask sysTaskP ,SysApprovenTaskMapper sysApprovenTaskMapper,SysApprovenRulePersonMapper ruleMapper ,SysApprovenFunctionRuleMapper sysApprovenFunctionRuleMapper){
		Map<String,String>  resultMap =new HashMap<String,String>(); 
		 resultMap.put("code", "000");
		 resultMap.put("msg", "审批信息设置成功");
		try {
			
		//根据部门查询相应部门的审批规则--start
		SysApprovenFunctionRule functionRule = new SysApprovenFunctionRule();
		
	 
		functionRule.setApprovenDepartId(sysTaskP.getCreateDepartId());
		functionRule.setApprovenDepartName(sysTaskP.getCreateDepartName());
 
		//需要审批的功能
		functionRule.setApprovenFunctionId(approvenFunctionId);
		List listRule = sysApprovenFunctionRuleMapper.query(functionRule);
		 
		 //根据部门查询相应部门的审批规则--end
		 if(listRule.size()==1){
			SysApprovenFunctionRule sysApprovenFunctionRule =(SysApprovenFunctionRule) listRule.get(0);
		    //根据审批规则获取审批人员信息
			
			List  list= ruleMapper.queryList(sysApprovenFunctionRule);
			if(list.size()==0){
				 resultMap.put("code", "002");
				 resultMap.put("msg", "审批规则编号"+sysApprovenFunctionRule.getApprovenRuleId()+"，没有定义对应的审批人。");
				 return resultMap;
			}
			 for(int i=0;i<list.size();i++){
				 SysApprovenRulePerson personObj = (SysApprovenRulePerson)list.get(i);
				 //创建待办任务
				 SysApprovenTask sysTask =new SysApprovenTask();
				 
				 sysTask.setTaskName(sysTaskP.getTaskName());
				 sysTask.setApprovenResult(sysTaskP.getApprovenResult());
				 sysTask.setApprovenUserId(personObj.getApprovenUserId());
				 sysTask.setApprovenUserName(personObj.getApprovenUserName());
				 sysTask.setApprovenSendTime(DateUtil.getCurrentDateString());
				 sysTask.setApprovenPersonId(personObj.getApprovenPersonId().toString());
				 sysTask.setApprovenRuleId(personObj.getApprovenRuleId());
				 sysTask.setApprovenRuleName(personObj.getApprovenRuleName());
				 sysTask.setApprovenFunctionId(personObj.getApprovenFunctionId());
				 sysTask.setApprovenFunctionName(personObj.getApprovenFunctionName());
				 sysTask.setSourceTable(sysTaskP.getSourceTable());
				 sysTask.setSourceTablePkColumnName(sysTaskP.getSourceTablePkColumnName());
				 sysTask.setSourceTablePkColumnValue(sysTaskP.getSourceTablePkColumnValue());
				//无序审批
				 if("2".equals(sysApprovenFunctionRule.getRuleIsOrderly())){
					 sysTask.setRuleOrder(1);
					 sysTask.setRuleOrderOld(1);
				 }else{
				//按顺序审批
					 sysTask.setRuleOrder(Integer.valueOf(personObj.getRuleOrder()));
					 sysTask.setRuleOrderOld(Integer.valueOf(personObj.getRuleOrder()));
				 }
				 //补充系统基本信息
				 HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
				 SysUserInfo sessionUserInfo=httpSessionProvider.getCurrentUserSession(session, request, response);
				 sysTask=(SysApprovenTask) httpSessionProvider.fillBaseInfo(sysTask, sessionUserInfo);
				 
				 sysApprovenTaskMapper.add(sysTask);
			 }
			 

		 }else{
			 resultMap.put("code", "001");
			 resultMap.put("msg", "没有定义审批流");
		 }
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("code", "003");
			resultMap.put("msg", "设置审批流信息异常了！");
		}
		return resultMap;
	}
	
	
	/**
	 * 处理审批
	 * @param obj
	 * @param sysApprovenTaskService
	 */
	public Map<String,Object> doApproven(HttpSession session ,HttpServletRequest request,
			HttpServletResponse response,SysApprovenTask obj,SysApprovenTaskMapper sysApprovenTaskMapper,SysApprovenTaskedMapper sysApprovenTaskedMapper,String approvenFunctionId){
		String sourceId = "";
		try {
			System.out.println("obj=="+obj);
			//将数据移入已办任务表中
			sysApprovenTaskedMapper.add(obj);
			//设置下个审批人信息
			
			SysApprovenTask objP=(SysApprovenTask) sysApprovenTaskMapper.queryByPkId(obj.getTaskId());
			sourceId = objP.getSourceTablePkColumnValue();
			objP.setRuleOrderOld((Integer.valueOf(objP.getRuleOrderOld())+1));
 			sysApprovenTaskMapper.updateNextApprovenPerosn(objP);
			//删除代办任务表信息
			sysApprovenTaskMapper.delete(obj);
			
			SysApprovenTask sysApprovenTask = new SysApprovenTask();
			sysApprovenTask.setApprovenFunctionId(approvenFunctionId);
			sysApprovenTask.setSourceTablePkColumnValue(sourceId);
			List<BaseInfo> sysApprovenTaskList=sysApprovenTaskMapper.queryRemainderTaskList(sysApprovenTask);
			
			Map <String,Object> map =new HashMap<String,Object>();
			map.put("sourceId", sourceId);
			map.put("sysApprovenTaskList", sysApprovenTaskList);
			return map ;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return null;
	}
}
