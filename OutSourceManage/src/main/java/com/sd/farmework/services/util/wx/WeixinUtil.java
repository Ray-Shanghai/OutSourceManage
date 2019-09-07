package com.sd.farmework.services.util.wx;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sd.farmework.common.util.HttpClientUtil;
import com.sd.farmework.common.util.StringUtil;

 


@SuppressWarnings("deprecation")
public class WeixinUtil {

 
 
	/**
	 * 获取OpenId
	 * @param code
	 * @return
	 */
	public static Map<String, Object> getWeiXinUserInfo(String code,WxConstant wxConstant) {

		Map<String, Object> map = getOpenId(code,wxConstant);
		if(!map.get("code").equals("000")){
			return map;
		}
		// 获取openId
		String openId = map.get("openid").toString();

		// 第二步获取有效的access_token
		Map<String, String> accessTokenMap = getAccessToken(wxConstant);
		if(!map.get("code").equals("000")){
			return map;
		}
		String accessToken = accessTokenMap.get("accessToken");

		// 第三步通过access_token和openId获取用户基本信息
		Map<String, Object> result = getWeixinUserInfo(accessToken, openId,wxConstant);
		return result;
	}

	public static String getJsTickte(String accessToken,WxConstant wxConstant){
		StringBuffer sb = new StringBuffer(wxConstant.wxServer);
		sb.append("cgi-bin/ticket/getticket?");
		sb.append("access_token=");
		sb.append(accessToken);
		sb.append("&type=");
		sb.append("jsapi");
		String result = HttpClientUtil.get(sb.toString(), null);
		JSONObject json = JSONObject.fromObject(result);
		String ticket =json.get("ticket").toString();
		return ticket;
	}

	/**
	 * 获取微信用户基本信息
	 * 
	 * @param accessToken
	 * @param openId
	 * @return
	 */
	private static Map<String, Object> getWeixinUserInfo(String accessToken,
			String openId,WxConstant wxConstant) {
		try {
			// 第三步通过access_token和openId获取用户基本信息
			StringBuffer sb = new StringBuffer(wxConstant.wxServer);
			sb.append("cgi-bin/user/info?");
			sb.append("access_token=");
			sb.append(accessToken);
			sb.append("&openId=");
			sb.append(openId);
			System.out.println(sb.toString());
			String result = HttpClientUtil.get(sb.toString(), null);
			JSONObject json = JSONObject.fromObject(result);

			if (json.containsKey("errcode")) {
				String errcode = json.get("errcode").toString();
				String errmsg = json.get("errmsg").toString();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("code", "001");
				map.put("message", errcode + "," + errmsg);
				return map;

			} else {
				Map<String,String> wxUserInfoMap =new HashMap<String,String>();
				if(StringUtil.isNullOrBlank(json.get("nickname"))){
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("result", wxUserInfoMap);
					map.put("code", "005");
					map.put("message", "未关注公众号");
					return map;

				}else{
					wxUserInfoMap.put("nickname",json.get("nickname").toString());
					wxUserInfoMap.put("headimgurl",json.get("headimgurl").toString());
					wxUserInfoMap.put("country",json.get("country").toString());
				    wxUserInfoMap.put("province",json.get("province").toString());
				    wxUserInfoMap.put("city",json.get("city").toString());
				    wxUserInfoMap.put("openId",json.get("openid").toString());
				    wxUserInfoMap.put("sex",json.get("sex").toString());
					Map<String, Object> map = new HashMap<String, Object>();
					
					map.put("result", wxUserInfoMap);
					map.put("code", "000");
					map.put("message", "success");
					return map;
				}
			}
		} catch (Exception e) {
 			e.printStackTrace();
			Map<String, Object> map = new HashMap<String, Object>();
 			map.put("code", "001");
			map.put("message", e.getMessage());
			return map;
		}

 	}

