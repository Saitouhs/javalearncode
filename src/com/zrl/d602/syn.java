package com.zrl.d602;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

class test{
	synchronized void test1() throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+"\t"+System.currentTimeMillis());
		Thread.sleep(2000);
	}
	void test2() throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+"\t"+System.currentTimeMillis());
		Thread.sleep(2000);
	}
}

class TestThread extends Thread {
	/*Vector<Integer> lst;

	@Override
	public void run() {
		for (int i = 1; i <= 50000; i++)
			lst.add(i);
	}

	public TestThread(Vector<Integer> lst) {
		this.lst = lst;*/

	test t;

	@Override
	public void run() {
		try{
			t.test1();
			//t.test2();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public TestThread(test t) {
		this.t = t;
	}
}

public class syn {

	public static void main(String[] args) throws InterruptedException {

	/*	StringBuffer;   vector    ;         Hashtable;       //	synchronized

		HashMap;        ArrayList    StringBuilder;//no synchronized*/
		/*Vector<Integer> lst = new Vector<>();
		Thread t1 = new TestThread(lst);
		Thread t2 = new TestThread(lst);
		t1.start();t2.start();
		t1.join();t2.join();
		System.out.println(lst.size());*/
		test test = new test();
		Thread t1 = new TestThread(test);
		Thread t2 = new TestThread(test);

		t1.start();t2.start();


	}
}
