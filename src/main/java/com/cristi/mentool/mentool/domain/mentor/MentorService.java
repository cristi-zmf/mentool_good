package com.cristi.mentool.mentool.domain.mentor;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.user.EmailAddress;
import com.cristi.mentool.mentool.exposition.mentor.MentorEditCommand;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.lang.String.format;

@Service
public class MentorService {
    private final Mentors mentors;

    public MentorService(Mentors mentors) {
        this.mentors = mentors;
    }

    public Mentor registerMentor(MentorEditCommand registrationCommand) {
        Mentor newMentor = registrationCommand.toNewMentor();
        if (mentors.exists(newMentor.getId())) {
            throw new IllegalStateException(format("Mentor with address <%s> already exists", newMentor.getId()));
        }
        return mentors.add(newMentor);
    }

    public Mentor updateMentor(MentorEditCommand editCommand) {
        Mentor newMentor = editCommand.toNewMentor();
        return mentors.add(newMentor);
    }

    public Mentor registerTraining(MentorTraining training) {
        Mentor mentorTeachingTraining = mentors.getOrThrow(training.getMentorId());
        mentorTeachingTraining.addTraining(training);
        return mentors.add(mentorTeachingTraining);
    }

    public Mentor removeTrainings(EmailAddress address, Set<UniqueId> trainingIds) {
        Mentor mentorToRemoveTrainingFrom = mentors.getOrThrow(address);
        mentorToRemoveTrainingFrom.removeTrainings(trainingIds);
        return mentors.add(mentorToRemoveTrainingFrom);
    }
}
