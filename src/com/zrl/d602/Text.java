package com.zrl.d602;

public class Text {
}

class Thread1 extends Thread {
	Text t1;
	Text t2;

	public Thread1(Text t1, Text t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public void run() {
		synchronized (t1) {
			try {
				sleep(200);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(getName() + "to lock t2");
			synchronized (t2) {
				System.out.println(getName() + "locked");
			}
		}
	}
}

class Thread2 extends Thread {
	Text t1;
	Text t2;

	public Thread2(Text t1, Text t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public void run() {
		synchronized (t2) {
			try {
				sleep(200);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(getName() + "to lock t1");
			synchronized (t1) {
				System.out.println(getName() + "locked");
			}
		}
	}
}

class nys {
	public static void main(String[] args) {
		Text t1 = new Text();
		Text t2 = new Text();
		Thread1 tr1 = new Thread1(t1, t2);
		Thread2 tr2 = new Thread2(t1, t2);

		tr1.start();
		tr2.start();

	}
}
