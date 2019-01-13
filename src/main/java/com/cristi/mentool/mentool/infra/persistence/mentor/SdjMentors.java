package com.cristi.mentool.mentool.infra.persistence.mentor;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.mentor.Mentor;
import com.cristi.mentool.mentool.domain.mentor.Mentors;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Primary
public class SdjMentors implements Mentors {

    private final MentorsSdj sdj;

    public SdjMentors(MentorsSdj sdj) {
        this.sdj = sdj;
    }

    @Override
    public Mentor add(Mentor mentor) {
        return sdj.saveAndFlush(mentor);
    }

    @Override
    public Mentor getOrThrow(UniqueId mentorId) {
        return Optional.ofNullable(sdj.getOne(mentorId)).orElseThrow(() -> new NoSuchElementException(mentorId.toString()));
    }

    @Override
    public Set<Mentor> findAll() {
        return new HashSet<>(sdj.findAll());
    }

    @Override
    public List<Mentor> findAllMentorsTeachingTheSkills(Set<UniqueId> skillIds) {
        return new ArrayList<>(sdj.findByTrainingsSkillId(skillIds));
    }

    @Override
    public List<Mentor> findAll(List<UniqueId> matchingMentorIds) {
        return sdj.findAllById(matchingMentorIds);
    }
}
