package com.comumu.hmj.chat.service;

import com.comumu.hmj.chat.domain.DirectMessage;
import com.comumu.hmj.chat.dto.DirectMessageDto;
import com.comumu.hmj.chat.repository.DirectMessageRepository;
import com.comumu.hmj.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DirectMessageService {

    private final DirectMessageRepository dmRepository;
    private final UserService userService;

    public String sendDM(DirectMessageDto dmDto) {

        try {
            DirectMessage save = dmRepository.save(
                    DirectMessage.builder()
                            .senderId(userService.getCurrentUserId())
                            .receiverId(dmDto.getReceiverId())
                            .sentAt(LocalDateTime.now())
                            .messageContents(dmDto.getMessage())
                            .build()
            );
            return save.getId().toString();
        } catch (Exception e) {
            return e.getMessage();
        }

    }
}
