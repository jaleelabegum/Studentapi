package com.example.StudentApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.StudentApplication.Entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>  {

	@Query(value = "select count(*) from student_details where student_mail = ? ", nativeQuery = true)
	Integer checkEmailAlreadyExists(String mail);
    

	List<StudentEntity> findByDepartment(String department);
    
	@Query(value = "select * from student_details where student_hostler = ?",nativeQuery=true)
	List<String> getListOfStudentNameByHostler(Boolean hostler);
    
	@Query(value= "select * from student_details where student_department = ?",nativeQuery = true)
	List<StudentEntity> getAllVehicleDetailsByDepartment(String department);

    @Query(value = "select * from student_details where student_id = ?",nativeQuery = true)
	StudentEntity findByStudentId(Integer id);

    @Query(value = "select student_id,student_address,student_age,student_department,student_hostler,student_mail,student_name from student_details inner join skill_db  on student_id = skill_id where skill_name = ?",nativeQuery=true)
	List<StudentEntity> getAllStudentDetailsBySkillName(String skillName);

    @Query(value = "select student_details.student_id,student_details.student_name,student_details.student_age,student_details.student_mail,student_details.student_hostler,student_details.student_department,student_details.student_address,skill_db.skill_id,skill_db.skill_name,students_skills.skill_id,students_skills.student_id "
            + "from student_db join skill_db join students_skills "
            + "on skill_db.skill_id = students_skills.skill_id "
            + "AND students_skills.student_id = student_db.student_id "
            + "having skill_name = ?", nativeQuery = true)
	List<StudentEntity> getByskillName(String skill_Name); 
   
    @Query(value="select student_age from student_details where student_age  < 18",nativeQuery=true)
    Integer checkAgeLessthan18(Integer age);


}
