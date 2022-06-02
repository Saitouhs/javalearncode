package com.zrl.d602;

import java.util.ArrayList;

class TestThread extends Thread {
	ArrayList<Integer> lst;

	@Override
	public void run() {
		for(int i=1;i<=500;i++)
			lst.add(i);
	}

	public TestThread(ArrayList<Integer> lst) {
		this.lst = lst;
	}
}

public class syn {

	public static void main(String[] args) throws InterruptedException {
		ArrayList<Integer> lst = new ArrayList<>();
		Thread t1 = new TestThread(lst);
		Thread t2 = new TestThread(lst);
		t1.start();t2.start();
		t1.join();t2.join();
		System.out.println(lst.size());
	}
}
