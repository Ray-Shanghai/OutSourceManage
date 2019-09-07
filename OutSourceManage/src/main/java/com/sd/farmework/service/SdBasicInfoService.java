package com.sd.farmework.service; 

import java.util.List;
import com.sd.farmework.pojo.SdBasicInfo;

/** 
 * test
 * @author Administrator 
 * 
 */ 
public interface SdBasicInfoService  extends BaseInfoService{
	public List queryOrderCountByStatus(SdBasicInfo sdBasicInfo);
}