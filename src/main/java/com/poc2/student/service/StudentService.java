package com.poc2.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poc2.student.entity.Project;
import com.poc2.student.entity.Student;
import com.poc2.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Transactional
	public ResponseEntity<Object> addStudent(Student student) {
		ResponseEntity<Object> responseEntity;
		if (!student.getProject().isEmpty()) {
			for (Project project : student.getProject()) {
				project.setStudent(student);
			}
			Student savedStudent = studentRepository.save(student);
			responseEntity = new ResponseEntity<Object>(
					"Student saved successfuly with id : " + savedStudent.getStudentId(), HttpStatus.OK);
		} else
			responseEntity = new ResponseEntity<Object>("Please enter atleast one project..", HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

	public ResponseEntity<Object> getAllStudents() {
		ResponseEntity<Object> responseEntity;

		List<Student> students = studentRepository.findAll();
		if (!students.isEmpty())
			responseEntity = new ResponseEntity<Object>(students, HttpStatus.OK);
		else
			responseEntity = new ResponseEntity<Object>("No Student record exists in Database...",
					HttpStatus.NO_CONTENT);
		return responseEntity;
	}

	public ResponseEntity<Object> getStudentById(Long studentId) {
		ResponseEntity<Object> responseEntity;

		if (studentId > 0) {
			Optional<Student> students = studentRepository.findById(studentId);
			if (!students.isEmpty())
				responseEntity = new ResponseEntity<Object>(students, HttpStatus.OK);
			else
				responseEntity = new ResponseEntity<Object>(
						"No Student record exists in Database with id : " + studentId, HttpStatus.NO_CONTENT);
		} else {
			responseEntity = new ResponseEntity<Object>("Please provide valid student id", HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}
}
