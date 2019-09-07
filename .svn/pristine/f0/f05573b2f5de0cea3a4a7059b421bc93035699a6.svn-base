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

import com.sd.farmework.pojo.SysApprovenTasked;
import com.sd.farmework.service.SysApprovenTaskedService;
/** 
 * 已办任务表
 * @author Administrator 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @RequestMapping(value="/SysApprovenTasked")
public class SysApprovenTaskedController{ 
    @Autowired
    private SysApprovenTaskedService SysApprovenTaskedService;
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
    public String  add(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenTasked SysApprovenTasked,Model model){
		try {
			SysApprovenTaskedService.add(SysApprovenTasked);	
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
    public String  update(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenTasked SysApprovenTasked,Model model){
		try {
			SysApprovenTaskedService.update(SysApprovenTasked);	
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
    public String  delete(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenTasked SysApprovenTasked,Model model){
		try {
			SysApprovenTaskedService.delete(SysApprovenTasked);	
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
    public String  queryList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenTasked SysApprovenTasked,Model model){
		try {
			SysApprovenTaskedService.queryList(SysApprovenTasked);	
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
    public String  queryListByPage(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenTasked SysApprovenTasked,Model model){
		try {
			SysApprovenTaskedService.queryCount(SysApprovenTasked);	
			SysApprovenTaskedService.queryListByPage(SysApprovenTasked);	
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
    public String  query(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenTasked SysApprovenTasked,Model model){
		try {
			SysApprovenTaskedService.query(SysApprovenTasked);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}