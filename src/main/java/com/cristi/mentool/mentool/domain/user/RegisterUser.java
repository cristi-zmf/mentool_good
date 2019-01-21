package com.cristi.mentool.mentool.domain.user;

import com.cristi.mentool.mentool.domain.security.Authorities;
import com.cristi.mentool.mentool.domain.security.Authority;
import com.cristi.mentool.mentool.exposition.user.UserRegistrationCommand;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.cristi.mentool.mentool.domain.Role.USER;

@Service
public class RegisterUser {
    private final Users users;
    private final Authorities authorities;
    private final BCryptPasswordEncoder encoder;

    public RegisterUser(Users users, Authorities authorities, BCryptPasswordEncoder encoder) {
        this.users = users;
        this.authorities = authorities;
        this.encoder = encoder;
    }
    public User registerUser(UserRegistrationCommand registrationCommand) {
        User newUser = User.createUserWithIdFromDtoUser(registrationCommand.newUser);
        String passwordHash = encoder.encode(registrationCommand.password);
        Authority newAuthority = new Authority(newUser.getEmailAddress(), USER, passwordHash, newUser.getId());
        authorities.add(newAuthority);
        return users.add(newUser);
    }
}
