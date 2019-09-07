package com.sd.farmework.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.mapper.SysFunctionInfoMapper;
import com.sd.farmework.pojo.SysFunctionInfo;
import com.sd.farmework.service.SysFunctionInfoService;

/** 
 * 功能菜单信息表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysFunctionInfoServiceImpl extends BaseInfoServiceImpl implements SysFunctionInfoService{ 
    @Autowired
    private SysFunctionInfoMapper baseMapper;
    public SysFunctionInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysFunctionInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public void add(SysFunctionInfo obj, String[] powers) throws Exception {
		
		
		obj.setFunctionType("1");
		
		
		if("mysql".equals(dbType)){
			baseMapper.addForMysql(obj);
		}else if("oracle".equals(dbType)){
			baseMapper.add(obj);
		}else if("sqlserver".equals(dbType)){
			baseMapper.addForSqlserver(obj);
		}
			String functionId =obj.getFunctionId();
			obj.setFunctionType("2");
			if(powers==null||powers.length==0){
				return;
			}
	  		for (int i = 0; i < powers.length; i++) {
	  			System.out.println(powers[i]);
	  			obj.setFunctionId(functionId);
	 			obj.setDictionaryId(powers[i].split("&")[0]);
	 			obj.setDictionaryName(powers[i].split("&")[1]);
	 			obj.setFunctionType("2");
	 			obj.setFunctionName(powers[i].split("&")[1]);
	 			obj.setParentFunctionId(obj.getFunctionId());
	 			if("mysql".equals(dbType)){
	 				baseMapper.addForMysql(obj);
	 			}else if("oracle".equals(dbType)){
	 				baseMapper.add(obj);
	 			}else if("sqlserver".equals(dbType)){
	 				baseMapper.addForSqlserver(obj);
	 			}
			}
			
		 
		
		
		
	}
 
	@SuppressWarnings("rawtypes")
	@Override
	public List queryByPkparentFunctionId(String obj) throws Exception {
		
		if("mysql".equals(dbType)){
			return baseMapper.queryByPkparentFunctionIdForMysql(obj);
		}else if("oracle".equals(dbType)){
			return baseMapper.queryByPkparentFunctionId(obj);
		}else if("sqlserver".equals(dbType)){
			return baseMapper.queryByPkparentFunctionIdForSqlserver(obj);
		}
		return null;
 	}
	@Override
	public void update(SysFunctionInfo obj, String[] powers) throws Exception {
		
		obj.setFunctionType("1");
		
		
		if("mysql".equals(dbType)){
			baseMapper.updateForMysql(obj);
		}else if("oracle".equals(dbType)){
			baseMapper.update(obj);
		}else if("sqlserver".equals(dbType)){
			baseMapper.updateForSqlserver(obj);
		}
		 
		
		obj.setParentFunctionId(obj.getFunctionId());
		if("mysql".equals(dbType)){
			baseMapper.deleteForMysql(obj);
		}else if("oracle".equals(dbType)){
			baseMapper.delete(obj);
		}else if("sqlserver".equals(dbType)){
			baseMapper.deleteForSqlserver(obj);
		}
		 
		String functionId =obj.getFunctionId();
		obj.setFunctionType("2");
		if(powers==null||powers.length==0){
			return;
		}
  		for (int i = 0; i < powers.length; i++) {
  			System.out.println(powers[i]);
  			obj.setFunctionId(functionId);
 			obj.setDictionaryId(powers[i].split("&")[0]);
 			obj.setDictionaryName(powers[i].split("&")[1]);
 			obj.setFunctionType("2");
 			obj.setFunctionName(powers[i].split("&")[1]);
 			obj.setParentFunctionId(obj.getFunctionId());
			
 			if("mysql".equals(dbType)){
 				baseMapper.addForMysql(obj);
 			}else if("oracle".equals(dbType)){
 				baseMapper.add(obj);
 			}else if("sqlserver".equals(dbType)){
 				baseMapper.addForSqlserver(obj);
 			}
			 
		}
	}
}