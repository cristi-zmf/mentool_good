package com.cristi.mentool.mentool.infra.persistence.mentor;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.mentor.calendar.MentorCalendar;
import com.cristi.mentool.mentool.domain.mentor.calendar.MentorCalendars;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Repository
public class SdjMentorCalendars implements MentorCalendars {
    private final MentorCalendarsSdj sdj;

    public SdjMentorCalendars(MentorCalendarsSdj sdj) {
        this.sdj = sdj;
    }

    @Override
    public List<UniqueId> findAllTrainingIdsInInterval(LocalDateTime startTime, LocalDateTime endTime) {
        if (startTime == null) {
            startTime = LocalDateTime.MAX;
        }
        if (endTime == null) {
            endTime = LocalDateTime.MIN;
        }
        return sdj.findByStartTimeAndEndTime(startTime, endTime).stream()
                .map(MentorCalendar::getTrainingId)
                .collect(toList());
    }

    @Override
    public MentorCalendar add(MentorCalendar calendarEntry) {
        return sdj.saveAndFlush(calendarEntry);
    }
}
