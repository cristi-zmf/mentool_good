package com.cristi.mentool.mentool.domain.security;

import com.cristi.mentool.mentool.domain.BaseEntity;
import com.cristi.mentool.mentool.domain.Role;
import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.user.EmailAddress;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

import static java.util.Collections.singleton;


@Entity(name = "AUTHORITY")
@Access(AccessType.FIELD)
@AttributeOverride(name = "id", column = @Column(name = "AUTHORITY_ID"))
public class Authority  extends BaseEntity<Authority, UniqueId> implements UserDetails {
    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "PERSON_ID"))
    private UniqueId personId;

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "USERNAME"))
    private EmailAddress username;

    @NotNull
    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotBlank
    @Column(name = "PASSWORD_HASH")
    private String passwordHash;

    @Column(name = "ACCOUNT_LOCKED")
    private boolean accountNonLocked;

    @Column(name = "ACCOUNT_EXPIRED")
    private boolean accountNonExpired;

    @Column(name = "CREDENTIAL_EXPIRED")
    private boolean credentialNonExpired;

    @Column(name = "ENABLED")
    private boolean enabled;



    public Authority(EmailAddress username, @NotNull Role role, @NotBlank String passwordHash, @NotNull UniqueId personId) {
        this(new UniqueId(), personId, role, passwordHash, username);
    }


    public Authority(
            @NotNull UniqueId id, @NotNull UniqueId personId, @NotNull Role role,
            @NotBlank String passwordHash, EmailAddress username
    ) {
        super(Authority.class, id);
        this.personId = personId;
        this.role = role;
        this.passwordHash = passwordHash;
        this.username = username;
        this.accountNonLocked = true;
        this.accountNonExpired = true;
        this.credentialNonExpired = true;
        this.enabled = true;
        validate(this);
    }

    /*Used by jpa*/
    private Authority() {
        super(Authority.class, new UniqueId());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return singleton(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return username.getValue();
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Role getRole() {
        return role;
    }
}
