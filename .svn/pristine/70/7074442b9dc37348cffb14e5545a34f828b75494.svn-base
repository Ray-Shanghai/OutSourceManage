package com.sd.farmework;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMain {
	/**
	 * @param args
	 * @throws UnknownHostException 
	 * @throws SocketException 
	 */
	public static void main(String[] args) throws UnknownHostException, SocketException {
		// TODO Auto-generated method stub
		
		//得到IP，输出PC-201309011313/122.206.73.83
		InetAddress ia = InetAddress.getLocalHost();
		System.out.println(ia);
		getLocalMac(ia);
	}
	private static void getLocalMac(InetAddress ia) throws SocketException {
		// TODO Auto-generated method stub
		//获取网卡，获取地址
		byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
		System.out.println("mac数组长度："+mac.length);
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<mac.length; i++) {
			if(i!=0) {
				sb.append("-");
			}
			//字节转换为整数
			int temp = mac[i]&0xff;
			String str = Integer.toHexString(temp);
			System.out.println("每8位:"+str);
			if(str.length()==1) {
				sb.append("0"+str);
			}else {
				sb.append(str);
			}
		}
		System.out.println("本机MAC地址:"+sb.toString().toUpperCase());
	}
	
	public static void main1(String[] args) throws SQLException, ClassNotFoundException {
//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		Connection conn=DriverManager.getConnection("jdbc:sqlserver://192.168.1.74:1433;DatabaseName=frameworkdb", "sa", "shida123456");
//		
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "shida123456");
	
		System.out.println(conn);

}
}