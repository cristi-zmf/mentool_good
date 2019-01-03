package com.cristi.mentool.mentool.domain.training;

import com.cristi.mentool.mentool.domain.BaseEntity;
import com.cristi.mentool.mentool.domain.UniqueId;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity(name = "TRAINING")
@Access(AccessType.FIELD)
@AttributeOverride(name = "id", column = @Column(name = "TRAINING_ID"))
public class Training extends BaseEntity<Training, UniqueId> {
    @NotEmpty
    private String trainingName;

    private Training(UniqueId id) {
        super(Training.class, id);
    }

    public Training(UniqueId id, @NotEmpty String trainingName) {
        this(id);
        this.trainingName = trainingName;
    }

    public String getTrainingName() {
        return trainingName;
    }

    /*Used only for jpa*/
    private Training() {
        super(Training.class, new UniqueId());
    }
}
