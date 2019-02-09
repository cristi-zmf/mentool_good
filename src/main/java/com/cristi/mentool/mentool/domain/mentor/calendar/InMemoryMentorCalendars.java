package com.cristi.mentool.mentool.domain.mentor.calendar;

import com.cristi.mentool.mentool.domain.UniqueId;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class InMemoryMentorCalendars implements MentorCalendars {
    private final Set<MentorCalendar> db = new HashSet<>();
    @Override
    public List<UniqueId> findAllTrainingIdsInInterval(LocalDateTime startTime, LocalDateTime endTime) {
        return db.stream()
                .filter(c -> startTime.isBefore(c.getStartTime()) || c.getStartTime().isEqual(startTime))
                .filter(c -> c.getEndTime().isBefore(endTime) || c.getEndTime().isEqual(endTime))
                .map(MentorCalendar::getTrainingId)
                .collect(toList())
                ;
    }

    @Override
    public MentorCalendar add(MentorCalendar calendarEntry) {
        db.add(calendarEntry);
        return calendarEntry;
    }
}
