package com.cristi.mentool.mentool.domain.user;

import com.cristi.mentool.mentool.domain.UniqueId;

import java.util.Set;

public interface Users {
    User add(User user);
    Set<User> findAll();
    User getOrThrow(UniqueId userId);
}
