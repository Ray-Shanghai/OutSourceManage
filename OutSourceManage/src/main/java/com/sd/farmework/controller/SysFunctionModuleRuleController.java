package com.sd.farmework.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.pojo.SysFunctionModuleRule;
import com.sd.farmework.pojo.SysFunctionModuleRuleBase;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.SysFunctionModuleRuleService;


/**
 * 用户定制
 * @author 
 * 2016-09-05
 * 
 */

@Controller
@Scope("prototype")
@RequestMapping(value="/manager/loginIn/functionModuleRule")
public class SysFunctionModuleRuleController {
	private static Logger logger = java.util.logging.Logger.getLogger(SysFunctionModuleRuleController.class.getName());
	@Autowired
	private SysFunctionModuleRuleService ruleService;

	/**
	 * 保存功能组件
	 * @param modules（{functionModuleId-functionModuleName-functionModuleDesc-functionId-functionName-functionModuleTypeId-functionModuleTypeName-moduleFromDataType-moduleFromDataName-isShow-isOrder-orderStyle}）
	 * @param response
	 * @param request
	 * @param session
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/saveFunctionModule")
	public void saveFunctionModule(String module,String functionModuleRuleBaseId,HttpServletResponse response,HttpServletRequest request,HttpSession session) throws Exception {
		SysUserInfo user=(SysUserInfo) session.getAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY);
		SysFunctionModuleRuleBase ruleBase=new SysFunctionModuleRuleBase();
		HttpSessionProvider sessionProvider=new HttpSessionProvider();
		ruleBase=(SysFunctionModuleRuleBase) sessionProvider.fillBaseInfo(ruleBase, session, request, response);
		ruleBase.setUserIds(user.getUserId());
		ruleBase.setFunctionModuleRuleBaseId(functionModuleRuleBaseId);
		List<SysFunctionModuleRule> ruleList=new ArrayList<SysFunctionModuleRule>();
		String []modules =  module.split("\\?");
		for (String moduleStr : modules) {
			SysFunctionModuleRule rule=new SysFunctionModuleRule();
			
			String[] mod=moduleStr.split("-");
			 
			if("1".equals(mod[9])){
				continue;
			}
			
			rule.setFunctionModuleId(StringUtil.fixDefaultString(mod[0]));
		 
			rule.setFunctionModuleName(StringUtil.fixDefaultString(mod[1]));
			 
			rule.setFunctionModuleDesc(StringUtil.fixDefaultString(mod[2]));
			 
			rule.setFunctionId(StringUtil.fixDefaultString(mod[3]));
			 
			rule.setFunctionName(StringUtil.fixDefaultString(mod[4]));
			 
			rule.setFunctionModuleTypeId(StringUtil.fixDefaultString(mod[5]));
			 
			rule.setFunctionModuleTypeName(StringUtil.fixDefaultString(mod[6]));
			 
			rule.setModuleFromDataType(StringUtil.fixDefaultString(mod[7]));
			
			rule.setModuleFromDataName(StringUtil.fixDefaultString(mod[8]));
			rule.setIsShow(Integer.parseInt(mod[9]));
			rule.setOrderStyle("");
			if("000020003".equals(rule.getFunctionModuleTypeId())){
				rule.setIsOrder(Integer.parseInt(mod[10]));
				rule.setOrderStyle(mod[10].equals("0")?mod[11]:"");
			}
			rule=(SysFunctionModuleRule) sessionProvider.fillBaseInfo(rule, session, request, response);
			ruleList.add(rule);
		}
		
		this.ruleService.saveFunctionModule(ruleList,ruleBase);
	}
	/**
	 * 
	 * @param modle
	 * @param sysFunctionModuleRule
	 * @return
	 */
	@RequestMapping(value="/queryModuleRuleList",method=RequestMethod.GET)
	public String queryList(Model modle,SysFunctionModuleRule sysFunctionModuleRule,HttpServletRequest request,HttpServletResponse response){
		try {
			SysUserInfo user=(SysUserInfo) request.getSession().getAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY);
			sysFunctionModuleRule.setUserIds(user.getUserId());
			List<SysFunctionModuleRule> ruleList=this.ruleService.queryList(sysFunctionModuleRule);
			List searchList=new ArrayList();
			List colList=new ArrayList();
			List buttonList=new ArrayList();
			for (SysFunctionModuleRule obj : ruleList) {
				if("000020003".equals(obj.getFunctionModuleTypeId())){
					colList.add(obj);
				}else if("000020002".equals(obj.getFunctionModuleTypeId())){
					buttonList.add(obj);
				}else{
					searchList.add(obj);
				}
			}
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("searchList", searchList);
			map.put("buttonList", buttonList);
			map.put("colList", colList);
			map.put("code", "000");
			map.put("msg", "success");
			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("code", "000");
			map.put("msg", "success");
			JSONUtils.objectToJson(request, response, map);
		}
		return null;
	}
}
