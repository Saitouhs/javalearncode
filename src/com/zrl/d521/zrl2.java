package com.zrl.d521;

import java.io.*;

public class zrl2 {
	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.err.println("usage: java txtcp souse_file target_file");
			return;
		}
		BufferedReader bf = new BufferedReader(new FileReader(args[0]));
		String s = args[1];
		String c;
		Integer cnt = 0;
		while ((c = bf.readLine()) != null) {
			String [] al  = c.split(" ");
			for (String value : al)
				if (value.equals(s))
					cnt++;
		}
		System.out.println(cnt);
		System.out.println("end");
		bf.close();
	}
}
