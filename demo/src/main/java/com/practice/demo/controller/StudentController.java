package com.practice.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.model.StudentModel;

@RestController
public class StudentController {

	// @RequestMapp//(name = "/login",method = RequestMethod.GET)

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

		System.out.println("Student Model: " + studentModel.getId() + " ," + studentModel.getFname() + " ,"
				+ studentModel.getMname() + " ," + studentModel.getLname());
	}
}
