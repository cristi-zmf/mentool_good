package com.cristi.mentool.mentool.infra.security;

import com.cristi.mentool.mentool.domain.security.Authorities;
import com.cristi.mentool.mentool.domain.security.Authority;
import com.cristi.mentool.mentool.domain.user.EmailAddress;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository(value = "userService")
@Primary
public class SdjAuthorities implements Authorities {
    private final AuthoritiesSdj sdj;


    public SdjAuthorities(AuthoritiesSdj sdj) {
        this.sdj = sdj;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return sdj.findByUsername(new EmailAddress(username));
    }

    @Override
    public Authority add(Authority authority) {
        return sdj.saveAndFlush(authority);
    }
}
