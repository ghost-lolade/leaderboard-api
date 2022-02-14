package com.renegade.leaderboard.leaderboardapi.apidata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renegade.leaderboard.leaderboardapi.tasks.Task;

@RestController
@RequestMapping("/")
public class LeaderboardController {

	@Autowired
	private LeaderboardService leaderboardService;
	
	@RequestMapping("api/v1/leaderboard")
	public List<Leaderboard> leaderboard() {
		return leaderboardService.getLeaderboard();
	}
	
	@RequestMapping("api/v1/task")
	public List<Task> getTaskList() {
		return leaderboardService.getTaskList();
	}
}
