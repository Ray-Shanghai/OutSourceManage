package com.sd.farmework.controller; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sd.farmework.pojo.SysApprovenRulePerson;
import com.sd.farmework.service.SysApprovenRulePersonService;
/** 
 * 审批规则对应审批人表
 * @author Administrator 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @RequestMapping(value="/SysApprovenRulePerson")
public class SysApprovenRulePersonController{ 
    @Autowired
    private SysApprovenRulePersonService SysApprovenRulePersonService;
    /**
    * 添加
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  add(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenRulePerson SysApprovenRulePerson,Model model){
		try {
			SysApprovenRulePersonService.add(SysApprovenRulePerson);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    /**
    * 修改
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String  update(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenRulePerson SysApprovenRulePerson,Model model){
		try {
			SysApprovenRulePersonService.update(SysApprovenRulePerson);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    /**
    * 修改
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String  delete(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenRulePerson SysApprovenRulePerson,Model model){
		try {
			SysApprovenRulePersonService.delete(SysApprovenRulePerson);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
    public String  queryList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenRulePerson SysApprovenRulePerson,Model model){
		try {
			SysApprovenRulePersonService.queryList(SysApprovenRulePerson);	
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
    public String  queryListByPage(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenRulePerson SysApprovenRulePerson,Model model){
		try {
			SysApprovenRulePersonService.queryCount(SysApprovenRulePerson);	
			SysApprovenRulePersonService.queryListByPage(SysApprovenRulePerson);	
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
    public String  query(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenRulePerson SysApprovenRulePerson,Model model){
		try {
			SysApprovenRulePersonService.query(SysApprovenRulePerson);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}