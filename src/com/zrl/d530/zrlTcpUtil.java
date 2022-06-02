package com.zrl.d530;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class zrlTcpUtil {

	public static boolean isIp(String str) {
		int lf =str.length();
		if(lf>15||lf<7)
			return false;
		String ip[]= str.split("\\.");
		if(ip.length>4)
			return false;
		for(int i=0;i<4;i++)
			if(Integer.parseInt(ip[i])<0||Integer.parseInt(ip[i])>256)
				return false;
		return true;
	}


	public static boolean isboolIp(String ipAddress) {
		String ip = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
		Pattern pattern = Pattern.compile(ip);
		Matcher matcher = pattern.matcher(ipAddress);
		return matcher.matches();
	}
}
