package com.comumu.hmj.chat.service;

import com.comumu.hmj.chat.repository.ChatroomMemberRepository;
import com.comumu.hmj.chat.repository.ChatroomRepository;
import com.comumu.hmj.user.domain.Role;
import com.comumu.hmj.user.domain.User;
import com.comumu.hmj.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ChatroomServiceTest {


    private ChatroomService chatroomService;

    @BeforeEach
    public void setUp() {
        chatroomService = chatroomService;
    }

    @Test
    public void testGetUserId() {
        User user = User.builder()
                .email("user1@gmail.com")
                .password("asdf1234")
                .role(Role.valueOf("GETTER"))
                .build();

        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Long userId = chatroomService.getCurrentUserId();

        assertNotNull(userId);
    }
}