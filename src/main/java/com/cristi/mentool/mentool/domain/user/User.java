package com.cristi.mentool.mentool.domain.user;

import com.cristi.mentool.mentool.domain.UniqueId;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
public class User extends BaseUser {
    public User(
            UniqueId id, @NotBlank String firstName, @NotBlank String lastName, @NotNull EmailAddress emailAddress,
            @NotNull PhoneNumber phoneNumber, boolean activatedAccount
    ) {
        super(id, firstName, lastName, emailAddress, phoneNumber, activatedAccount);
        validate(this);
    }

    public static User createUserWithIdFromDtoUser(User dtoUserFromFrontend) {
        return new User(
                new UniqueId(), dtoUserFromFrontend.getFirstName(), dtoUserFromFrontend.getLastName(),
                dtoUserFromFrontend.getEmailAddress(), dtoUserFromFrontend.getPhoneNumber(), false
        );
    }


}
