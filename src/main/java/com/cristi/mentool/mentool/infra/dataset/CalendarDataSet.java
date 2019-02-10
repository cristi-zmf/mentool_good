package com.cristi.mentool.mentool.infra.dataset;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.mentor.MentorTraining;
import com.cristi.mentool.mentool.domain.mentor.calendar.MentorCalendar;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CalendarDataSet {
    private final static LocalDateTime START_TIME = LocalDateTime.parse("2018-10-10T00:00");
    private final static LocalDateTime END_TIME = LocalDateTime.parse("2018-12-15T00:00");
    private final static long LOWER_BOUND = 1L;
    private final static long UPPER_BOUND = 20L;
    public static List<MentorCalendar> generateMentorCalendarForTrainings(Set<MentorTraining> trainings) {
        List<MentorCalendar> program = new ArrayList<>();
        for (MentorTraining training : trainings) {
            LocalDateTime startTime = START_TIME.minusDays(generateRandomLong());
            LocalDateTime endTime = END_TIME.plusDays(generateRandomLong());
            MentorCalendar trainingProgram = new MentorCalendar(new UniqueId(), training.getId(), startTime, endTime);
            program.add(trainingProgram);
        }
        return program;
    }

    private static long generateRandomLong() {
        return LOWER_BOUND + (long) (Math.random() * (UPPER_BOUND - LOWER_BOUND));
    }
}
