package com.zrl.d520;

import java.io.IOException;

public class zrl25 {

	static boolean isValidNumber(String str) {
		int i = Integer.parseInt(str);
		if (i<5000||i>9999)
			return false;
		return true;
	}

	public static void main(String[] args) {

		Integer a=5;
		Integer b=a+10;
		Integer c=15;
		Integer d=5+10;
		System.out.println(b==c);
		System.out.println(c==d);
		System.out.println(b==d);
	}
}