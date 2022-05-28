package com.zrl.day0516;

public class zrl3
{

	static boolean isPass(String str)
	{
		if(str.length()<8||str.length()>12)
			return false;
		int num = 0;
		int letter = 0;
		for (int i = 0; i < str.length(); i++)
		{
			char ch = str.charAt(i);
			if (ch > 48 && ch < '9')
				num++;
			else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
				letter++;
			else return false;
		}
		return num > 0 && letter > 0;
	}

	public static void main(String[] args)
	{

		System.out.println(isPass("add"));
		System.out.println(isPass("abcdegfihh"));
		System.out.println(isPass("123456789"));
		System.out.println(isPass("abcdefg12"));
	}
}
