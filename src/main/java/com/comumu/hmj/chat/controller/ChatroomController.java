package com.comumu.hmj.chat.controller;

import com.comumu.hmj.chat.service.ChatroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ChatroomController {

    private final ChatroomService chatroomService;

    @PostMapping(value = "/chatroom")
    public void newChatroom(@RequestBody Long userId) {

        // 이미 채팅방이 있는지 검사


        // 채팅방 생성
        chatroomService.newChatroom(userId);
    }
}
