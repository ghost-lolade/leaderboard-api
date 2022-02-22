package com.renegade.leaderboard.leaderboardapi.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
 
public interface UserRepository extends JpaRepository<User, Long> {
 
    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String email, String username);
}
