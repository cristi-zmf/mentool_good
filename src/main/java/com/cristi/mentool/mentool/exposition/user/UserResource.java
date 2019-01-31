package com.cristi.mentool.mentool.exposition.user;

import com.cristi.mentool.mentool.domain.user.EmailAddress;
import com.cristi.mentool.mentool.domain.user.RegisterUser;
import com.cristi.mentool.mentool.exposition.MentoolRequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@MentoolRequestMapping
public class UserResource {

    private final RegisterUser registerUser;

    public UserResource(RegisterUser registerUser) {
        this.registerUser = registerUser;
    }
    @PostMapping(value = "/users")
    public EmailAddress registerUser(@Valid UserDto newUser) {
        return registerUser.registerUser(newUser.toUser()).getId();
    }
}
