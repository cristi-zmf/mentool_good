package com.cristi.mentool.mentool.exposition.authentication;

import com.cristi.mentool.mentool.domain.Role;
import com.cristi.mentool.mentool.domain.security.Authority;
import com.fasterxml.jackson.annotation.JsonProperty;


public class AuthentifiedUserDto {
    @JsonProperty
    private String token;
    @JsonProperty
    private String username;
    @JsonProperty
    private Role role;


    public AuthentifiedUserDto(String token) {
        this.token = token;
    }
    public AuthentifiedUserDto(Authority authority, String token) {
        this.token = token;
        this.username = authority.getUsername();
        this.role = authority.getRole();
    }
}
