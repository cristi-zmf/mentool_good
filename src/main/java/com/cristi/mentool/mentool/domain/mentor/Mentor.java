package com.cristi.mentool.mentool.domain.mentor;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.user.EmailAddress;
import com.cristi.mentool.mentool.domain.user.PhoneNumber;
import com.cristi.mentool.mentool.domain.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Access(AccessType.FIELD)
public class Mentor extends User {
    @Column(name = "YEARS_OF_EXPERIENCE")
    private int yearsOfExperience;

    @NotBlank @Column(name = "LINKEDIN_URL")
    private String linkedInUrl;

    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MENTOR_ID")
    private Set<MentorTraining> trainings;

    @NotEmpty
    @ElementCollection
    @CollectionTable(name = "MENTOR_TIMEZONE", joinColumns = @JoinColumn(name = "MENTOR_ID"))
    @Column(name = "TIMEZONE_ID")
    private Set<String> timezones;

    protected Mentor(UniqueId uniqueId) {
        super(uniqueId);
    }



    public Mentor(
            UniqueId id, @NotBlank String firstName, @NotBlank String lastName, @NotNull EmailAddress emailAddress,
            @NotNull PhoneNumber phoneNumber, boolean activatedAccount, @NotBlank String passwordHash,
            int yearsOfExperience, @NotBlank String linkedInUrl, @NotEmpty Set<MentorTraining> trainings, Set<String> timezones
    ) {
        super(id, firstName, lastName, emailAddress, phoneNumber, activatedAccount, passwordHash);
        this.yearsOfExperience = yearsOfExperience;
        this.linkedInUrl = linkedInUrl;
        this.trainings = new HashSet<>(trainings);
        this.timezones = new HashSet<>(timezones);
    }
}
