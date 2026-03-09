package com.boss.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boss.Repository.StudentRepository;
import com.boss.entity.Student;

@RestController

public class StudentController {
	
	private final StudentRepository repo;
	
	public StudentController(StudentRepository repo) {
		this.repo=repo;
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return repo.findAll();	}
	
	@PostMapping("/students")
	public Student saveStudent(@RequestBody Student student) {
		return repo.save(student);
	}
	@GetMapping("/students/{id}")
	  public Student getStudentBygId(@PathVariable int id) {
		  return repo.findById(id).orElse(null);
	  }
	@PutMapping("/students/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
		Student existingStudent =repo.findById(id).orElse(null);
		
		if(existingStudent !=null) {
			existingStudent.setName(student.getName());
			existingStudent.setStudentClass(student.getStudentClass());
			existingStudent.setAddress(student.getAddress());
			return repo.save(existingStudent);
		}
		return null;
	}
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		repo.deleteById(id);
	    return "Student deleted successfully 👍👍👍";	
	}

}
