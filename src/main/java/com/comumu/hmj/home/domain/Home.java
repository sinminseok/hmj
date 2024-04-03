package com.comumu.hmj.home.domain;

import com.comumu.hmj.common.domain.BaseTimeEntity;
import com.comumu.hmj.user.domain.Gender;
import com.comumu.hmj.user.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


/**
 * 최대한 많은 데이터를 넣는것 보단 최소한의 데이터로 간편하게 볼 수 있게 만드는게 좋을듯
 */
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Home extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "home_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //집 사진
    @JsonIgnore
    @OneToMany(mappedBy = "home" , cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<HomeImage> images;

    @OneToOne()
    private HomeAddress homeAddress;

    // 화장실 개수
    private Integer bathRoomCount;

    //사는 사람 수
    private Integer peopleCount;

    //보증금
    private Integer bond;

    //todo 입주 날짜, 퇴실 날짜가 있어야 하나 ?
    private LocalDate dateMoveIn;
    private LocalDate dateMoveOut;

    private Gender gender;

    @Enumerated(EnumType.STRING)
    private HomeType type;

    //집 한줄 소개
    private String shortIntroduce;

    //집 소개 내용
    private String introduce;

    // 주세 / perWeek
    private Integer bill;

    //조회수
    private Integer viewCount;

}
