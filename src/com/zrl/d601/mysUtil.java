package com.zrl.d601;

import com.zrl.d528.ipIllegal;
import com.zrl.d528.portIllegal;

import static com.zrl.d530.zrlTcpUtil.isIp;

public class mysUtil {

	public static boolean isIp(String sip) {
		if(sip==null)
			return false;
		int lf =sip.length();
		if(lf>15||lf<7||sip.charAt(0)<'0'||sip.charAt(0)>'9'||sip.charAt(lf-1)<'0'||sip.charAt(lf-1)>'9')
			return false;
		String[] ip = sip.split("\\.");
		if(ip.length>4)
			return false;
		for(int i=0;i<4;i++)
			if(Integer.parseInt(ip[i])<0||Integer.parseInt(ip[i])>255)
				return false;
		return true;
	}


	public static int isport(String sport) throws portIllegal {
		int port = 0;
		port = Integer.parseInt(sport);
		if (port > 9000 || port < 5000)
			throw new portIllegal(port);
		else return port;

	}

}
