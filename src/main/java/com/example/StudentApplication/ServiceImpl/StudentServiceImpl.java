package com.example.StudentApplication.ServiceImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.StudentApplication.Dto.StudentDto;
import com.example.StudentApplication.Entity.SkillEntity;
import com.example.StudentApplication.Entity.StudentEntity;
import com.example.StudentApplication.Exception.ExceptionHandling;
import com.example.StudentApplication.Repository.SkillRepository;
import com.example.StudentApplication.Repository.StudentRepository;
import com.example.StudentApplication.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private SkillRepository skillRepository;

	@Override
	public StudentEntity addStudents(StudentDto studentDto) throws ExceptionHandling {
		// TODO Auto-generated method stub
		if (studentRepository.checkEmailAlreadyExists(studentDto.getMail()) > 0)  {
			throw new ExceptionHandling("Email  already Exists");
		}
		
		if(studentDto.getAge()<18) {
			throw new ExceptionHandling("Age Should Be greater than 18");
		}
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setName(studentDto.getName());
		studentEntity.setAge(studentDto.getAge());
		studentEntity.setMail(studentDto.getMail());
		studentEntity.setAddress(studentDto.getAddress());
		studentEntity.setHostler(studentDto.isHostler());
		studentEntity.setDepartment(studentDto.getDepartment());
		return  studentRepository.save(studentEntity);
	}

	@Override
	public StudentEntity updateStudentsRecords(StudentDto studentDto,Integer id) throws ExceptionHandling {
		// TODO Auto-generated method stub
		Optional<StudentEntity> studentEntity = studentRepository.findById(studentDto.getId());
		if(studentRepository.checkEmailAlreadyExists(studentDto.getMail()) > 0) {
			throw new ExceptionHandling("Email already Exists");
		}
		
		StudentEntity studentEntity1 = studentEntity.get();
		studentEntity1.setName(studentDto.getName());
		studentEntity1.setAge(studentDto.getAge());
		studentEntity1.setMail(studentDto.getMail());
		studentEntity1.setAddress(studentDto.getAddress());
		studentEntity1.setHostler(studentDto.isHostler());
		studentEntity1.setDepartment(studentDto.getDepartment());
		
		return studentRepository.save(studentEntity1);
	
	}

	@Override
	public Optional<StudentEntity> getById(Integer id) throws ExceptionHandling {
		// TODO Auto-generated method stub
		if(!studentRepository.existsById(id)) {
			throw new ExceptionHandling("Student Information:"+id+"not found");
		}
		return studentRepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) throws ExceptionHandling {
		// TODO Auto-generated method stub
		if(!studentRepository.existsById(id)) {
			throw new ExceptionHandling("Student id:"+id+ "not Exist");
		}
		
		studentRepository.deleteById(id);
		
	}

	@Override
	public List<StudentEntity> findAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public List<StudentEntity> listOfStudents(List<StudentDto> studentListDto)  {
		// TODO Auto-generated method stub
     List<StudentEntity> listStudentEntity = new ArrayList<StudentEntity>();
		
		for(StudentDto st: studentListDto) {
			
			StudentEntity studentEntity = new StudentEntity();
			studentEntity.setName(st.getName());
			studentEntity.setAge(st.getAge());
			studentEntity.setMail(st.getMail());
			studentEntity.setAddress(st.getAddress());
			studentEntity.setHostler(st.isHostler());
			studentEntity.setDepartment(st.getDepartment());
			
			listStudentEntity.add(studentRepository.save(studentEntity));			
		}
		return listStudentEntity;
	}

	@Override
	public List<StudentEntity> getStudentDetailsByDepartment(String department) {
		// TODO Auto-generated method stub
		return studentRepository.findByDepartment(department);
	}

	@Override
	public List<String> getListOfStudentNameByHostler(Boolean hostler) {
		// TODO Auto-generated method stub
		return studentRepository.getListOfStudentNameByHostler(hostler);
	}

	@Override
	public Map<String, List<StudentEntity>> getAllStudentDetailsByDepartmentUsingMap(String department) {
		// TODO Auto-generated method stub
		List<StudentEntity> studentEntityList = studentRepository.getAllVehicleDetailsByDepartment(department);
		Map<String, List<StudentEntity>> studentDetailsGroupByDepartment = new HashMap<String, List<StudentEntity>>();
		for(StudentEntity vt:studentEntityList) {
			if(!studentDetailsGroupByDepartment.containsKey(vt.getDepartment())) {
			studentDetailsGroupByDepartment.put(vt.getDepartment(),new ArrayList<StudentEntity>());
			studentDetailsGroupByDepartment.get(vt.getDepartment()).add(vt);
			}
			else {
				studentDetailsGroupByDepartment.get(vt.getDepartment()).add(vt);
			}	
			
		}
		return studentDetailsGroupByDepartment;
	}

	@Override
	public StudentEntity assignSkillsToStudents(Integer id, Integer skillId) {
		// TODO Auto-generated method stub
		Set<SkillEntity> skillSet = null;
		StudentEntity studentEntity = studentRepository.findByStudentId(id);
		SkillEntity skillEntity = skillRepository.findBySkillId(skillId);
		skillSet = studentEntity.getSkills();
		skillSet.add(skillEntity);
		studentEntity.setSkills(skillSet);
		return studentRepository.save(studentEntity);
	}

	@Override
	public List<StudentEntity> getStudentDetailsBySkillName(String skillName) {
		// TODO Auto-generated method stub
		List<StudentEntity> studentEntity1= studentRepository.getAllStudentDetailsBySkillName(skillName);
		return studentEntity1;
	}

	@Override
	public List<StudentEntity> listAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	/*@Override
	public void save(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
		      List<StudentEntity> students = ExcelImporter.excelToStudents(file.getInputStream());
		      studentRepository.saveAll(students);
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store excel data: " + e.getMessage());
		    }
		
	}*/

	@Override
	public List<StudentEntity> getStudentDataBySkill(String skill_Name) {
		// TODO Auto-generated method stub
		List<StudentEntity> studentList = studentRepository.getByskillName(skill_Name);
        return studentList;
	}

	


}
