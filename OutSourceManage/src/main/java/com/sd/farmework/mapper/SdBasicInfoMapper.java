package com.sd.farmework.mapper; 

import java.util.List;
import com.sd.farmework.pojo.SdBasicInfo;

/** 
 * test
 * @author Administrator 
 * 
 */ 
public interface SdBasicInfoMapper  extends BaseMapper{ 
	public List queryOrderCountByStatusForMysql(SdBasicInfo sdBasicInfo);
}