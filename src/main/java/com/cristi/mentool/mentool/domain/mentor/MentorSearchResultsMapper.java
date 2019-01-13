package com.cristi.mentool.mentool.domain.mentor;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.skill.Skill;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class MentorSearchResultsMapper {

    public List<MentorSearchResult> map(
            List<MentorTraining> allCriteriaMatchingTrainings, List<Mentor> allMentorsMatchingCriteria, List<Skill> skills
    ) {
        Map<UniqueId, Mentor> mentorMap = allMentorsMatchingCriteria.stream().collect(
                toMap(Mentor::getId, Function.identity())
        );
        Map<UniqueId, Skill> skillMap = skills.stream().collect(toMap(Skill::getId, Function.identity()));
        return allCriteriaMatchingTrainings.stream().map(t -> mapTraining(t, mentorMap, skillMap))
                .collect(toList());
    }

    private MentorSearchResult mapTraining(MentorTraining training, Map<UniqueId, Mentor> mentorMap, Map<UniqueId, Skill> skills) {
        Mentor mentorOfTraining = mentorMap.get(training.getMentorId());
        Skill skill = skills.get(training.getSkillId());
        return new MentorSearchResult(
                mentorOfTraining.getFirstName(), mentorOfTraining.getLastName(), mentorOfTraining.getYearsOfExperience(),
                mentorOfTraining.getNoOfOverallTrainingsDone(), training.getNoOfTrainingsDone(),
                training.getFee(), skill.getSkillName()
        );
    }
}
