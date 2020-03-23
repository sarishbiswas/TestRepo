package com.cognizant.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.model.Student;

@Service
public class StudentDaoImpl implements StudentDao {

	private List<Student> students = new ArrayList<>();

	public String insert(Student student) {
		// TODO Auto-generated method stub
		students.add(student);
		return "Success";
	}

	@Override
	public String update(int id, String name) {
		String st = "Update Failure";
		for (Student student : students) {
			if (student.getId() == id) {
				student.setName(name);
				st = "Update Successful";
				break;
			}
		}
		return st;
	}

	@Override
	public String delete(int id) {
		int i=0;
		String st = "Deletion Failure";
		for (Student student : students) {
			if (student.getId() == id) {
				students.remove(i);
				st = "Deletion Successful";
				break;
			}
			i++;
		}
		return st;
	}

	@Override
	public List<Student> getAll() {
		return students;
	}
}
