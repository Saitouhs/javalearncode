package com.zrl.d528;

public class ipIllegal extends Exception {
	public ipIllegal(String s) {
		System.err.println("ip address " + s + " is illegal.\nPlease enter a valid IPv4 address.");
	}
}
