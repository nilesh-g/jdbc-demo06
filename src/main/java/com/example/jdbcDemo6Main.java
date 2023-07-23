package com.example;

import java.util.List;

public class jdbcDemo6Main {

	public static void main(String[] args) {
		try(StudentDao dao = new StudentDaoImpl()) {
			Student s = new Student(6, "Elon", 97.2);
			int cnt = dao.save(s);
			System.out.println("Inserted records: " + cnt);
		} // dao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try(StudentDao dao = new StudentDaoImpl()) {
			List<Student> list = dao.findAll();
			for (Student s : list)
				System.out.println(s);
		} // dao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