	/**
	 * 获取AccessToken
	 * 
	 * @return
	 */
	public static Map<String, String> getAccessToken(WxConstant wxConstant) {
		// 第二步获取有效的access_token
		try {
			StringBuffer sb = new StringBuffer(wxConstant.wxServer);
			sb.append("cgi-bin/token?");
			sb.append("grant_type=client_credential");
			sb.append("&appid=");
			sb.append(wxConstant.wxAppId);
			sb.append("&secret=");
			sb.append(wxConstant.wxSecret);

			String result = HttpClientUtil.get(sb.toString(), null);
			System.out.println(result);
			JSONObject json = JSONObject.fromObject(result);

			if (json.containsKey("errcode")) {
				String errcode = json.get("errcode").toString();
				String errmsg = json.get("errmsg").toString();
				Map<String, String> map = new HashMap<String, String>();
 				map.put("code", "001");
				map.put("message", errcode + "," + errmsg);
				return map;

			} else {
				String accessToken = json.get("access_token").toString();
				Map<String, String> map = new HashMap<String, String>();
				map.put("result", result);
				map.put("code", "000");
				map.put("accessToken", accessToken);
				map.put("message", "success");
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, String> map = new HashMap<String, String>();
			map.put("code", "001");
			map.put("message", e.getMessage());
			return map;
		}
	}

	/**
	 * 獲取微信用戶唯一標示信息
	 * @param code
	 * @return
	 */
	public static Map<String, Object> getOpenId(String code,WxConstant wxConstant) {
		// 第一步通过code获取openId
		try {
			StringBuffer sb = new StringBuffer(wxConstant.wxServer);
			sb.append("sns/oauth2/access_token?");
			sb.append("appid=");
			sb.append(wxConstant.wxAppId);
			sb.append("&secret=");
			sb.append(wxConstant.wxSecret);
			sb.append("&code=");
			sb.append(code);
			sb.append("&grant_type=authorization_code");

			String result = HttpClientUtil.get(sb.toString(), null);
			// {"access_token":"ox7LBMb3VucP1k6fnHooaLhYKxj8hNqg9nvOosgGUoU8DglRaQkFQ80TR0Rfo6mjpwJOe_80IVAYIIEj99LVViMgkqXtevo1lOnzBukqWig","expires_in":7200,"refresh_token":"D1vzkvcqxtogtRG5bebNVi0l4LzLzswyMcnOGwnlRLof7gbIvsTZ-hqonJF_6Vpg6yHKm4YT91nX35Y1KTtc5imaxnDje-tBdgOAYF66f88","openid":"oFYpzwQIXaJSOfnJEb1oeBLINW9w","scope":"snsapi_base"}
			JSONObject json = JSONObject.fromObject(result);
			if (json.containsKey("errcode")) {
				String errcode = json.get("errcode").toString();
				String errmsg = json.get("errmsg").toString();
				Map<String, Object> map = new HashMap<String, Object>();
 				map.put("code", "001");
				map.put("message", errcode + "," + errmsg);
				return map;
				 
				
			} else {
				Map<String, Object> map = new HashMap<String, Object>();
				String openId = json.get("openid").toString();
				map.put("result", result);
				map.put("openid", openId);
				map.put("code", "000");
				return map;

			}
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("code", "001");
			map.put("message", e.getMessage());
			return map;
		}
 	}

	// 第一步 获取 code 的值
	// https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1d3b41e646164be4&redirect_uri=http://caixiaolian.com/&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect
	// http://caixiaolian.com/?code=0413tEfd2rbOCR0ul8jd2FjJfd23tEfA&state=STATE
	// 第二步
	// https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx1d3b41e646164be4&secret=555b435983fb071ee219e109359f9cd9&code=011fseBt11Iqu80sIUyt1x3fBt1fseB-&grant_type=authorization_code
	//
	// 第三步
	//
	// https://api.weixin.qq.com/sns/userinfo?access_token=43UAbjy4RRxbwBzwI2IGfo7e7wAUsYZOUPRVAokf244hIu5SMmxvRKt7jQr_ULlNktAdlYl6dZj38YSPAnEArakmtPaEHAjoJAU_4FwkokY&openid=oFYpzwQIXaJSOfnJEb1oeBLINW9w

	
	 public static Map<String, String> getJSSDKTicket(String access_token,WxConstant wxConstant) {  
		 try{
	        StringBuffer sb = new StringBuffer(wxConstant.wxServer);
			sb.append("cgi-bin/ticket/getticket?");
			sb.append("access_token=");
			sb.append(access_token);
			sb.append("&type=");
			sb.append("jsapi");
			String result = HttpClientUtil.get(sb.toString(), null);
			System.out.println(result);
			JSONObject json = JSONObject.fromObject(result);

 				if(json.get("errcode").toString().equals("0")){
					String ticket = json.get("ticket").toString();
					Map<String, String> map = new HashMap<String, String>();
					map.put("result", result);
					map.put("code", "000");
					map.put("ticket", ticket);
					map.put("message", "success");
					return map;
				}else{
					String errcode = json.get("errcode").toString();
					String errmsg = json.get("errmsg").toString();
					Map<String, String> map = new HashMap<String, String>();
	 				map.put("code", "001");
					map.put("message", errcode + "," + errmsg);
					return map;
 				}
 		} catch (Exception e) {
			e.printStackTrace();
			Map<String, String> map = new HashMap<String, String>();
			map.put("code", "001");
			map.put("message", e.getMessage());
			return map;
		}
	    } 
	 /**
      * 发送给指定某个OpenId
      * @param openId
      */
    public static void testsendTextByOpenids(String openId,Map<String, String> map,WxConstant wxConstant){
       String urlstr =wxConstant.wxServer+"cgi-bin/message/custom/send?access_token=ACCESS_TOKEN"; //发送客服图文消息
       Map<String, String> accessTokenMap = WeixinUtil.getAccessToken(wxConstant);
		String accessToken = accessTokenMap.get("accessToken");
       urlstr =urlstr.replace("ACCESS_TOKEN", accessToken);
       System.out.println("urlstr:"+urlstr);
         String reqjson =createSendData(openId,map);
        try {
            URL httpclient =new URL(urlstr);
            HttpURLConnection conn =(HttpURLConnection) httpclient.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(2000);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");    
            conn.setDoOutput(true);        
            conn.setDoInput(true);
            conn.connect();
            OutputStream os= conn.getOutputStream();    
            System.out.println("ccccc:"+reqjson);
            os.write(reqjson.getBytes("UTF-8"));//传入参数    
            os.flush();
            os.close();
            
            InputStream is =conn.getInputStream();
            int size =is.available();
            byte[] jsonBytes =new byte[size];
            is.read(jsonBytes);
            String message=new String(jsonBytes,"UTF-8");
            System.out.println("testsendTextByOpenids:"+message);
         
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    //创建发送的数据
    private static String createSendData(String openId,Map<String, String> map){
         JSONObject gjson =new JSONObject();
          gjson.put("touser", openId);
         gjson.put("msgtype", "news");
         JSONObject news =new JSONObject();
         JSONArray articles =new JSONArray();
         JSONObject list =new JSONObject();
         list.put("title",String.valueOf(map.get("title"))); //标题
         list.put("description",String.valueOf(map.get("description"))); //描述
         list.put("url",String.valueOf(map.get("url"))); //点击图文链接跳转的地址
         list.put("picurl",String.valueOf(map.get("picurl"))); //图文链接的图片
         articles.add(list);
         news.put("articles", articles);
         JSONObject text =new JSONObject();
         text.put("test1", String.valueOf(map.get("test1")));
         gjson.put("text", text);
         gjson.put("news", news);
         
        return gjson.toString();
    }
    /**
     * 发送文字消息
     * @param openId
     * @param map
     * @param wxConstant
     */
    public static void testsendTextsByOpenids(String openId,Map<String, String> map,WxConstant wxConstant){
        String urlstr =wxConstant.wxServer+"cgi-bin/message/custom/send?access_token=ACCESS_TOKEN"; //发送客服图文消息
        Map<String, String> accessTokenMap = WeixinUtil.getAccessToken(wxConstant);
 		String accessToken = accessTokenMap.get("accessToken");
        urlstr =urlstr.replace("ACCESS_TOKEN", accessToken);
        System.out.println("urlstr:"+urlstr);
          String reqjson =createSendDataToText(openId,map);
         try {
             URL httpclient =new URL(urlstr);
             HttpURLConnection conn =(HttpURLConnection) httpclient.openConnection();
             conn.setConnectTimeout(5000);
             conn.setReadTimeout(2000);
             conn.setRequestMethod("POST");
             conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");    
             conn.setDoOutput(true);        
             conn.setDoInput(true);
             conn.connect();
             OutputStream os= conn.getOutputStream();    
             System.out.println("ccccc:"+reqjson);
             os.write(reqjson.getBytes("UTF-8"));//传入参数    
             os.flush();
             os.close();
             
             InputStream is =conn.getInputStream();
             int size =is.available();
             byte[] jsonBytes =new byte[size];
             is.read(jsonBytes);
             String message=new String(jsonBytes,"UTF-8");
             System.out.println("testsendTextByOpenids:"+message);
          
         } catch (MalformedURLException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         } 
     }
     
  //创建发送的数据
    private static String createSendDataToText(String openId,Map<String, String> map){
         JSONObject gjson =new JSONObject();
          gjson.put("touser", openId);
          gjson.put("msgtype", "text");
          
         JSONObject text =new JSONObject();
         text.put("content", String.valueOf(map.get("content")));
         gjson.put("text", text);
         
         
        return gjson.toString();
    }
    
    public static Map<String, String> sign(String jsapi_ticket, String url) {
        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";

        //注意这里参数名必须全部小写，且必须有
        string1 = "jsapi_ticket=" + jsapi_ticket +
                  "&noncestr=" + nonce_str +
                  "&timestamp=" + timestamp +
                  "&url=" + url;
        System.out.println(string1);

        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);

        return ret;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    public static Map<String, String> getJsSDKMap(WxConstant wx,String url){
    	Map<String, String>  result = getAccessToken(wx);
		String str =result.get("accessToken");
		
		String jsapi_ticket=getJsTickte(str,wx);
		 
		
		Map<String, String> ret = WeixinUtil.sign(jsapi_ticket, url);
		
		return ret;
    	
    	
    } 
   
		public static void main(String[] args) {
	 		//
//			String str= "http://caixiaolian.com/?code=041JQnt82auNfE0wV1u82Xojt82JQntK&state=STATE";
//			System.out.println(str.split("&")[0].split("=")[1]);
//			String code =str.split("&")[0].split("=")[1];
//			Map result = getWeiXinUserInfo(code);
//			System.out.println(result);
			WxConstant wx= new WxConstant();
			wx.setWxAppId("wx629e79a82e05937f");
			wx.setWxSecret("b59d849d3c797f8a62f7188c7d6fa836");
			/*String url ="";
			Map map = new HashMap();
			map.put("content", "123213");
			wx.setWxAppId("wxf0a0ed09c964138f");
			wx.setWxSecret("b77b574316dbcbdd2e57ed71c187dd89");

			String openId ="oFYpzwfXKIotGE4dkPhhjIpK9JWY";
			testsendTextsByOpenids(openId,map,wx);*/
			
			WeixinUtil.getJsSDKMap(wx,"https://or.angelic.com.cn/OutSourceManage/wxManagerWx/signMap.html");

		}
}
