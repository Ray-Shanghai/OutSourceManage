package com.sd.farmework.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.common.ApprovenUtil;
import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.mapper.SysApprovenFunctionRuleMapper;
import com.sd.farmework.mapper.SysApprovenRulePersonMapper;
import com.sd.farmework.mapper.SysApprovenTaskMapper;
import com.sd.farmework.mapper.SysApprovenTaskedMapper;
import com.sd.farmework.mapper.TestApprovenFuncitonMapper;
import com.sd.farmework.pojo.SysApprovenTask;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.pojo.TestApprovenFunciton;
import com.sd.farmework.service.SysApprovenTaskService;
import com.sd.farmework.service.SysApprovenTaskedService;
import com.sd.farmework.service.TestApprovenFuncitonService;
/**
 * 审批流测试模块
 * @author yangyang
 * 2016-12-1
 */
@SuppressWarnings("unused")
@Service
public class TestApprovenFuncitonServiceImpl   extends BaseInfoServiceImpl  implements TestApprovenFuncitonService {

	
	private static Logger logger = Logger.getLogger("TestApprovenFuncitonServiceImpl");

	@Autowired
	private SysApprovenRulePersonMapper ruleMapper;
	@Autowired
	private SysApprovenTaskMapper sysApprovenTaskMapper;
	@Autowired
	private SysApprovenTaskedMapper sysApprovenTaskedMapper;
	@Autowired
	private SysApprovenFunctionRuleMapper sysApprovenFunctionRuleMapper;
	@Autowired
	private TestApprovenFuncitonMapper baseMapper;

	public TestApprovenFuncitonMapper getBaseMapper() {
		return baseMapper;
	}

	public void setBaseMapper(TestApprovenFuncitonMapper baseMapper) {
		this.baseMapper = baseMapper;
	}
    
	
	@Override
	public Map<String,String> addApproven(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
			String approvenFunctionId = (String)request.getAttribute("approvenFunctionId");
			TestApprovenFunciton obj = (TestApprovenFunciton)request.getAttribute("obj");
			HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
			SysUserInfo sessionUserInfo=httpSessionProvider.getCurrentUserSession(session, request, response);
			obj=(TestApprovenFunciton) httpSessionProvider.fillBaseInfo(obj, sessionUserInfo);
			
			 baseMapper.add(obj);
			
			 
			 //审批开始
			 //sys_approven_task
			 SysApprovenTask sysTaskP =new SysApprovenTask();
			 //任务名称
			 sysTaskP.setTaskName(obj.getTestName()+"请假申请");
			 //业务表名
			 sysTaskP.setSourceTable("test_approven_funciton");
			 //业务表主键名称
			 sysTaskP.setSourceTablePkColumnName("test_id");
			 //业务表主键对应值
			 sysTaskP.setSourceTablePkColumnValue(obj.getTestId()+"");
			 
			 //审批工具类
			 ApprovenUtil appr = new ApprovenUtil();
			 //请假调休审批 0000000001 sys_approven_function_rule
			 sysTaskP = (SysApprovenTask) httpSessionProvider.fillBaseInfo(sysTaskP, sessionUserInfo);
			 Map<String,String> map= appr.addApprovenTask(session, request, response, approvenFunctionId,sysTaskP,sysApprovenTaskMapper,ruleMapper,sysApprovenFunctionRuleMapper);
			 if(!map.get("code").equals("000")){
				 throw new Exception(map.get("code").toString());
			 }
			 return map;
		 
 	}
	/**
	 * 处理审批
	 * @param session
	 * @param request
	 * @param response
	 * @param obj
	 * @param sysApprovenTaskService
	 * @param sysApprovenTaskedService
	 * @param approvenFunctionId
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> doApproven(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			SysApprovenTask obj, SysApprovenTaskService sysApprovenTaskService,
			SysApprovenTaskedService sysApprovenTaskedService,
			String approvenFunctionId) throws Exception{
		// 审批功能编号map
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ApprovenUtil appr = new ApprovenUtil();
			map = appr.doApproven(session, request, response,
					obj, sysApprovenTaskMapper, sysApprovenTaskedMapper,
					approvenFunctionId);			 
			List<BaseInfo> sysApprovenTaskList=(List<BaseInfo>) map.get("sysApprovenTaskList");
			
			
			//审核通过
			TestApprovenFunciton function =new TestApprovenFunciton();
			function.setTestId(Integer.valueOf(map.get("sourceId").toString()));
			
			//审核不通过
			if("2".equals(obj.getApprovenResult())){
				 function.setStep("3");
				 baseMapper.update(function);
				 for(int i=0;i<sysApprovenTaskList.size();i++){
					 sysApprovenTaskService.delete(sysApprovenTaskList.get(i));
				 }
			 }else{
				 if(sysApprovenTaskList==null||sysApprovenTaskList.size()==0){
						function.setStep("2");
						baseMapper.update(function);
						
						//写发送短信或者其他业务操作
						
					}
			 }
		map.put("code", "000");
		map.put("msg", "success");
		return map;
	} catch (Exception e) {
		e.printStackTrace();
		map.put("code", "001");
		map.put("msg", "fail");
		return map;
	}	
	}
	 
	 
}
