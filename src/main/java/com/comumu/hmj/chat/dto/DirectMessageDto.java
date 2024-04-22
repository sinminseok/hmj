package com.comumu.hmj.chat.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DirectMessageDto {

    private Long receiverId;
    private String message;
}
