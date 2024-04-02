package com.comumu.hmj.user.repository;

import com.comumu.hmj.user.domain.Role;
import com.comumu.hmj.user.domain.SocialType;
import com.comumu.hmj.user.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        User user = User.builder()
                .email("test@naver.com")
                .nickName("닉네임")
                .socialId("socialId")
                .socialType(SocialType.GOOGLE)
                .brith(1031) // Note: 날짜는 숫자로 변경
                .password("test1234@")
                .phoneNumber(1012341234) // Note: 전화번호는 Long으로 변경
                .role(Role.PROVIDER)
                .build();

        userRepository.save(user);
    }

    @Test
    public void findByEmail_테스트() {
        //given
        String email = "test@naver.com";

        //when
        Optional<User> optionalUser = userRepository.findByEmail(email);

        //then
        Assertions.assertTrue(optionalUser.isPresent());
        Assertions.assertEquals(email, optionalUser.get().getEmail());
    }

    @Test
    public void findByNickName_테스트() {
        //given
        String nickName = "닉네임";

        //when
        Optional<User> optionalUser = userRepository.findByNickName(nickName);

        //then
        Assertions.assertTrue(optionalUser.isPresent());
        Assertions.assertEquals(nickName, optionalUser.get().getNickName());
    }

    @Test
    public void findBySocialTypeAndSocialId_테스트() {
        //given
        String socialId = "socialId";
        SocialType socialType = SocialType.GOOGLE;

        //when
        Optional<User> optionalUser = userRepository.findBySocialTypeAndSocialId(socialType, socialId);

        //then
        Assertions.assertTrue(optionalUser.isPresent());
        Assertions.assertEquals(socialId, optionalUser.get().getSocialId());
        Assertions.assertEquals(socialType, optionalUser.get().getSocialType());
    }


}
