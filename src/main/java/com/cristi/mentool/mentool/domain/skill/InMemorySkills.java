package com.cristi.mentool.mentool.domain.skill;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class InMemorySkills implements Skills {
    private final Set<Skill> db;

    public InMemorySkills() {
        this.db = new HashSet<>();
    }

    @Override
    public List<Skill> findAllWithPattern(String trainingPattern) {
        String lowerCasePattern = trainingPattern.toLowerCase();
        return db.stream().filter(t -> t.getSkillName().toLowerCase().contains(lowerCasePattern))
                .collect(toList());

    }

    @Override
    public Skill add(Skill training) {
        db.add(training);
        return training;
    }
}
