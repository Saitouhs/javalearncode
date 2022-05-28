package com.zrl.d520;

public class prd extends printData
{

	public void print(int i)
	{

		System.out.printf("int :\t%d\t", i);
	}

	public void print(double f)
	{

		System.out.printf("float:\t%f\t", f);
	}

	public void print(String c)
	{
		System.out.printf("string:\t");System.out.println(c);
	}
}
