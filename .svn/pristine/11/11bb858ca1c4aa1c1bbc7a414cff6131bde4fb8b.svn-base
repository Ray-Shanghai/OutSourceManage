package com.sd.farmework.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sd.farmework.pojo.SysApprovenTask;



/**
 * 用户管理
 * @author wangchaochao
 * 2016-10-28 15:25:10
 */

@SuppressWarnings("rawtypes")
public interface TestApprovenFuncitonService extends BaseInfoService{
	/**
	 * 添加审批流
	 * @param session
	 * @param request
	 * @param response
	 * @param obj
	 * @return
	 */
	public Map addApproven(HttpSession session ,HttpServletRequest request,
				HttpServletResponse response)throws Exception;
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
	public Map<String, Object> doApproven(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			SysApprovenTask obj, SysApprovenTaskService sysApprovenTaskService,
			SysApprovenTaskedService sysApprovenTaskedService,
			String approvenFunctionId) throws Exception;
}
