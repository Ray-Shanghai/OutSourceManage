package com.sd.farmework.common;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sd.farmework.pojo.SysUserInfo;

/**
 * Session提供者
  * @ClassName: SessionProvider
  * @Description: TODO
  * @author 王超超
  * @date 2016-11-17 下午03:45:23
  *
 */
public interface SessionProvider {

	public Serializable getAttribute(HttpServletRequest request, String name);

	public void setAttribute(HttpServletRequest request,String name, Serializable value);

	public Serializable getSessionId(HttpServletRequest request);

	public void logout(HttpServletRequest request );
	
	public SysUserInfo getCurrentUserSession(HttpSession session,HttpServletRequest request,HttpServletResponse response);

	public BaseInfo fillBaseInfo(BaseInfo baseInfo, SysUserInfo sessionSysUserInfo);
}
