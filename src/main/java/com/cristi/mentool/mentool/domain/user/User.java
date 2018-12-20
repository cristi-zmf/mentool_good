package com.cristi.mentool.mentool.domain.user;

import com.cristi.mentool.mentool.domain.BaseEntity;
import com.cristi.mentool.mentool.domain.UniqueId;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "USER")
public class User extends BaseEntity<User, UniqueId> {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private EmailAddress emailAddres;
    @NotNull
    private PhoneNumber phoneNumber;
    private boolean activatedAccount;
    @NotBlank
    private String passwordHash;


    protected User(Class<User> type, UniqueId uniqueId) {
        super(type, uniqueId);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public EmailAddress getEmailAddres() {
        return emailAddres;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
