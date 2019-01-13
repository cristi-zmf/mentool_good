package com.cristi.mentool.mentool.domain.mentor;

import com.cristi.mentool.mentool.domain.BaseValueObject;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;

public class MentorSearchResult extends BaseValueObject<MentorSearchResult> {
    @NotNull
    private final String firstName;
    @NotNull
    private final String lastName;
    private final int yearsOfExperience;
    private final int noOfOverallTrainingsDone;
    private final int noOfTrainingsForTechnologyDone;
    @NotNull
    private final BigDecimal fee;

    public MentorSearchResult(
            String firstName, String lastName, int yearsOfExperience, int noOfOverallTrainingsDone,
            int noOfTrainingsForTechnologyDone, BigDecimal fee
    ) {
        super(MentorSearchResult.class);
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearsOfExperience = yearsOfExperience;
        this.noOfOverallTrainingsDone = noOfOverallTrainingsDone;
        this.noOfTrainingsForTechnologyDone = noOfTrainingsForTechnologyDone;
        this.fee = fee;
        validate(this);
    }

    @Override
    protected List<Object> attributesToIncludeInEqualityCheck() {
        return asList(firstName, lastName, yearsOfExperience, noOfOverallTrainingsDone, noOfTrainingsForTechnologyDone, fee);
    }
}
