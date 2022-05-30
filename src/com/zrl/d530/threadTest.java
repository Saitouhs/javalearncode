package com.zrl.d530;
/*
 *Object a1[] = new Object[3];//new -> heap
 *Object a2[] = {1,"1",'1'};//-> stack  堆中对象池 new Integer (1) 地址 | 静态区"1"地址 | 堆 new Character ('1')地址
 * java-sqldbs
 *
 * 1.table->objectClass
 * 2.hashMap
 *
 * */

class ThreadA extends Thread {
	@Override
	public void run() {
		//thread code
		for (int i = 1; i < 99; i += 2)
			System.out.println(getName()+ "\t"+i );
	}
}

class ThreadB implements Runnable {
	@Override
	public void run() {
		for (int j = 2; j < 101; j += 2)
			System.out.println(Thread.currentThread().getName()+ "\t"+j );
	}
}

public class threadTest {
	public static void main(String[] args) {
			new ThreadA().start();
			new Thread(new ThreadB()).start();
	}

}
