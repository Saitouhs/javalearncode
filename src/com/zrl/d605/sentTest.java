package com.zrl.d605;

import static com.zrl.d605.javaMailTest.sentMail;

public class sentTest {

	public static void main(String[] args) {
		String to = "3094816545@qq.com";
		String title = "测试邮件标题";
		String text = "测试邮件正文";
		sentMail(to,title,text);
	}


}
