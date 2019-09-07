package com.sd.farmework.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sd.farmework.common.PropertiesConstant;
import com.sd.farmework.services.util.wx.WeixinUtil;
import com.sd.farmework.services.util.wx.WxConstant;





/**
 * 微信扫一扫
 * @author 杨洋
 * 2017-1-06
 * 
 */

@Scope("prototype")
@RequestMapping(value="/weixinUtil")
@Controller
public class WxUtilController {
	private static Logger logger = Logger.getLogger(WxUtilController.class);
	@Autowired 
	private WxConstant wxConstant  ;
	@Autowired 
	private PropertiesConstant propertiesConstant;
	
	 
	
	@ResponseBody
	@RequestMapping(value = "/getJsSdkData", method = RequestMethod.GET) 
	public Object  weixinpay(HttpServletRequest request,String shareChannel) throws Exception{
		 
		//String url ="http://www.caixiaolian.com/Farmework/wx/share.html";
		String url ="";
		String shareType = request.getParameter("type");
		System.out.println("域名:"+propertiesConstant.getServerDomain());
		 
		 
	 
		String link = "";
		//wxpage/targetManage/selfCenter/recommend.html
		//url 必须和发起分享的页面地址一致
//		if("1".equals(shareType)){
//			link =propertiesConstant.getServerDomain()+"/"+propertiesConstant.getServerName()+"/wxpage/myTarget/joinTeam/jointeam.html?parentNo="+superAccountNo+"&teamNo="+teamAccountNo+"&shareChannel="+shareChannel;
//		   url =propertiesConstant.getServerDomain()+"/"+propertiesConstant.getServerName()+"/wxpage/targetManage/selfCenter/recommend/recommend.html";
//		}
		
		
	
		
		Map<String, String> map = WeixinUtil.getJsSDKMap(wxConstant, url);
		map.put("appId", wxConstant.getWxAppId());
		map.put("link", link);
		
		
		
		
	     for (Map.Entry entry : map.entrySet()) {
	            System.out.println(entry.getKey() + ", " + entry.getValue());
	     }
	     map.remove("jsapi_ticket");
	      
		return map;
		
	}
	
 
	
	 
 }