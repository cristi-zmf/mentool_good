package com.cristi.mentool.mentool.exposition.mentor;

import com.cristi.mentool.mentool.domain.RomanianDateTimeFormatter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class MentorSearchRequest {
    @JsonProperty
    private String skillNamePattern;
    @JsonProperty
    private String startDate;
    @JsonProperty
    private String endDate;


    public String getSkillNamePattern() {
        return skillNamePattern;
    }

    public LocalDateTime getStartTime() {
        if (StringUtils.isEmpty(startDate)) {
            return null;
        }
        return LocalDateTime.parse(startDate, RomanianDateTimeFormatter.ROMANIAN_FORMATTER);
    }

    public LocalDateTime getEndTime() {
        if (StringUtils.isEmpty(endDate)) {
            return null;
        }
        return LocalDateTime.parse(endDate, RomanianDateTimeFormatter.ROMANIAN_FORMATTER);
    }
}
