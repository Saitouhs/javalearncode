package com.zrl.d528;

import java.util.*;

public class mapTest {
	static Map<Character, Integer> count(String str) {
		Map<Character, Integer> m = new Hashtable<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= '0' && ch <= '9') {
				m.merge(ch, 1, Integer::sum);
			}
		}
		return m;
	}

	static Set<Character> count2(String str){
		Set <Character>s =new HashSet<Character>();
		for (int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			s.add(ch);
		}
		return s;
	}


	public static void main(String[] args) {
		Map<Character, Integer> m = count("zrls12dfdee223");
		System.out.println(m.keySet());
		System.out.println(m.values());
		for (Character ch : m.keySet()) {
			System.out.println("key\t" + ch + ":value\t" + m.get(ch));
		}

		Set<Character>set = count2("aweefsqwfaf");
		Set<String> s = new HashSet<String>();
		s.add(null);
		s.add("zs");
		s.add("ls");
		s.add("zs");
		s.add(new String("ls"));
		System.out.println(s.size());



	}

}
