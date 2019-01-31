package com.cristi.mentool.mentool.domain.user;

import org.springframework.stereotype.Service;

@Service
public class RegisterUser {
    private final Users users;

    public RegisterUser(Users users) {
        this.users = users;
    }
    public User registerUser(User newUser) {
        return users.add(newUser);
    }
}
