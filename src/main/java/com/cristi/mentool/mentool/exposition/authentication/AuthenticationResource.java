package com.cristi.mentool.mentool.exposition.authentication;


import com.cristi.mentool.mentool.domain.security.Authority;
import com.cristi.mentool.mentool.infra.security.TokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationResource {
    private AuthenticationManager authenticationManager;
    private TokenProvider jwtTokenUtil;

    public AuthenticationResource(AuthenticationManager authenticationManager, TokenProvider jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping(value = "/generate-token")
    public AuthentifiedUserDto register(@RequestBody LoginUser loginUser) throws AuthenticationException {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Authority loggedAuthority = (Authority) authentication.getPrincipal();
        final String token = jwtTokenUtil.generateToken(authentication);
        return new AuthentifiedUserDto(loggedAuthority, token);
    }
}
