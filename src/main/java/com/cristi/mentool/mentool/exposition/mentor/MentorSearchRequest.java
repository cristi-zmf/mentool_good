package com.cristi.mentool.mentool.exposition.mentor;

import com.cristi.mentool.mentool.domain.RomanianDateTimeFormatter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@NoArgsConstructor
public class MentorSearchRequest {
    @JsonProperty
    @NotEmpty
    private String skillNamePattern;
    @JsonProperty
    @NotEmpty
    private String startDate;
    @JsonProperty
    @NotEmpty
    private String endDate;


    public String getSkillNamePattern() {
        return skillNamePattern;
    }

    public LocalDateTime getStartTime() {
        return LocalDateTime.parse(startDate, RomanianDateTimeFormatter.ROMANIAN_FORMATTER);
    }

    public LocalDateTime getEndTime() {
        return LocalDateTime.parse(endDate, RomanianDateTimeFormatter.ROMANIAN_FORMATTER);
    }
}
