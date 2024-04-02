package com.comumu.hmj.user.service;

import com.comumu.hmj.user.domain.User;
import com.comumu.hmj.user.dto.SignupDto;
import com.comumu.hmj.user.repository.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository, passwordEncoder);
    }

    @Test
    public void 회원가입_서비스_메서드_테스트() throws Exception {
        SignupDto signupDto = SignupDto.builder()
                .email("test@naver.com")
                .password("1234")
                        .build();

        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());
        when(userRepository.findByNickName(any())).thenReturn(Optional.empty());

        userService.signUp(signupDto);

        verify(userRepository, times(1)).save(any());
    }

    @Test
    public void 회원가입_이미_존재하는_회원이_있을때_예외테스트() {
        SignupDto signupDto = SignupDto.builder()
                .email("test@naver.com")
                .password("1234")
                .build();


        when(userRepository.findByEmail(any())).thenReturn(Optional.of(new User()));

        Exception exception = assertThrows(Exception.class, () -> userService.signUp(signupDto));
        assertEquals("이미 존재하는 이메일 입니다.", exception.getMessage());

        verify(userRepository, never()).save(any());
    }

    @Test
    public void 회원가입_이미_존재하는_닉네임_있을때_예외테스트() {
        SignupDto signupDto = SignupDto.builder()
                .email("test@naver.com")
                .password("1234")
                .build();

        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());
        when(userRepository.findByNickName(any())).thenReturn(Optional.of(new User()));

        Exception exception = assertThrows(Exception.class, () -> userService.signUp(signupDto));
        assertEquals("이미 존재하는 닉네임 입니다.", exception.getMessage());

        verify(userRepository, never()).save(any());
    }
}
