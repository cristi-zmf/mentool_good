package com.cristi.mentool.mentool.domain.user;

import com.cristi.mentool.mentool.domain.BaseValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

import static java.util.Arrays.asList;

@Embeddable
public class EmailAddress extends BaseValueObject<EmailAddress> {
    @Email @NotBlank @Column(name = "EMAIL")
    private final String value;

    public EmailAddress(String value) {
        super(EmailAddress.class);
        this.value = value;
        validate(this);
    }

    public String getValue() {
        return value;
    }

    /*USED ONLY BY JPA*/
    private EmailAddress() {
        super(EmailAddress.class);
        this.value = null;
    }

    @Override
    protected List<Object> attributesToIncludeInEqualityCheck() {
        return asList(value);
    }
}
