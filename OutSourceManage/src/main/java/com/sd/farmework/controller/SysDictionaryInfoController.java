package com.sd.farmework.controller; 

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
import com.sd.farmework.common.JSONUtils;
import com.sd.farmework.pojo.SysDictionaryInfo;
import com.sd.farmework.pojo.SysFunctionInfo;
import com.sd.farmework.service.SysDictionaryInfoService;
/** 
 * 数据字典表
 * @author Administrator 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @RequestMapping(value="/manager/loginIn/SysDictionaryInfo")
public class SysDictionaryInfoController{ 
    @Autowired
    private SysDictionaryInfoService SysDictionaryInfoService;
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
    public String  add(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysDictionaryInfo SysDictionaryInfo,Model model){
		try {
			SysDictionaryInfoService.add(SysDictionaryInfo);	
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
    public String  update(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysDictionaryInfo SysDictionaryInfo,Model model){
		try {
			SysDictionaryInfoService.update(SysDictionaryInfo);	
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
    public String  delete(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysDictionaryInfo SysDictionaryInfo,Model model){
		try {
			SysDictionaryInfoService.delete(SysDictionaryInfo);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    
    /**
     * 通过字典类型获取信息
     * @param dictionaryTypeId
     * @param session
     * @param request
     * @param response
     * @param sysFunctionInfo
     * @param model
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/queryDictionaryInfo",method = RequestMethod.GET)
    public String  queryDictionaryInfo(String dictionaryTypeId ,HttpSession session,HttpServletRequest request,HttpServletResponse response,SysFunctionInfo sysFunctionInfo,Model model){
   	 SysDictionaryInfo sysDictionaryInfo = new SysDictionaryInfo();
   	 sysDictionaryInfo.setDictionaryTypeId(dictionaryTypeId);
   	 
		List list = null;
		try {
			list = SysDictionaryInfoService.queryList(sysDictionaryInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONUtils.objectToJsonArray(request, response, list);
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
    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
	public String queryList(HttpSession session,
			HttpServletRequest request, HttpServletResponse response, SysDictionaryInfo sysDictionaryInfo, Model model) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", Constant.SUCCESS_MSG);
		try {
		
			List list = SysDictionaryInfoService.queryList(sysDictionaryInfo);
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
    public String  queryListByPage(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysDictionaryInfo SysDictionaryInfo,Model model){
		try {
			SysDictionaryInfoService.queryCount(SysDictionaryInfo);	
			SysDictionaryInfoService.queryListByPage(SysDictionaryInfo);	
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
    public String  query(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysDictionaryInfo SysDictionaryInfo,Model model){
		try {
			SysDictionaryInfoService.query(SysDictionaryInfo);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}