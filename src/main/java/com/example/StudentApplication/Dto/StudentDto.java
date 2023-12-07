package com.example.StudentApplication.Dto;

import java.util.Set;

public class StudentDto {
	private Integer id;
	private String name;
	private Integer age;
	private String mail;
	private String address;
	private boolean hostler;
	private String department;
	private Set<SkillDto> skills;
	
	
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
	public Set<SkillDto> getSkills() {
		return skills;
	}
	public void setSkills(Set<SkillDto> skills) {
		this.skills = skills;
	}


}
