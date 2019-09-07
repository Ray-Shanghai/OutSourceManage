package com.sd.farmework.controller; 

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;
import com.sd.farmework.pojo.SysApprovenFunctionRule;
import com.sd.farmework.service.SysApprovenFunctionRuleService;
/** 
 * 审批功能规则表
 * @author Administrator 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @RequestMapping(value="/manager/loginIn/SysApprovenFunctionRule")
public class SysApprovenFunctionRuleController{ 
    @Autowired
    private SysApprovenFunctionRuleService SysApprovenFunctionRuleService;
    /**
    * 添加
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/saveApprovenRuleInfo",method = RequestMethod.POST)
    public void  add(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenFunctionRule sysApprovenFunctionRule,Model model){
		try {
			HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
			sysApprovenFunctionRule=(SysApprovenFunctionRule)httpSessionProvider.fillBaseInfo(sysApprovenFunctionRule, session, request, response);
			
			SysApprovenFunctionRuleService.add(sysApprovenFunctionRule);	
		
			Map<String,String> map =new HashMap<String,String>();
			map.put("code", "000");
			map.put("msg", "success");
			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
				e.printStackTrace();
			}
	}
    
    /**
    * 查询不分页列表
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/queryList",method = RequestMethod.POST)
    public String  queryList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenFunctionRule SysApprovenFunctionRule,Model model){
		try {
			SysApprovenFunctionRuleService.queryList(SysApprovenFunctionRule);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    /**
    * 查询分页列表
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/queryListByPage",method = RequestMethod.POST)
    public String  queryListByPage(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenFunctionRule SysApprovenFunctionRule,Model model){
		try {
			SysApprovenFunctionRuleService.queryCount(SysApprovenFunctionRule);	
			SysApprovenFunctionRuleService.queryListByPage(SysApprovenFunctionRule);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
  
    /**
    * 通过任意条件查询一条信息
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public String  query(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenFunctionRule SysApprovenFunctionRule,Model model){
		try {
			SysApprovenFunctionRuleService.query(SysApprovenFunctionRule);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}