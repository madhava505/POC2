package com.poc2.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.poc2.student.entity.Project;
import com.poc2.student.entity.Student;
import com.poc2.student.service.StudentService;

@SpringBootTest
class SpringBootStudentApiApplicationTests {

	@Autowired
	StudentService studentService;

	@Test
	void contextLoads() {
	}

	@Test
	void addStudentTest() throws ParseException {

		Student student = new Student();
		student.setFirstName("Madhava145");
		student.setLastName("Baleboina");
		student.setMobileNo("9640982360");
		student.setEmail("madhava@2345");
		student.setProject(
				Arrays.asList(new Project("projectName1", 8, student), new Project("ProjectName2", 24, student)));
		assertEquals(HttpStatus.OK, studentService.addStudent(null));
	}

	@Test
	void getAllStudentsTest() throws ParseException {
		String userType = "admin";
		assertEquals(HttpStatus.OK, studentService.getAllStudents());
	}

	@Test
	void getStudentByIdTest() throws ParseException {
		String userType = "admin";
		Long studentId = 1L;
		assertEquals(HttpStatus.OK, studentService.getStudentById(studentId));
	}

}
