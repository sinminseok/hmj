package com.comumu.hmj.user.repository;

import com.comumu.hmj.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
