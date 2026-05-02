package com.skillexchange.backend.repository;

import com.skillexchange.backend.entity.SkillType;
import com.skillexchange.backend.entity.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSkillRepository extends JpaRepository<UserSkill, Integer> {

    List<UserSkill> findBySkill_IdAndType(Integer skillId, SkillType type);
}