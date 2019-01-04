package com.cristi.mentool.mentool.infra.persistence.mentor;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.mentor.Mentor;
import com.cristi.mentool.mentool.domain.mentor.MentorTraining;
import com.cristi.mentool.mentool.domain.training.Training;
import com.cristi.mentool.mentool.domain.user.EmailAddress;
import com.cristi.mentool.mentool.domain.user.PhoneNumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static java.util.Collections.singleton;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class SdjMentorsLocalIT {

    private static final UniqueId UNIQUE_ID = new UniqueId();
    private static final UniqueId MENTOR_TRAINING_ID = new UniqueId();
    @Autowired
    private MentorsSdj sdj;

    @Autowired
    private SdjMentors sut;


    @Test
    public void should_save_correctly_a_mentor() {
        Mentor aMentor = new Mentor(
                UNIQUE_ID, "Linus", "CoolGuy", new EmailAddress("linus.coolguy@cool.com"),
                new PhoneNumber("0722577943"), true, "someHash", 10,
                "linkedingURL", singleton(new MentorTraining(MENTOR_TRAINING_ID, singleton("courses"),
                new Training(new UniqueId(), "JAVA"))), singleton("GMT+2")
        );
        sut.add(aMentor);
        Mentor savedMentor = sdj.getOne(aMentor.getId());
        assertThat(savedMentor).isEqualToComparingFieldByFieldRecursively(aMentor);
    }

    @Test
    public void should_get_correctly_a_mentor() {
        Mentor aMentor = new Mentor(
                UNIQUE_ID, "Linus", "CoolGuy", new EmailAddress("linus.coolguy@cool.com"),
                new PhoneNumber("0722577943"), true, "someHash", 10,
                "linkedingURL", singleton(new MentorTraining(MENTOR_TRAINING_ID, singleton("courses"),
                new Training(new UniqueId(), "JAVA"))), singleton("GMT+2")
        );
        sdj.saveAndFlush(aMentor);
        Mentor dbMentor = sut.getOrThrow(aMentor.getId());
        assertThat(dbMentor).isEqualToComparingFieldByFieldRecursively(aMentor);
    }

}