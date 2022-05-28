package com.zrl.d528;

import java.util.Scanner;

public class zrl5281 {
	static int[] count(String str) {

		int[] cnt = new int[10];

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) <= '9' && str.charAt(i) >= '0')//48
				cnt[str.charAt(i) - '0']++;
		}
		return cnt;
	}

	public static void main(String[] args) {
		String str;
		Scanner scanner = new Scanner(System.in);
		str = scanner.nextLine();
		int[] cnt = count(str);
		for (int i = 0; i < 10; i++)
			System.out.printf("%d:\t%d\n", i, cnt[i]);
	}
}