package com.cristi.mentool.mentool.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity(name = "AUTHORITY")
@Access(AccessType.FIELD)
@AttributeOverride(name = "id", column = @Column(name = "AUTHORITY_ID"))
public class Authority  extends BaseEntity<Authority, UniqueId>{
    @NotNull
    @Column(name = "PERSON_ID")
    private String personId;

    @NotBlank
    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotBlank
    @Column(name = "PASSWORD_HASH")
    private String passwordHash;

    public Authority(@NotNull UniqueId personId, @NotBlank Role role, @NotBlank String passwordHash) {
        super(Authority.class, new UniqueId());
        this.personId = personId.getValue();
        this.role = role;
        this.passwordHash = passwordHash;
        validate(this);
    }


    public Authority(@NotNull UniqueId id, @NotNull UniqueId personId, @NotBlank Role role, @NotBlank String passwordHash) {
        super(Authority.class, id);
        this.personId = personId.getValue();
        this.role = role;
        this.passwordHash = passwordHash;
        validate(this);
    }

    /*Used by jpa*/
    private Authority() {
        super(Authority.class, new UniqueId());
    }
}
