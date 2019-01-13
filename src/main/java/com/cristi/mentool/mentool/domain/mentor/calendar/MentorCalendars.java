package com.cristi.mentool.mentool.domain.mentor.calendar;

import com.cristi.mentool.mentool.domain.UniqueId;

import java.time.LocalDateTime;
import java.util.List;

public interface MentorCalendars {
    List<UniqueId> findAllInInterval(LocalDateTime startTime, LocalDateTime endTime);

    MentorCalendar add(MentorCalendar calendarEntry);
}
