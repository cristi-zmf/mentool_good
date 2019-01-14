package com.cristi.mentool.mentool.domain.user;

import com.cristi.mentool.mentool.domain.BaseValueObject;
import com.cristi.mentool.mentool.domain.Role;
import lombok.Getter;

import java.util.List;

import static java.util.Arrays.asList;

@Getter
public class MentorCreationCommand extends BaseValueObject<MentorCreationCommand> {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private Role role;
    private String password;
    private boolean activatedAccount;

    public MentorCreationCommand(
            String firstName, String lastName, String emailAddress, Role role, String password,
            String phoneNumber, boolean activatedAccount
    ) {
        super(MentorCreationCommand.class);
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.activatedAccount = activatedAccount;
    }

    @Override
    protected List<Object> attributesToIncludeInEqualityCheck() {
        return asList(firstName, lastName, emailAddress, phoneNumber, activatedAccount);
    }
}
