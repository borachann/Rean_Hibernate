package com.boralovesahleak.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boralovesahleak.spring.dao.StudentDao;
import com.boralovesahleak.spring.demo.model.Student;
import com.boralovesahleak.spring.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao;

	@Transactional // ahhhh
	public void add(Student student) {
		// TODO Auto-generated method stub
		studentDao.add(student);
	}

	@Transactional
	public void edit(Student student) {
		// TODO Auto-generated method stub
		studentDao.edit(student);
	}

	@Transactional
	public void delete(int stuId) {
		// TODO Auto-generated method stub
		studentDao.delete(stuId);
	}

	@Transactional
	public Student getStudent(int stuId) {
		// TODO Auto-generated method stub
		return studentDao.getStudent(stuId);
	}

	@Transactional
	public List getAllStudent() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudent();
	}

}
