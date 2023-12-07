package com.example.StudentApplication.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;

public class StudentEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Student_Id")
	private Integer id;
	
	@Column(name="Student_name")
	private String name;
	
	@Column(name="Student_Age")
	private Integer age;
	
	@Email
	@Column(name="Student_Mail")
	private String mail;
	
	@Column(name ="Student_Address")
	private String address;
	
	@Column(name="Student_Hostler")
	private boolean hostler;
	
	@Column(name="Student_Department")
	private String department;
	
	  @ManyToMany
	  @JoinTable(name="Students_Skills")
	  
	  private Set<SkillEntity> skills = new HashSet<>();
	 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isHostler() {
		return hostler;
	}

	public void setHostler(boolean hostler) {
		this.hostler = hostler;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Set<SkillEntity> getSkills() {
		return skills;
	}

	public void setSkills(Set<SkillEntity> skills) {
		this.skills = skills;
	}


}
