package com.renegade.leaderboard.leaderboardapi.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Roles, Long> {
	Optional<Roles> findByName(String name);

}
