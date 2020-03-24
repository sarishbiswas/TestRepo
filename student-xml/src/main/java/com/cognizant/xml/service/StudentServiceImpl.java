package com.cognizant.xml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.xml.dao.StudentDao;
import com.cognizant.xml.model.Student;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private
	StudentDao studentDao;
	public String insert(Student student) {
		// TODO Auto-generated method stub
		return studentDao.insert(student);
	}

	public String update(Student student) {
		// TODO Auto-generated method stub
		return studentDao.update(student);
	}

	public String delete(Student student) {
		// TODO Auto-generated method stub
		return studentDao.delete(student);
	}

	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return studentDao.getAll();
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

}
