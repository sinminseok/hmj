package com.comumu.hmj.home.domain.room;

import com.comumu.hmj.home.domain.home.Home;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class RoomImage {

    @Id
    @GeneratedValue
    @Column(name = "home_image_id")
    private Long id;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_id")
    private Room room;
}
