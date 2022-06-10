package com.zrl.d606;

import com.sun.org.apache.regexp.internal.RE;
import com.zrl.d527.entity.Student;


public class sorts {

	public static void main(String[] args) {
		int arr[] = new int[]{1, 5, 3, 6, 4, 7, 9, 8};
		qsort(arr, 0, arr.length - 1);
		for (int i : arr)
			System.out.printf(i + "\t");
		/*System.out.println(isPass(null));
		System.out.println(isPass("12345678"));
		System.out.println(isPass("abcdefgh"));
		System.out.println(isPass("123456ab@#"));
		System.out.println(isPass("1234abcd"));
		String a = "zsls@qq.com";
		System.out.println(a.split("@")[0]);
		System.out.println(a.substring(0, a.indexOf("@")));*/
	}
	static void sort(int[] a) {

		for (int i = 0; i < a.length - 1; i++)
			for (int j = 0; j < a.length - i - 1; j++)
				if (a[j] > a[j + 1]) {
					int tem = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tem;
				}
	}
	static boolean isPass(String Pass) {
		if (Pass == null || Pass.length() > 12 || Pass.length() < 8)
			return false;
		int num = 0, cha = 0;
		for (int i = 0; i < Pass.length(); i++)
			if ((Pass.charAt(i) >= '0' && Pass.charAt(i) <= '9'))
				num++;
			else if ((Pass.charAt(i) >= 'a' && Pass.charAt(i) <= 'z') || (Pass.charAt(i) >= 'A' && Pass.charAt(i) <= 'Z'))
				cha++;
			else return false;
		return num > 0 && cha > 0;
	}
	static void qsort(int[] arr, int begin, int end) {
		if (begin >= end)
			return;
		int i = begin;
		int j = end;
		int key = arr[begin];
		while (true) {
			while (arr[i] <= key) {
				i++;
				if (i >= end)
					break;
			}
			while (arr[j] >= key) {
				j--;
				if (j <= begin)
					break;
			}
			if (i >= j)
				break;
			int tem = arr[j];
			arr[j] = arr[i];
			arr[i] = tem;
		}
		arr[begin] = arr[j];
		arr[j] = key;

		qsort(arr, begin, j - 1);
		qsort(arr, j + 1, end);
	}
}
