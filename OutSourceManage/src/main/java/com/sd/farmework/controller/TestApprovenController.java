package com.sd.farmework.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.pojo.SysApprovenTask;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.pojo.TestApprovenFunciton;
import com.sd.farmework.service.SysApprovenFunctionRuleService;
import com.sd.farmework.service.SysApprovenRulePersonService;
import com.sd.farmework.service.SysApprovenTaskService;
import com.sd.farmework.service.SysApprovenTaskedService;
import com.sd.farmework.service.TestApprovenFuncitonService;


/**
 * 用户定制通用接口
 * @author 延小三
 * 2016-09-05
 * 
 */

@Controller
@Scope("prototype")
@RequestMapping(value="/testApproven")
public class TestApprovenController {
	private static Logger logger = Logger.getLogger("TestApprovenController");
	@Autowired
	private TestApprovenFuncitonService services;
	@Autowired
	private SysApprovenRulePersonService ruleServices;
	@Autowired
	private SysApprovenTaskService sysApprovenTaskService;
	@Autowired
	private SysApprovenTaskedService sysApprovenTaskedService;
	@Autowired
	private SysApprovenFunctionRuleService sysApprovenFunctionRuleService;
    //请假
	 private  String approvenFunctionId = "00011";
	 
	/**
	 * 1、查询业务信息
	 * @param employee
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectTestFunction", method = RequestMethod.GET)
	public String selectTestFunction(TestApprovenFunciton obj,Model model) throws Exception{
		List<BaseInfo> list=services.queryList(obj);
		model.addAttribute("testList", list);
		return "testApprovenDo/testApprovenFunctionList";
	}
 	/**
	 * 2、添加用户页面
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addTaskPanel", method = RequestMethod.GET)
	public String  addTaskPanel(Model model){
		
		return "testApprovenDo/addTestApproven";
	}
	/**
	 * 3、添加审批流任务
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/saveTask", method = RequestMethod.GET)
	public String  saveTask(HttpSession session ,HttpServletRequest request,
			HttpServletResponse response,TestApprovenFunciton obj,Model model) throws Exception{
	  //1、向业务表写入数据
	
	 Map<String,String> map = new HashMap<String,String>();
	 try {
		 request.setAttribute("approvenFunctionId", approvenFunctionId);
		 request.setAttribute("obj", obj);
		 
		map = services.addApproven(session, request, response);
	 } catch (Exception e) {
		e.printStackTrace();
		logger.info(e.getMessage());
		if(e.getMessage().equals("001")){
		 
			map.put("code","001");
			map.put("msg","没有定义审批流程");
		}
	}
	 System.out.println(map.toString());
	 model.addAllAttributes(map);
	 return "testApprovenDo/addTestApproven";
	}
	
	/**
	 * 4、待审批列表
	 * @param obj
	 * @param model
	 * @return waitingTestApprovenFunctionList.do?approvenUserId=0000000004
	 * @throws Exception
	 */
	@RequestMapping(value = "/waitingTestApprovenFunctionList", method = RequestMethod.GET)
	public String waitingTestApprovenFunctionList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenTask obj,Model model) throws Exception{
		//通过审批人编号查询当前审批人的待办事项
		// approvenUserId  =0000000004   系统当前登录用户sesssion获取
		//
		HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
		SysUserInfo sysUserInfo=httpSessionProvider.getCurrentUserSession(session, request, response);
		 
 		String  approvenUserId=sysUserInfo.getUserId(); 
 		
		obj.setApprovenUserId(approvenUserId);
		obj.setApprovenFunctionId(approvenFunctionId);
		 
		obj.setApprovenDepartId(sysUserInfo.getDepartId());
		obj.setApprovenDepartName(sysUserInfo.getDepartName());
		 
		
		List<BaseInfo> list=sysApprovenTaskService.queryList(obj);
		model.addAttribute("testList", list);
		return "testApprovenDo/waitingTestApprovenFunctionList";
	}
	/**
	 * 4、查询业务信息
	 * @param employee
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/testApproven1", method = RequestMethod.GET)
	public String testApproven(TestApprovenFunciton obj,Model model,String taskId) throws Exception{
		
		SysApprovenTask sysApprovenTask=(SysApprovenTask) sysApprovenTaskService.queryByPkId(taskId);
		model.addAttribute("sysApprovenTask", sysApprovenTask);
		return "testApprovenDo/testApproven";
	}
	/**
	 * 5、执行审批操作
	 * @param obj
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveTestApproven", method = RequestMethod.GET)
	public String saveTestApproven(HttpSession session,HttpServletRequest request, HttpServletResponse response,SysApprovenTask obj,Model model) throws Exception{
		//审批功能编号
	
		services.doApproven(session, request, response, obj, sysApprovenTaskService, sysApprovenTaskedService, approvenFunctionId);
			
		 return waitingTestApprovenFunctionList(session,request, response, obj, model);
	}
	
	/**
	 * 6、已审批列表
	 * @param obj
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/waitedTestApprovenFunctionList", method = RequestMethod.GET)
	public String waitedTestApprovenFunctionList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenTask obj,Model model) throws Exception{
		//通过审批人编号查询当前审批人的待办事项
		//通过审批人编号查询当前审批人的待办事项
		// approvenUserId  =0000000004   系统当前登录用户sesssion获取
		 HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
		 SysUserInfo sysUserInfo=httpSessionProvider.getCurrentUserSession(session, request, response);
		 
		String  approvenUserId=sysUserInfo.getUserId(); 
		obj.setApprovenUserId(approvenUserId);
		
		obj.setApprovenFunctionId(approvenFunctionId);
		List<BaseInfo> list=sysApprovenTaskedService.queryList(obj);
		
		model.addAttribute("testList", list);
		return "testApprovenDo/waitedTestApprovenFunctionList";
	}
	/**
	 * 7、查看当前审批任务进度
	 * @param obj
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dataApprovenDetailList", method = RequestMethod.GET)
	public String dataApprovenDetailList(SysApprovenTask obj,Model model) throws Exception{
		//通过审批人编号查询当前审批人的待办事项
		
		
 		obj.setApprovenFunctionId(approvenFunctionId);
		List<BaseInfo> list=sysApprovenTaskService.queryAllApprovenTaskList(obj);
		
		model.addAttribute("testList", list);
		return "testApprovenDo/dataApprovenDetailList";
	}
}
