package com.cristi.mentool.mentool.infra;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.mentor.*;
import com.cristi.mentool.mentool.domain.mentor.calendar.MentorCalendar;
import com.cristi.mentool.mentool.domain.mentor.calendar.MentorCalendars;
import com.cristi.mentool.mentool.domain.security.AddNewAuthority;
import com.cristi.mentool.mentool.domain.skill.Skill;
import com.cristi.mentool.mentool.domain.skill.Skills;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import static com.cristi.mentool.mentool.domain.RomanianDateTimeFormatter.ROMANIAN_FORMATTER;
import static com.cristi.mentool.mentool.domain.mentor.ValidMentorGenerator.LINUS;

@Component
public class InitialDataSetRunner implements ApplicationRunner {
    private static final LocalDateTime START_TIME = LocalDateTime.parse("13.01.2018 23:43", ROMANIAN_FORMATTER);
    private static final LocalDateTime END_TIME = LocalDateTime.parse("28.01.2018 23:43", ROMANIAN_FORMATTER);

    private final Mentors mentors;
    private final MentorCalendars mentorCalendars;
    private final Skills skills;
    private final AddNewAuthority addNewAuthority;

    public InitialDataSetRunner(Mentors mentors, MentorCalendars mentorCalendars, Skills skills, AddNewAuthority addNewAuthority) {
        this.mentors = mentors;
        this.mentorCalendars = mentorCalendars;
        this.skills = skills;
        this.addNewAuthority = addNewAuthority;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Mentor mentor = LINUS;
        mentors.add(mentor);
        MentorTraining mentorTraining = mentor.getTrainings().stream().findFirst()
                .orElseThrow(NoSuchElementException::new);
        UniqueId skillId = mentorTraining.getSkillId();
        Skill skill = new Skill(skillId, "JAVA");
        skills.add(skill);
        MentorCalendar calendarEntry = new MentorCalendar(new UniqueId(), mentorTraining.getId(), START_TIME, END_TIME);
        mentorCalendars.add(calendarEntry);
        addNewAuthority.addAuthorityFor(mentor, "mentor");
    }
}
