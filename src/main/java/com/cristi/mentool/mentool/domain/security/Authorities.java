package com.cristi.mentool.mentool.domain.security;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface Authorities extends UserDetailsService {
    Authority add(Authority authority);
}
