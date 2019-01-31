package com.cristi.mentool.mentool.infra.persistence.mentor;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.mentor.Mentor;
import com.cristi.mentool.mentool.domain.user.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface MentorsSdj extends JpaRepository<Mentor, EmailAddress> {
    Set<Mentor> findByTrainingsSkillId(Set<UniqueId> skillIds);
}
