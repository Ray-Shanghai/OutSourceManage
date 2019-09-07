package com.sd.farmework.common.util;



import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 *
 * @author Administrator
 */
public class SendSMS {

    public static String SMS(String postData, String postUrl) {
        try {
            //发送POST请求
            URL url = new URL(postUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Length", "" + postData.length());
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(postData);
            out.flush();
            out.close();

            //获取响应状态
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("connect failed!");
                return "";
            }
            //获取响应内容体
            String line, result = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return "";
    }
    
    public static String MMS(String postData, String postUrl) {
        try {
            //发送POST请求
            URL url = new URL(postUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            conn.setRequestProperty("SOAPAction", "http://MmsWebInterface.org/SubmitMms");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Length", "" + postData.length());
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(postData);
            out.flush();
            out.close();

            //获取响应状态
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("connect failed!");
                return "";
            }
            //获取响应内容体
            String line, result = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return "";
    }

    public static String PackMMS(String sname, String spwd, String scorpid, String sprdid, String tels, String title, byte[] mms) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><soap:Body><SubmitMms xmlns=\"http://MmsWebInterface.org/\">");
        sb.append("<UserID>" + sname + "</UserID>");
        sb.append("<Password>" + spwd + "</Password>");
        sb.append("<CorpID>" + scorpid + "</CorpID>");
        sb.append("<PrdID>" + sprdid + "</PrdID>");
        sb.append("<DstID>" + tels + "</DstID>");
        sb.append("<MmsSubject>" + title + "</MmsSubject>");
        sb.append("<TmsBuffer>" + new sun.misc.BASE64Encoder().encode(mms) + "</TmsBuffer>");
        sb.append("</SubmitMms></soap:Body></soap:Envelope>");
        return sb.toString();
    }

    public static byte[] PackFile(String file) throws IOException {
        File f = new File(file);
        if (f.exists()) {
            String fileName = f.getName();
            int fileSize = (int) f.length();
            try {
                byte[] fileBytes = new byte[fileSize];
                byte[] filenameBytes = (fileName + '\0').getBytes();                         

                FileInputStream stream = new FileInputStream(file);
                DataInputStream ds = new DataInputStream(stream);
                for (int i = 0; i < fileSize; i++) {
                    fileBytes[i] = ds.readByte();
                }
                
                //4 表示文件的大小的int的byte大小
                int length = fileBytes.length + filenameBytes.length + 4;
                ByteBuffer buffer = ByteBuffer.allocate(length);
                buffer.put((fileName + '\0').getBytes());

                ByteBuffer bufferLength = ByteBuffer.allocate(4);
                bufferLength.order(ByteOrder.LITTLE_ENDIAN);
                bufferLength.putInt(fileSize);
                
                buffer.put(bufferLength.array());

                buffer.put(fileBytes);
                return buffer.array();

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

        }
        return null;
    }
    
    public static void main(String[] args) {
    	for (int i = 0; i < 2; i++) {
			
		
    	 try {
    		 String str="【十达工贸】领导您好！采销链今日报价\n"
    		+" 普板   Q235B   08*2300*L   鞍钢   3580;\n"
    		+" 热轧卷   Q235B   5.0*1250*C   本钢   3460;\n"
    		+"酸洗卷   QSTE380TM   2.0*1250*C   邯钢   3930;\n"
    		+"低合金卷   Q345B   14*2000*C   鞍钢   3630;\n"
    		+"低合金卷   Q345B   12*2200*C   鞍钢   3730;\n"
    		+"姚婷 1801622561";
    		 
    		 
			String PostData = "sname=dlzhangjian&spwd=zj112233&scorpid=&sprdid=1012812&sdst=18321740095&smsg="+URLEncoder.encode(str+"退订回T","utf-8");
			 //out.println(PostData);
			 String ret = SendSMS.SMS(PostData, "http://cf.51welink.com/submitdata/Service.asmx/g_Submit");
			 System.out.println(ret);
    	 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    	
    	
    	 try {
    		 String str="【十达工贸】领导您好！采销链今日报价\n"
    		+" 普板   Q235B   08*2300*L   鞍钢   3580;\n"
    		+" 热轧卷   Q235B   5.0*1250*C   本钢   3460;\n"
    		+"酸洗卷   QSTE380TM   2.0*1250*C   邯钢   3930;\n"
    		+"低合金卷   Q345B   14*2000*C   鞍钢   3630;\n"
    		+"低合金卷   Q345B   12*2200*C   鞍钢   3730;\n"
    		+"姚婷 1801622561";
    		 
    		 
			String PostData = "sname=dlzhangjian&spwd=zj112233&scorpid=&sprdid=1012812&sdst=18321740095&smsg="+URLEncoder.encode(str+"","utf-8");
			 //out.println(PostData);
			 String ret = SendSMS.SMS(PostData, "http://cf.51welink.com/submitdata/Service.asmx/g_Submit");
			 System.out.println(ret);
    	 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    	

    	 
	 
}
