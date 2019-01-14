package com.cristi.mentool.mentool.domain.security;

import com.cristi.mentool.mentool.domain.Role;
import com.cristi.mentool.mentool.domain.mentor.Mentor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AddNewAuthority {
    private final Authorities authorities;
    private final BCryptPasswordEncoder bcryptEncoder;

    public AddNewAuthority(Authorities authorities, BCryptPasswordEncoder bcryptEncoder) {
        this.authorities = authorities;
        this.bcryptEncoder = bcryptEncoder;
    }

    public Authority addAuthorityFor(Mentor mentor, String password) {
        String passwordHash = bcryptEncoder.encode(password);
        Authority newAuthority = new Authority(
                mentor.getEmailAddress(), Role.MENTOR, passwordHash, mentor.getId());
        return authorities.add(newAuthority);
    }
}
