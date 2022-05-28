package com.zrl.d520;


public class zrl23 {


	/***
	 * 统计特定字符数量
	 *
	 */
	static int counts(String str, char c) {
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)==c)
				cnt++;
		}
		return cnt;
	}


	public static void main(String[] args) {
		//zrlStudent zrls[]=new zrlStudent[10];
		/*double i[]=new double[10];
		for (double j :i) {
			System.out.printf("%d\t\t",(int)i[(int)j]);
		}
		System.out.println();
		for(int j=0;j<10;j++)
		{
			System.out.printf("%s\t",zrls[j]);
		}


		System.out.println(zrls);
		System.out.println(zrls[0]);

		zrls[0] = new zrlStudent();

		System.out.println(zrls[0]);
		zrls[1] = new zrlStudent(1000,"zrl",26,"male");*/

		/*System.out.println("".length());
		System.out.println(args);
		System.out.println(args[0]);
		System.out.println("".charAt(0));*/

		/*System.out.println("abcdbc".indexOf("cb"));
		String s1 = "quit";
		String s2 = new String(s1);
		System.out.println(s1 == s2);

		String s3 = "abc,cd,dfdf,zrl";
		String ss[] = s3.split(",");
		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i]);

		}*/


		System.out.println(counts("hellow world",'l'));

	}
}
