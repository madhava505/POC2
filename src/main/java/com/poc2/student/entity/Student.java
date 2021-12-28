package com.poc2.student.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "STUDENT")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUDENT_ID")
	private Long studentId;

	@Column(name = "FIRST_NAME")
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z ]{0,48}[a-zA-Z]$", message = "{student.firstname.errMessage}")
	private String firstName;

	@Column(name = "LAST_NAME")
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z ]{0,48}[a-zA-Z]$", message = "{student.lastname.errMessage}")
	private String lastName;

	@Column(name = "MOBILE_NO")
	@Pattern(regexp = "^[0-9]{10,10}$", message = "{student.mobile.errMessage}")
	private String mobileNo;

	@Column(name = "EMAIL")
	@Email(regexp = "^[a-zA-Z0-9_.]+[@][a-zA-Z]+[.][a-zA-Z]{2,3}$", message = "{student.email.errMessage}")
	private String email;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "student")
	private @NotEmpty(message = "{student.projectlist.errMessage}") List<Project> project;

	public Student() {
		super();
	}

	public Student(
			@Pattern(regexp = "^[a-zA-Z][a-zA-Z ]{0,48}[a-zA-Z]$", message = "{student.firstname.errMessage}") String firstName,
			@Pattern(regexp = "^[a-zA-Z][a-zA-Z ]{0,48}[a-zA-Z]$", message = "{student.lastname.errMessage}") String lastName,
			@Pattern(regexp = "^[0-9]{10,10}$", message = "{student.mobile.errMessage}") String mobileNo,
			@Email(regexp = "^[a-zA-Z0-9_.]+[@][a-zA-Z]+[.][a-zA-Z]{2,3}$", message = "{student.email.errMessage}") String email,
			@NotEmpty(message = "{student.projectlist.errMessage}") List<Project> project) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.project = project;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

}
