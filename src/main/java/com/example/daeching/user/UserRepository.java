package com.example.daeching.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByLoginIdAndPassword(String loginId, String password);
}
