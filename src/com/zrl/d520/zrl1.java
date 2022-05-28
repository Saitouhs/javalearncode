package com.zrl.d520;

public class zrl1
{

	static String arg = "zrl";
	public static void main(String[] args)
	{
		printData pd = new printData();

		pd.print(1);
		pd.print(2.5);
		String s = "hello java";
		pd.print(s);


		prd ps = new prd();

		ps.print(1);
		ps.print(2.5);
		ps.print(s);
	}
}
