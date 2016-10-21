package com.boralovesahleak.spring.service;

import java.util.List;

import com.boralovesahleak.spring.demo.model.Student;

public interface StudentService {
	public void add(Student student);
	public void edit(Student student);
	public void delete(int stuId);
	public Student getStudent(int stuId);
	public List getAllStudent();
}
