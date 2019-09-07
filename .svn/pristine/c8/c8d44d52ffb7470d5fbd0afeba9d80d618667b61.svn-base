package com.sd.farmework.controller; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.farmework.service.SdOrderComplainService; 
import com.sd.farmework.pojo.SdBasicInfo;
import com.sd.farmework.pojo.SdOrderComplain; 
import com.sd.farmework.pojo.SdOrderInfo;
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
 @RequestMapping(value="/SdOrderComplain")
public class SdOrderComplainController{ 
    @Autowired
    private SdOrderComplainService sdordercomplainService;
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
    public String  add(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderComplain sdordercomplain,Model model){
		try {
			sdordercomplainService.add(sdordercomplain);	
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
    public String  update(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderComplain sdordercomplain,Model model){
		try {
			sdordercomplainService.update(sdordercomplain);	
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
    public String  delete(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderComplain sdordercomplain,Model model){
		try {
			sdordercomplainService.delete(sdordercomplain);	
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
    public String  queryList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderComplain sdordercomplain,Model model){
		try {
			sdordercomplainService.queryList(sdordercomplain);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
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
     public String  queryOrderCountByStatus(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderComplain sdordercomplain,Model model){
     	Map<String,Object> map = new HashMap<String,Object>();
     	try {
 	   		List list = sdordercomplainService.queryOrderCountByStatus(sdordercomplain);	
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
     * 投诉分析
     * @param session
     * @param request
     * @param response
     * @param lastUpdateTime
     * @param lastUpdateTime2
     * @param model
     * @return
     */
     @RequestMapping(value = "/queryComplainForCount",method = RequestMethod.POST)
     public String  queryComplainForCount(HttpSession session,HttpServletRequest request,HttpServletResponse response,
    		 String lastUpdateTime,String lastUpdateTime2,Model model){
     	Map<String,Object> map = new HashMap<String,Object>();
     	try {
     		Map<String,Object> strmap = new HashMap<String,Object>();
     		strmap.put("lastUpdateTime", lastUpdateTime);
     		strmap.put("lastUpdateTime2", lastUpdateTime2);
 	   		List list = sdordercomplainService.queryComplainForCount(strmap);
 	   		
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
    public String  queryListByPage(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderComplain sdordercomplain,
    		Model model,int pageIndex,int pageSize){
		try {
			sdordercomplain.setCurrPage(pageIndex);
			sdordercomplain.setPageSize(pageSize);
			List list=sdordercomplainService.queryListByPage(sdordercomplain);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("count", sdordercomplainService.queryCount(sdordercomplain));
			map.put("code", 0);
			map.put("rows", JSONArray.fromObject(list));
			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "001");
			map.put("msg", "系统繁忙");
			JSONUtils.objectToJson(request, response, map);
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
    public String  queryByPkId(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderComplain sdordercomplain,Model model,String pkId){
		try {
			sdordercomplainService.queryByPkId(pkId);	
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
    public String  query(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdOrderComplain sdordercomplain,Model model){
		try {
			sdordercomplainService.query(sdordercomplain);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}