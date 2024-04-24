package com.comumu.hmj.chat.controller;

import com.comumu.hmj.chat.dto.DirectMessageDto;
import com.comumu.hmj.chat.service.DirectMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DirectMessageController {

    private final DirectMessageService dmService;

    @GetMapping("/dm")
    public List<DirectMessageDto> dmList(@RequestParam Long userId) {
        return dmService.getMyDmList(userId);
    }
}
