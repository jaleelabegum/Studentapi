package com.example.StudentApplication.Service;

import com.example.StudentApplication.Dto.SkillDto;
import com.example.StudentApplication.Entity.SkillEntity;

public interface SkillService {
	SkillEntity saveSkill(SkillDto skillDto);

}
