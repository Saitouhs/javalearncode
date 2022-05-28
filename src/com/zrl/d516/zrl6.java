package com.zrl.day0516;

public class zrl6
{
	static int  test(int a)
	{
		a=200;
		return a;
	}
	static int b=200;

	public static void main(String[] args)
	{
		int a=100;
		test(a);
		System.out.println(b);
		System.out.println(a);
	}
}
