package com.cristi.mentool.mentool.domain.mentor;

import com.cristi.mentool.mentool.domain.user.BaseUser;
import com.cristi.mentool.mentool.domain.user.EmailAddress;
import com.cristi.mentool.mentool.domain.user.PhoneNumber;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Access(AccessType.FIELD)
@AttributeOverride(name = "id", column = @Column(name = "MENTOR_ID"))
@NoArgsConstructor(access = PRIVATE)
@Getter
public class Mentor extends BaseUser {
    @Column(name = "YEARS_OF_EXPERIENCE")
    private int yearsOfExperience;

    @NotBlank @Column(name = "LINKEDIN_URL")
    private String linkedInUrl;

    @NotEmpty
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "MENTOR_ID")
    private Set<MentorTraining> trainings;

    private int noOfOverallTrainingsDone;


    public Mentor(
            @NotNull EmailAddress username, @NotBlank String firstName, @NotBlank String lastName,
            @NotNull PhoneNumber phoneNumber,
            int yearsOfExperience, @NotBlank String linkedInUrl, @NotEmpty Set<MentorTraining> trainings,
            int noOfOverallTrainingsDone
    ) {
        super(username, firstName, lastName, phoneNumber);
        this.yearsOfExperience = yearsOfExperience;
        this.linkedInUrl = linkedInUrl;
        this.trainings = new HashSet<>(trainings);
        this.noOfOverallTrainingsDone = noOfOverallTrainingsDone;
        validate(this);
    }

    public Set<MentorTraining> getTrainings() {
        return new HashSet<>(trainings);
    }
}
