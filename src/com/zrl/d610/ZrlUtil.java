package com.zrl.d610;

public class ZrlUtil{
	/**
	 * @param str
	 * @return
	 */
	public static boolean isPass(String str){
		return true;

	}

	/**
	 *
	 */

	public void test(){

	}

	public static void main(String[] args) {

		String a= "重地";
		String s = new String("通话");
		System.out.println(a.hashCode());
		System.out.println(s.hashCode());
		System.out.println(a.hashCode()==s.hashCode());
		System.out.println(a==s);
		System.out.println(a.equals(s));
	}
}