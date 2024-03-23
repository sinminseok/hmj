package com.comumu.hmj.oauth;

import com.comumu.hmj.user.domain.Role;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.util.Collection;
import java.util.Map;

/**
 * OAuth2UserService 에서 사용할 OAuth2User 객체를 커스텀한 클래스.
 * OAuth2UserService 에서 기본으로 반환되는 OAuth2User 객체에서 추가할 필드가 있어
 * 커스텀해 OAuth2UserService 에서 커스텀한 CustomOAuth2User 를 반환할 예정이다.
 *
 * CustomOAuth2User 를 구현하는 이유는, Resource Server 에서 제공하지 않는 추가 정보들을 내 서비스에서 가지고 있기 위함이다.
 * 따라서 Resource Server 에서 제공하는 정보만 사용해도 된다면 일반 DefaultOAuth2User 를 사용해도 괜찮 ㅇㅇ
 */
@Getter
public class CustomOAuth2User extends DefaultOAuth2User {

    private String email; // OAuth 로그인 시 처음 로그인일 경우, 내 서비스에서 Resource Server 가 제공하지 않는 정보가 필요할 경우, Resource Server 가 아닌 내 서비스에서 해당 정보를 사용자에게 입력 받아야 한다.
    private Role role;

    /**
     * Constructs a {@code DefaultOAuth2User} using the provided parameters.
     *
     * @param authorities      the authorities granted to the user
     * @param attributes       the attributes about the user
     * @param nameAttributeKey the key used to access the user's &quot;name&quot; from
     *                         {@link #getAttributes()}
     */
    public CustomOAuth2User(Collection<? extends GrantedAuthority> authorities,
                            Map<String, Object> attributes, String nameAttributeKey,
                            String email, Role role) {
        super(authorities, attributes, nameAttributeKey);
        this.email = email;
        this.role = role;
    }
}
