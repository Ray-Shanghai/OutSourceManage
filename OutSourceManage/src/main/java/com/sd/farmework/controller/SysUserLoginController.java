package com.sd.farmework.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;
import com.sd.farmework.common.MD5Util;
import com.sd.farmework.common.util.DateUtil;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.pojo.Menu;
import com.sd.farmework.pojo.SysFunctionInfo;
import com.sd.farmework.pojo.SysLogInfo;
import com.sd.farmework.pojo.SysRoleInfo;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.pojo.SysUserRole;
import com.sd.farmework.service.SysFunctionInfoService;
import com.sd.farmework.service.SysLogInfoService;
import com.sd.farmework.service.SysRoleInfoService;
import com.sd.farmework.service.SysUserInfoService;
import com.sd.farmework.service.SysUserRoleService;
import com.sd.farmework.services.util.wx.WeixinUtil;
import com.sd.farmework.services.util.wx.WxConstant;

/**
 * 用户信息操作
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("rawtypes")
@Controller
@Scope("prototype")
@RequestMapping(value = "/manager/loginIn/SysUserInfo")
public class SysUserLoginController {
	private static Logger logger = Logger.getLogger("SysUserLoginController");
	@Autowired
	private SysUserInfoService SysUserInfoService;
	@Autowired
	private SysFunctionInfoService sysFunctionInfoService;
	@Autowired
	private SysRoleInfoService sysRoleInfoService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysLogInfoService sysLogInfoService;
	@Autowired
	private WxConstant wxConstant;


	/**
	 * 登录
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenFunction
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void query(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysUserInfo SysUserInfo) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", "LOGIN_0000");
		map.put("msg", "success");

		try {
			SysUserInfo.setLoginPwd(MD5Util.GetMD5Code(SysUserInfo
					.getLoginPwd()));
			SysUserInfo.setLoginName(SysUserInfo.getLoginName().trim());
			@SuppressWarnings("unchecked")
			List<BaseInfo> list = SysUserInfoService.query(SysUserInfo);
			System.out.println(list);
			 
			if (list.size() == 0) {
				map.put("code", "LOGIN_0001");
				map.put("msg", "用户名或密码不存在。");
				logger.info("用户名或密码不存在.。");
			} else if (list.size() > 1) {
				map.put("code", "LOGIN_0002");
				map.put("msg", "用户名或密码不存在。");
				logger.info("用户名或密码不存在。");
			} else {
				SysUserInfo sysUserInfo = (SysUserInfo) list.get(0);
			 
				session.setAttribute(
						HttpSessionProvider.CURRENT_USER_SESSION_KEY,
						sysUserInfo);
				 

				List functionInfoList = sysFunctionInfoService.queryList(null);
				if (functionInfoList == null || functionInfoList.size() == 0) {
					logger.info("没有分配角色信息。");
					map.put("code", "LOGIN_0003");
					map.put("msg", "没有分配角色信息");
				} else {
					
					SysLogInfo sysLogInfo =new SysLogInfo();
					
					sysLogInfo.setOperatePersonId(sysUserInfo.getUserId());
					sysLogInfo.setFunctionUrl("login.do");
					sysLogInfo.setFunctionName("登陆");
					sysLogInfo.setRemark("登陆");
					sysLogInfo.setFunctionDesc("登陆成功");
					sysLogInfo.setOperatePersonName(sysUserInfo.getUserName());
					sysLogInfo.setOperateTime(DateUtil.getCurrentDateString()); 
					
					sysLogInfo.setCreateDepartId(sysUserInfo.getDepartId());
					sysLogInfo.setCreateDepartName(sysUserInfo.getDepartName());
					sysLogInfo.setCreateUserId(sysUserInfo.getUserId());
					sysLogInfo.setCreateUserName(sysUserInfo.getUserName());
					
					sysLogInfoService.add(sysLogInfo);
					SysUserInfo sysUserRole = new SysUserInfo();
					sysUserRole.setUserId(sysUserInfo.getUserId());
					List sysUserRoleList = sysRoleInfoService
							.queryFunction(sysUserRole);

					StringBuffer sb = new StringBuffer();

					for (int i = 0; i < sysUserRoleList.size(); i++) {
						SysRoleInfo sysUserRoleI = (SysRoleInfo) sysUserRoleList
								.get(i);
						// sysUserRoleI.get
						sb.append(sysUserRoleI.getFunctionIds());
					}
 					List<Map> childTypeList  = new ArrayList<Map>();
 					LinkedHashMap<String,List<Map>> functionTypeMap = new LinkedHashMap<String,List<Map>>();
					for (int i = 0; i < functionInfoList.size(); i++) {
						SysFunctionInfo sysFunctionInfo = (SysFunctionInfo) functionInfoList.get(i);
						String functionId = sysFunctionInfo.getFunctionId();
						
						if (functionId.length() == 6) {
							//父节点
							String functionName = sysFunctionInfo.getFunctionName();
							String typeId = sysFunctionInfo.getTypeId();
							List<Menu> list11= new ArrayList<Menu>();
							//匹配对应二级功能
							for (int j = 0; j < functionInfoList.size(); j++) {
								SysFunctionInfo sysFunctionInfoChild = (SysFunctionInfo) functionInfoList.get(j);
								String parentFunctionId = sysFunctionInfoChild.getParentFunctionId();
								if (sysFunctionInfoChild.getFunctionId().length()==9&&parentFunctionId.equals(functionId)&&sb.toString().indexOf(","+ sysFunctionInfoChild.getFunctionId() + ",") > -1) {
									Menu menu = new Menu();
									
									menu.setTitle(sysFunctionInfoChild.getFunctionName());
									menu.setIcon(sysFunctionInfoChild.getFunctionIcon());
									menu.setSpread(true);
									
									menu.setOrderNo(Integer.valueOf(sysFunctionInfoChild.getFunctionSeque()));
									menu.setId(sysFunctionInfoChild.getFunctionId());
									menu.setText(sysFunctionInfoChild.getFunctionName());
									menu.setParentMenuId(sysFunctionInfoChild.getParentFunctionId());
									menu.setHref(sysFunctionInfoChild.getFunctionUrl());
									menu.setMenuType(sysFunctionInfoChild.getTypeId());
									list11.add(menu);
								}
							}
							 
							Map map1 = new HashMap();
							if(list11.size()>0){
								map1.put("title", functionName);
								map1.put("icon", sysFunctionInfo.getFunctionIcon());
								map1.put("functionSeque", sysFunctionInfo.getFunctionSeque());
								Collections.sort(list11,new Comparator<Menu>(){

									@Override
									public int compare(Menu o1, Menu o2) {
										// TODO Auto-generated method stub
										
										return o1.getOrderNo()<o2.getOrderNo()?-1:1;
									}
									
								});
								
								
								map1.put("children", list11);
							}else{
								
								continue;
							}
							
							if(!functionTypeMap.containsKey(typeId)){
								childTypeList =new  ArrayList<Map>();
								childTypeList.add(map1);
								
								
								
								
								functionTypeMap.put(typeId, childTypeList);
							}else{
								childTypeList.add(map1);
							}
							 
						}
					}
					
					
					
					for (String key :functionTypeMap.keySet()) {
						List<Map>  li = functionTypeMap.get(key);
						Collections.sort(li,new Comparator<Map>(){
							@Override
							public int compare(Map o1, Map o2) {
								// TODO Auto-generated method stub
								
								int no1 = Integer.valueOf(o1.get("functionSeque").toString());
								int no2= Integer.valueOf(o2.get("functionSeque").toString());;
								return no1<no2?-1:1;
							}
						});
						functionTypeMap.put(key, li);
					}
					session.setAttribute("functionMap", functionTypeMap);
				}
				 
			}
			JSONUtils.objectToJson(request, response, map);

		} catch (Exception e) {
			e.printStackTrace();

			map.put("code", "LOGIN_0004");
			map.put("msg", "系统繁忙，请稍后再试。");

			JSONUtils.objectToJson(request, response, map);

		}

	}
	/**
	 * 中转页面
	 * @param session
	 * @param request
	 * @param response
	 * @param code
	 */
	@RequestMapping(value = "/transfer",method = RequestMethod.POST)
	public void transfer(HttpSession session,HttpServletRequest request,HttpServletResponse response,String code){
		try {
				Map<String,String> strMap=new HashMap<String, String>();
				System.out.println("跳转页当前code="+code);
				Map<String, Object> map = WeixinUtil.getOpenId(code,wxConstant);
				String openid = String.valueOf(map.get("openid"));
				System.out.println("跳转页当前用户的openid："+openid);
				//判断用户表中是否有该openid的用户
				SysUserInfo sysUserInfo=new SysUserInfo();
				sysUserInfo.setWxOpenId(openid);
				SysUserInfo newUser=this.SysUserInfoService.queryUserByOpenId(sysUserInfo);
				if(newUser!=null){
					session.setAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY, newUser);
					strMap.put("code", "000");
					strMap.put("nextUri", "index.html");
				}else{
					strMap.put("code", "001");
					strMap.put("nextUri", "login.html");
					strMap.put("openid",openid);
				}
				JSONUtils.objectToJson(request, response, strMap);
		} catch (Exception e) {
			Map<String,String> strMap=new HashMap<String, String>();
			strMap.put("code", "003");
			strMap.put("msg", "系统繁忙，请稍后再试。");
			JSONUtils.objectToJson(request, response, strMap);
		}
	}
	 /**
     * 微信首次登录
     * @param session
     * @param request
     * @param response
     * @param SysApprovenFunction
     * @param model
     * @return
     */
     @RequestMapping(value = "/wxLogin",method = RequestMethod.POST)
     public void  wxLogin(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysUserInfo sysUserInfo,Model model,String openid){
     	try {
     		Map<String,String> strmap=new HashMap<String, String>();
     		sysUserInfo.setLoginPwd(MD5Util.GetMD5Code(sysUserInfo.getLoginPwd()));
     		sysUserInfo.setLoginName(sysUserInfo.getLoginName().trim());
 			List<BaseInfo> list=	SysUserInfoService.query(sysUserInfo);	
 			System.out.println("登陆用户查询结果集合"+list);
 			if(list.size()==0){
 				strmap.put("code", "001");
 				strmap.put("msg", "系统繁忙,请稍后重试");
				JSONUtils.objectToJson(request, response, strmap);
 			}else if(list.size()>1){
 				strmap.put("code", "002");
 				strmap.put("msg", "系统繁忙,请稍后重试");
 				JSONUtils.objectToJson(request, response, strmap);
 			}else{
 				SysUserInfo oldsysUserInfo =  (SysUserInfo)list.get(0);
 				session.setAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY, oldsysUserInfo);
 				model.addAttribute("userInfo",oldsysUserInfo);
 				//添加登陆日志
 				SysLogInfo sysLogInfo =new SysLogInfo();
				
				sysLogInfo.setOperatePersonId(oldsysUserInfo.getUserId());
				sysLogInfo.setFunctionUrl("wxlogin.do");
				sysLogInfo.setFunctionName("微信端登陆");
				sysLogInfo.setRemark("微信端登陆");
				sysLogInfo.setFunctionDesc("微信端登陆成功");
				sysLogInfo.setOperatePersonName(oldsysUserInfo.getUserName());
				sysLogInfo.setOperateTime(DateUtil.getCurrentDateString()); 
				
				sysLogInfo.setCreateDepartId(oldsysUserInfo.getDepartId());
				sysLogInfo.setCreateDepartName(oldsysUserInfo.getDepartName());
				sysLogInfo.setCreateUserId(oldsysUserInfo.getUserId());
				sysLogInfo.setCreateUserName(oldsysUserInfo.getUserName());
				
				sysLogInfoService.add(sysLogInfo);
 				
 				
 				//绑定用户openid--------start
 				if(StringUtil.isNullOrBlank(oldsysUserInfo.getWxOpenId())&&StringUtil.isNotNullOrBlank(openid)){//为空则说明没有绑定openid
 	 					
 	 	 				System.out.println("当前用户的openid："+openid);
 	 					SysUserInfo paramUser = new SysUserInfo();
 	 	 				paramUser.setUserId(oldsysUserInfo.getUserId());
 	 	 				paramUser.setWxOpenId(openid);
						SysUserInfoService.updateUser(paramUser);
 				}
 				//-------end
 				
 				/*model.addAttribute("functionMap",functionMap);*/
 				strmap.put("code", "000");
 				strmap.put("msg", "success");
 				JSONUtils.objectToJson(request, response, strmap);
 			}
     	} catch (Exception e) {
     		Map<String,String> strMap=new HashMap<String, String>();
			strMap.put("code", "003");
			strMap.put("msg", "系统繁忙，请稍后再试。");
			JSONUtils.objectToJson(request, response, strMap);
     	}
 		 
 	}
	
	/**
	 * 获取当前登录用户信息
	 * @param session
	 * @param request
	 * @param response
	 * @param model
	 * @param userId
	 */
	@ResponseBody
	@RequestMapping(value = "/getCurrentUser", method = RequestMethod.POST)
	public void getCurrentUser(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			Model model, String userId) {
		
		
		 
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", "000");
	 
	 
		HttpSessionProvider p = new HttpSessionProvider();
		SysUserInfo sysUserInfo = p.getCurrentUserSession(session, request,
				response);

		map.put("userName", sysUserInfo.getUserName());

		
		JSONUtils.objectToJson(request, response, map);
		
	}
	
	
	
	/**
	 * 获取功能菜单
	 * @param session
	 * @param request
	 * @param response
	 * @param model
	 * @param userId
	 */
	@ResponseBody
	@RequestMapping(value = "/getCurrentUserMenu", method = RequestMethod.POST)
	public void getCurrentUserMenu(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			Model model, String userId) {
		
		
		Map functionMap= (Map)session.getAttribute("functionMap");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", "INDEX_0000");
	 
		 
		map.put("functionMap", functionMap);
		HttpSessionProvider p = new HttpSessionProvider();
		SysUserInfo sysUserInfo = p.getCurrentUserSession(session, request,
				response);

		map.put("userName", sysUserInfo.getUserName());

		
		JSONUtils.objectToJson(request, response, map);
		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/getCurrentUserMenuByMenuId", method = RequestMethod.GET)
	public void getCurrentUserMenuByMenuId(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			 String menuId) {
		
		
		Map<String,List<Menu>>  functionMap= (Map<String,List<Menu>>)session.getAttribute("functionMap");
 
  
	 
		List lis =new ArrayList();
		
		
		if(StringUtil.isNullOrBlank(menuId)||"all".equals(menuId)){
			
			for (String key : functionMap.keySet()) {
				List l=functionMap.get(key);
			   for (Object object : l) {
				   lis.add(object);
			}
			}
			
		}else{
			  lis =functionMap.get(menuId);
		}
		
		
		JSONUtils.objectToJsonArray(request, response,lis );
		
	}
	  

	 
}