package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;




@Controller
public class DepartmentController {
	
	private final DepartmentRepository repository;

	@Autowired //←コンストラクタが１つの場合は、＠Autowiredは省略可
	public DepartmentController(DepartmentRepository repository) {
		this.repository = repository;
		
	}

	
	@GetMapping("/add")
	public String showDepartment(@ModelAttribute Department department) {
		return "/department/form";
	}
	
	@PostMapping("/add")
	public String addDepartment(@ModelAttribute Department department, 
		Model model,
		BindingResult result) {
	
	if(result.hasErrors()) {
		return "index";
	}
	
	repository.save(department);
	return "redirect:/";
	}
	
	

	}

