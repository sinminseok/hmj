package com.comumu.hmj.chat.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageDTO {

    private String roomId;
    private String writerName;
    private String writerId;
    private String message;
}
