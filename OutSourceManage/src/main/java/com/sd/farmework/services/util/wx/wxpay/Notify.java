package com.sd.farmework.services.util.wx.wxpay;

import java.io.BufferedOutputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;
 
public class Notify {
	static Logger logger   =Logger.getLogger(Notify.class);
	public static String unescape(String src) {
		  StringBuffer tmp = new StringBuffer();
		  tmp.ensureCapacity(src.length());
		  int lastPos = 0, pos = 0;
		  char ch;
		  while (lastPos < src.length()) {
		   pos = src.indexOf("%", lastPos);
		   if (pos == lastPos) {
		    if (src.charAt(pos + 1) == 'u') {
		     ch = (char) Integer.parseInt(src
		       .substring(pos + 2, pos + 6), 16);
		     tmp.append(ch);
		     lastPos = pos + 6;
		    } else {
		     ch = (char) Integer.parseInt(src
		       .substring(pos + 1, pos + 3), 16);
		     tmp.append(ch);
		     lastPos = pos + 3;
		    }
		   } else {
		    if (pos == -1) {
		     tmp.append(src.substring(lastPos));
		     lastPos = src.length();
		    } else {
		     tmp.append(src.substring(lastPos, pos));
		     lastPos = pos;
		    }
		   }
		  }
		  return tmp.toString();
		 }
	
