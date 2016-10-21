package com.boralovesahleak.spring.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boralovesahleak.spring.dao.StudentDao;
import com.boralovesahleak.spring.demo.model.Student;
@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(student);
	}

	@Override
	public void edit(Student student) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(student);
	}

	@Override
	public void delete(int stuId) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(getStudent(stuId));
	}

	@Override
	public Student getStudent(int stuId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Student.class, stuId);
	}

	@Override
	public List getAllStudent() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Student").list();
	}

}
