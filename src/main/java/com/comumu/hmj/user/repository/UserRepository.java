package com.comumu.hmj.user.repository;

import com.comumu.hmj.user.domain.SocialType;
import com.comumu.hmj.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/*
JPA를 이용해 Repository 생성


 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByNickName(String nickname);

    Optional<User> findByRefreshToken(String refreshToken);

    /**
    * 소셜 타입과 소셜의 식별값으로 회원을 찾는 메서드
     * 정보 제공을 동의한 순간 DB에 저장해야 하지만, 아직 추가 정보를 입력 받지 않았으므로
     * 유저 객체는 DB게 있지만 추가 정보가 빠진 상태다
     * 따라서 추가 정보를 입력받아 회원가입을 진행할 때 소셜타입, 식별자로 해당 회원을 찾기 위한 메서드
    *
     */
    Optional<User> findBySocialTypeAndSocialId(SocialType socialType, String socialId);
}
