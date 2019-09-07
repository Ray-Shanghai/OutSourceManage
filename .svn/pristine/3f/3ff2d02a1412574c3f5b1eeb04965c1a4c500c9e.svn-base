package com.sd.farmework.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sd.farmework.common.BaseInfo;

public interface MysqlBaseMapper extends SqlserverBaseMapper {
	
	/**
	 * 查询单一信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List queryForMysql(BaseInfo obj) throws Exception;
	 
	/**
	 * 查询所有条数
	 */
 	public int queryCountForMysql(BaseInfo obj) throws Exception;
	
	/**
	 * 查询所有后台信息
	 */
 	public List<BaseInfo> queryListForMysql(BaseInfo obj) throws Exception;
 	
	
	/**
	 * 查询所有后台信息分页时使用
	 */
 	public List<BaseInfo> queryListByPageForMysql(BaseInfo obj) throws Exception;
 
 	/**
	 * 添加信息
	 * @param user
	 * @throws Exception
	 */
	public void addForMysql(BaseInfo obj) throws Exception;
	/**
	 * 删除信息
	 * @param user
	 * @throws Exception
	 */
	public void deleteForMysql(String id) throws Exception;
	/**
	 * 修改信息
	 * @param user
	 * @throws Exception
	 */
	public void updateForMysql(BaseInfo obj) throws Exception;
	/**
	 * 查询基本信息通过ID
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public BaseInfo queryByIdForMysql(BaseInfo obj) throws Exception;
	/**
	 * 查询插入数据的主键
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public String querySeqForMysql(BaseInfo obj) throws Exception;
	/**
	 * 根据主键查询多条记录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ArrayList<HashMap> queryListByPrimaryKeyForMysql(BaseInfo obj) throws Exception;
	/**
	 * 获取下一个的主键
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public String queryNextSeqForMysql(BaseInfo obj) throws Exception;
	
	/**
	 * 批量写入
	 * @param obj
	 * @throws Exception
	 */
	public void addBatchForMysql(List  obj) throws Exception;
	/**
	 * 批量更新
	 * @param obj
	 * @throws Exception
	 */
	public void updateBatchForMysql(List  obj) throws Exception;
	/**
	 * 删除数据
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public void deleteForMysql(BaseInfo obj) throws Exception;
	 
 	
	/**
	 * 查询基本信息通过ID
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public BaseInfo queryByPkIdForMysql(String obj) throws Exception;
	
	/**
	 * 删除数据
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public void updateStatusForMysql(BaseInfo obj) throws Exception;
	
	
	
}
