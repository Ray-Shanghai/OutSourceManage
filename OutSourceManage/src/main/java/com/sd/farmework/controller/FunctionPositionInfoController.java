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

import com.sd.farmework.common.JSONUtils;
import com.sd.farmework.pojo.FunctionPositionInfo;
import com.sd.farmework.service.FunctionPositionInfoService;
/** 
 * 系统日志表
 * @author Administrator 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @RequestMapping(value="/manager/loginIn/FunctionPositionInfo")
public class FunctionPositionInfoController{ 
    @Autowired
    private FunctionPositionInfoService FunctionPositionInfoService;
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
    public String  add(HttpSession session,HttpServletRequest request,HttpServletResponse response,FunctionPositionInfo FunctionPositionInfo,Model model){
		try {
			FunctionPositionInfoService.add(FunctionPositionInfo);	
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
    public String  update(HttpSession session,HttpServletRequest request,HttpServletResponse response,FunctionPositionInfo FunctionPositionInfo,Model model){
		try {
			FunctionPositionInfoService.update(FunctionPositionInfo);	
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
    public String  delete(HttpSession session,HttpServletRequest request,HttpServletResponse response,FunctionPositionInfo FunctionPositionInfo,Model model){
		try {
			FunctionPositionInfoService.delete(FunctionPositionInfo);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    
	/**
	 * 查询分页列表
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenFunction
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryListByPageIndex", method = RequestMethod.GET)
	public String queryListByPageIndex(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			FunctionPositionInfo powerPositionInfo,int pageIndex,int pageSize) {
		try {
			//pageIndex++;
			powerPositionInfo.setPageSize(pageSize);
			powerPositionInfo.setCurrPage(pageIndex);
			List list = FunctionPositionInfoService.queryListByPage(powerPositionInfo);
			powerPositionInfo.setTotalCount(FunctionPositionInfoService.queryCount(powerPositionInfo));
			Map<String,Object> map = new HashMap<String,Object>();
			
			map.put("count", powerPositionInfo.getTotalCount());
			map.put("code", 0);
			map.put("rows", JSONArray.fromObject(list));
			
			
			
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
    * 通过任意条件查询一条信息
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public String  query(HttpSession session,HttpServletRequest request,HttpServletResponse response,FunctionPositionInfo FunctionPositionInfo,Model model){
		try {
			FunctionPositionInfoService.query(FunctionPositionInfo);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}