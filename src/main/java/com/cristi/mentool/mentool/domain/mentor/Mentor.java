package com.cristi.mentool.mentool.domain.mentor;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.user.EmailAddress;
import com.cristi.mentool.mentool.domain.user.PhoneNumber;
import com.cristi.mentool.mentool.domain.user.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "MENTOR")
@Access(AccessType.FIELD)
@AttributeOverride(name = "id", column = @Column(name = "MENTOR_ID"))
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Mentor extends User {
    @Column(name = "YEARS_OF_EXPERIENCE")
    private int yearsOfExperience;

    @NotBlank @Column(name = "LINKEDIN_URL")
    private String linkedInUrl;

    @NotEmpty
    @ElementCollection
    @CollectionTable(name = "MENTOR_TRAININGS")
    private Set<UniqueId> trainings;

    @NotEmpty
    @ElementCollection
    @CollectionTable(name = "MENTOR_TIMEZONE")
    @Column(name = "TIMEZONE_ID")
    private Set<String> timezones;


    public Mentor(
            UniqueId id, @NotBlank String firstName, @NotBlank String lastName, @NotNull EmailAddress emailAddress,
            @NotNull PhoneNumber phoneNumber, boolean activatedAccount,
            int yearsOfExperience, @NotBlank String linkedInUrl, @NotEmpty Set<UniqueId> trainings, Set<String> timezones
    ) {
        super(User.class, id, firstName, lastName, emailAddress, phoneNumber, activatedAccount);
        this.yearsOfExperience = yearsOfExperience;
        this.linkedInUrl = linkedInUrl;
        this.trainings = new HashSet<>(trainings);
        this.timezones = new HashSet<>(timezones);
        validate(this);
    }
}
