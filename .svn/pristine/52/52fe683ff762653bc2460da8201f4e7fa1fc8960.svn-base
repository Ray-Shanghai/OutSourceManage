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

import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;
import com.sd.farmework.common.TreeService;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.pojo.SysDictionaryInfo;
import com.sd.farmework.pojo.SysFunctionInfo;
import com.sd.farmework.pojo.SysRoleInfo;
import com.sd.farmework.service.SysDictionaryInfoService;
import com.sd.farmework.service.SysFunctionInfoService;
import com.sd.farmework.service.SysRoleInfoService;
/** 
 * 功能菜单信息表
 * @author Administrator 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @SuppressWarnings("rawtypes")
 @RequestMapping(value="/manager/loginIn/SysFunctionInfo")
public class SysFunctionInfoController{ 
    @Autowired
    private SysFunctionInfoService SysFunctionInfoService;
    @Autowired
    private SysRoleInfoService SysRoleInfoService;
    @Autowired
    private SysDictionaryInfoService sysDictionaryInfoService;
    
    /**
    * 添加功能类型和功能信息
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  add(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysFunctionInfo SysFunctionInfo,Model model,String powerId){
		try {
			HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
			SysFunctionInfo=	 (SysFunctionInfo) httpSessionProvider.fillBaseInfo(SysFunctionInfo, session, request, response);
			if(StringUtil.isNullOrBlank(SysFunctionInfo.getDictionaryId())){
				SysFunctionInfo.setDictionaryId("");
				SysFunctionInfo.setDictionaryName("");
			}
			Map<String,String> map = new HashMap<String,String>();
			if(StringUtil.isNotNullOrBlank(powerId)){
				String [] powerIds = powerId.split(",");
				SysFunctionInfoService.add(SysFunctionInfo,powerIds);	
				map.put("code", "000");
				map.put("msg", "success");
			}else{
				SysFunctionInfoService.add(SysFunctionInfo,null);	
				map.put("code", "000");
				map.put("msg", "success");
			}
		 JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    /**
    * 修改功能类型
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String  update(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysFunctionInfo SysFunctionInfo,Model model){
    	Map<String,String> map = new HashMap<String,String>();
		try {
			HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
			SysFunctionInfo=	 (com.sd.farmework.pojo.SysFunctionInfo) httpSessionProvider.fillBaseInfo(SysFunctionInfo, session, request, response);
			SysFunctionInfo.setFunctionUrl(StringUtil.fixDefaultString(SysFunctionInfo.getFunctionUrl(), "/"));
			SysFunctionInfoService.update(SysFunctionInfo);
			map.put("code", "000");
			map.put("msg", "success");
			 JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", "001");
			map.put("msg", "error");
			 JSONUtils.objectToJson(request, response, map);
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
    public String  queryList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysFunctionInfo SysFunctionInfo ,String type,String roleId){
		
    	if("2".equals(SysFunctionInfo.getFunctionType())){
    		queryPowerList(session, request, response, SysFunctionInfo, type,roleId);
    	}else{
	    	try {
	    		String functionIds="";
	    		if(StringUtil.isNotNullOrBlank(roleId)){
		 			SysRoleInfo sysrole=(SysRoleInfo) SysRoleInfoService.queryByPkId(roleId);
					if(sysrole!=null){
							functionIds=sysrole.getFunctionIds();
					}
	    		}
		 
				List list=SysFunctionInfoService.queryList(SysFunctionInfo);	
				List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>(); 
				for (int i = 0; i < list.size(); i++) {
					SysFunctionInfo sysFunctioInfo =(SysFunctionInfo) list.get(i);
					if(sysFunctioInfo.getFunctionType().equals("1")){
						Map<String,Object>  map = new HashMap<String,Object>();
						map.put("PARENT_ID",sysFunctioInfo.getParentFunctionId());
						map.put("ID",sysFunctioInfo.getFunctionId());
						map.put("NAME",sysFunctioInfo.getFunctionName());
						map.put("isVirtual",sysFunctioInfo.getIsVirtual());
						//角色设置，查看角色信息时type=1 
						if("1".equals(type)&&functionIds.indexOf(","+sysFunctioInfo.getFunctionId()+",")>-1){
							map.put("checked",true);
						}
						listMap.add(map);
					}
				}
				TreeService s = new TreeService();
				String srt=JSONArray.fromObject(s.getTreeData(listMap,"-1")).toString();
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(srt);
				response.getWriter().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
		return null;
	}
    
    /**
     * 查询不分页列表
     * @param session
     * @param request
     * @param response
     * @param SysFunctionInfo
     * @param model
     * @param type （1：复选框树）
     * @param roleId（2、角色编号）
     * @return
     */
    
     @RequestMapping(value = "/queryPowerList",method = RequestMethod.GET)
     public void  queryPowerList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysFunctionInfo SysFunctionInfo,String type,String roleId){
 		try {
			SysRoleInfo sysrole=(SysRoleInfo) SysRoleInfoService.queryByPkId(roleId);
			String functionIds="";
			String functionOperateIds="";
			if(sysrole!=null){
					functionIds=sysrole.getFunctionIds();
					functionOperateIds=StringUtil.fixDefaultString(sysrole.getFunctionOperateIds());
			}
  			String [] functionIdArray = functionIds.split(",");
 			
			List list=SysFunctionInfoService.queryList(SysFunctionInfo);	
 			List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>(); 
 			for (int i = 0; i < list.size(); i++) {
 				SysFunctionInfo sysFunctioInfo =(SysFunctionInfo) list.get(i);
 				if(sysFunctioInfo.getFunctionType().equals("1")||sysFunctioInfo.getFunctionType().equals("2")){
 					Map<String,Object>  map = new HashMap<String,Object>();
 					map.put("PARENT_ID",sysFunctioInfo.getParentFunctionId());
 					map.put("ID",sysFunctioInfo.getFunctionId());
 					map.put("NAME",sysFunctioInfo.getFunctionName());
 					map.put("isVirtual",sysFunctioInfo.getIsVirtual());
 					if("1".equals(type)&&functionOperateIds.indexOf(","+sysFunctioInfo.getFunctionId()+",")>-1){
						map.put("checked",true);
					}
 					
 					for (int j = 0; j < functionIdArray.length; j++) {
 						String functionId =functionIdArray[j];
 						int currFunctionIdStrLength = sysFunctioInfo.getFunctionId().length();
 						if(StringUtil.isNotNullOrBlank(functionId)){
  							if(currFunctionIdStrLength<=9&&functionId.substring(0, currFunctionIdStrLength).equals(sysFunctioInfo.getFunctionId())){
 								listMap.add(map);
 								break;
 							}else if(sysFunctioInfo.getFunctionId().indexOf(functionId)==0){
 								listMap.add(map);
 								break;
 							}
 						}
					}
 					
 					
 				}
 			}
 			
 			
 			TreeService s = new TreeService();
 			String srt=JSONArray.fromObject(s.getTreeData(listMap,"-1")).toString();
 			response.setCharacterEncoding("utf-8");
 			response.getWriter().write(srt);
 			response.getWriter().close();
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		 
 	}
     
     /**
      * 打开添加功能模块列表
      * @param session
      * @param request
      * @param response
      * @param sysFunctionInfo
      * @param model
      * @return
      */
     
     @RequestMapping(value = "/queryDictionaryInfo",method = RequestMethod.GET)
     public String  queryDictionaryInfo(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysFunctionInfo sysFunctionInfo,Model model){
    	 SysDictionaryInfo sysDictionaryInfo = new SysDictionaryInfo();
    	 sysDictionaryInfo.setDictionaryTypeId("00001");
    	 
		List list = null;
		try {
			list = sysDictionaryInfoService.queryList(sysDictionaryInfo);
			
			System.out.println("list="+list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONUtils.objectToJsonArray(request, response, list);
		return null;
     }
     
     
     /**
      * 打开修改功能页面
      * @param session
      * @param request
      * @param response
      * @param sysFunctionInfo
      * @param model
      * @return
      */
      
     @RequestMapping(value = "/editFunctionInfo",method = RequestMethod.GET)
     public String  editFunctionInfo(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysFunctionInfo sysFunctionInfo,Model model){
    	 SysDictionaryInfo sysDictionaryInfo = new SysDictionaryInfo();
    	 sysDictionaryInfo.setDictionaryTypeId("00001");
    	 List list = null;
		try {
			list = sysDictionaryInfoService.queryList(sysDictionaryInfo);
			
			 model.addAttribute("list",list);
			 SysFunctionInfo sysFunction =  (SysFunctionInfo) SysFunctionInfoService.queryByPkId(sysFunctionInfo.getFunctionId());
			 model.addAttribute("sysFunction",sysFunction);
			 
			 List OperList=  SysFunctionInfoService.queryByPkparentFunctionId(sysFunction.getFunctionId());
			   
			 model.addAttribute("operList",OperList);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		 model.addAttribute("list", list);
    	 model.addAttribute("parentFunctionId", sysFunctionInfo.getParentFunctionId());
    	 return "sysManage/SysFunctionInfo/editFunctionInfo";
     }
     /**
      * 打开修改功能页面
      * @param session
      * @param request
      * @param response
      * @param sysFunctionInfo
      * @param model
      * @return
      */
    
     @RequestMapping(value = "/getOperListByFunctionId",method = RequestMethod.GET)
     public String  getOperListByFunctionId(HttpSession session,HttpServletRequest request,HttpServletResponse response,String functionId){
		try {
			SysDictionaryInfo sysDictionaryInfo = new SysDictionaryInfo();
	    	 sysDictionaryInfo.setDictionaryTypeId("00001");
	    	
			List	dictionaryInfoList = sysDictionaryInfoService.queryList(sysDictionaryInfo);
			 List OperList=  SysFunctionInfoService.queryByPkparentFunctionId(functionId);
			 Map<String,Object> map =new HashMap<String,Object>();
			 map.put("dictionaryInfoList", dictionaryInfoList);
			 map.put("operList", OperList);
			 JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
     }
     
     /**
      * 添加功能类型和功能信息
      * @param session
      * @param request
      * @param response
      * @param SysApprovenFunction
      * @param model
      * @return
      */
      @RequestMapping(value = "/saveEditFunctionInfo",method = RequestMethod.POST)
      public String  saveEditFunctionInfo(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysFunctionInfo SysFunctionInfo,Model model,String powerId){
  		try {
  			HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
  			SysFunctionInfo=	 (com.sd.farmework.pojo.SysFunctionInfo) httpSessionProvider.fillBaseInfo(SysFunctionInfo, session, request, response);
  			if(StringUtil.isNullOrBlank(SysFunctionInfo.getDictionaryId())){
  				SysFunctionInfo.setDictionaryId("");
  				SysFunctionInfo.setDictionaryName("");
  			}
  			
  			if(StringUtil.isNullOrBlank(SysFunctionInfo.getTypeId())){
  				SysFunctionInfo.setTypeId("");
  			}
  			Map<String,String> map = new HashMap<String,String>();
  			if(StringUtil.isNotNullOrBlank(powerId)){
  				String [] powerIds = powerId.split(",");
  				SysFunctionInfoService.update(SysFunctionInfo,powerIds);	
  				map.put("code", "000");
  				map.put("msg", "success");
  			}else{
  				map.put("code", "001");
  				map.put("msg", "请选择对应操作按钮");
  			}
  			JSONUtils.objectToJson(request, response, map);
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		return null;
  	}
   
    /**
    * 查询功能菜单列表
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public String  query(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysFunctionInfo SysFunctionInfo,int pageIndex,int pageSize){
		try {
		SysFunctionInfo.setPageSize(pageSize);
		SysFunctionInfo.setCurrPage(pageIndex);
		
		List list=	SysFunctionInfoService.queryListByPage(SysFunctionInfo);	
		int count=SysFunctionInfoService.queryCount(SysFunctionInfo);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		map.put("count", count);
		map.put("rows", JSONArray.fromObject(list));
		 JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
      /**
       * 查询功能菜单列表
       * @param session
       * @param request
       * @param response
       * @param SysApprovenFunction
       * @param model
       * @return
       */
        
       @RequestMapping(value = "/queryByPkId",method = RequestMethod.POST)
       public String  queryByPkId(HttpSession session,HttpServletRequest request,HttpServletResponse response,String functionId   ){
   		try {
   	 
   		
   		SysFunctionInfo  sysFunctionInfo=	(SysFunctionInfo) SysFunctionInfoService.queryByPkId(functionId);
   		 
   		
   		Map<String,Object> map = new HashMap<String,Object>();
   		 
   		map.put("sysFunctionInfo",sysFunctionInfo);
   		 JSONUtils.objectToJson(request, response, map);
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
   		return null;
   	}
}