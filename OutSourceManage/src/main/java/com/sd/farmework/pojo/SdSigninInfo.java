package com.sd.farmework.pojo;

import com.sd.farmework.common.BaseInfo;
/**
 * 签到表
 * @author yy
 *
 */
public class SdSigninInfo extends BaseInfo {
  private String signinId; //签到主键id
  private String signinName;//签到位置信息
  
	public String getSigninId() {
		return signinId;
	}
	public void setSigninId(String signinId) {
		this.signinId = signinId;
	}
	public String getSigninName() {
		return signinName;
	}
	public void setSigninName(String signinName) {
		this.signinName = signinName;
	}
	@Override
	public String toString() {
		return "sdSigninInfo [signinId=" + signinId + ", signinName=" + signinName
			+ "]";
	}
  
}
