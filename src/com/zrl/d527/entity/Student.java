package com.zrl.d527.entity;

public class Student {
	private int s_id;
	private String s_name;
	private String s_brith;
	private String s_sex;

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_brith() {
		return s_brith;
	}

	public void setS_brith(String s_brith) {
		this.s_brith = s_brith;
	}

	public String getS_sex() {
		return s_sex;
	}

	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}

	@Override
	public String toString() {
		return "{\"s_id\":\""+s_id+"\"," +
				"\"s_name\":\""+s_name+"\"," +
				"\"s_brith\":\""+s_brith+"\"," +
				"\"s_sex\":\""+s_sex+"\"}";
	}
}


