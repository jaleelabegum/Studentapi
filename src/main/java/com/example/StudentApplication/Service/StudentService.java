package com.example.StudentApplication.Service;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.example.StudentApplication.Dto.StudentDto;
import com.example.StudentApplication.Entity.StudentEntity;
import com.example.StudentApplication.Exception.ExceptionHandling;

public interface StudentService {
	StudentEntity addStudents(StudentDto studentDto) throws ExceptionHandling;

	StudentEntity updateStudentsRecords(StudentDto studentDto,Integer id) throws ExceptionHandling;

	Optional<StudentEntity> getById(Integer id) throws ExceptionHandling;

	void deleteById(Integer id) throws ExceptionHandling;

	List<StudentEntity> findAllStudents();

	List<StudentEntity> listOfStudents(List<StudentDto> studentDto);

	List<StudentEntity> getStudentDetailsByDepartment(String department);

	List<String> getListOfStudentNameByHostler(Boolean hostler);

	Map<String, List<StudentEntity>> getAllStudentDetailsByDepartmentUsingMap(String department);

	StudentEntity assignSkillsToStudents(Integer id, Integer skillId);

	List<StudentEntity> getStudentDetailsBySkillName(String skillName);

	List<StudentEntity> listAll();

	//void save(MultipartFile file);

	List<StudentEntity> getStudentDataBySkill(String skill_Name);



}
