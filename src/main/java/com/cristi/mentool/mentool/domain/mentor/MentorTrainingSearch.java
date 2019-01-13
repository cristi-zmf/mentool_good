package com.cristi.mentool.mentool.domain.mentor;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.skill.Skill;
import com.cristi.mentool.mentool.domain.skill.Skills;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@Service
public class MentorTrainingSearch {

    private Skills skills;
    private Mentors mentors;
    private MentorCalendars mentorCalendars;

    public MentorTrainingSearch(Skills skills, Mentors mentors, MentorCalendars mentorCalendars) {
        this.skills = skills;
        this.mentors = mentors;
        this.mentorCalendars = mentorCalendars;
    }

    private MentorSearchResultsMapper mapper = new MentorSearchResultsMapper();
    List<MentorSearchResult> searchForMentors (String trainingPattern, LocalDateTime startTime, LocalDateTime endTime) {
        List<Skill> matchingTrainings = skills.findAllWithPattern(trainingPattern);
        Set<UniqueId> skillIds = matchingTrainings.stream().map(Skill::getId).collect(toSet());
        List<MentorTraining> matchingMentorTrainings = mentors.findAllMentorsTeachingTheSkills(skillIds)
                .stream().flatMap(m -> m.getTrainings().stream())
                .filter(t -> skillIds.contains(t.getSkillId()))
                .collect(toList());
        List<UniqueId> matchingTimeTrainingsIds = mentorCalendars.findAllInInterval(startTime, endTime);
        List<MentorTraining> allCriteriaMatchingTrainings = matchingMentorTrainings.stream()
                .filter(t -> matchingTimeTrainingsIds.contains(t.getId()))
                .distinct()
                .collect(toList());
        List<UniqueId> matchingMentorIds = allCriteriaMatchingTrainings.stream()
                .map(MentorTraining::getMentorId)
                .collect(toList());
        List<Mentor> allMentorsMatchingCriteria = mentors.findAll(matchingMentorIds);
        return mapper.map(allCriteriaMatchingTrainings, allMentorsMatchingCriteria);
    }
}
