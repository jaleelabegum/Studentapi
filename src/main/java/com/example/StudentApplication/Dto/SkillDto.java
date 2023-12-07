package com.example.StudentApplication.Dto;

import java.util.Set;

import jakarta.persistence.ManyToMany;

public class SkillDto {
	private Integer skillId;
	private String skillName;
	
	@ManyToMany(mappedBy="skills")
	private Set<StudentDto> students;
	public Integer getSkillId() {
		return skillId;
	}
	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}	


}
