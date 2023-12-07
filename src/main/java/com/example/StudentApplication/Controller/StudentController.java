package com.example.StudentApplication.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentApplication.Dto.StudentDto;
import com.example.StudentApplication.Entity.StudentEntity;
import com.example.StudentApplication.Exception.ExceptionHandling;
import com.example.StudentApplication.Service.SkillService;
import com.example.StudentApplication.Service.StudentService;

@RestController
public class StudentController {
	@Autowired
	public StudentService studentService;
	
	@Autowired
	public SkillService skillService;
	
	
	
	/*@Autowired
	public ExcelService excelService; */
	
	public  StudentController(StudentService studentService) {
		// TODO Auto-generated constructor stub
		this.studentService=studentService;
		
	}
	
	@PostMapping("/addStudentsRecords")
	public StudentEntity addStudent(@RequestBody StudentDto studentDto)  throws ExceptionHandling{
		return studentService.addStudents(studentDto);
	}
	
	@PutMapping("/updateStudentsRecords/{id}")
	public StudentEntity updateStudentsRecordsByID(@RequestBody StudentDto studentDto,Integer id) throws ExceptionHandling {
		return studentService.updateStudentsRecords(studentDto, id);
	}
	
	@GetMapping("/getStudentsRecords/{id}")
	private Optional<StudentEntity> getStudentsRecordsyId(@PathVariable("id") Integer id) throws ExceptionHandling {	
		return studentService.getById(id);		
	}
	
	@DeleteMapping("/DeleteStudent/{id}")
	private void deleteStudentById(@PathVariable("id") Integer id) throws ExceptionHandling{ 
		studentService.deleteById(id);  
	}  
	
	@GetMapping("/getAllStudentsRecords")
	public List<StudentEntity> getVehicle(){
		return studentService.findAllStudents();
	}
	
	@PostMapping("/addListOfStudents")
	public List<StudentEntity> listOfStudent(@RequestBody List<StudentDto> studentDto) {
		return studentService.listOfStudents(studentDto);
	}
	
	@GetMapping("/department/{department}")
	public List<StudentEntity> getStudentsByDept(@PathVariable String department){
		return studentService.getStudentDetailsByDepartment(department);
	} 
	
	@GetMapping("/listOfStudentsName/{hostler}")
	private List<String> getListOfStudentNameByHostler(@PathVariable("hostler") Boolean hostler)  {	
		return studentService.getListOfStudentNameByHostler(hostler);		
	} 
	
	@GetMapping("/getStudentsDetailsByDepartment/{department}")
	private Map<String, List<StudentEntity>> getAllStudentsDetailsByDepartmentUsingMap(@PathVariable  String department ){
		return studentService.getAllStudentDetailsByDepartmentUsingMap(department);
	}	
	
	@PostMapping("/{id}/skills/{skillId}")
	public  StudentEntity assignSkillsToStudents(@PathVariable Integer id,@PathVariable Integer skillId) {
		return studentService.assignSkillsToStudents(id,skillId);
	}
	
	@GetMapping("/skills/{skillName}/students")
	private List<StudentEntity> getStudentDetailsBySkillName(@PathVariable String skillName){
		return studentService.getStudentDetailsBySkillName(skillName);
	}
	
	
	 @GetMapping("/getStudentDataBySkill/{skill_Name}")
	    public List<StudentEntity> getStudentDataBySkill(@PathVariable String skill_Name) {
	        return studentService.getStudentDataBySkill(skill_Name);

	 }
	 
	
	 


}
