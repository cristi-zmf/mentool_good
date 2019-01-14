package com.cristi.mentool.mentool.exposition.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthToken {
    @JsonProperty
    private String token;

    public AuthToken(String token) {
        this.token = token;
    }
}
