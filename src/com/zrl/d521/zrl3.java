package com.zrl.d521;

import java.io.*;

public class zrl3 {
	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.err.println("usage: java txtcp souse_file target_file");
			return;
		}
		BufferedReader bf = new BufferedReader(new FileReader(args[0]));
		String s = args[1];
		String c;
		Integer cnt = 0;
		boolean cpr = true;

		while ((c = bf.readLine()) != null) {
			String[] al = c.split(" ");
			for (String value : al) {
				int x = value.length() - s.length();
				for (int j = 0; j <= x; j++) {
					for (int k = 0; k < s.length(); k++) {
						if (value.charAt(j + k) != s.charAt(k)) {
							cpr = false;
							break;
						}
					}
					if (cpr) {
						cnt++;
						j += s.length() - 1;
					} else
						cpr = true;
				}
			}
		}
		System.out.println(cnt);
		System.out.println("end");
		bf.close();
	}
}
