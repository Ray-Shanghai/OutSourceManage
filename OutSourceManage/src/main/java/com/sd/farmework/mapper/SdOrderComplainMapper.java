package com.sd.farmework.mapper; 

import java.util.List;
import java.util.Map;

import com.sd.farmework.pojo.SdBasicInfo;
import com.sd.farmework.pojo.SdOrderComplain;

/** 
 * test
 * @author Administrator 
 * 
 */ 
public interface SdOrderComplainMapper  extends BaseMapper{
	public List queryOrderCountByStatusForMysql(SdOrderComplain sdOrderComplain);
	/**
	 * 投诉统计
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> queryComplainForCount(Map<String,Object> map);
}