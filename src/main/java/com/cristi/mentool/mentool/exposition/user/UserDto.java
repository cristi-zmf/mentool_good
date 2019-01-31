package com.cristi.mentool.mentool.exposition.user;

import com.cristi.mentool.mentool.domain.user.EmailAddress;
import com.cristi.mentool.mentool.domain.user.PhoneNumber;
import com.cristi.mentool.mentool.domain.user.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserDto {
    @NotNull
    public String username;
    @NotBlank
    public String firstName;
    @NotBlank
    public String lastName;
    @NotNull
    public String phoneNumber;

    public User toUser() {
        return new User(new EmailAddress(username), firstName, lastName, new PhoneNumber(phoneNumber));
    }
}
