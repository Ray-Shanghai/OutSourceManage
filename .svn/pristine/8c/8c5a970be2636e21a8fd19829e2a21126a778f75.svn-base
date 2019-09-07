package com.sd.farmework.controller; 

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.pojo.SysUserRole;
import com.sd.farmework.service.SysUserRoleService;
/** 
 * 用户角色映射表
 * @author Administrator 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @RequestMapping(value="/manager/loginIn/SysUserRole")
public class SysUserRoleController{ 
    @Autowired
    private SysUserRoleService SysUserRoleService;
	private static Logger logger = Logger.getLogger("SysUserRoleController");
    /**
    * 添加
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/addUserRoleInfo",method = RequestMethod.POST)
    public String  addUserRoleInfo(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysUserRole SysUserRole,Model model){
		try {
			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
			SysUserRole =	(com.sd.farmework.pojo.SysUserRole) httpSessionProvider.fillBaseInfo(SysUserRole, session, request, response);
			SysUserRoleService.add(SysUserRole);	
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
    public String  update(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysUserRole SysUserRole,Model model){
		try {
			SysUserRoleService.update(SysUserRole);	
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
    public String  delete(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysUserRole SysUserRole,Model model){
		try {
			SysUserRoleService.delete(SysUserRole);	
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
    public String  queryList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysUserRole SysUserRole,Model model){
		try {
			SysUserRoleService.queryList(SysUserRole);	
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
    public String  queryListByPage(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysUserRole SysUserRole,Model model){
		try {
			SysUserRoleService.queryCount(SysUserRole);	
			SysUserRoleService.queryListByPage(SysUserRole);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
 
    /**
    * 通过任意条件查询信息
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public String  query(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysUserRole sysUserRole,Model model){
 		try {
			
			List<SysUserRole> list = SysUserRoleService.query(sysUserRole);
			
			List<String> roleId=new ArrayList<String>();
			for (int i = 0; i < list.size(); i++) {
				roleId.add(list.get(i).getRoleId());
			}
			
			JSONArray obj=JSONArray.fromObject(roleId);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(obj.toString());
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}