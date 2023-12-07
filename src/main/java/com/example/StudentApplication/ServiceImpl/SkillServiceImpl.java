package com.example.StudentApplication.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentApplication.Dto.SkillDto;
import com.example.StudentApplication.Entity.SkillEntity;
import com.example.StudentApplication.Repository.SkillRepository;
import com.example.StudentApplication.Service.SkillService;

@Service
public class SkillServiceImpl implements SkillService  {
	@Autowired
	private SkillRepository skillRepository;

	@Override
	public SkillEntity saveSkill(SkillDto skillDto) {
		// TODO Auto-generated method stub
		SkillEntity skillEntity = new SkillEntity();
		skillEntity.setSkillName(skillDto.getSkillName());
		skillEntity.setSillId(skillDto.getSkillId());
		return skillRepository.save(skillEntity);
	}


}
