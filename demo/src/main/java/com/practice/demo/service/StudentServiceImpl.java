package com.practice.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.demo.model.StudentModel;
import com.practice.demo.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepo repo;
	
	public void savestudent(StudentModel student) {

		repo.save(student);
		
	}

	public List getAllStudent() {
		return repo.findAll();
		
	}

	public StudentModel findById(Integer id) {
		
		return repo.findById(id).get();
	}
}
