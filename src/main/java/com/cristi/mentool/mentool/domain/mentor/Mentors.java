package com.cristi.mentool.mentool.domain.mentor;

import com.cristi.mentool.mentool.domain.UniqueId;

import java.util.Set;

public interface Mentors {

    Mentor getOrThrow(UniqueId mentorId);
    Set<Mentor> findAll();

}
