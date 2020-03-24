package com.cognizant.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.student.dao.StudentDao;
import com.cognizant.student.model.Student;
@Service
public class StudentServicesImpl implements StudentServices {
	@Autowired
	private StudentDao studentDao;

	@Override
	public String insert(Student student) {
		// TODO Auto-generated method stub
		return studentDao.insert(student);
	}

	@Override
	public String update(Student student) {
		// TODO Auto-generated method stub
		return studentDao.update(student);
	}

	@Override
	public String delete(Student student) {
		// TODO Auto-generated method stub
		return studentDao.delete(student);
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return studentDao.getAll();
	}


	public void setStudentDao(StudentDao students) {
		this.studentDao = students;
	}

}
