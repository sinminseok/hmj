package com.comumu.hmj.account.user;


import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

public interface CustomUserDetails extends UserDetails {
    Long getId();
}
