package com.sd.farmework.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
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
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.pojo.SysUserRole;
import com.sd.farmework.service.SysDepartInfoService;
import com.sd.farmework.service.SysUserInfoService;
import com.sd.farmework.service.SysUserRoleService;

/**
 * 部门信息
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("rawtypes")
@Controller
@Scope("prototype")
@RequestMapping(value = "/manager/loginIn/SysDepartInfo")
public class SysDepartInfoController {
	@Autowired
	private SysDepartInfoService SysDepartInfoService;
	@Autowired
	private SysUserInfoService sysUserInfoService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	private Logger logger = Logger.getLogger(SysDepartInfoController.class);

	
	
	/**
	 * 2、 添加单位信息提交保存
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenFunction
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/saveAddUnit", method = RequestMethod.POST)
	public String saveAddUnit(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo sysDepartInfo,
			Model model, String type) {
		Map<String,String> map = new HashMap<String,String>();
		try {
			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
			SysUserInfo sessionUserInfo = httpSessionProvider
					.getCurrentUserSession(session, request, response);
			sysDepartInfo = (SysDepartInfo) httpSessionProvider.fillBaseInfo(
					sysDepartInfo, sessionUserInfo);
			
			int length = sysDepartInfo.getParentDepartId().length();
			
			if (length==6) {
				sysDepartInfo.setNodeType(1);
				sysDepartInfo.setIsVirtual("1");
				SysDepartInfoService.addUnit(sysDepartInfo);
			}else if (length==12) {
				sysDepartInfo.setNodeType(2);
				sysDepartInfo.setIsVirtual("1");
				SysDepartInfoService.addDepart(sysDepartInfo);
			}else if (length==18) {
				sysDepartInfo.setNodeType(4);
				sysDepartInfo.setIsVirtual("1");
				SysDepartInfoService.addTeam(sysDepartInfo);
			}

			
			

			
			
			map.put("code", "000");
			map.put("msg", "success");
		     JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			e.printStackTrace();
		//	logger.info(e.getMessage());
			map.put("code", "001");
			map.put("msg", "error");
			 JSONUtils.objectToJson(request, response, map);
		}
		return null;
	}
	
	/**
	 * 2、 添加单位信息提交保存
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenFunction
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/saveEditDepartInfo", method = RequestMethod.POST)
	public String saveEditDepartInfo(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo sysDepartInfo,
			Model model, String type) {
		Map<String,String> map = new HashMap<String,String>();
		try {
			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
			SysUserInfo sessionUserInfo = httpSessionProvider
					.getCurrentUserSession(session, request, response);
			sysDepartInfo = (SysDepartInfo) httpSessionProvider.fillBaseInfo(
					sysDepartInfo, sessionUserInfo);
			SysDepartInfoService.update(sysDepartInfo);

		 
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
	 * 2、 添加部门信息提交保存
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenFunction
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/saveAddDepart", method = RequestMethod.POST)
	public String saveAddDepart(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			SysDepartInfo sysDepartInfo, Model model, String type) {
		Map<String,String> map = new HashMap<String,String>();
		try {
			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
			SysUserInfo sessionUserInfo = httpSessionProvider
					.getCurrentUserSession(session, request, response);
			sysDepartInfo = (SysDepartInfo) httpSessionProvider.fillBaseInfo(
					sysDepartInfo, sessionUserInfo);
			if ("depart".equals(type)) {
				sysDepartInfo.setNodeType(1);
				sysDepartInfo.setIsVirtual("1");
			}

			SysDepartInfoService.addDepart(sysDepartInfo);

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
	 * 2、 添加部门信息提交保存
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenFunction
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/saveAddTeam", method = RequestMethod.POST)
	public String saveAddTeam(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo sysDepartInfo,
			Model model, String type) {
		Map<String,String> map = new HashMap<String,String>();
		try {
			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
			SysUserInfo sessionUserInfo = httpSessionProvider
					.getCurrentUserSession(session, request, response);
			sysDepartInfo = (SysDepartInfo) httpSessionProvider.fillBaseInfo(
					sysDepartInfo, sessionUserInfo);
			if ("team".equals(type)) {
				sysDepartInfo.setNodeType(1);
				sysDepartInfo.setIsVirtual("4");
			}

			SysDepartInfoService.addTeam(sysDepartInfo);

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
	  * 
	  * @param session
	  * @param request
	  * @param response
	  * @param SysDepartInfo
	  * @param userId          显示某个用户的角色信息
	  * @param notNodeType   无需显示的节点
	  * @param IsShowLastNoChild 是否显示最后一级没有子节点的节点（单位、部门、角色、班组）
	  * @param dataType  加载数据内容   5查询角色
	  * @return
	  */
	@RequestMapping(value = "/queryList", method = RequestMethod.GET)
	public String queryList(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo SysDepartInfo,
			 String userId
			 ,String notNodeType,
			 String isShowLastNoChild,
			 String dataType) {
		try {
			StringBuffer userRoleSb = new StringBuffer(",");
			if(StringUtil.isNotNullOrBlank(userId)){
				SysUserRole sysUserRole = new SysUserRole();
				sysUserRole.setUserId(userId);
				
				List  list=   sysUserRoleService.query(sysUserRole);
			
				for (Object object : list) {
					SysUserRole sysUserRole1=(SysUserRole)object;
					userRoleSb.append(sysUserRole1.getRoleId());
					userRoleSb.append(",");
				}
				 
			}
			
			List<String> listNodeType = new ArrayList<String>();
			
			if("5".equals(notNodeType)){
				listNodeType.add("0");
				listNodeType.add("1");
				listNodeType.add("2");
				listNodeType.add("3");
				listNodeType.add("4");
			}else{
				listNodeType.add("0");
				listNodeType.add("1");
				listNodeType.add("2");
				listNodeType.add("3");
				listNodeType.add("4");
				listNodeType.add("5");
			}
			
			SysDepartInfo.setNodeTypes(listNodeType);
			
			
			List list = SysDepartInfoService.queryList(SysDepartInfo);
			List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < list.size(); i++) {
				SysDepartInfo sysDepartInfo = (SysDepartInfo) list.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("PARENT_ID", sysDepartInfo.getParentDepartId());
				map.put("ID", sysDepartInfo.getDepartId());
				map.put("NAME", sysDepartInfo.getDepartName());
				map.put("isVirtual", sysDepartInfo.getIsVirtual());
				map.put("NODE_TYPE", sysDepartInfo.getNodeType());
				if(userRoleSb.indexOf(","+sysDepartInfo.getDepartId()+",")>-1){
					map.put("checked", true);
				}
				 
				int length = sysDepartInfo.getDepartId().length();
				if(StringUtil.isNullOrBlank(isShowLastNoChild)||"Y".equals(isShowLastNoChild)){
					listMap.add(map);
				}else{
					// 6 单位，角色，12，部门，角色，18  班组，角色
					if ((length==6||length==12||length==18)&&!"5".equals(dataType)) {
						SysDepartInfo SysDepartInfo1 = new SysDepartInfo();
						SysDepartInfo1.setParentDepartId(sysDepartInfo.getDepartId());
						List<String>  nodeTypes =new ArrayList<String>();
						nodeTypes.add("0");
						nodeTypes.add("1");
						nodeTypes.add("2");
						nodeTypes.add("3");
						nodeTypes.add("4");
						SysDepartInfo1.setNodeTypes(nodeTypes);
						SysDepartInfo1.setIsVirtual("1");
						int  count=SysDepartInfoService.getDepartInfoByLikeParentIdCount(SysDepartInfo1);
						if(count>0){
							listMap.add(map);
						}
					}else  {
						//角色
						if("5".equals(dataType)){
							if(sysDepartInfo.getNodeType()!=5){
								SysDepartInfo SysDepartInfo1 = new SysDepartInfo();
								List<String>  nodeTypes =new ArrayList<String>();
								nodeTypes.add("5");
								SysDepartInfo1.setNodeTypes(nodeTypes);
								SysDepartInfo1.setParentDepartId(sysDepartInfo.getDepartId());
								SysDepartInfo1.setIsVirtual("1");
								int  count=SysDepartInfoService.getDepartInfoByLikeParentIdCount(SysDepartInfo1);
								if(count>0){
									listMap.add(map);
								}
							}else{
								
								listMap.add(map);
							}
						}else{
							listMap.add(map);
						}
					}
				}
			}
			TreeService s = new TreeService();
			String srt = JSONArray.fromObject(s.getTreeData(listMap, "-1"))
					.toString();
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(srt);

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
	@RequestMapping(value = "/getDepartInfoByParentId", method = RequestMethod.GET)
	public String getDepartInfoByParentId(String parentDepartId,
			HttpSession session, HttpServletRequest request,
			HttpServletResponse response,int pageIndex,int pageSize) {
		try {
			SysDepartInfo SysDepartInfo = new SysDepartInfo();
			SysDepartInfo.setParentDepartId(parentDepartId);
			SysDepartInfo.setPageSize(pageSize);
			SysDepartInfo.setCurrPage(pageIndex);
			int  count=SysDepartInfoService.getDepartInfoByParentIdCount(SysDepartInfo);
			List list = SysDepartInfoService
					.getDepartInfoByParentId(SysDepartInfo);
			//{total:15,rows:[{name:'test',age:12},{name:'test2',age:18}]}
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("count", count);
			map.put("code", 0);
			map.put("rows", JSONArray.fromObject(list));
			 JSONUtils.objectToJson(request, response, map);
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
	@RequestMapping(value = "/getDepartInfoByDepartId", method = RequestMethod.GET)
	public void getDepartInfoByDepartId(String departId,
			HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		try {
		 
			SysDepartInfo  sysDepartInfo=(SysDepartInfo) SysDepartInfoService.queryByPkId(departId);
		 
			Map<String,Object> map = new HashMap<String,Object>();
		    map.put("sysDepartInfo", sysDepartInfo);
			 JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
}