	public static String getStr(String str){
		return unescape(str.replaceAll("jaj", "%"));
		
	}
	/*
	 //版本购买方法
    public static  void vserionPay(String versionSerialNo,
    		String versionInfoId,
    		String versionPrice,
    		String userId,
    		String remark,
    		String company,
    		String teamName,
    		String teamNumber,
    		String accountAule,
    		String payType,TmVersionPayRecodService tmversionpayrecodService,TmUserArchivesInfoService tmUserArchivesInfoService){
    	TmVersionPayRecod versionPay = new TmVersionPayRecod();
		String versionName = "";
    	if("4".equals(versionInfoId)){
    		versionName = "团队版";
    		double teamPrice= Double.parseDouble(versionPrice)-Double.parseDouble(remark)*Double.parseDouble(teamNumber);
    		versionPay.setRemark("您购买的是团队版，金额：￥"+teamPrice+"；附带了"+teamNumber+"个小组版(一年)，金额：￥"+remark+"；共付金额：￥"+versionPrice);
    	}else if("2".equals(versionInfoId)){
    		versionName = "小组版";
    		versionPay.setRemark("您购买的是小组版(三个月),金额：￥"+versionPrice);
    	}else if("3".equals(versionInfoId)){
    		versionName = "个人版";
    		versionPay.setRemark("您购买的是小组版(一年),金额：￥"+versionPrice);
    	}
    	// 查询用户信息
    	TmUserArchivesInfo userArchivesInfo = new TmUserArchivesInfo();;
		try {
			userArchivesInfo.setUserId(userId);
			List userArchivesList = tmUserArchivesInfoService.query(userArchivesInfo);//获取当前登陆用户信息
			if(userArchivesInfo!=null&&userArchivesList.size()>0){
				userArchivesInfo = (TmUserArchivesInfo)userArchivesList.get(0);
				versionPay.setVersionInfoId(Integer.parseInt(versionInfoId));
				versionPay.setVersionName(versionName);
				versionPay.setVersionPrice(versionPrice);
				versionPay.setVersionSerialNo(versionSerialNo);
				versionPay.setCreateUserId(userArchivesInfo.getUserId());
				versionPay.setCreateUserName(userArchivesInfo.getNickName());
				versionPay.setCreateUnitId(userArchivesInfo.getCreateUnitId());
				versionPay.setCreateUnitName(userArchivesInfo.getCreateUnitName());

				//向用户档案信息中赋值
				userArchivesInfo.setCompany(company);
				userArchivesInfo.setTeamName(teamName);
				userArchivesInfo.setTeamNumber(teamNumber);
				userArchivesInfo.setAccountAule(accountAule);
				userArchivesInfo.setAccountType(Integer.parseInt(versionInfoId));
				Date sysDate=new Date();
				userArchivesInfo.setAccountStartDate(DateUtil.getDateString(sysDate));
				if(userArchivesInfo.getAccountType()==2){	//小组版三个月
					Date nextdates=DateUtil.getRelativeDate(sysDate, 2, 3);
					userArchivesInfo.setAccountEndDate(DateUtil.getDateString(nextdates));
				}else if(userArchivesInfo.getAccountType()==3){	//小组版一年
					Date nextdates=DateUtil.getRelativeDate(sysDate, 1, 1);
					userArchivesInfo.setAccountEndDate(DateUtil.getDateString(nextdates));
				}else if(userArchivesInfo.getAccountType()==4){	//团队版一年
					Date nextdates=DateUtil.getRelativeDate(sysDate, 1, 1);
					userArchivesInfo.setAccountEndDate(DateUtil.getDateString(nextdates));
				}
				
				//******** 添加版本购买记录信息 ***
				
				logger.info("====== 版本购买开始  ===="+versionPay);
				tmversionpayrecodService.addVersionPay(versionPay);
				if(userArchivesInfo.getAccountType()==4){	//说明购买的是团队版
					tmUserArchivesInfoService.updateUserBuyInfo(userArchivesInfo,payType);
				}else if(userArchivesInfo.getAccountType()==2||userArchivesInfo.getAccountType()==3){	//购买的是个人版
					tmUserArchivesInfoService.update(userArchivesInfo);
				}
				
				logger.info("======   版本购买结束   =====");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
    }
    */
	public void notify(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		
		
		//把如下代码贴到的你的处理回调的servlet 或者.do 中即可明白回调操作
		System.out.print("微信支付回调数据开始");
		//示例报文
 		String inputLine;
		String notityXml = "";
		String resXml = "";

		try {
			while ((inputLine = request.getReader().readLine()) != null) {
				notityXml += inputLine;
			}
			request.getReader().close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("接收到的报文：" + notityXml);
		
		Map m = parseXmlToList2(notityXml);
		WxPayResult wpr = new WxPayResult();
		wpr.setAppid(m.get("appid").toString());
		wpr.setBankType(m.get("bank_type").toString());
		wpr.setCashFee(m.get("cash_fee").toString());
		wpr.setFeeType(m.get("fee_type").toString());
		wpr.setIsSubscribe(m.get("is_subscribe").toString());
		wpr.setMchId(m.get("mch_id").toString());
		wpr.setNonceStr(m.get("nonce_str").toString());
		wpr.setOpenid(m.get("openid").toString());
		wpr.setOutTradeNo(m.get("out_trade_no").toString());
		wpr.setResultCode(m.get("result_code").toString());
		wpr.setReturnCode(m.get("return_code").toString());
		wpr.setSign(m.get("sign").toString());
		wpr.setTimeEnd(m.get("time_end").toString());
		wpr.setTotalFee(m.get("total_fee").toString());
		wpr.setTradeType(m.get("trade_type").toString());
		wpr.setTransactionId(m.get("transaction_id").toString());
		
		if("SUCCESS".equals(wpr.getResultCode())){
			//支付成功
			
			String versionInfoId = (String)m.get("a");			//版本主键
			//String versionName = getStr((String)m.get("b"));	//版本名称
			String versionPrice = (String)m.get("c");			//版本价格
			String userId = (String)m.get("d");					//用户主键
			String remark = (String)m.get("e");					//个人版价格
			String company = getStr((String)m.get("f"));		//公司名称
			String teamName = getStr((String)m.get("g"));		//团队名称
			String teamNumber = (String)m.get("h");				//人数
			String accountAule = (String)m.get("i");			//规则
			String payType = (String)m.get("j");				//操作类型
			
		 
			//vserionPay(m.get("out_trade_no").toString(),versionInfoId,versionPrice,userId,remark,company,teamName,teamNumber,accountAule,payType,tmversionpayrecodService,tmUserArchivesInfoService);
			
			resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
			+ "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
		}else{
			resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
			+ "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
		}

		System.out.println("微信支付回调数据结束");

		BufferedOutputStream out = new BufferedOutputStream(
				response.getOutputStream());
		out.write(resXml.getBytes());
		out.flush();
		out.close();

	}
	
	/**
	 * description: 解析微信通知xml
	 * 
	 * @param xml
	 * @return
	 * @author ex_yangxiaoyi
	 * @see
	 */
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	private static Map parseXmlToList2(String xml) {
		Map retMap = new HashMap();
		try {
			StringReader read = new StringReader(xml);
			// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
			InputSource source = new InputSource(read);
			// 创建一个新的SAXBuilder
			SAXBuilder sb = new SAXBuilder();
			// 通过输入源构造一个Document
			Document doc = (Document) sb.build(source);
			Element root = doc.getRootElement();// 指向根节点
			List<Element> es = root.getChildren();
			if (es != null && es.size() != 0) {
				for (Element element : es) {
					retMap.put(element.getName(), element.getValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMap;
	}

}
