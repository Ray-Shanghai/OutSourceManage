package com.sd.farmework.controller; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.farmework.service.SdSupplierContactService;
import com.sd.farmework.service.SdSupplierInfoService; 
import com.sd.farmework.pojo.SdSupplierContact;
import com.sd.farmework.pojo.SdSupplierInfo; 
import com.sd.farmework.common.Constant;
import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;

import net.sf.json.JSONArray;

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
 @RequestMapping(value="/SdSupplierInfo")
public class SdSupplierInfoController{ 
    @Autowired
    private SdSupplierInfoService sdsupplierinfoService;
    @Autowired
    private SdSupplierContactService sdSupplierContactService;
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
     public String add(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdSupplierInfo sdsupplierinfo,SdSupplierContact sdsuppliercontact,Model model){
     	Map<String,String> map = new HashMap<String,String>();
     	try {
 			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
 			sdsupplierinfo = (SdSupplierInfo) httpSessionProvider.fillBaseInfo(sdsupplierinfo, session, request, response);
 			sdsuppliercontact = (SdSupplierContact) httpSessionProvider.fillBaseInfo(sdsuppliercontact, session, request, response);
 			sdsupplierinfoService.add(sdsupplierinfo,sdsuppliercontact);
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
     public String  update(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdSupplierInfo sdsupplierinfo,SdSupplierContact sdsuppliercontact,String hidDelContactId,Model model){
     	Map<String,String> map = new HashMap<String,String>();
     	try {
 			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
 			sdsuppliercontact = (SdSupplierContact) httpSessionProvider.fillBaseInfo(sdsuppliercontact, session, request, response);
 			sdsupplierinfoService.update(sdsupplierinfo,sdsuppliercontact,hidDelContactId);
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
     public String  delete(HttpSession session,HttpServletRequest request,HttpServletResponse response,String pkId,Model model){
     	Map<String,String> map = new HashMap<String,String>();
     	try {
     		SdSupplierInfo sdsupplierinfo = new SdSupplierInfo();
     		sdsupplierinfo.setsupplierId(Integer.parseInt(pkId));
     		sdsupplierinfoService.delete(sdsupplierinfo);
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
      * 通过ID获取信息
      * @param dictionaryTypeId
      * @param session
      * @param request
      * @param response
      * @param sysFunctionInfo
      * @param model
      * @return
      */
     @SuppressWarnings("rawtypes")
     @RequestMapping(value = "/queryByPkId",method = RequestMethod.POST)
     public String querySdSupplierInfo(String pkId ,HttpSession session,HttpServletRequest request,HttpServletResponse response ,Model model){
     	Map<String,Object> map = new HashMap<String,Object>();
     	SdSupplierInfo sdsupplierinfo = new SdSupplierInfo();
     	sdsupplierinfo.setsupplierId(Integer.parseInt(pkId));
 		try {
 			SdSupplierContact sdSupplierContact = new SdSupplierContact();
 			sdsupplierinfo = (SdSupplierInfo)sdsupplierinfoService.queryByPkId(pkId);
 			
 			SdSupplierContact sdsuppliercontact = new SdSupplierContact();
 			sdsuppliercontact.setsupplierId(Integer.parseInt(pkId));
 			List list = sdSupplierContactService.queryList(sdsuppliercontact);

 			map.put("rows", sdsupplierinfo);
 			map.put("rowsDetail", JSONArray.fromObject(list));
 			map.put("code", "000");
 			map.put("msg", "success");
 		} catch (Exception e) {
 			e.printStackTrace();
 			map.put("code", "002");
			map.put("msg", "网络繁忙，请稍后再试");
			JSONUtils.objectToJson(request, response, map);
 		}
 		JSONUtils.objectToJson(request, response, map);
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
     @RequestMapping(value = "/queryList", method = RequestMethod.POST)
 	public String queryList(HttpSession session,
 			HttpServletRequest request, HttpServletResponse response, SdSupplierInfo sdsupplierinfo, Model model) {
 		Map<String,Object> map = new HashMap<String,Object>();
 		map.put("code", 0);
 		map.put("msg", Constant.SUCCESS_MSG);
 		try {
 		
 			List list = sdsupplierinfoService.queryList(sdsupplierinfo);
 			map.put("rows", JSONArray.fromObject(list));
  			JSONUtils.objectToJson(request, response, map);

 		} catch (Exception e) {
 			e.printStackTrace();
 			map.put("code",Constant.ERROR_CODE);
 			map.put("msg", Constant.ERROR_MSG);
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
     public String  queryListByPage(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdSupplierInfo sdsupplierinfo,int pageIndex,int pageSize,Model model){
     	Map<String,Object> map = new HashMap<String,Object>();
     	try {
     		sdsupplierinfo.setPageSize(pageSize);
     		sdsupplierinfo.setCurrPage(pageIndex);
     		sdsupplierinfo.setTotalCount(sdsupplierinfoService.queryCount(sdsupplierinfo));	
 			List list = sdsupplierinfoService.queryListByPage(sdsupplierinfo);
 			map.put("count", sdsupplierinfo.getTotalCount());
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
     * 通过任意条件查询一条信息
     * @param session
     * @param request
     * @param response
     * @param SysApprovenFunction
     * @param model
     * @return
     */
     @RequestMapping(value = "/query",method = RequestMethod.POST)
     public String  query(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdSupplierInfo sdsupplierinfo,Model model){
    	 Map<String,Object> map = new HashMap<String,Object>();
    	 try {
 			List list = sdsupplierinfoService.query(sdsupplierinfo);
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