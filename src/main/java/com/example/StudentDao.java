package com.example;

import java.util.List;

public interface StudentDao extends AutoCloseable {
	Student findById(int roll)  throws Exception;
	List<Student> findAll()  throws Exception;
	int save(Student s)  throws Exception;
}
