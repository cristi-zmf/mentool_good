package com.cristi.mentool.mentool.domain.mentor;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.user.EmailAddress;
import com.cristi.mentool.mentool.domain.user.PhoneNumber;

import java.math.BigDecimal;

import static java.util.Collections.singleton;

public class ValidMentorGenerator {
    private static final UniqueId UNIQUE_ID = new UniqueId();

    private static final MentorTraining training = new MentorTraining(new UniqueId(),
            "Hands-on", new UniqueId(), "Java core", 20, UNIQUE_ID,
            new BigDecimal(100)
    );
    public static Mentor LINUS = new Mentor(
            UNIQUE_ID, "Linus", "CoolGuy", new EmailAddress("linus.coolguy@cool.com"),
            new PhoneNumber("0722577943"), true, 10,
            "linkedingURL", singleton(training), singleton("GMT+2"), 100
    );
}
