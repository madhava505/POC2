package com.poc2.student.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poc2.student.entity.Student;
import com.poc2.student.service.StudentService;


@RestController
@Validated
public class StudentController {

	@Autowired
    private StudentService studentService;
     
    @RequestMapping(value = "/student/addStudent/",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addStudent(@Valid @RequestBody Student student, BindingResult bindingResult) {
    	if(bindingResult.hasErrors()) {
    		Map<String, String> errors = new HashMap<>();
    		bindingResult.getFieldErrors().forEach(error -> {
    			errors.put("message", error.getDefaultMessage());
    			errors.put("field name", error.getField());
    		});
    		
    		ResponseEntity<Object> responseEntity =	new ResponseEntity<Object>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    		return responseEntity;
    	}else
    		return studentService.addStudent(student);
    }
    
    @RequestMapping(value = "/student/getAllStudents/",method = RequestMethod.GET)
    public ResponseEntity<Object> getAllStudents() {
    	return studentService.getAllStudents();
    }
    
    @RequestMapping(value = "/student/getStudentById/{studentId}",method = RequestMethod.GET)
    public ResponseEntity<Object> getStudentById(@PathVariable("studentId")@NotNull(message = "{studentId.null.errMessage}") Long studentId) {
    	return studentService.getStudentById(studentId);
    }
}
