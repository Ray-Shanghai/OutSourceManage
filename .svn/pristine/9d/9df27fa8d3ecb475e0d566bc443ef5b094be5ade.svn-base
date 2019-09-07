package com.sd.farmework.controller; 

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.farmework.service.SdBasicInfoService;
import com.sd.farmework.service.SdPushSetInfoService;
import com.sd.farmework.service.SdSigninInfoService;
import com.sd.farmework.service.SysUserInfoService;
import com.sd.farmework.services.util.wx.WeixinUtil;
import com.sd.farmework.services.util.wx.WxConstant;
import com.sd.farmework.pojo.SdBasicInfo; 
import com.sd.farmework.pojo.SdSigninInfo;
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
 * 个人中心
 * @author Administrator 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @RequestMapping(value="/personCenter")
public class PersonalCenterController{ 
    @Autowired
    private SysUserInfoService sysUserInfoService;
    @Autowired
    private SdBasicInfoService sdBasicInfoService;
    @Autowired
    private WxConstant wxConstant;
    @Autowired
    private SdPushSetInfoService sdPushSetInfoService;
    @Autowired
    private SdSigninInfoService sdSigninInfoService;
    /**
     * 获取当前登录用户信息
     * @param session
     * @param request
     * @param response
     * @param model
     */
    @ResponseBody
    @RequestMapping(value = "/queryloginUser",method = RequestMethod.POST)
    public void queryloginUser(HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model){
    	try {
    		HttpSessionProvider sessionProvider=new HttpSessionProvider();
        	SysUserInfo sysUserInfo=sessionProvider.getCurrentUserSession(session, request, response);
        	List list=sdBasicInfoService.queryOrderCountByStatus(null); //查询每个状态下的订单数量
        	int queRenNum=0;
        	 if(((SdBasicInfo) list.get(0)).getOrderCount()!=null){
        		 queRenNum=((SdBasicInfo) list.get(0)).getOrderCount();
        	 }
        	 int caigouNum=0;
        	 if(((SdBasicInfo) list.get(0)).getOrderCount()!=null){
        		 caigouNum=((SdBasicInfo) list.get(1)).getOrderCount();
        	 }
        	 int baojiaNum=0;
        	 if(((SdBasicInfo) list.get(0)).getOrderCount()!=null){
        		 baojiaNum=((SdBasicInfo) list.get(2)).getOrderCount();
        	 }
        	 int hedingNum=0;
        	 if(((SdBasicInfo) list.get(0)).getOrderCount()!=null){
        		 hedingNum=((SdBasicInfo) list.get(3)).getOrderCount();
        	 }
        	 int jianyanNum=0;
        	 if(((SdBasicInfo) list.get(0)).getOrderCount()!=null){
        		 jianyanNum=((SdBasicInfo) list.get(4)).getOrderCount();
        	 }
        	 int peiliaoNum=0;
        	 if(((SdBasicInfo) list.get(0)).getOrderCount()!=null){
        		 peiliaoNum=((SdBasicInfo) list.get(5)).getOrderCount();
        	 }
        	 int caiqieNum=0;
        	 if(((SdBasicInfo) list.get(0)).getOrderCount()!=null){
        		 caiqieNum=((SdBasicInfo) list.get(6)).getOrderCount();
        	 }
        	 int shengchanNum=0;
        	 if(((SdBasicInfo) list.get(0)).getOrderCount()!=null){
        		 shengchanNum=((SdBasicInfo) list.get(7)).getOrderCount();
        	 }
        	 int wanchenNum=0;
        	 if(((SdBasicInfo) list.get(0)).getOrderCount()!=null){
        		 wanchenNum=((SdBasicInfo) list.get(8)).getOrderCount();
        	 }
        	 int yanshouNum=0;
        	 if(((SdBasicInfo) list.get(0)).getOrderCount()!=null){
        		 yanshouNum=((SdBasicInfo) list.get(9)).getOrderCount();
        	 }
        	 int wanjieNum=0;
        	 if(((SdBasicInfo) list.get(0)).getOrderCount()!=null){
        		 wanjieNum=((SdBasicInfo) list.get(10)).getOrderCount();
        	 }
        	int totalCount=(baojiaNum+hedingNum+jianyanNum+peiliaoNum+caiqieNum+shengchanNum+wanchenNum+yanshouNum+wanjieNum);
        	int zhipaiCount=(caigouNum+jianyanNum);
        	int baojiaCount=(baojiaNum+hedingNum);
        	int shengcanCount=(peiliaoNum+caiqieNum+shengchanNum+wanchenNum+yanshouNum+wanjieNum);
        	
        	Map<String,Object> map = new HashMap<String,Object>();
        	map.put("code","000");
        	map.put("sysUserInfo", sysUserInfo);
        	map.put("queRenNum",queRenNum);
        	map.put("caigouNum",caigouNum);
        	map.put("baojiaNum",baojiaNum);
        	map.put("hedingNum",hedingNum);
        	map.put("jianyanNum",jianyanNum);
        	map.put("peiliaoNum",peiliaoNum);
        	map.put("caiqieNum",caiqieNum);
        	map.put("shengchanNum",shengchanNum);
        	map.put("wanchenNum",wanchenNum);
        	map.put("yanshouNum",yanshouNum);
        	map.put("wanjieNum",wanjieNum);
        	map.put("totalCount",totalCount);
        	map.put("zhipaiCount",zhipaiCount);
        	map.put("baojiaCount",baojiaCount);
        	map.put("shengcanCount",shengcanCount);
        	
        	JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "001");
			map.put("msg", "系统繁忙");
			JSONUtils.objectToJson(request, response, map);
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
    @RequestMapping(value = "/queryList",method = RequestMethod.POST)
    public String  queryList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdBasicInfo sdbasicinfo,Model model){
    	Map<String,Object> map = new HashMap<String,Object>();
    	try {
	   		List list = sysUserInfoService.queryList(sdbasicinfo);	
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
    
    
     
    /**
     * 获取页面需要的配置信息的参数
     * @param session
     * @param request
     * @param response
     * @param model
     * @return
     */
    @ResponseBody 
    @RequestMapping(value = "/getJsTicket",method = RequestMethod.POST)
    public Map<String, String>  queryListByPage(HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model,String url){
    	Map<String, String> map = new HashMap<String, String>();  
		try {
			map=WeixinUtil.getJsSDKMap(wxConstant, url);
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
    /**
    * 通过主键查询一条信息
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/queryByPkId",method = RequestMethod.POST)
    public String  queryByPkId(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdBasicInfo sdbasicinfo,Model model,String pkId){
		try {
			sysUserInfoService.queryByPkId(pkId);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
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
    @RequestMapping(value = "/queryByPushSet",method = RequestMethod.POST)
    public String  queryByPushSet(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdBasicInfo sdbasicinfo,Model model){
    	HttpSessionProvider sessionProvider =new HttpSessionProvider();
    	SysUserInfo user=sessionProvider.getCurrentUserSession(session, request, response);	
		try {
		 Map<String,Object> map=new HashMap<String,Object>();
		 map.put("userName", user.getUserName());
		 map.put("position",user.getPosition());
			//每个人的订单完结成交量，销售额
       	 Calendar now = Calendar.getInstance();  
       	 //获取年 
       	 int year= now.get(Calendar.YEAR);
       	 //获取当前月
       	 int month=(now.get(Calendar.MONTH) + 1);
       	 Map<String,Object> strMap=new HashMap<String, Object>();
       	 strMap.put("lastUpdateTime", year+"-"+month+"-"+"00 00:00:00");
       	 if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
       		strMap.put("lastUpdateTime2", year+"-"+month+"-"+"31 00:00:00");
       	 }else if(month==4||month==6||month==9||month==11){
       		strMap.put("lastUpdateTime2", year+"-"+month+"-"+"30 00:00:00");
       	 }else{
       		strMap.put("lastUpdateTime2", year+"-"+month+"-"+"28 00:00:00");
       	 }
       	 strMap.put("userIdList", new String[]{user.getUserId()});
       	 List<Map<String, Object>> monthPushList=this.sdPushSetInfoService.queryUserByOrderOnPush(strMap);
       	 if(monthPushList!=null){
       		Long count= (Long) monthPushList.get(0).get("totalCount");//成交量
       		int totalNum=count.intValue();
       		map.put("totalNum", totalNum);
       		Double totalPrice=0.00;//销售额
       		Double totalPushNum=0.00;
   			if( monthPushList.get(0).get("totalPrice")!=null){
   				 totalPrice=(Double) monthPushList.get(0).get("totalPrice");
   			}
   			if(monthPushList.get(0).get("totalPushNum")!=null){
   				totalPushNum=(Double) monthPushList.get(0).get("totalPushNum");
   			}
   			Double yujiMoney=0.0;
			 if(totalNum>0){
				yujiMoney=totalPrice*(totalPushNum/totalNum)*0.01;//预计收益
				BigDecimal bigDecimal=new BigDecimal(yujiMoney);
				yujiMoney=bigDecimal.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			 }
   			map.put("totalPrice", totalPrice);
   			map.put("yujiMoney", yujiMoney);
       	 } 
       	 //获取年份统计数据
       	 Map<String,Object> strMap2=new HashMap<String, Object>();
       	 strMap2.put("lastUpdateTime", year+"-01-01 00:00:00");
    	 strMap2.put("lastUpdateTime2", year+"-12-31 00:00:00");
    	 strMap2.put("userIdList", new String[]{user.getUserId()});
    	 List<Map<String, Object>> yearPushList=this.sdPushSetInfoService.queryUserByOrderOnPush(strMap2);
    	 if(yearPushList!=null){
        		Long count2= (Long) yearPushList.get(0).get("totalCount");//成交量
        		int totalCount2=count2.intValue();
        		Double totalPrice2=0.00;//销售额
        		Double totalPushNum2=0.00;
    			if( monthPushList.get(0).get("totalPrice")!=null){
    				totalPrice2=(Double) monthPushList.get(0).get("totalPrice");
    			}
    			if(monthPushList.get(0).get("totalPushNum")!=null){
    				totalPushNum2=(Double) monthPushList.get(0).get("totalPushNum");
    			}
    			Double yujiMoney2=0.0;
    			if(totalCount2>0){
    				yujiMoney2=totalPrice2*(totalPushNum2/totalCount2)*0.01;//预计收益
    				BigDecimal bigDecimal=new BigDecimal(yujiMoney2);
    				yujiMoney2=bigDecimal.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
    			}
    			map.put("totalCount2", totalCount2);
    			map.put("totalPrice2", totalPrice2);
    			map.put("yujiMoney2", yujiMoney2);
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
     * 添加签到信息
     * @param session
     * @param request
     * @param response
     * @param sdSigninInfo
     * @param model
     */
    @ResponseBody
    @RequestMapping(value = "/addSigninInfo",method = RequestMethod.POST)
    public void addSigninInfo(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdSigninInfo sdSigninInfo,Model model){
    	try {
			HttpSessionProvider sessionProvider=new HttpSessionProvider();
			sdSigninInfo=(SdSigninInfo) sessionProvider.fillBaseInfo(sdSigninInfo, session, request, response);
			this.sdSigninInfoService.add(sdSigninInfo);
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "000");
			map.put("msg", "success");
			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "001");
			map.put("msg", "系统繁忙");
			JSONUtils.objectToJson(request, response, map);
		}
    }
    /**
     * 查询签到列表分页
     * @param session
     * @param request
     * @param response
     * @param sdSigninInfo
     * @param pageIndex
     * @param pageSize
     * @param model
     */
    @ResponseBody
    @RequestMapping(value = "/querySigninList",method = RequestMethod.POST)
    public void querySigninList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdSigninInfo sdSigninInfo,
    		int pageIndex,int pageSize,Model model){
    	try {
    		sdSigninInfo.setCurrPage(pageIndex);
    		sdSigninInfo.setPageSize(pageSize);
			List list=this.sdSigninInfoService.queryListByPage(sdSigninInfo);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("count", this.sdSigninInfoService.queryCount(sdSigninInfo));
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
    }
    
    public static void main(String[] args) throws Exception {  
        Calendar now = Calendar.getInstance();  
        System.out.println("年: " + now.get(Calendar.YEAR));  
        System.out.println("月: " + (now.get(Calendar.MONTH) + 1) + "");  
        System.out.println("日: " + now.get(Calendar.DAY_OF_MONTH));  
        System.out.println("时: " + now.get(Calendar.HOUR_OF_DAY));  
        System.out.println("分: " + now.get(Calendar.MINUTE));  
        System.out.println("秒: " + now.get(Calendar.SECOND));  
        System.out.println("当前时间毫秒数：" + now.getTimeInMillis());  
        System.out.println(now.getTime());  
  
        Date d = new Date();  
        System.out.println(d);  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String dateNowStr = sdf.format(d);  
        System.out.println("格式化后的日期：" + dateNowStr);  
          
        String str = "2012-1-13 17:26:33";  //要跟上面sdf定义的格式一样  
        Date today = sdf.parse(str);  
        System.out.println("字符串转成日期：" + today);  
    }  
}