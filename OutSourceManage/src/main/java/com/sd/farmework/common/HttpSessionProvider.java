package com.sd.farmework.common;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.pojo.SysUserInfo;

/**
 * HttpSession提供类
 * 
 * @ClassName: HttpSessionProvider
 * @Description: TODO
 * @author 王超超
 * @date 2016-11-17 下午03:45:35
 * 
 */
public class HttpSessionProvider implements SessionProvider {
	//系统当前登录用户session key
	public static String CURRENT_USER_SESSION_KEY ="loginUser";

	/**
	 * 获取session对象
	 * @param request,name
	 * @Description: TODO
	 * @author 王超超
	 * @date 2016-11-17 下午03:45:35
	 * 
	 */
	public Serializable getAttribute(HttpServletRequest request, String name) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			return (Serializable) session.getAttribute(name);
		} else {
			return null;
		}
	}

	
	/**
	 * 设置session对象
	 * @param request,name
	 * @Description: TODO
	 * @author 王超超
	 * @date 2016-11-17 下午03:45:35
	 * 
	 */
	public void setAttribute(HttpServletRequest request, String name,
			Serializable value) {
		HttpSession session = request.getSession();
		session.setAttribute(name, value);
	}

	/**
	 * 获取session ID
	 * @param request
	 * @Description: TODO
	 * @author 王超超
	 * @date 2016-11-17 下午03:45:35
	 * 
	 */
	public Serializable getSessionId(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			return (Serializable) session.getId();
		} else {
			return null;
		}
	}

	/**
	 * 销毁session
	 * @param request
	 * @Description: TODO
	 * @author 王超超
	 * @date 2016-11-17 下午03:45:35
	 * 
	 */
	public void logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}
	
	/**
	 * 移除指定session对象
	 * @param request
	 * @Description: TODO
	 * @author 王超超
	 * @date 2016-11-17 下午03:45:35
	 * 
	 */
	public void removeAttribute(HttpServletRequest request, String key) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute(key);
		}
	}


	@Override
	public  SysUserInfo getCurrentUserSession(HttpSession session ,HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
			Object obj=session.getAttribute(CURRENT_USER_SESSION_KEY);
			if(obj==null){
				return null;
			}else{
				return (SysUserInfo) obj;
			}
		
		
	}
	public BaseInfo fillBaseInfo(BaseInfo baseInfo,HttpSession session ,HttpServletRequest request,
			HttpServletResponse response) {
		SysUserInfo sys=getCurrentUserSession(session, request, response);
		return fillBaseInfo(baseInfo,sys);
	}
     /**
      * 系统参数自动填充
      */
	@Override
	public BaseInfo fillBaseInfo(BaseInfo baseInfo,SysUserInfo sessionSysUserInfo) {
		// TODO Auto-generated method stub
		
		baseInfo.setCreateUserId(sessionSysUserInfo.getUserId());
		baseInfo.setCreateUserName(sessionSysUserInfo.getUserName());
	 
		baseInfo.setCreateDepartId(StringUtil.fixDefaultString(sessionSysUserInfo.getDepartId()));
		baseInfo.setCreateDepartName(StringUtil.fixDefaultString(sessionSysUserInfo.getDepartName()));
		
		 	
		baseInfo.setLastUpdateUserId(sessionSysUserInfo.getUserId());
		baseInfo.setLastUpdateUserName(sessionSysUserInfo.getUserName());
		
		 	
		baseInfo.setLastUpdateDepartId(StringUtil.fixDefaultString(sessionSysUserInfo.getDepartId()));
		baseInfo.setLastUpdateDepartName(StringUtil.fixDefaultString(sessionSysUserInfo.getDepartName()));
	 		
		return baseInfo;
	}
	 
	public Map fillBaseMap(Map map,SysUserInfo sessionSysUserInfo) {
		// TODO Auto-generated method stub
		 
		map.put("create_user_id",sessionSysUserInfo.getUserId());
		map.put("create_user_name",sessionSysUserInfo.getUserName());
	 
		map.put("create_depart_id",StringUtil.fixDefaultString(sessionSysUserInfo.getDepartId()));
		map.put("create_depart_name",StringUtil.fixDefaultString(sessionSysUserInfo.getDepartName()));
		
		 	
		map.put("last_update_user_id",sessionSysUserInfo.getUserId());
		map.put("last_update_user_name",sessionSysUserInfo.getUserName());
		
		 	
		map.put("last_update_depart_id",StringUtil.fixDefaultString(sessionSysUserInfo.getDepartId()));
		map.put("last_update_depart_name",StringUtil.fixDefaultString(sessionSysUserInfo.getDepartName()));
	 		
		return map;
	}
	
	public static void main(String[] args) {
		 
	}
	
	
	
	
	
	
}
