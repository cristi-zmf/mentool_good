package com.cristi.mentool.mentool.infra.persistence.user;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.security.Authority;
import com.cristi.mentool.mentool.domain.user.EmailAddress;
import com.cristi.mentool.mentool.domain.user.PhoneNumber;
import com.cristi.mentool.mentool.domain.user.RegisterUser;
import com.cristi.mentool.mentool.domain.user.User;
import com.cristi.mentool.mentool.exposition.user.UserRegistrationCommand;
import com.cristi.mentool.mentool.infra.security.AuthoritiesSdj;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.cristi.mentool.mentool.domain.Role.USER;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterUserLocalIT {
    @Autowired private RegisterUser sut;
    @Autowired private AuthoritiesSdj authoritiesSdj;
    @Autowired private UsersSdj usersSdj;
    @Autowired private BCryptPasswordEncoder encoder;
    private User gigiUser;

    @Before
    public void setup() {
        gigiUser = getGigiUser();
        usersSdj.deleteAll();
        authoritiesSdj.deleteAll();
    }


    @Test
    public void registerUser() {
        UserRegistrationCommand command = new UserRegistrationCommand(gigiUser, "password");
        sut.registerUser(command);
        List<User> foundUsers = usersSdj.findAll();
        assertThat(foundUsers).hasSize(1);
        List<Authority> foundAuthorities = authoritiesSdj.findAll();
        User actualUser = foundUsers.get(0);
        User expectedUser =new User(
            actualUser.getId(), actualUser.getFirstName(), actualUser.getLastName(), actualUser.getEmailAddress(), actualUser.getPhoneNumber(), false
        );
        Authority expectedAuthority = new Authority(
                gigiUser.getEmailAddress(), USER, encoder.encode(command.password), expectedUser.getId()
        );
        assertThat(actualUser).isEqualToComparingFieldByFieldRecursively(expectedUser);
        assertThat(foundAuthorities).hasSize(1);
        Authority actualAuthority = foundAuthorities.get(0);
        assertThat(actualAuthority).isEqualToIgnoringGivenFields(expectedAuthority, "id", "passwordHash");
        assertThat(
                encoder.matches(command.password, actualAuthority.getPassword())
        ).isTrue();
    }
    private User getGigiUser() {
        return new User(
                new UniqueId(), "Cristi", "Gigi", new EmailAddress("cristi.gigi@test.com"),
                new PhoneNumber("0711456867"), true
        );
    }
}