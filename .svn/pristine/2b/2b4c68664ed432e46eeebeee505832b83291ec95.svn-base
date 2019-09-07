package com.sd.farmework.controller; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.sd.farmework.common.Constant;
import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.pojo.SdCustomerInfo;
import com.sd.farmework.service.SdCustomerInfoService;
/** 
 * 客户信息表
 * @author NGY 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @RequestMapping(value="/SdCustomerInfo")
public class SdCustomerInfoController{ 
    @Autowired
    private SdCustomerInfoService sdcustomerinfoService;
    
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
    public String add(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdCustomerInfo sdcustomerinfo,Model model){
    	Map<String,String> map = new HashMap<String,String>();
    	try {
			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
			sdcustomerinfo = (SdCustomerInfo) httpSessionProvider.fillBaseInfo(sdcustomerinfo, session, request, response);
			sdcustomerinfoService.add(sdcustomerinfo);
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
    public String  update(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdCustomerInfo sdcustomerinfo,Model model){
    	Map<String,String> map = new HashMap<String,String>();
    	try {
			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
			sdcustomerinfo = (SdCustomerInfo) httpSessionProvider.fillBaseInfo(sdcustomerinfo, session, request, response);
			sdcustomerinfoService.update(sdcustomerinfo);	
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
    		SdCustomerInfo sdcustomerinfo = new SdCustomerInfo();
    		sdcustomerinfo.setcustomerId(Integer.parseInt(pkId));
    		sdcustomerinfoService.delete(sdcustomerinfo);	
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
    public String querysdcustomerinfo(String pkId ,HttpSession session,HttpServletRequest request,HttpServletResponse response ,Model model){
    	Map<String,Object> map = new HashMap<String,Object>();
    	SdCustomerInfo sdcustomerinfo = new SdCustomerInfo();
    	sdcustomerinfo.setcustomerId(Integer.parseInt(pkId));
		try {
			sdcustomerinfo = (SdCustomerInfo)sdcustomerinfoService.queryByPkId(pkId);
			map.put("rows", sdcustomerinfo);
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
			HttpServletRequest request, HttpServletResponse response, SdCustomerInfo sdcustomerinfo, Model model) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", "000");
		map.put("msg", Constant.SUCCESS_MSG);
		try {
			List<SdCustomerInfo> customerList =new ArrayList<SdCustomerInfo>();
			//如果客户名称不为空那么进入后台模糊查询
			if(StringUtil.isNotNullOrBlank(sdcustomerinfo.getcustomerName())){
				customerList=sdcustomerinfoService.queryList(sdcustomerinfo);	
			}
			map.put("customerList", customerList);
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
    public String  queryListByPage(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdCustomerInfo sdcustomerinfo,int pageIndex,int pageSize,Model model){
    	Map<String,Object> map = new HashMap<String,Object>();
    	try {
    		sdcustomerinfo.setPageSize(pageSize);
    		sdcustomerinfo.setCurrPage(pageIndex);
    		sdcustomerinfo.setTotalCount(sdcustomerinfoService.queryCount(sdcustomerinfo));	
			List list = sdcustomerinfoService.queryListByPage(sdcustomerinfo);
			map.put("count", sdcustomerinfo.getTotalCount());
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
    public String  query(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdCustomerInfo sdcustomerinfo,Model model){
    	Map<String,Object> map = new HashMap<String,Object>();
    	try {
			List list = sdcustomerinfoService.query(sdcustomerinfo);
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