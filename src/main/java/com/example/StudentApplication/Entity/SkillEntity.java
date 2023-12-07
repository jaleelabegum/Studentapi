package com.example.StudentApplication.Entity;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Skill_Db")

public class SkillEntity {

	@Id
	@Column(name = "Skill_id")
	private Integer sillId;
	
	@Column(name = "Skill_name")
	private String skillName;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "skills")
	private Set<StudentEntity> students;

	public Integer getSillId() {
		return sillId;
	}

	public void setSillId(Integer sillId) {
		this.sillId = sillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	/*public Set<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentEntity> students) {
		this.students = students;
	}*/	

	

}
