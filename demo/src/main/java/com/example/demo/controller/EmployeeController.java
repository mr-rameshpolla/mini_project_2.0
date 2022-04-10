package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.empolyee;
import com.example.demo.repo.EmployeeRepo;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepo employeerepo; 
	
	@PostMapping("/saveemp")
	public ResponseEntity<Map<String,String>> postMethod(@RequestBody empolyee emp) {
		employeerepo.save(emp); 
		Map<String,String> response = new HashMap<String, String>();
		response.put("ok", "success saving data");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@GetMapping("/getemp")
	public List<empolyee>saveMethod(){
		return employeerepo.findAll();
	} 
	
	@GetMapping("/getemp/{id}")
	public Optional<empolyee> saveMethod(@PathVariable(value="id") Long id){
		return employeerepo.findById(id);
	}
//	@DeleteMapping("/deleteemp/{id}")
//	public ResponseEntity<> deleteMethod(@PathVariable(value="id") Long id){
//	      employeerepo.deleteById(id);
//	      return ResponseEntity<HttpStatus.OK>)
//	}
    
//	@PutMapping("/upadate/{id}")
//	public ResponseEntity<Map<String,String>>updatemp(@RequestBody empolyee newemp,@RequestParam(value="id") Long id){
//		
//		empolyee oldone = employeerepo.findById(id); 
//		oldone.setName(newemp.getName()); 
//		oldone.setUsername(newemp.getUsername()); 
//		oldone.setPassword(newemp.getPassword()); 
//		employeerepo.save(oldone); 
//		Map<String,String> response = new HashMap<String, String>(); 
//		response.put("status","UpdatedSuccessfully"); 
//		return new ResponseEntity<>(response,HttpStatus.ok);
//	}


}
