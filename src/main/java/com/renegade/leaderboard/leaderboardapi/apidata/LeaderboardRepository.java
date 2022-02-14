package com.renegade.leaderboard.leaderboardapi.apidata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderboardRepository extends JpaRepository<Leaderboard, Long>{
	
//	@Query(nativeQuery = true,value = "SELECT captain_id, match_id, team_name, total_score, user_id, vcaptain_id, team_id, DENSE_RANK() OVER(ORDER BY total_score DESC) as rank FROM leader_board l INNER JOIN player player ON player.id = l.player_id ORDER BY rank ASC")
//	List<Leaderboard> showLeaderBoard();

//	@Query(nativeQuery = true,value = "SELECT"
//			+ "captain_id, "
//			+ "match_id, team_name, "
//			+ "total_score, user_id, "
//			+ "vcaptain_id, team_id, "
//			+ "DENSE_RANK() "
//			+ "OVER(ORDER BY total_score DESC) as rank "
//			+ "FROM leader_board l "
//			+ "INNER JOIN player player ON player.id = l.player_id "
//			+ "ORDER BY rank ASC")
	@Query(nativeQuery = true, value = "SELECT "
			+ "id, user_id, first_name, score, job, email, FROM leaderboard l INNER JOIN Users u ON u.user_id = l.id ORDER BY score DESC")
	List<Leaderboard> showLeaderBoard();
}
