package com.zrl.d514;

class zrl3
{
	static int sum(int zsls[], int len)
	{
		int s = 0;
		zsls[zsls[0]]++;
		for (int i = 0; i < len; i++)
			s = s + zsls[i];
		return s;
	}

	public static void main(String[] args)
	{
		int a[] = {2, 1, 9, -3};
		for (int i = 0; i < a.length; i++)
			System.out.printf("%d\t", a[i]);
		System.out.printf(" \n%d", sum(a, a.length));
	}
}