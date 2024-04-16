package com.comumu.hmj.chat.repository;

import com.comumu.hmj.chat.domain.ChatroomMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatroomMemberRepository extends JpaRepository<ChatroomMember, Long> {
}
