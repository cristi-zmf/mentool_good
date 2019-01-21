package com.cristi.mentool.mentool.infra.persistence.user;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.user.EmailAddress;
import com.cristi.mentool.mentool.domain.user.PhoneNumber;
import com.cristi.mentool.mentool.domain.user.User;

public class ValidUserGenerator {
    public static User gigiUser() {
        return new User(
                new UniqueId(), "Cristi", "Gigi", new EmailAddress("cristi.gigi@test.com"),
                new PhoneNumber("0711456867"), true
        );
    }
}