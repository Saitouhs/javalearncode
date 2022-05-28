package com.zrl.d527.dao;

import com.zrl.d527.entity.Course;
import com.zrl.d527.entity.Score;
import com.zrl.d527.entity.Student;

import java.util.ArrayList;

public class zrl22 {
	public static void main(String[] args) {
		/*Student stu[] = zrlDao.getStus();
		for (Student student : stu) {
			System.out.print(student.getS_id() + "\t|");
			System.out.print(student.getS_name() + "\t|");
			System.out.print(student.getS_brith() + "\t|");
			System.out.println(student.getS_sex());
		}
		System.out.println();
		for(int i=0;i<stu.length;i++){
			System.out.print(stu[i].getS_id()+"\t|");
			System.out.print(stu[i].getS_name()+"\t|");
			System.out.print(stu[i].getS_brith()+"\t|");
			System.out.println(stu[i].getS_sex());
		}
		System.out.println();
		int i=0;
		while (i<stu.length){
			System.out.print(stu[i].getS_id()+"\t|");
			System.out.print(stu[i].getS_name()+"\t|");
			System.out.print(stu[i].getS_brith()+"\t|");
			System.out.println(stu[i].getS_sex());
			i++;
		}
		System.out.println();
		i=0;
		do{
			System.out.print(stu[i].getS_id()+"\t|");
			System.out.print(stu[i].getS_name()+"\t|");
			System.out.print(stu[i].getS_brith()+"\t|");
			System.out.println(stu[i].getS_sex());
			i++;
		}while (i<stu.length);

		/*for (int i=0;i<stu.length;i++) {
			System.out.println(stu[i].toString());
		}*/

		/*ArrayList<Student> lstStu=zrlDao.getStus("select student.s_id ,stuent.s_name,count(select score.c_id from score group by score.s_id) from student join score on student.s_id = score.s_id ");

		for(Student tmp:lstStu){
			System.out.println(tmp);
		}*/

		/*Object o = new Object[]{null, 1, "zs", '1'};
		System.out.println(new Integer(1));
		System.out.println(new Character('1'));
		int a[] = new int[]{};
		new StringBuffer(30);*/
		/*Score scr[] = zrlDao.getScore();
		for (Score score : scr)
			System.out.println(score);
		System.out.println();*/
		Student stu[] = zrlDao.getStus();
		for (Student tmp : stu)
			System.out.println(tmp);
		System.out.println();
		Score scr[] = zrlDao.getScore();
		for (Score tpr : scr)
			System.out.println(tpr);
		System.out.println();
		Course crs[] = zrlDao.getCourse();
		for (Course tpc : crs)
			System.out.println(tpc);

	}

}
