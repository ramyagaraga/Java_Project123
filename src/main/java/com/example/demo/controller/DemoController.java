package com.example.demo.controller;

import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.demo.CustomException;
import com.example.demo.Dto.Department;
import com.example.demo.service.DepService;
import com.github.andrewoma.dexx.collection.List;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/demo1")
public class DemoController {
    
	@Autowired
	depService depService;
	
	
	
	
	@PostMapping("/saveDept")
	public Department name(@Valid @RequestBody Department department) {
		System.err.println(a+"lll");
		Department department2 = depService.saveDept(department);
		 return department2;
	}
	@GetMapping("/fetchAll")
	public ResponseEntity<java.util.List<Department>> fetchAll() {
			return ResponseEntity.ok(depService.fetchAll());
	}
	
	@GetMapping("/getDept/{id}")
	public Department getById(@PathVariable int id) {
 
			return depService.getById(id);
	}
	
//	@GetMapping("getAll")
//	public List<Department> getAll() {
//		return depService.getAll();
//     }
	
	@PutMapping("/updateDept")
	public Department updateDept(@RequestBody Department department) throws CustomException {
		return depService.updateDept(department);
		
	}
	
	@DeleteMapping("/deleteDept/{id}")
	private int deleteDept(@PathVariable int id) {

		depService.deleteDept(id);

		return id;
	}
	
	
}
