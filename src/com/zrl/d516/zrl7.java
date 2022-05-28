package com.zrl.day0516;

public class zrl7
{
	public static void main(String[] args)
	{
		int a [] = new int [Short.MAX_VALUE];// 1 * 0X7F 1024 1024 1024 2^30    31 * 4
		System.out.println(a.length);//2 * 32767 16 10 6 2 4 8 16 32 64      15 * 2 65534  32767   2 15
	}
}
