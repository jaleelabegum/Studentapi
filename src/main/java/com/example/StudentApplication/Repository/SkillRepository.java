package com.example.StudentApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.StudentApplication.Entity.SkillEntity;

@Repository

public interface SkillRepository extends JpaRepository<SkillEntity, Integer> {
	@Query(value = "select * from skill_db where skill_id = ?",nativeQuery=true)
	SkillEntity findBySkillId(Integer skillId);
    
	
   


}
