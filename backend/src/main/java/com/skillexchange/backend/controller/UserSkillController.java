package com.skillexchange.backend.controller;

import com.skillexchange.backend.entity.*;
import com.skillexchange.backend.service.UserSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-skills")
public class UserSkillController {

    private final UserSkillService userSkillService;

    public UserSkillController(UserSkillService userSkillService) {
        this.userSkillService = userSkillService;
    }

    @PostMapping
    public UserSkill addUserSkill(
            @RequestParam Integer userId,
            @RequestParam Integer skillId,
            @RequestParam SkillType type,
            @RequestParam SkillLevel level) {

        return userSkillService.addUserSkill(userId, skillId, type, level);
    }

    @GetMapping("/search")
    public List<UserSkill> getUsersBySkill(
            @RequestParam Integer skillId,
            @RequestParam SkillType type) {

        return userSkillService.getUsersBySkill(skillId, type);
    }
}