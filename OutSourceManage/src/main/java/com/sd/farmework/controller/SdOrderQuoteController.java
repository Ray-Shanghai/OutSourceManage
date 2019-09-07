package com.sd.farmework.controller; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.farmework.service.SdOrderQuoteService; 
import com.sd.farmework.pojo.SdOrderQuote; 
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
 @RequestMapping(value="/SdOrderQuote")
public class SdOrderQuoteController{ 
    @Autowired
    private SdOrderQuoteService sdorderquoteService;
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
    public String  add(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderQuote sdorderquote,Model model){
		try {
			HttpSessionProvider sessionProvider=new HttpSessionProvider();
			sdorderquote=(SdOrderQuote) sessionProvider.fillBaseInfo(sdorderquote, session, request, response);
			Map<String,Object> map=sdorderquoteService.addOrderQuote(sdorderquote);
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
    public String  update(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderQuote sdorderquote,Model model){
		try {
			HttpSessionProvider sessionProvider=new HttpSessionProvider();
			sdorderquote=(SdOrderQuote) sessionProvider.fillBaseInfo(sdorderquote, session, request, response);
			sdorderquoteService.updateOrderQuote(sdorderquote); 
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "000");
			map.put("msg", "success");
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
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String  delete(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderQuote sdorderquote,Model model){
		try {
			sdorderquoteService.delete(sdorderquote);	
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
    public String  queryList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderQuote sdorderquote,Model model){
		try {
			List<SdOrderQuote> quoteList=sdorderquoteService.queryList(sdorderquote);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("code", "000");
			map.put("quoteList", quoteList);
			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("code", "001");
			map.put("msg", "系统繁忙");
			JSONUtils.objectToJson(request, response, map);
		}
		return null;
	}
    /**
     * 
     * @param session
     * @param request
     * @param response
     * @param sdorderquote
     * @param model
     * @return
     */
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public String  queryQuoteList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderQuote sdorderquote,Model model){
		try {
			HttpSessionProvider sessionProvider=new HttpSessionProvider();
			sdorderquote=(SdOrderQuote) sessionProvider.fillBaseInfo(sdorderquote, session, request, response);
			List<SdOrderQuote> quoteList=sdorderquoteService.query(sdorderquote);
			Map<String,Object> map = new HashMap<String,Object>();
			if(quoteList!=null&&quoteList.size()>0){
				map.put("code", "000");
				map.put("quoteList", quoteList);
			}else{
				map.put("code", "002");
			}
			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String,Object>();
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
    public String  queryListByPage(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderQuote sdorderquote,Model model){
		try {
			sdorderquoteService.queryCount(sdorderquote);	
			sdorderquoteService.queryListByPage(sdorderquote);	
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
    public String  queryByPkId(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderQuote sdorderquote,Model model,String pkId){
		try {
			sdorderquoteService.queryByPkId(pkId);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    
}