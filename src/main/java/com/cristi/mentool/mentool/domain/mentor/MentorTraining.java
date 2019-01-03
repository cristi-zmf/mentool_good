package com.cristi.mentool.mentool.domain.mentor;

import com.cristi.mentool.mentool.domain.BaseEntity;
import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.training.Training;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "MENTOR_TRAINING")
@AttributeOverride(name = "id", column = @Column(name = "MENTOR_TRAINING_ID"))
@Access(AccessType.FIELD)
public class MentorTraining extends BaseEntity<MentorTraining, UniqueId> {
    @NotEmpty
    @ElementCollection
    @CollectionTable(name = "MENTOR_FACILITY", joinColumns = @JoinColumn(name = "MENTOR_TRAINING_ID"))
    @Column(name = "FACILITY")
    private Set<String> facilities;

    @OneToOne(cascade = CascadeType.ALL, fetch = LAZY, optional = false)
    @JoinColumn(name = "TRAINING_ID")
    private Training training;


    private MentorTraining(UniqueId id) {
        super(MentorTraining.class, id);
    }

    public MentorTraining(UniqueId id, @NotEmpty Set<String> facilities, Training training) {
        this(id);
        this.facilities = facilities;
        this.training = training;
    }

    /*Used only by JPA*/
    private MentorTraining() {
        this(new UniqueId());
    }
}
