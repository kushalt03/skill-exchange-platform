package com.skillexchange.backend.service;

import com.skillexchange.backend.entity.Skill;
import com.skillexchange.backend.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill addSkill(Skill skill) {

        Optional<Skill> existing = skillRepository.findByName(skill.getName());

        if (existing.isPresent()) {
            return existing.get();
        }

        return skillRepository.save(skill);
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }
}