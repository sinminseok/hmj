package com.comumu.hmj.home.domain.home;

import com.comumu.hmj.post.domain.PostEntity;
import com.comumu.hmj.post.domain.PostFunctionality;
import com.comumu.hmj.user.domain.Gender;
import com.comumu.hmj.user.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Home extends PostEntity {

    //구현체 생성해서 외부에서 주입, 어느 계층에서 주입할지 고민해보자
    private PostFunctionality postFunctionality;

    @Id
    @GeneratedValue
    @Column(name = "home_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "home" , cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<HomeImage> images;

    private String address;

    private Integer roomCount;

    private Integer bathRoomCount;

    private Integer tenantMaxCount;

    private Integer tenantMinCount;

    private Integer bond;

    private LocalDate dateMoveIn;

    private LocalDate dateMoveOut;

    private Gender gender;

    private HomeType type;

    private String introduce;

    private String contents;

    private List<HomeHashTag> hashTag;

    private Integer bill;

    //필드 네이밍 고려
    private boolean canAnimal;

    private HomeStatus homeStatus;

}
