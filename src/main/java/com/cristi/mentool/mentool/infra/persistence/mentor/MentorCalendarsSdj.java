package com.cristi.mentool.mentool.infra.persistence.mentor;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.mentor.MentorCalendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Set;

public interface MentorCalendarsSdj extends JpaRepository<MentorCalendar, UniqueId> {
    Set<MentorCalendar> findByStartTimeGreaterThanEqualAndEndTimeLessThanEqual(LocalDateTime startTime, LocalDateTime endTime);
}
