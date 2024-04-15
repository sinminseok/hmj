package com.comumu.hmj.chat.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @Column(name = "message_id")
    private Long id;

    @Column(name="message")
    private String message;

    @Column(name="datetime")
    private String received_at;

    @Column(name="user_id")
    private String userId;

    @Column(name="chatroom_id")
    private Long chatroom_id;
}
