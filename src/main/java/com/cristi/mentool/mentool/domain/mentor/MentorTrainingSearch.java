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
        List<MentorTraining> matchingMentorTrainings = findAllTrainingsTeachingTheSkills(skillIds);
        List<UniqueId> matchingTimeTrainingsIds = mentorCalendars.findAllInInterval(startTime, endTime);
        List<MentorTraining> allCriteriaMatchingTrainings = filterTrainingsBasedOnTrainingIds(
                matchingMentorTrainings, matchingTimeTrainingsIds
        );
        List<UniqueId> matchingMentorIds = findMentorIdsByMentorTrainings(allCriteriaMatchingTrainings);
        List<Mentor> allMentorsMatchingCriteria = mentors.findAll(matchingMentorIds);
        return mapper.map(allCriteriaMatchingTrainings, allMentorsMatchingCriteria);
    }

    private List<UniqueId> findMentorIdsByMentorTrainings(List<MentorTraining> mentorTrainings) {
        return mentorTrainings.stream()
                .map(MentorTraining::getMentorId)
                .collect(toList());
    }

    private List<MentorTraining> filterTrainingsBasedOnTrainingIds(
            List<MentorTraining> matchingMentorTrainings, List<UniqueId> matchingTimeTrainingsIds
    ) {
        return matchingMentorTrainings.stream()
                .filter(t -> matchingTimeTrainingsIds.contains(t.getId()))
                .distinct()
                .collect(toList());
    }

    private List<MentorTraining> findAllTrainingsTeachingTheSkills(Set<UniqueId> skillIds) {
        return mentors.findAllMentorsTeachingTheSkills(skillIds)
                .stream().flatMap(m -> m.getTrainings().stream())
                .filter(t -> skillIds.contains(t.getSkillId()))
                .collect(toList());
    }
}
