package com.sd.farmework.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sd.farmework.pojo.Menu;

public class JSONUtils {
   @SuppressWarnings("rawtypes")
   public static void objectToJson(HttpServletRequest request,HttpServletResponse response, Map map){
		JSONObject js = JSONObject.fromObject(map);
		String restr=js.toString();
		
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			PrintWriter pw;
			pw = response.getWriter();
			pw.write(restr);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
   }
   @SuppressWarnings("rawtypes")
   public static void objectToJsonArray(HttpServletRequest request,HttpServletResponse response,List list){
	   JSONArray js = JSONArray.fromObject(list);
		String restr=js.toString();
		
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			PrintWriter pw;
			pw = response.getWriter();
			pw.write(restr);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
  }
   public static void main(String[] args) {
	  List list =new ArrayList();
	   Map map = new HashMap();
	   List list1 =new ArrayList();
	   
	   Menu men =new Menu();
	   men.setId("001");
	   men.setText("填写请假单");
	   list1.add(men);
	   men =new Menu();
	   men.setId("001");
	   men.setText("填写请假单");
	   
	   
	   list1.add(men);
	   map.put("items",list1);
	   map.put("text", "考勤管理");
	   
	   
	   list.add(map);
	   
	   list.add(map);
	   
	   
	   JSONArray js = JSONArray.fromObject(list);
		String restr=js.toString();
	   
		System.out.println(restr);
}
}
