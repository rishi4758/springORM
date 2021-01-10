package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDao {
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	private HibernateTemplate hibernateTemplate;
	@Transactional
	public int insert (Student student) {
		Integer i =(Integer) hibernateTemplate.save(student);
		return i;
	}
	@Transactional
	public Student getStudent(int studentId){
		System.out.println(studentId+"id");
		Student st= this.hibernateTemplate.get(Student.class, studentId);
		return st;
		
	}
	@Transactional
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		List<Student> allStudent= this.hibernateTemplate.loadAll(Student.class);
		return allStudent;
	}
	@Transactional
	public int delStudent(int i) {
		// TODO Auto-generated method stub
		Student st=this.hibernateTemplate.get(Student.class, i);
		hibernateTemplate.delete(st);
		return 0;
	}

}
