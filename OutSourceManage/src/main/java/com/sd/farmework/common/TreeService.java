package com.sd.farmework.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.pojo.SysRoleInfo;

 
/**
 * @author  yangyang 
 */
public class TreeService {
 
	 
	public List<Map<String, Object>> getTreeData(List<Map<String, Object>> dataList,String nodeParam,SysRoleInfo param) {
		return genTreeStucture(dataList, nodeParam,param);
	}
	
 
	
	private List<Map<String, Object>> genTreeStucture(List<Map<String, Object>> list, String rootId,SysRoleInfo param) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map : list) {
			if(rootId.equals(map.get("PARENT_ID"))) {
				List<Map<String, Object>> childList = genTreeStucture(list, (String)map.get("ID"),param);
				
				HashMap<String, Object> treeMap = new HashMap<String, Object>();
				treeMap.put("id", map.get("ID"));
				treeMap.put("text", map.get("NAME"));
				treeMap.put("parentId", map.get("PARENT_ID"));
				StringBuffer sb = new StringBuffer();
				sb.append(map.get("PARENT_ID"));
				sb.append("_");
				sb.append(map.get("ID"));
				if(!StringUtil.isNullOrBlank(param.getFunctionOperateIds())){
					if(param.getFunctionOperateIds().indexOf(String.valueOf(sb))>-1){
						treeMap.put("checked", "checked");
					}
				}
				treeMap.put("functionOperateIds", sb.toString());
				treeMap.put("children", childList);
				result.add(treeMap);
			}
		}
		return result;
	}
	public List<Map<String, Object>> getTreeData(List<Map<String, Object>> dataList,String nodeParam) {
		return genTreeStucture(dataList, nodeParam);
	}
	
 
	
	private List<Map<String, Object>> genTreeStucture(List<Map<String, Object>> list, String rootId) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map : list) {
			if(rootId.equals(map.get("PARENT_ID"))) {
				List<Map<String, Object>> childList = genTreeStucture(list, (String)map.get("ID"));
				
				HashMap<String, Object> treeMap = new HashMap<String, Object>();
				treeMap.put("id", map.get("ID"));
				treeMap.put("text", map.get("NAME"));
				treeMap.put("parentId", map.get("PARENT_ID"));
				treeMap.put("isVirtual", map.get("isVirtual"));
				treeMap.put("nodeType", map.get("NODE_TYPE"));
				
				if(StringUtil.isNotNullOrBlank(map.get("checked"))){
					treeMap.put("checked", map.get("checked"));
				}
				if(StringUtil.isNotNullOrBlank(map.get("state"))){
					treeMap.put("state", map.get("state"));
				}
				
				
//				if(!StringUtil.isNullOrBlank(param.getFunctionOperateIds())){
//					if(param.getFunctionOperateIds().indexOf(String.valueOf(sb))>-1){
//						treeMap.put("checked", "checked");
//					}
//				}
				//treeMap.put("functionOperateIds", sb.toString());
				treeMap.put("children", childList);
				result.add(treeMap);
			}
		}
		return result;
	}
}
