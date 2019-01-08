package com.cristi.mentool.mentool.domain.user;

import com.cristi.mentool.mentool.domain.BaseEntity;
import com.cristi.mentool.mentool.domain.UniqueId;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class User extends BaseEntity<User, UniqueId> {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private EmailAddress emailAddress;
    @NotNull
    private PhoneNumber phoneNumber;
    private boolean activatedAccount;



    protected User(UniqueId uniqueId) {
        super(User.class, uniqueId);
    }


    protected User(
            Class<User> type, UniqueId id, @NotBlank String firstName, @NotBlank String lastName,
            @NotNull EmailAddress emailAddress, @NotNull PhoneNumber phoneNumber,
            boolean activatedAccount
    ) {
        super(type, id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.activatedAccount = activatedAccount;
    }

    public User(
            UniqueId id, @NotBlank String firstName, @NotBlank String lastName,
            @NotNull EmailAddress emailAddress, @NotNull PhoneNumber phoneNumber,
            boolean activatedAccount
    ) {
        this(User.class, id, firstName, lastName, emailAddress, phoneNumber, activatedAccount);
        validate(this);
    }

    public User(
            @NotBlank String firstName, @NotBlank String lastName,
            @NotNull EmailAddress emailAddress, @NotNull PhoneNumber phoneNumber,
            boolean activatedAccount
    ) {
        this(User.class, new UniqueId(), firstName, lastName, emailAddress, phoneNumber, activatedAccount);
        validate(this);
    }
/*Only used for JPA*/
    private User() {
        this(new UniqueId());
        this.firstName = null;
        this.lastName = null;
        this.emailAddress = null;
        this.phoneNumber = null;
        this.activatedAccount = false;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
