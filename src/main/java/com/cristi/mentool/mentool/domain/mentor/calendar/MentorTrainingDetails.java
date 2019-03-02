package com.cristi.mentool.mentool.domain.mentor.calendar;


import com.cristi.mentool.mentool.domain.BaseValueObject;
import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.mentor.Mentor;
import com.cristi.mentool.mentool.domain.mentor.MentorTraining;
import com.cristi.mentool.mentool.domain.user.EmailAddress;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

public class MentorTrainingDetails extends BaseValueObject<MentorTrainingDetails> {
    @NotNull
    @JsonProperty
    private UniqueId trainingId;

    @NotEmpty
    @JsonProperty
    private String facilitiesDesc;

    @NotEmpty
    @JsonProperty
    private String prerequisitesDesc;

    @NotNull
    @JsonProperty
    private EmailAddress emailAddress;

    @JsonProperty
    private int noOfTrainingsDone;

    @NotEmpty
    @JsonProperty
    private String mentorName;

    @NotNull
    @JsonProperty
    private BigDecimal fee;

    @NotNull
    @JsonProperty
    private LocalDateTime startDate;
    @NotNull
    @JsonProperty
    private LocalDateTime endDate;

    private MentorTrainingDetails() {
        super(MentorTrainingDetails.class);
    }

    public MentorTrainingDetails(
            UniqueId trainingId, @NotEmpty String facilitiesDesc, @NotEmpty String prerequisitesDesc, @NotNull EmailAddress emailAddress,
            int noOfTrainingsDone, @NotEmpty String mentorName, @NotNull BigDecimal fee,
            LocalDateTime startDate, LocalDateTime endDate) {
        this();
        this.trainingId = trainingId;
        this.facilitiesDesc = facilitiesDesc;
        this.prerequisitesDesc = prerequisitesDesc;
        this.emailAddress = emailAddress;
        this.noOfTrainingsDone = noOfTrainingsDone;
        this.mentorName = mentorName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.fee = fee;
    }

    public MentorTrainingDetails(Mentor mentorOfTraining, MentorTraining training, MentorCalendar trainingCalendar) {
        this(
                training.getId(), training.getFacilitiesDesc(), training.getPrerequisitesDesc(), mentorOfTraining.getId(),
                training.getNoOfTrainingsDone(), mentorOfTraining.getFullName(), training.getFee(),
                trainingCalendar.getStartTime(), trainingCalendar.getEndTime()
        );
    }

    @Override
    protected List<Object> attributesToIncludeInEqualityCheck() {
        return asList(facilitiesDesc, prerequisitesDesc, emailAddress, mentorName, fee);
    }
}
