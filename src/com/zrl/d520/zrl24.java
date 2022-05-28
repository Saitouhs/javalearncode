package com.zrl.d520;

import java.io.IOException;

public class zrl24 {


	static String test(String s4,StringBuffer s3)
	{
		s4 = s4.toUpperCase();
		s3.reverse();

		return s4;
	}

	public static void main(String[] args) throws IOException {

		String s1="hello";//static
		String s2 = new String("hello");//heap

		System.out.println(s1);
		System.out.println(s2);


		System.out.println(s2.charAt(1));

		System.out.println(s1);

		System.out.println(s2);/*
		s2.append(" java");
		System.out.println(s2);*/

	}
}
