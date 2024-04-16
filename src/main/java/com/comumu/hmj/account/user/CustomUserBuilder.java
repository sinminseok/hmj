package com.comumu.hmj.account.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserBuilder {

    private Long id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public CustomUserBuilder username(String username) {
        this.username = username;
        return this;
    }

    public CustomUserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public CustomUserBuilder authorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
        return this;
    }

    public CustomUserBuilder roles(String... roles) {
        List<GrantedAuthority> authorities = new ArrayList<>(roles.length);
        for (String role : roles) {
            Assert.isTrue(!role.startsWith("ROLE_"),
                    () -> role + " cannot start with ROLE_ (it is automatically added)");
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        return authorities(authorities);
    }

    public UserDetails build() {
        return new CustomUser(id, username, password, authorities);
    }

}
