package com.cristi.mentool.mentool.domain.user;

import com.cristi.mentool.mentool.domain.BaseEntity;
import com.cristi.mentool.mentool.domain.UniqueId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@NoArgsConstructor
@Getter
public class BaseUser extends BaseEntity<BaseUser, UniqueId> {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private EmailAddress emailAddress;
    @NotNull
    private PhoneNumber phoneNumber;
    private boolean activatedAccount;



    protected BaseUser(UniqueId uniqueId) {
        super(BaseUser.class, uniqueId);
    }


    public BaseUser(
            UniqueId id, @NotBlank String firstName, @NotBlank String lastName,
            @NotNull EmailAddress emailAddress, @NotNull PhoneNumber phoneNumber,
            boolean activatedAccount
    ) {
        super(BaseUser.class, id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.activatedAccount = activatedAccount;
    }

    public BaseUser(
            @NotBlank String firstName, @NotBlank String lastName,
            @NotNull EmailAddress emailAddress, @NotNull PhoneNumber phoneNumber,
            boolean activatedAccount
    ) {
        this(new UniqueId(), firstName, lastName, emailAddress, phoneNumber, activatedAccount);
        validate(this);
    }
///*Only used for JPA*/
//    private BaseUser() {
//        this(new UniqueId());
//        this.firstName = null;
//        this.lastName = null;
//        this.emailAddress = null;
//        this.phoneNumber = null;
//        this.activatedAccount = false;
//    }
}
