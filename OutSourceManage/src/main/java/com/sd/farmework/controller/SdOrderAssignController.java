package com.sd.farmework.controller; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.farmework.service.SdOrderAssignService; 
import com.sd.farmework.pojo.SdOrderAssign; 
import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import  javax.servlet.http.HttpServletRequest;
import  javax.servlet.http.HttpServletResponse;
import  javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/** 
 * test
 * @author Administrator 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @RequestMapping(value="/SdOrderAssign")
public class SdOrderAssignController{ 
    @Autowired
    private SdOrderAssignService sdorderassignService;
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
    public String  add(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderAssign sdorderassign,Model model,String userNames){
		try {
			List<SdOrderAssign> assignList=new ArrayList<SdOrderAssign>();
			HttpSessionProvider sessionProvider=new HttpSessionProvider();
			sdorderassign=(SdOrderAssign) sessionProvider.fillBaseInfo(sdorderassign, session, request, response);
			String acceptUserNames[]=sdorderassign.getacceptUserName().split(",");
			for (int i = 0; i < acceptUserNames.length; i++) {
				SdOrderAssign sdorderassign2=new SdOrderAssign();
				sdorderassign2=(SdOrderAssign) sessionProvider.fillBaseInfo(sdorderassign2, session, request, response);
				sdorderassign2.setorderId(sdorderassign.getorderId());
				sdorderassign2.setassignUserId(sdorderassign2.getCreateUserId());
				sdorderassign2.setacceptUserName(acceptUserNames[i]);
				sdorderassign2.setisLook(sdorderassign.getisLook());
				sdorderassign2.setassignType(sdorderassign.getassignType());
				assignList.add(sdorderassign2);
			}
			sdorderassignService.addAssignOrder(sdorderassign, assignList,userNames);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("code", "000");
			map.put("msg", "分配成功");
			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "001");
			map.put("msg", "系统繁忙");
			JSONUtils.objectToJson(request, response, map);
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
    public String  update(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderAssign sdorderassign,Model model){
		try {
			sdorderassignService.update(sdorderassign);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
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
    public String  delete(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderAssign sdorderassign,Model model){
		try {
			sdorderassignService.delete(sdorderassign);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
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
    public String  queryList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderAssign sdorderassign,Model model){
		try {
			List<SdOrderAssign> assignList=sdorderassignService.queryList(sdorderassign);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("code", "000");
			map.put("assignList", assignList);
			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "001");
			map.put("msg", "系统繁忙");
			JSONUtils.objectToJson(request, response, map);
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
    public String  queryListByPage(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderAssign sdorderassign,Model model){
		try {
			sdorderassignService.queryCount(sdorderassign);	
			sdorderassignService.queryListByPage(sdorderassign);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    /**
    * 通过主键查询一条信息
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/queryByPkId",method = RequestMethod.POST)
    public String  queryByPkId(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderAssign sdorderassign,Model model,String pkId){
		try {
			sdorderassignService.queryByPkId(pkId);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
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
    public String  query(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderAssign sdorderassign,Model model){
		try {
			sdorderassignService.query(sdorderassign);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}