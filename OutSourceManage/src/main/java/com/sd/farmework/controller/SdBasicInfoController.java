package com.sd.farmework.controller; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.farmework.service.SdBasicInfoService; 
import com.sd.farmework.pojo.SdBasicInfo; 
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
 @RequestMapping(value="/SdBasicInfo")
public class SdBasicInfoController{ 
    @Autowired
    private SdBasicInfoService sdbasicinfoService;
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
    public String  add(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdBasicInfo sdbasicinfo,Model model){
		try {
			sdbasicinfoService.add(sdbasicinfo);	
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
    public String  update(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdBasicInfo sdbasicinfo,Model model){
		try {
			sdbasicinfoService.update(sdbasicinfo);	
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
    public String  delete(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdBasicInfo sdbasicinfo,Model model){
		try {
			sdbasicinfoService.delete(sdbasicinfo);	
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
    public String  queryList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdBasicInfo sdbasicinfo,Model model){
    	Map<String,Object> map = new HashMap<String,Object>();
    	try {
	   		List list = sdbasicinfoService.queryList(sdbasicinfo);	
	   		if(list.size() > 0){
				map.put("code", "000");
			}else{
				map.put("code", "001");
			}
	   		map.put("rows", JSONArray.fromObject(list));
			map.put("msg", "success");
			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", "001");
			map.put("msg", "系统繁忙");
			JSONUtils.objectToJson(request, response, map);
		}
		return null;
	}
    
    /**
     * 根据状态列表汇总订单数量
     * @param session
     * @param request
     * @param response
     * @param SysApprovenFunction
     * @param model
     * @return
     */
     @RequestMapping(value = "/queryOrderCountByStatus",method = RequestMethod.POST)
     public String  queryOrderCountByStatus(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdBasicInfo sdbasicinfo,Model model){
     	Map<String,Object> map = new HashMap<String,Object>();
     	try {
     		sdbasicinfo.setRemark(sdbasicinfo.getRemark());
 	   		List list = sdbasicinfoService.queryOrderCountByStatus(sdbasicinfo);	
 	   		if(list.size() > 0){
 				map.put("code", "000");
 			}else{
 				map.put("code", "001");
 			}
 	   		map.put("rows", JSONArray.fromObject(list));
 			map.put("msg", "success");
 			JSONUtils.objectToJson(request, response, map);
 		} catch (Exception e) {
 			e.printStackTrace();
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
    public String  queryListByPage(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdBasicInfo sdbasicinfo,Model model){
		try {
			sdbasicinfoService.queryCount(sdbasicinfo);	
			sdbasicinfoService.queryListByPage(sdbasicinfo);	
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
    public String  queryByPkId(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdBasicInfo sdbasicinfo,Model model,String pkId){
		try {
			sdbasicinfoService.queryByPkId(pkId);	
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
    public String  query(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdBasicInfo sdbasicinfo,Model model){
		try {
			sdbasicinfoService.query(sdbasicinfo);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}