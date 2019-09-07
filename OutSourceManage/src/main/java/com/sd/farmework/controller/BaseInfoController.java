package com.sd.farmework.controller; 

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.farmework.service.SdBasicInfoService;
import com.sd.farmework.service.SdPushSetInfoService;
import com.sd.farmework.service.SysUserInfoService;
import com.sd.farmework.services.util.wx.WeixinUtil;
import com.sd.farmework.services.util.wx.WxConstant;
import com.sd.farmework.pojo.SdBasicInfo; 
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;

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
import org.springframework.web.bind.annotation.ResponseBody;
/** 
 * 
 * @author Administrator 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @RequestMapping(value="/BaseInfo")
public class BaseInfoController{ 
    @Autowired
    private SysUserInfoService sysUserInfoService;
    /**
     * 获取当前登录用户信息
     * @param session
     * @param request
     * @param response
     * @param model
     */
    @ResponseBody
    @RequestMapping(value = "/queryUser",method = RequestMethod.POST)
    public void queryUser(HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model){
    	try {
    		HttpSessionProvider sessionProvider=new HttpSessionProvider();
        	SysUserInfo sysUserInfo=sessionProvider.getCurrentUserSession(session, request, response);
        	
        	
        	Map<String,Object> map = new HashMap<String,Object>();
        	map.put("code","000");
        	map.put("sysUserInfo", sysUserInfo);
        	JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "001");
			map.put("msg", "系统繁忙");
			JSONUtils.objectToJson(request, response, map);
		}
    	
    }
  
}