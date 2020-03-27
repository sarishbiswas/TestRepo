package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.StudentDao;
import com.cognizant.model.Student;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;
	@Override
	public String insert(Student student) {
		return studentDao.insert(student);
	}

	@Override
	public String update(Student student) {
		return studentDao.update(student);
	}

	@Override
	public String delete(Student student) {
		return studentDao.delete(student);
	}

	@Override
	public List<Student> getAll() {
		return studentDao.getAll();
	}

	@Override
	public List<Student> getByName(Student student) {
		return studentDao.getByName(student);
	}

	@Override
	public int countStudents() {
		// TODO Auto-generated method stub
		return studentDao.countStudents();
	}

}
