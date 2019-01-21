package com.cristi.mentool.mentool.infra.persistence.user;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.user.User;
import com.cristi.mentool.mentool.domain.user.Users;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class SdjUsers implements Users {
    private final UsersSdj sdj;

    public SdjUsers(UsersSdj sdj) {
        this.sdj = sdj;
    }

    @Override
    public User add(User user) {
        return sdj.saveAndFlush(user);
    }

    @Override
    public Set<User> findAll() {
        return new HashSet<>(sdj.findAll());
    }

    @Override
    public User getOrThrow(UniqueId userId) {
        return sdj.getOne(userId);
    }
}
