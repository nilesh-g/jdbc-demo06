package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao, AutoCloseable {
	private Connection con;
	public StudentDaoImpl() throws Exception {
		con = DbUtil.getConnection();
	}
	
	@Override
	public void close() {
		try {
			con.close();
		} catch (Exception e) {
			// ignore the error for now
		}
	}

	@Override
	public Student findById(int roll) throws Exception {
		String sql = "SELECT * FROM students WHERE roll=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, roll);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int rollNum = rs.getInt("roll");
				String name = rs.getString("name");
				double marks = rs.getDouble("marks");
				Student s = new Student(roll, name, marks);
				return s;
			}
		}
		return null;
	}

	@Override
	public List<Student> findAll() throws Exception {
		List<Student> list = new ArrayList<>();
		String sql = "SELECT * FROM students";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int rollNum = rs.getInt("roll");
				String name = rs.getString("name");
				double marks = rs.getDouble("marks");
				Student s = new Student(rollNum, name, marks);
				list.add(s);
			}
		}
		return list;
	}

	@Override
	public int save(Student s) throws Exception {
		String sql = "INSERT INTO students VALUES(?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, s.getRoll());
		stmt.setString(2, s.getName());
		stmt.setDouble(3, s.getMarks());
		int count = stmt.executeUpdate();
		return count;
	}

}
