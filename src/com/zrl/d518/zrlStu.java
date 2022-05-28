package com.zrl.d518;

import java.util.Arrays;
import java.util.Objects;

/***
 * 无父类 obj
 *
 * 无构造 默认构造无参
 *
 * public zrlStu(){}
 * @author Saito
 */
public class zrlStu
{
	private static int id;
	private static String name;

	private static int age;
	private static String sex;

	public zrlStu()
	{

	}

	public zrlStu(int id, String name, int age, String sex)
	{
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	@Override
	public String toString()
	{
		return "zrlStu{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", sex='" + sex + '\'' +
				'}';
	}
}
