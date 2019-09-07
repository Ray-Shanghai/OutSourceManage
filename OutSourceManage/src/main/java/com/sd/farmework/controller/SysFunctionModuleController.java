 package com.sd.farmework.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.pojo.SysFunctionModule;
import com.sd.farmework.pojo.SysFunctionModuleRule;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.SysFunctionModuleRuleService;
import com.sd.farmework.service.SysFunctionModuleService;


/**
 * 功能组件
 * @author 
 * 2016-09-05
 * 
 */

@Controller
@Scope("prototype")
@RequestMapping(value="/manager/loginIn/functionModule")
public class SysFunctionModuleController {
	private static Logger logger = Logger.getLogger("SysFunctionModuleController");

	@Autowired
	private SysFunctionModuleService baseService;
	@Autowired
	private SysFunctionModuleRuleService ruleService;

	/**
	 * 查询组件
	 * @param obj （functionId）
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/queryModuleByFunctionId", method = RequestMethod.GET)
	public Object queryModuleByFunctionId(SysFunctionModule obj,HttpServletResponse response,HttpServletRequest request) throws Exception {
		  SysUserInfo user=(SysUserInfo) request.getSession().getAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY);
		List<SysFunctionModule>list = this.baseService.queryList(obj);
		
		Map map=new HashMap();
		List queryList=new ArrayList();
		List buttonList=new ArrayList();
		List tableList=new ArrayList();
		for (SysFunctionModule info : list) {
			SysFunctionModuleRule rule=new SysFunctionModuleRule();
			rule.setUserIds(user.getUserId());
			info.setIsShow(1);
			info.setIsOrder(1);
			rule.setFunctionModuleId(info.getFunctionModuleId());
			List<SysFunctionModuleRule> ruleList=this.ruleService.query(rule);
			if(ruleList!=null&&ruleList.size()>0){
				for (SysFunctionModuleRule sysFunctionModuleRule : ruleList) {
					info.setIsShow(sysFunctionModuleRule.getIsShow());
					info.setIsOrder(sysFunctionModuleRule.getIsOrder());
					info.setOrderStyle(sysFunctionModuleRule.getOrderStyle());
					map.put("functionModuleRuleBaseId", sysFunctionModuleRule.getFunctionModuleRuleBaseId());
				}
			}
			
			if("000020001".equals(info.getFunctionModuleTypeId())){
				queryList.add(info);
			}
			if("000020002".equals(info.getFunctionModuleTypeId())){
				buttonList.add(info);
			}
			if("000020003".equals(info.getFunctionModuleTypeId())){
				tableList.add(info);
			}
		}
		map.put("queryList", queryList);
		map.put("buttonList", buttonList);
		map.put("tableList", tableList);
		return map;
 	}

}
