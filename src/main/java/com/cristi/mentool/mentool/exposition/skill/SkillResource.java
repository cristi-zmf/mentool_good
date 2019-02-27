package com.cristi.mentool.mentool.exposition.skill;

import com.cristi.mentool.mentool.domain.skill.Skill;
import com.cristi.mentool.mentool.domain.skill.Skills;
import com.cristi.mentool.mentool.exposition.MentoolRequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@MentoolRequestMapping
public class SkillResource {
    private final Skills skills;

    public SkillResource(Skills skills) {
        this.skills = skills;
    }

    @GetMapping("/skills")
    public List<Skill> getSkills() {
        return skills.findAllWithPattern(null);
    }

    @PutMapping("/skills")
    public Skill addSkill(@RequestBody SkillCreateCommand skill) {
        return skills.add(new Skill(skill.skillName));
    }
}
