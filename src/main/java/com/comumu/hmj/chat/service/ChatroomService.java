package com.comumu.hmj.chat.service;

import com.comumu.hmj.chat.domain.ChatRoom;
import com.comumu.hmj.chat.domain.ChatroomMember;
import com.comumu.hmj.chat.dto.ChatRoomDto;
import com.comumu.hmj.chat.repository.ChatroomMemberRepository;
import com.comumu.hmj.chat.repository.ChatroomRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatroomService {

    private final ChatroomRepository chatroomRepository;
    private final ChatroomMemberRepository chatroomMemberRepository;


    public Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            // 인증된 사용자의 정보에서 ID 가져오기
            User userDetails = (User) authentication.getPrincipal();
            log.info(String.valueOf(userDetails.getUsername()));
            return userDetails.getId();
        }
        return null; // 인증되지 않은 경우 또는 사용자 정보가 없는 경우
    }

    public void newChatroom(Long userId) {
        Long chatroomId = chatroomRepository.save(
                ChatRoom.builder()
                .build()).getId();

        chatroomMemberRepository.save(
                ChatroomMember.builder()
                        .chatroomId(chatroomId)
                        .userId(userId).build());

        Long currentUserId = getCurrentUserId();
        chatroomMemberRepository.save(
                ChatroomMember.builder()
                        .chatroomId(chatroomId)
                        .userId(currentUserId).build());
    }
}
