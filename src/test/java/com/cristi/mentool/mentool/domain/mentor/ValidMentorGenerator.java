package com.cristi.mentool.mentool.domain.mentor;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.training.Training;
import com.cristi.mentool.mentool.domain.user.EmailAddress;
import com.cristi.mentool.mentool.domain.user.PhoneNumber;

import static java.util.Collections.singleton;

public class ValidMentorGenerator {
    private static final UniqueId UNIQUE_ID = new UniqueId();

    public static Mentor LINUS = new Mentor(
            UNIQUE_ID, "Linus", "CoolGuy", new EmailAddress("linus.coolguy@cool.com"),
            new PhoneNumber("0722577943"), true, 10,
            "linkedingURL", singleton(new MentorTraining(new UniqueId(), singleton("courses"),
            new Training(new UniqueId(), "JAVA"))), singleton("GMT+2")
    );
}
