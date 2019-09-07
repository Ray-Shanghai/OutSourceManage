package com.sd.farmework.controller; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.farmework.service.SdProductInfoService; 
import com.sd.farmework.pojo.SdProductGrade;
import com.sd.farmework.pojo.SdProductInfo; 
import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;
import com.sd.farmework.common.util.StringUtil;

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
 @RequestMapping(value="/manager/loginIn/SdProductInfo")
public class SdProductInfoController{ 
    @Autowired
    private SdProductInfoService sdproductinfoService;
    
    /**
     * 输入框值改变时查询
     * @param session
     * @param request
     * @param response
     * @param SysApprovenFunction
     * @param model
     * @return
     */
     @RequestMapping(value = "/search",method = RequestMethod.POST)
     public String  search(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdProductInfo sdproductinfo,Model model){
 		try {
 			List<SdProductInfo> proList=new ArrayList<SdProductInfo>();
 			//如果产品名不为空那么进入后台模糊查询
 			if(StringUtil.isNotNullOrBlank(sdproductinfo.getproductName())){
 				 proList=sdproductinfoService.query(sdproductinfo);
 			}
 			Map<String,Object> map = new HashMap<String,Object>();
			map.put("code", "000");
			map.put("msg", "success");
			map.put("proList", proList);
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
    * 添加
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  add(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdProductInfo sdproductinfo,Model model){
		Map<String,String> map = new HashMap<String,String>();
		try {
 			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
 			sdproductinfo = (SdProductInfo) httpSessionProvider.fillBaseInfo(sdproductinfo, session, request, response);
 			sdproductinfoService.add(sdproductinfo);
 			map.put("code", "000");
 			map.put("msg", "success");
 			JSONUtils.objectToJson(request, response, map);
 		} catch (Exception e) {
 			e.printStackTrace();
 			map.put("code", "002");
 			map.put("msg", "网络繁忙，请稍后再试");
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
    public String  update(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdProductInfo sdproductinfo,Model model){
		Map<String,String> map = new HashMap<String,String>();
     	try {
 			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
 			sdproductinfo = (SdProductInfo) httpSessionProvider.fillBaseInfo(sdproductinfo, session, request, response);
 			sdproductinfoService.update(sdproductinfo);	
 			map.put("code", "000");
 			map.put("msg", "success");
 			JSONUtils.objectToJson(request, response, map);
 		} catch (Exception e) {
 			e.printStackTrace();
 			map.put("code", "002");
 			map.put("msg", "网络繁忙，请稍后再试");
 			JSONUtils.objectToJson(request, response, map);
 		}
		return null;
	}
    /**
    * 删除
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String  delete(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdProductInfo sdproductinfo,Model model){
		try {
			sdproductinfoService.delete(sdproductinfo);	
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
    public String  queryList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdProductInfo sdproductinfo,Model model){
    	Map<String,Object> map = new HashMap<String,Object>();
    	try {
	   		List list = sdproductinfoService.queryList(sdproductinfo);	
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
    public String  queryListByPage(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdProductInfo sdproductinfo,int pageIndex,int pageSize,Model model){
		Map<String,Object> map = new HashMap<String,Object>();
     	try {
     		sdproductinfo.setPageSize(pageSize);
     		sdproductinfo.setCurrPage(pageIndex);
     		sdproductinfo.setTotalCount(sdproductinfoService.queryCount(sdproductinfo));	
 			List list = sdproductinfoService.queryListByPage(sdproductinfo);
 			map.put("count", sdproductinfo.getTotalCount());
 			map.put("code", 0);
 			map.put("rows", JSONArray.fromObject(list));
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
    * 通过主键查询一条信息
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/queryByPkId",method = RequestMethod.POST)
    public String  queryByPkId(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdProductInfo sdproductinfo,Model model,String pkId){
		Map<String,Object> map = new HashMap<String,Object>();
		SdProductInfo sdproductinfo1 = new SdProductInfo();
		sdproductinfo1.setproductId(Integer.parseInt(pkId));
 		try {
 			sdproductinfo1 = (SdProductInfo)sdproductinfoService.queryByPkId(pkId);
 			map.put("rows", sdproductinfo1);
 			map.put("code", "000");
 			map.put("msg", "success");
 		} catch (Exception e) {
 			e.printStackTrace();
 			map.put("code", "002");
 			map.put("msg", "网络繁忙，请稍后再试");
 		}
 		JSONUtils.objectToJson(request, response, map);
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
    public String  query(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdProductInfo sdproductinfo,Model model){
		Map<String,Object> map = new HashMap<String,Object>();
   	 	try {
	   		List list = sdproductinfoService.query(sdproductinfo);
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
}