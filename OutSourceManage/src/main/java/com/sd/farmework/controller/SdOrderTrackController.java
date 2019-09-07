package com.sd.farmework.controller; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.farmework.service.SdOrderTrackService; 
import com.sd.farmework.pojo.SdOrderTrack; 
import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.JSONUtils;

import net.sf.json.JSONArray;

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
 @RequestMapping(value="/SdOrderTrack")
public class SdOrderTrackController{ 
    @Autowired
    private SdOrderTrackService sdordertrackService;
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
    public String  add(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderTrack sdordertrack,Model model){
		try {
			sdordertrackService.add(sdordertrack);	
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
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String  update(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderTrack sdordertrack,Model model){
		try {
			sdordertrackService.update(sdordertrack);	
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
    public String  delete(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderTrack sdordertrack,Model model){
		try {
			sdordertrackService.delete(sdordertrack);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    /**
    * 查询订单跟踪详情
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/queryList",method = RequestMethod.POST)
    public String  queryList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderTrack sdordertrack,Model model){
		try {
			List<BaseInfo> trackList=sdordertrackService.queryList(sdordertrack);
			
 			Map<String,Object> map = new HashMap<String,Object>();
 			map.put("code", "000");
 			map.put("trackList", JSONArray.fromObject(trackList));
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
    public String  queryListByPage(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderTrack sdordertrack,Model model){
		try {
			sdordertrackService.queryCount(sdordertrack);	
			sdordertrackService.queryListByPage(sdordertrack);	
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
    public String  queryByPkId(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderTrack sdordertrack,Model model,String pkId){
		try {
			sdordertrackService.queryByPkId(pkId);	
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
    public String  query(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderTrack sdordertrack,Model model){
		try {
			sdordertrackService.query(sdordertrack);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}