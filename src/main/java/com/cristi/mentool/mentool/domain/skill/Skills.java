package com.cristi.mentool.mentool.domain.skill;

import java.util.List;

public interface Skills {
    List<Skill> findAllWithPattern(String trainingPattern);

    Skill add(Skill training);
}
