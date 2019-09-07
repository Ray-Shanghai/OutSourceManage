package com.sd.farmework.controller; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.farmework.service.SdPushSetInfoService; 
import com.sd.farmework.pojo.SdPushSetInfo; 
import com.sd.farmework.common.Constant;
import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;
import com.sd.farmework.common.util.StringUtil;

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
 * test
 * @author Administrator 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @RequestMapping(value="/SdPushSetInfo")
public class SdPushSetInfoController{ 
    @Autowired
    private SdPushSetInfoService sdPushSetInfoService;
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
     public String add(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdPushSetInfo sdPushSetInfo,Model model){
     	Map<String,String> map = new HashMap<String,String>();
     	try {
 			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
 			sdPushSetInfo = (SdPushSetInfo) httpSessionProvider.fillBaseInfo(sdPushSetInfo, session, request, response);
 			sdPushSetInfoService.add(sdPushSetInfo);
 			map.put("code", "000");
 			map.put("msg", "success");
 			JSONUtils.objectToJson(request, response, map);
 		} catch (Exception e) {
 			e.printStackTrace();
 			map.put("code", "002");
 			map.put("msg", "网络繁忙，请稍后再试");
 			JSONUtils.objectToJson(request, response, map);
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
     public String  update(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdPushSetInfo sdPushSetInfo,Model model){
     	Map<String,String> map = new HashMap<String,String>();
     	try {
 			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
 			sdPushSetInfo = (SdPushSetInfo) httpSessionProvider.fillBaseInfo(sdPushSetInfo, session, request, response);
 			sdPushSetInfoService.update(sdPushSetInfo);	
 			map.put("code", "000");
 			map.put("msg", "success");
 			JSONUtils.objectToJson(request, response, map);
 		} catch (Exception e) {
 			e.printStackTrace();
 			map.put("code", "002");
 			map.put("msg", "网络繁忙，请稍后再试");
 			JSONUtils.objectToJson(request, response, map);
 		}
 		return null;
 	}
     /**
     * 删除
     * @param session
     * @param request
     * @param response
     * @param SysApprovenFunction
     * @param model
     * @return
     */
     @RequestMapping(value = "/delete",method = RequestMethod.POST)
     public String  delete(HttpSession session,HttpServletRequest request,HttpServletResponse response,String pkId,Model model){
     	Map<String,String> map = new HashMap<String,String>();
     	try {
     		SdPushSetInfo sdPushSetInfo = new SdPushSetInfo();
     		sdPushSetInfo.setPushSetId(Integer.parseInt(pkId));
     		sdPushSetInfoService.delete(sdPushSetInfo);	
 			map.put("code", "000");
 			map.put("msg", "success");
 			JSONUtils.objectToJson(request, response, map);
 		} catch (Exception e) {
 			e.printStackTrace();
 			map.put("code", "002");
 			map.put("msg", "网络繁忙，请稍后再试");
 			JSONUtils.objectToJson(request, response, map);
 		}
 		return null;
 	}
     
     /**
      * 通过ID获取信息
      * @param dictionaryTypeId
      * @param session
      * @param request
      * @param response
      * @param sysFunctionInfo
      * @param model
      * @return
      */
     @SuppressWarnings("rawtypes")
     @RequestMapping(value = "/queryByPkId",method = RequestMethod.POST)
     public String querySdPushSetInfo(String pkId ,HttpSession session,HttpServletRequest request,HttpServletResponse response ,Model model){
     	Map<String,Object> map = new HashMap<String,Object>();
     	SdPushSetInfo sdPushSetInfo = new SdPushSetInfo();
     	sdPushSetInfo.setPushSetId(Integer.parseInt(pkId));
 		try {
 			sdPushSetInfo = (SdPushSetInfo)sdPushSetInfoService.queryByPkId(pkId);
 			map.put("rows", sdPushSetInfo);
 			map.put("code", "000");
 			map.put("msg", "success");
 		} catch (Exception e) {
 			e.printStackTrace();
 			map.put("code", "002");
			map.put("msg", "网络繁忙，请稍后再试");
			JSONUtils.objectToJson(request, response, map);
 		}
 		JSONUtils.objectToJson(request, response, map);
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
 			HttpServletRequest request, HttpServletResponse response, SdPushSetInfo sdPushSetInfo, Model model) {
 		Map<String,Object> map = new HashMap<String,Object>();
 		map.put("code", 0);
 		map.put("msg", Constant.SUCCESS_MSG);
 		try {
 			List list = sdPushSetInfoService.queryList(sdPushSetInfo);
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
     public String  queryListByPage(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdPushSetInfo sdPushSetInfo,int pageIndex,int pageSize,Model model){
     	Map<String,Object> map = new HashMap<String,Object>();
     	try {
     		sdPushSetInfo.setPageSize(pageSize);
     		sdPushSetInfo.setCurrPage(pageIndex);
     		sdPushSetInfo.setTotalCount(sdPushSetInfoService.queryCount(sdPushSetInfo));	
 			List list = sdPushSetInfoService.queryListByPage(sdPushSetInfo);
 			map.put("count", sdPushSetInfo.getTotalCount());
 			map.put("code", 0);
 			map.put("rows", JSONArray.fromObject(list));
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
     * 通过任意条件查询一条信息
     * @param session
     * @param request
     * @param response
     * @param SysApprovenFunction
     * @param model
     * @return
     */
     @RequestMapping(value = "/query",method = RequestMethod.POST)
     public String  query(HttpSession session,HttpServletRequest request,HttpServletResponse response,SdPushSetInfo sdPushSetInfo,Model model){
    	 Map<String,Object> map = new HashMap<String,Object>();
    	 try {
 			List list = sdPushSetInfoService.query(sdPushSetInfo);
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
      * 提成统计查询（按人，时间统计提成金额）
      * @param session
      * @param request
      * @param response
      * @param sdPushSetInfo
      * @param model
      */
     @ResponseBody
     @RequestMapping(value = "/queryPushSetByUser",method = RequestMethod.POST)
     public void queryPushSetByUser(HttpSession session,HttpServletRequest request,HttpServletResponse response,
    		 Model model,String lastUpdateTime,String lastUpdateTime2,String userIds){
    	 	Map<String,Object> map = new HashMap<String,Object>();
    	 try {
    		 Map<String,Object> strMap=new HashMap<String,Object>();
        	 strMap.put("lastUpdateTime", lastUpdateTime);
        	 strMap.put("lastUpdateTime2", lastUpdateTime2);
        	 if(StringUtil.isNotNullOrBlank(userIds)){
        		 strMap.put("userIdList", userIds.split(","));
        	 }
        	 List<Map<String, Object>> pushList=this.sdPushSetInfoService.queryUserByOrderOnPush(strMap);
        	 List<Double> pushMoneylist=new ArrayList<Double>();
        	 if(pushList!=null){
        		 for (int i = 0; i < pushList.size(); i++) {
        			 Long count= (Long) pushList.get(i).get("totalCount");//成交量
             		 int totalNum=count.intValue();
             		 map.put("totalNum", totalNum);
             		 Double totalPrice=0.00;//销售额
             		 Double totalPushNum=0.00;
         			 if( pushList.get(i).get("totalPrice")!=null){
         				 totalPrice=(Double) pushList.get(i).get("totalPrice");
         			 }
         			 if(pushList.get(i).get("totalPushNum")!=null){
         				totalPushNum=(Double) pushList.get(i).get("totalPushNum");
         			 }
         			 Double yujiMoney=0.0;
         			 if(totalNum>0){
         				yujiMoney=totalPrice*(totalPushNum/totalNum)*0.01;//预计收益
         			 }
         			 pushMoneylist.add(yujiMoney);
				}
            		
             }
        	 map.put("code", "000");
        	 map.put("pushMoneylist", pushMoneylist);
        	 JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", "001");
 			map.put("msg", "系统繁忙");
 			JSONUtils.objectToJson(request, response, map);
		}
     }
}