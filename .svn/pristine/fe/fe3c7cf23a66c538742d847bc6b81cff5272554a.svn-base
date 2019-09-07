package com.sd.farmework.controller; 

import java.io.IOException;
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

import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;
import com.sd.farmework.common.TreeService;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.pojo.FunctionPositionInfo;
import com.sd.farmework.pojo.PowerPositionInfo;
import com.sd.farmework.pojo.SysDepartInfo;
import com.sd.farmework.pojo.SysFunctionInfo;
import com.sd.farmework.pojo.SysRoleInfo;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.FunctionPositionInfoService;
import com.sd.farmework.service.PowerPositionInfoService;
/** 
 * 系统日志表
 * @author Administrator 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @RequestMapping(value="/manager/loginIn/PowerPositionInfo")
public class PowerPositionInfoController{ 
    @Autowired
    private PowerPositionInfoService PowerPositionInfoService;
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
    public String  add(HttpSession session,HttpServletRequest request,HttpServletResponse response,PowerPositionInfo PowerPositionInfo,Model model){
		try {
			PowerPositionInfoService.add(PowerPositionInfo);	
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
    public String  update(HttpSession session,HttpServletRequest request,HttpServletResponse response,PowerPositionInfo PowerPositionInfo,Model model){
		try {
			PowerPositionInfoService.update(PowerPositionInfo);	
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
    public String  delete(HttpSession session,HttpServletRequest request,HttpServletResponse response,PowerPositionInfo PowerPositionInfo,Model model){
		try {
			PowerPositionInfoService.delete(PowerPositionInfo);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    /**
     * 1、查询不分页列表
     * @param session
     * @param request
     * @param response
     * @param SysApprovenFunction
     * @param model
     * @return
     */
     
     @RequestMapping(value = "/queryList",method = RequestMethod.GET)
     public String  queryList(HttpSession session,HttpServletRequest request,HttpServletResponse response,FunctionPositionInfo FunctionPositionInfo ,String type,String powerId){
 		
 	    	try {
 	    		String functionIds="";
 	    		if(StringUtil.isNotNullOrBlank(powerId)){
 	    			PowerPositionInfo powerPositionInfo=(PowerPositionInfo) PowerPositionInfoService.queryByPkId(powerId);
 					if(powerPositionInfo!=null){
 							functionIds=powerPositionInfo.getFunctionIds();
 					}
 	    		}
				List list=FunctionPositionInfoService.queryList(FunctionPositionInfo);	
				List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>(); 
				for (int i = 0; i < list.size(); i++) {
					FunctionPositionInfo functionPositionInfo =(FunctionPositionInfo) list.get(i);
						Map<String,Object>  map = new HashMap<String,Object>();
						map.put("PARENT_ID","-1");
						map.put("ID",functionPositionInfo.getFunctionId());
						map.put("NAME",functionPositionInfo.getFunctionName());
						map.put("isVirtual","0");
						//角色设置，查看角色信息时type=1
						if(StringUtil.isNotNullOrBlank(functionIds)&&functionIds.indexOf(","+functionPositionInfo.getFunctionId()+",")>-1){
							map.put("checked",true);
						}
						listMap.add(map);
				}
 	    					TreeService s = new TreeService();
 	    					String srt=JSONArray.fromObject(s.getTreeData(listMap,"-1")).toString();
 	    					response.setCharacterEncoding("utf-8");
 	    					response.getWriter().write(srt);
 	    					response.getWriter().close();
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
			PowerPositionInfo powerPositionInfo,int pageIndex,int pageSize) {
		try {
			//pageIndex++;
			powerPositionInfo.setPageSize(pageSize);
			powerPositionInfo.setCurrPage(pageIndex);
			List list = PowerPositionInfoService.queryListByPage(powerPositionInfo);
			powerPositionInfo.setTotalCount(PowerPositionInfoService.queryCount(powerPositionInfo));
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
    @RequestMapping(value = "/queryByPositionId",method = RequestMethod.POST)
    public String  query(HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model){
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			HttpSessionProvider httpSessionProvider=new HttpSessionProvider();
			SysUserInfo user=httpSessionProvider.getCurrentUserSession(session, request, response);
			PowerPositionInfo powerPositionInfo=new PowerPositionInfo();
			if(user.getUserId().equals("0000000001")){
				powerPositionInfo.setPositionId("6");
			}else{
				powerPositionInfo.setPositionId(user.getPosition());
			}
			powerPositionInfo=(PowerPositionInfo) PowerPositionInfoService.queryById(powerPositionInfo);
			if(powerPositionInfo!=null&&StringUtil.isNotNullOrBlank(powerPositionInfo.getFunctionIds())){
				map.put("code", "000");
				map.put("functionIds", powerPositionInfo.getFunctionIds());
			}
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
     @RequestMapping(value = "/queryByPkId",method = RequestMethod.GET)
     public String  queryByPkId(HttpSession session,HttpServletRequest request,HttpServletResponse response,PowerPositionInfo PowerPositionInfo,Model model){
 		try {
 			PowerPositionInfo powerPositionInfo = (com.sd.farmework.pojo.PowerPositionInfo) PowerPositionInfoService.queryByPkId(PowerPositionInfo.getPowerId());
 			Map<String,Object> map = new HashMap<String,Object>();
		    map.put("powerPositionInfo", powerPositionInfo);
			JSONUtils.objectToJson(request, response, map);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
     /**
      * 添加单位角色后台
      * @param session
      * @param request
      * @param response
      * @param SysDepartInfo
      * @param model
      * @param parentDepartId
      * @return
      */
     @RequestMapping(value = "/savePowerRole",method = RequestMethod.POST)
     public void  savePowerRole(HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model,String functionIds,String opear,String powerId){
     	Map<String,String> map = new HashMap<String,String>();
     	try {
 			PowerPositionInfo powerPositionInfo = new PowerPositionInfo();
  			powerPositionInfo.setFunctionIds(functionIds);
 			powerPositionInfo.setPowerId(powerId);
 	 
 			

 			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
 			SysUserInfo sessionUserInfo = httpSessionProvider
 					.getCurrentUserSession(session, request, response);
 			powerPositionInfo = (PowerPositionInfo) httpSessionProvider.fillBaseInfo(
 					powerPositionInfo, sessionUserInfo);
 			 
  			PowerPositionInfoService.update(powerPositionInfo);
 		 
 		
 			map.put("code", "000");
 			map.put("msg", "success");
              JSONUtils.objectToJson(request, response, map);
 		} catch (Exception e) {
 			map.put("code", "001");
 			map.put("msg", "error");
 			e.printStackTrace();
 		}
 		
     }
     public static void main(String[] args) {
		String str=",1,2,3,";
		String strs[]=str.split(",");
		for (int i = 0; i < strs.length; i++) {
			System.out.println(i+"------------------"+strs[i]);
		}
		
	}
}