package com.cristi.mentool.mentool.domain.mentor;

import com.cristi.mentool.mentool.domain.BaseEntity;
import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.user.EmailAddress;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Access(AccessType.FIELD)
@Getter
@Entity
public class MentorTraining extends BaseEntity<MentorTraining, UniqueId> {
    @NotEmpty
    @Column(name = "FACILITIES")
    private String facilitiesDesc;

    @NotNull
    @AttributeOverride(name = "value", column = @Column(name = "SKILL_ID"))
    private UniqueId skillId;

    @NotEmpty
    @Column(name = "TRAINING_PREREQUISITE")
    private String prerequisitesDesc;

    private int noOfTrainingsDone;

    @NotNull
    @AttributeOverride(name = "value", column = @Column(name = "MENTOR_ID"))
    private EmailAddress mentorId;

    @NotNull
    private BigDecimal fee;

    public MentorTraining(
            UniqueId id, @NotEmpty String facilitiesDesc, UniqueId skillId, String prerequisitesDesc,
            int noOfTrainingsDone, EmailAddress mentorId, BigDecimal fee
    ) {
        super(MentorTraining.class, id);
        this.facilitiesDesc = facilitiesDesc;
        this.skillId = skillId;
        this.prerequisitesDesc = prerequisitesDesc;
        this.noOfTrainingsDone = noOfTrainingsDone;
        this.mentorId = mentorId;
        this.fee = fee;
        validate(this);
    }

    /*Used by JPA*/
    private MentorTraining() {
        super(MentorTraining.class, new UniqueId());
        prerequisitesDesc = null;
        skillId = null;
        facilitiesDesc = null;
    }
}
