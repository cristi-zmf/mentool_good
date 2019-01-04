package com.cristi.mentool.mentool.domain.user;

import com.cristi.mentool.mentool.domain.BaseValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

import static java.util.Arrays.asList;

@Embeddable
public class PhoneNumber extends BaseValueObject<PhoneNumber> {
    @NotBlank @Pattern(regexp="(^$|[0-9]{10})") @Column(name = "PHONE_NUMBER")
    private final String value;

    public PhoneNumber(String value) {
        super(PhoneNumber.class);
        this.value = value;
        validate(this);
    }

    private PhoneNumber() {
        super(PhoneNumber.class);
        this.value = null;
    }

    @Override
    protected List<Object> attributesToIncludeInEqualityCheck() {
        return asList(value);
    }
}
