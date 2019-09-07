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
import net.sf.json.JSONObject;

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
import com.sd.farmework.pojo.SysDepartInfo;
import com.sd.farmework.pojo.SysRoleInfo;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.SysDepartInfoService;
import com.sd.farmework.service.SysRoleInfoService;
/** 
 * 角色权限表
 * @author Administrator 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @RequestMapping(value="/manager/loginIn/SysRoleInfo")
public class SysRoleInfoController{ 
    @Autowired
    private SysRoleInfoService SysRoleInfoService;
    @Autowired
    private SysDepartInfoService SysDepartInfoService;
     
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
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getDepartInfoByParentId", method = RequestMethod.POST)
	public void getDepartInfoByParentId(String parentDepartId,
			HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model,int page) {
		try {
			SysDepartInfo SysDepartInfo = new SysDepartInfo();
			SysDepartInfo.setParentDepartId(parentDepartId);
			SysDepartInfo.setPageSize(15);
			SysDepartInfo.setCurrPage(page);
			int  count=SysDepartInfoService.getDepartInfoByParentIdCount(SysDepartInfo);
			
			List list = SysDepartInfoService
					.getDepartInfoByParentId(SysDepartInfo);
			//{total:15,rows:[{name:'test',age:12},{name:'test2',age:18}]}
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("total", count);
			map.put("rows", JSONArray.fromObject(list));
			JSONObject ojb =JSONObject.fromObject(map);
			response.setCharacterEncoding("utf-8");
 			response.getWriter().write(ojb.toString());
			
 			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
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
    @RequestMapping(value = "/saveAddUnitRole",method = RequestMethod.POST)
    public void  saveAddUnitRole(HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model,String parentDepartId,String unitName,String unitId,String roleName,String functionIds,String functionOperateIds,String roleDesc,String status,String opear,String roleId,String functionType){
    	Map<String,String> map = new HashMap<String,String>();
    	try {
			SysDepartInfo sysDepartInfo = new SysDepartInfo();
			sysDepartInfo.setParentDepartId(parentDepartId);
			sysDepartInfo.setNodeType(1);
			sysDepartInfo.setIsVirtual("1");
			sysDepartInfo.setDepartName(roleName);
			sysDepartInfo.setUnitId(unitId);
			sysDepartInfo.setUnitName(unitName);
			sysDepartInfo.setStatus(status);
			sysDepartInfo.setDepartDesc(roleDesc);
			

			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
			SysUserInfo sessionUserInfo = httpSessionProvider.getCurrentUserSession(session, request, response);
			sysDepartInfo = (SysDepartInfo) httpSessionProvider.fillBaseInfo(sysDepartInfo, sessionUserInfo);
			
			SysRoleInfo sysRoleInfo = new  SysRoleInfo();
			
			sysRoleInfo.setRoleName(roleName);
			sysRoleInfo.setRoleDesc(roleDesc);
			sysRoleInfo.setStatus(status);
			
			sysRoleInfo.setFunctionIds(functionIds);
			sysRoleInfo.setFunctionOperateIds(functionOperateIds);
			
			sysRoleInfo = (SysRoleInfo) httpSessionProvider.fillBaseInfo(sysRoleInfo, sessionUserInfo);
			
			if("add".equals(opear)||StringUtil.isNullOrBlank(roleId)){
				SysDepartInfoService.addRoleUnitRole(sysDepartInfo,sysRoleInfo);
				
			}else if("edit".equals(opear)){
				sysDepartInfo.setDepartId(roleId);
				SysDepartInfoService.updateRole(sysDepartInfo,sysRoleInfo,functionType);
			}
		
			map.put("code", "000");
			map.put("msg", "success");
             JSONUtils.objectToJson(request, response, map);
		} catch (IOException e) {
			e.printStackTrace();
			map.put("code", "001");
			map.put("msg", "error");
			JSONUtils.objectToJson(request, response, map);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/queryList",method = RequestMethod.GET)
    public String  queryList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysDepartInfo SysDepartInfo,Model model,String state){
		try {
			List <String> listNodeType = new ArrayList<String>();
			listNodeType.add("0");
			listNodeType.add("1");
			listNodeType.add("2");
			listNodeType.add("3");
			listNodeType.add("4");
			listNodeType.add("5");
			SysDepartInfo.setNodeTypes(listNodeType);
			
			List list =SysDepartInfoService.queryList(SysDepartInfo);	
			List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>(); 
			for (int i = 0; i < list.size(); i++) {
				SysDepartInfo sysDepartInfo =(SysDepartInfo) list.get(i);
				Map<String,Object>  map = new HashMap<String,Object>();
				map.put("PARENT_ID",sysDepartInfo.getParentDepartId());
				map.put("ID",sysDepartInfo.getDepartId());
				map.put("NAME",sysDepartInfo.getDepartName());
				map.put("isVirtual",sysDepartInfo.getIsVirtual());
				map.put("NODE_TYPE",sysDepartInfo.getNodeType());
				
				if(StringUtil.isNotNullOrBlank(state)){
					map.put("state",state);
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
    

 
}