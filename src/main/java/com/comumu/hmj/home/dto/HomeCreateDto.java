package com.comumu.hmj.home.dto;

import com.comumu.hmj.home.domain.Home;
import com.comumu.hmj.home.domain.HomeAddress;
import com.comumu.hmj.home.domain.HomeImage;
import com.comumu.hmj.home.domain.HomeType;
import com.comumu.hmj.user.domain.Gender;
import com.comumu.hmj.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class HomeCreateDto {

    private HomeAddressDto homeAddressDto;

    private List<String> images;

    private String address;

    private Integer roomCount;

    private Integer bathRoomCount;

    private Integer bond;

    private Gender gender;

    private Integer peopleCount;

    private HomeType homeType;

    private String shortIntroduce;

    private String introduce;

    private Integer bill;


    public Home toEntity(User user) {
        Home home = Home.builder()
                .user(user)
                .bathRoomCount(this.bathRoomCount)
                .peopleCount(peopleCount)
                .bond(bond)
                .gender(gender)
                .type(homeType)
                .introduce(introduce)
                .shortIntroduce(shortIntroduce)
                .bill(bill)
                .viewCount(0)
                .build();

        HomeAddress homeAddress = homeAddressDto.toEntity();
        home.registerHomeAddress(homeAddress);

        List<HomeImage> homeImages = toHomeImages(images, home);
        home.registerHomeImages(homeImages);
        return home;
    }

    private List<HomeImage> toHomeImages(List<String> urls, Home home){
        List<HomeImage> homeImages = new ArrayList<>();

        for(String url : urls){
            HomeImage build = HomeImage.builder()
                    .home(home)
                    .imageUrl(url)
                    .build();
            homeImages.add(build);
        }
        return homeImages;
    }

}
