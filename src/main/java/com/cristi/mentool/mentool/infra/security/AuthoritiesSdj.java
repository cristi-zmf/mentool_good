package com.cristi.mentool.mentool.infra.security;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.security.Authority;
import com.cristi.mentool.mentool.domain.user.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesSdj extends JpaRepository<Authority, UniqueId> {
    Authority findByUsername(EmailAddress username);
}
