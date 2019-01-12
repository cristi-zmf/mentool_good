package com.cristi.mentool.mentool.domain.mentor;

import com.cristi.mentool.mentool.domain.BaseEntity;
import com.cristi.mentool.mentool.domain.UniqueId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@Entity(name = "MENTOR_TRAINING")
@Access(AccessType.FIELD)
@NoArgsConstructor(access = PRIVATE)
public class MentorTraining extends BaseEntity<MentorTraining, UniqueId> {
    @NotEmpty
    @ElementCollection
    @CollectionTable(name = "MENTOR_TRAINING_FACILITY")
    @Column(name = "FACILITY")
    private Set<String> facilities;

    @NotNull
    @AttributeOverride(name = "value", column = @Column(name = "TRAINING_ID"))
    private UniqueId trainingId;

    @AttributeOverride(name = "value", column = @Column(name = "MENTOR_ID"))
    private UniqueId mentorId;


    private MentorTraining(UniqueId id) {
        super(MentorTraining.class, id);
    }

    public MentorTraining(UniqueId id, @NotEmpty Set<String> facilities, UniqueId trainingId) {
        this(id);
        this.facilities = facilities;
        this.trainingId = trainingId;
        validate(this);
    }

}
