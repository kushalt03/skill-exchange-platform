package com.skillexchange.backend.service;

import com.skillexchange.backend.entity.*;
import com.skillexchange.backend.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import com.skillexchange.backend.entity.SkillType;
import com.skillexchange.backend.entity.SkillLevel;

@Service
public class UserSkillService {

    private final UserSkillRepository userSkillRepository;
    private final UserRepository userRepository;
    private final SkillRepository skillRepository;

    public UserSkillService(UserSkillRepository userSkillRepository,
                            UserRepository userRepository,
                            SkillRepository skillRepository) {
        this.userSkillRepository = userSkillRepository;
        this.userRepository = userRepository;
        this.skillRepository = skillRepository;
    }

    public UserSkill addUserSkill(Integer userId, Integer skillId, SkillType type, SkillLevel level) {

        User user = userRepository.findById(userId).orElseThrow();
        Skill skill = skillRepository.findById(skillId).orElseThrow();

        UserSkill userSkill = new UserSkill();
        userSkill.setUser(user);
        userSkill.setSkill(skill);
        userSkill.setType(type);
        userSkill.setLevel(level);

        return userSkillRepository.save(userSkill);
    }

    public List<UserSkill> getUsersBySkill(Integer skillId, SkillType type) {
        return userSkillRepository.findBySkill_IdAndType(skillId, type);
    }
}