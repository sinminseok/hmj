package com.comumu.hmj.chat.repository;

import com.comumu.hmj.chat.domain.DirectMessage;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DirectMessageRepositoryTest {

    @Autowired
    private DirectMessageRepository dmRepository;

    @BeforeEach
    public void dumyData() throws InterruptedException {
        dmRepository.save(DirectMessage.builder().senderId(1L).receiverId(2L).messageContents("First message").sentAt(LocalDateTime.now()).build());
        Thread.sleep(1);
        dmRepository.save(DirectMessage.builder().senderId(1L).receiverId(2L).messageContents("Second message").sentAt(LocalDateTime.now()).build());
        Thread.sleep(1);
        dmRepository.save(DirectMessage.builder().senderId(1L).receiverId(3L).messageContents("Other message").sentAt(LocalDateTime.now()).build());
        Thread.sleep(1);
        dmRepository.save(DirectMessage.builder().senderId(3L).receiverId(2L).messageContents("Other message").sentAt(LocalDateTime.now()).build());
        Thread.sleep(1);
        dmRepository.save(DirectMessage.builder().senderId(2L).receiverId(1L).messageContents("Third message").sentAt(LocalDateTime.now()).build());
        Thread.sleep(1);
        dmRepository.save(DirectMessage.builder().senderId(1L).receiverId(2L).messageContents("Fourth message").sentAt(LocalDateTime.now()).build());
    }

    @Test
    public void findDmListByUserIds_test() {
        List<DirectMessage> dmList = dmRepository.findDmListByUserIds(1L, 2L);

        Assertions.assertThat(dmList.get(0).getMessageContents()).isEqualTo("Fourth message");
        Assertions.assertThat(dmList.get(1).getMessageContents()).isEqualTo("Third message");
        Assertions.assertThat(dmList.get(2).getMessageContents()).isEqualTo("Second message");
        Assertions.assertThat(dmList.get(3).getMessageContents()).isEqualTo("First message");
    }
}