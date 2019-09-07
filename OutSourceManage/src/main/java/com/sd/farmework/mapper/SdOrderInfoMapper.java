package com.sd.farmework.mapper; 

import java.util.List;

import com.sd.farmework.pojo.SdOrderInfo;

/** 
 * test
 * @author Administrator 
 * 
 */ 
public interface SdOrderInfoMapper  extends BaseMapper{ 
	/**
	 * 查询每天最大的订单编号
	 * @param now
	 * @return
	 * @throws Exception
	 */
	public String queryMaxOrderNuber(String now) throws Exception;
	/**
	 * 订单跟踪列表
	 * @param sdOrderInfo
	 * @return
	 * @throws Exception
	 */
	public List<SdOrderInfo> queryListByTrack(SdOrderInfo sdOrderInfo)throws Exception;
	/**
	 * 订单数量
	 * @param sdOrderInfo
	 * @return
	 * @throws Exception
	 */
	public Integer queryCountByTrack(SdOrderInfo sdOrderInfo)throws Exception;
	/**
	 * 修改订单信息
	 * @param sdOrderInfo
	 * @throws Exception
	 */
	public void updateOrderInfo(SdOrderInfo sdOrderInfo)throws Exception;
	/**
	 * 微信端查询分页列表
	 * @param sdOrderInfo
	 * @return
	 * @throws Exception
	 */
	public List<SdOrderInfo> queryListByWxPage(SdOrderInfo sdOrderInfo)throws Exception;
	/**
	 * 微信端数据条数
	 * @param sdOrderInfo
	 * @return
	 * @throws Exception
	 */
	public Integer queryCountByWxPage(SdOrderInfo sdOrderInfo)throws Exception;
}