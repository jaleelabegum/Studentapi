package com.example.StudentApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentApplication.Dto.SkillDto;
import com.example.StudentApplication.Entity.SkillEntity;
import com.example.StudentApplication.Service.SkillService;

@RestController
public class Skillcontroller {
	
	@Autowired
	public SkillService skillService;
	
	@PostMapping("/addSkills")
	public SkillEntity createSkills(@RequestBody SkillDto skillDto) {
        return skillService.saveSkill(skillDto);
    }


}
