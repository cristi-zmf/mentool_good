package com.cristi.mentool.mentool.infra.persistence.mentor;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.mentor.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorsSdj extends JpaRepository<Mentor, UniqueId> {
}
