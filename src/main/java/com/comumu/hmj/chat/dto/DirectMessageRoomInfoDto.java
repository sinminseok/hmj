package com.comumu.hmj.chat.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DirectMessageRoomInfoDto {
    private Long senderId;
    private String senderName;
    private Long receiverId;
    private String roomId;
}
