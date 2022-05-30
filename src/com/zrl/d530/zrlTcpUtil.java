package com.zrl.d530;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class zrlTcpUtil {

	public static boolean isPort(String port) {
		int lf =port.length();
		String a[]= port.split("\\.");
		if(a.length>4)
			return false;
		for(int i=0;i<4;i++)
			if(Integer.parseInt(a[i])<0||Integer.parseInt(a[i])>256)
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
