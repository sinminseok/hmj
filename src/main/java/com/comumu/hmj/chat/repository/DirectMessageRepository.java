package com.comumu.hmj.chat.repository;

import com.comumu.hmj.chat.domain.DirectMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DirectMessageRepository extends JpaRepository<DirectMessage, Long> {

    @Query("SELECT d FROM DirectMessage d WHERE (d.senderId = :user1Id AND d.receiverId = :user2Id) OR (d.senderId = :user2Id and d.receiverId = :user1Id) ORDER BY d.sentAt DESC")
    List<DirectMessage> findDmListByUserIds(@Param("user1Id") Long user1Id, @Param("user2Id") Long user2Id);
}
