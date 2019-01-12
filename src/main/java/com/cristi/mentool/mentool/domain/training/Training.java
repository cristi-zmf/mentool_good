package com.cristi.mentool.mentool.domain.training;

import com.cristi.mentool.mentool.domain.BaseEntity;
import com.cristi.mentool.mentool.domain.UniqueId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Entity(name = "TRAINING")
@Access(AccessType.FIELD)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Training extends BaseEntity<Training, UniqueId> {
    @NotEmpty
    @Column(name = "TRAINING_NAME")
    private String trainingName;

    @NotEmpty
    @Column(name = "TRAINING_NAME")
    @ElementCollection
    @CollectionTable(name = "PREREQUISITES")
    private Set<String> prerequisites;

    public Training(UniqueId id, @NotEmpty String trainingName, @NotEmpty Set<String> prerequisites) {
        super(Training.class, id);
        this.trainingName = trainingName;
        this.prerequisites = prerequisites;
    }

    public String getTrainingName() {
        return trainingName;
    }
}
