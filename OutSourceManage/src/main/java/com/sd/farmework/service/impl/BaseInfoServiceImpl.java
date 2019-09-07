package com.sd.farmework.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.mapper.BaseMapper;
import com.sd.farmework.service.BaseInfoService;

 

@SuppressWarnings("rawtypes")
public class BaseInfoServiceImpl implements BaseInfoService {
	
	protected static String dbType ;
	static Properties pro =  new Properties();
	 static{
			try {
					
					InputStream  fi = BaseInfoServiceImpl.class.getResourceAsStream("/common.properties");
					pro.load(fi);
					dbType = (String) pro.get("dbType");
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		    }
	 
	protected	BaseMapper baseMapper;

	 

	public BaseMapper getBaseMapper() {
		
		return baseMapper;
	}
	
	/**
	 * 查询所有用户
	 */
	
	public List<BaseInfo> queryList(BaseInfo obj) throws Exception {
		
		List<BaseInfo> list = null;
		try {
			if("mysql".equals(dbType)){
				list = getBaseMapper().queryListForMysql(obj);
			}else if("oracle".equals(dbType)){
				list = getBaseMapper().queryList(obj);
			}else if("sqlserver".equals(dbType)){
				list = getBaseMapper().queryListForSqlserver(obj);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception(e);
		}
		
		return list;
	}

	
	public void add(BaseInfo obj) throws Exception {
		
		try {
			if("mysql".equals(dbType)){
				getBaseMapper().addForMysql(obj);
			}else if("oracle".equals(dbType)){
				getBaseMapper().add(obj);
			}else if("sqlserver".equals(dbType)){
				getBaseMapper().addForSqlserver(obj);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	
	public void update(BaseInfo obj) throws Exception {
 		
		try {
			if("mysql".equals(dbType)){
				getBaseMapper().updateForMysql(obj);
			}else if("oracle".equals(dbType)){
				getBaseMapper().update(obj);
			}else if("sqlserver".equals(dbType)){
				getBaseMapper().updateForSqlserver(obj);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception(e);
		}

	}

	


	
	public List query(BaseInfo obj) throws Exception {
		
		List objout = null;
		try {
			if("mysql".equals(dbType)){
				objout = getBaseMapper().queryForMysql(obj);
			}else if("oracle".equals(dbType)){
				objout = getBaseMapper().query(obj);
			}else if("sqlserver".equals(dbType)){
				objout = getBaseMapper().queryForSqlserver(obj);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception(e);
		}
		return objout;
	}

	
	public int queryCount(BaseInfo obj) throws Exception {
		
		
		int objout =0;
		try {
			if("mysql".equals(dbType)){
				objout = getBaseMapper().queryCountForMysql(obj);
			}else if("oracle".equals(dbType)){
				objout = getBaseMapper().queryCount(obj);
			}else if("sqlserver".equals(dbType)){
				objout = getBaseMapper().queryCountForSqlserver(obj);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception(e);
		}
		return objout;
	}

	@Override
	public String querySeq(BaseInfo obj) throws Exception {
		
		String objout="";
		try {
			if("mysql".equals(dbType)){
				objout = getBaseMapper().querySeqForMysql(obj);
			}else if("oracle".equals(dbType)){
				objout = getBaseMapper().querySeq(obj);
			}else if("sqlserver".equals(dbType)){
				objout = getBaseMapper().querySeqForSqlserver(obj);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception(e);
		}
		return objout;
	}

	@Override
	public ArrayList<HashMap> queryListByPrimaryKey(BaseInfo obj) throws Exception {
		
		
		ArrayList<HashMap> list = null;
		try {
			if("mysql".equals(dbType)){
				list = getBaseMapper().queryListByPrimaryKeyForMysql(obj);
			}else if("oracle".equals(dbType)){
				list = getBaseMapper().queryListByPrimaryKey(obj);
			}else if("sqlserver".equals(dbType)){
				list = getBaseMapper().queryListByPrimaryKeyForSqlserver(obj);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception(e);
		}
		
		return list;

	}

	@Override
	public String queryNextSeq(BaseInfo obj) throws Exception {
		
		String objout="";
		try {

			if("mysql".equals(dbType)){
				objout = getBaseMapper().queryNextSeqForMysql(obj);
			}else if("oracle".equals(dbType)){
				objout = getBaseMapper().queryNextSeq(obj);
			}else if("sqlserver".equals(dbType)){
				objout = getBaseMapper().queryNextSeqForSqlserver(obj);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception(e);
		}
		return objout;
	}
	@Override
	public void addBatch(List obj) throws Exception {
		
		try {
			if("mysql".equals(dbType)){
				getBaseMapper().addBatchForMysql(obj);
			}else if("oracle".equals(dbType)){
				getBaseMapper().addBatch(obj);
			}else if("sqlserver".equals(dbType)){
				getBaseMapper().addBatchForSqlserver(obj);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@Override
	public void updateBatch(List obj) throws Exception {
		
		try {
			if("mysql".equals(dbType)){
				getBaseMapper().updateBatchForMysql(obj);
			}else if("oracle".equals(dbType)){
				getBaseMapper().updateBatch(obj);
			}else if("sqlserver".equals(dbType)){
				getBaseMapper().updateBatchForSqlserver(obj);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@Override
	public void delete(BaseInfo obj) throws Exception {
		
		
				try {

					if("mysql".equals(dbType)){
						getBaseMapper().deleteForMysql(obj);
					}else if("oracle".equals(dbType)){
						getBaseMapper().delete(obj);
					}else if("sqlserver".equals(dbType)){
						getBaseMapper().deleteForSqlserver(obj);
					}
					
				} catch (Exception e) {
					
					e.printStackTrace();
					throw new Exception(e);
				}
	}

	@Override
	public List<BaseInfo> queryListByPage(BaseInfo obj) throws Exception {
		
				List<BaseInfo> list = null;
				try {

					if("mysql".equals(dbType)){
						list = getBaseMapper().queryListByPageForMysql(obj);
					}else if("oracle".equals(dbType)){
						list = getBaseMapper().queryListByPage(obj);
					}else if("sqlserver".equals(dbType)){
						list = getBaseMapper().queryListByPageForSqlserver(obj);
					}
				} catch (Exception e) {
					
					e.printStackTrace();
					throw new Exception(e);
				}
				
				return list;
	}

	@Override
	public BaseInfo queryByPkId(String obj) throws Exception {
		BaseInfo objout = null;
			try {
				if("mysql".equals(dbType)){
					objout = getBaseMapper().queryByPkIdForMysql(obj);
				}else if("oracle".equals(dbType)){
					objout = getBaseMapper().queryByPkId(obj);
				}else if("sqlserver".equals(dbType)){
					objout = getBaseMapper().queryByPkIdForSqlserver(obj);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
				throw new Exception(e);
			}
			return objout;
	}

	@Override
	public void delete(String pkId) throws Exception {
		// TODO Auto-generated method stub

		try {

			if("mysql".equals(dbType)){
				getBaseMapper().deleteForMysql(pkId);
			}else if("oracle".equals(dbType)){
				getBaseMapper().delete(pkId);
			}else if("sqlserver".equals(dbType)){
				getBaseMapper().deleteForSqlserver(pkId);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@Override
	public void updateStatus(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub

		try {
			if("mysql".equals(dbType)){
				getBaseMapper().updateStatusForMysql(obj);
			}else if("oracle".equals(dbType)){
				getBaseMapper().updateStatus(obj);
			}else if("sqlserver".equals(dbType)){
				getBaseMapper().updateStatusForSqlserver(obj);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@Override
	public BaseInfo queryById(BaseInfo obj) throws Exception {
		BaseInfo objout = null;
		try {
			if("mysql".equals(dbType)){
				objout= getBaseMapper().queryByIdForMysql(obj);
			}else if("oracle".equals(dbType)){
				objout= getBaseMapper().queryById(obj);
			}else if("sqlserver".equals(dbType)){
				objout= getBaseMapper().queryByIdForSqlserver(obj);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception(e);
		}
		return objout;
	}
}