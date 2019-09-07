package com.sd.farmework.service; 

import java.util.Map;

import com.sd.farmework.pojo.SdOrderQuote;

/** 
 * test
 * @author Administrator 
 * 
 */ 
public interface SdOrderQuoteService  extends BaseInfoService{ 
	/**
	 * 添加供应商报价信息
	 * @param sdOrderQuote
	 * @throws Exception
	 */
	public Map<String,Object> addOrderQuote(SdOrderQuote sdOrderQuote)throws Exception;
	/**
	 * 核价后整理报价信息
	 * @param sdOrderQuote
	 * @throws Exception
	 */
	public void updateOrderQuote(SdOrderQuote sdOrderQuote)throws Exception;
}