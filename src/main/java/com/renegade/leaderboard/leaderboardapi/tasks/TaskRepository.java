package com.renegade.leaderboard.leaderboardapi.tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
