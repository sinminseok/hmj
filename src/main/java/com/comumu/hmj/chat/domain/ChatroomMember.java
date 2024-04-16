package com.comumu.hmj.chat.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatroomMember {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatroom_member_id")
    private Long chatroomMemberId;

    @Column(name = "chatroom_id")
    private Long chatroomId;

    @Column(name = "user_id")
    private Long userId;
}
