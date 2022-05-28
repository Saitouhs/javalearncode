package com.zrl.day0516;

public class zrl2
{

	public static void main(String[] args)
	{/*
		Short s1 = 1;//内存s1指向内容是0x01
		Short s2 = 1;//同上
		System.out.println(s1 == s2);
		s1 = 200;
		s2 = 200;//new200
		System.out.println(s1 == s2);*/

		String s1 = "hello";
		String s2 = "hello";
		String s3 = new String("hello");

		System.out.println(s1 == s3);
		System.out.println(s2 == s3);

	}
}
