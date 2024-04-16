package com.comumu.hmj.chat.repository;

import com.comumu.hmj.chat.domain.DirectMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectMessageRepository extends JpaRepository<DirectMessage, Long> {
}
