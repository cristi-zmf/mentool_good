package com.cristi.mentool.mentool.domain.mentor;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.user.EmailAddress;
import com.cristi.mentool.mentool.domain.user.PhoneNumber;

import java.math.BigDecimal;

import static java.util.Collections.singleton;

public class ValidMentorGenerator {
    private static final EmailAddress LINUS_EMAIL_ADDRESS = new EmailAddress("linus.coolguy@cool.com");

    private static final MentorTraining training = new MentorTraining(new UniqueId(),
            "Hands-on", new UniqueId(), "Java core", 20, LINUS_EMAIL_ADDRESS,
            new BigDecimal(100)
    );
    public static Mentor LINUS = new Mentor(
            LINUS_EMAIL_ADDRESS, "Linus", "CoolGuy",
            new PhoneNumber("0722123456"), 10,
            "linkedingURL", singleton(training), singleton("GMT+2"), 100
    );
}
