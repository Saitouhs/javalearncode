package com.zrl.d514;

public class zrl1
{

	static void sort(int zrls[], int len)
	{
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < len - i; j++) {
				if (zrls[j] > zrls[j + 1]) {
					int t = zrls[j];
					zrls[j] = zrls[j + 1];
					zrls[j + 1] = t;
				}
			}
		}
	}


	public static void main(String[] args)
	{
		int a[] = {2, 1, 9, -3};
		for (int i = 0; i < a.length; i++)
			System.out.printf("%d \t", a[i]);
		System.out.println();
		sort(a, a.length);
		for (int i : a)
			System.out.printf("%d\t", i);
	}

}

