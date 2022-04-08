package com.practice.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.model.StudentModel;
import com.practice.demo.service.StudentService;
import com.practice.demo.service.StudentServiceImpl;

@RestController
public class StudentController {

	// @RequestMapp//(name = "/login",method = RequestMethod.GET)
	@Autowired
	StudentServiceImpl service;

	@GetMapping("/login")
	public String loginPage() {
		System.out.println("This is login pagre");
		return "Welcome this is newpage";

	}

	@GetMapping("/student/welcome")
	public String welcomepage() {

		return "Welcome this is newpage";

	}

	// @RequestMapping(name = "/student/saveStudent", method = RequestMethod.POST)
	@PostMapping("/student/saveStudent/{id}/{name}")
	public void saveStudent(@PathVariable("id") String id, @PathVariable("name") String name) {

		System.out.println("Id: " + id + "Name: " + name);
	}

	@PostMapping("/student/saveStudentModel")
	public void saveStudenModel(@RequestBody StudentModel studentModel) {
		// StudentServiceImpl service = new StudentServiceImpl();

		System.out.println("Student Model: " + studentModel.getId() + " ," + studentModel.getFname() + " ,"
				+ studentModel.getMname() + " ," + studentModel.getLname());
		service.savestudent(studentModel);
	}

	@GetMapping("/student/getAll")
	public List<StudentModel> getAllData() {
		List list = service.getAllStudent();
		System.out.println("Student List: " + list);
		return list;
	}
	
	@GetMapping("/student/findById/{id}")
	public StudentModel FindById(@PathVariable("id") Integer id) {
		StudentModel s= service.findById(id);
		System.out.println("Student List: " + s);
		return s;
	}
}
