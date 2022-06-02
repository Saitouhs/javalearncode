package com.zrl.d528;

class portIllegal extends Exception {
	public portIllegal(int port) {
		super("port " + port + " is illegal.\nPlease enter a value between 5000 and 9000.\n");
	}
}
