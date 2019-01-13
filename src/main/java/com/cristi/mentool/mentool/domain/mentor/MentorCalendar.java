package com.cristi.mentool.mentool.domain.mentor;


import com.cristi.mentool.mentool.domain.BaseEntity;
import com.cristi.mentool.mentool.domain.UniqueId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity(name = "MENTOR_CALENDAR")
@Getter
public class MentorCalendar extends BaseEntity<MentorCalendar, UniqueId> {
    @NotNull
    @AttributeOverride(name = "value", column = @Column(name = "TRAINING_ID"))
    private UniqueId trainingId;

    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;

    public MentorCalendar(@NotNull UniqueId id, UniqueId trainingId, @NotNull LocalDateTime startTime, @NotNull LocalDateTime endTime) {
        super(MentorCalendar.class, id);
        this.trainingId = trainingId;
        this.startTime = startTime;
        this.endTime = endTime;
        validate(this);
    }

    private MentorCalendar() {
        super(MentorCalendar.class, new UniqueId());
    }
}
