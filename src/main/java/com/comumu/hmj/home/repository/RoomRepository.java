package com.comumu.hmj.home.repository;

import com.comumu.hmj.home.domain.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
