package com.comumu.hmj.home.domain.room;

import com.comumu.hmj.home.domain.BasicInfo;
import com.comumu.hmj.home.domain.LeaseStatus;
import com.comumu.hmj.home.domain.home.Home;
import com.comumu.hmj.home.domain.Price;
import com.comumu.hmj.user.domain.Gender;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_id")
    private Home home;

    @OneToMany(mappedBy = "room", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<RoomImage> images;

    private Integer peopleMaxCount;

    @Embedded
    private Price price;

    @Embedded
    private BasicInfo info;

    @Embedded
    private LeaseStatus status;

    private Gender gender;

    private BedType bedType;
}
