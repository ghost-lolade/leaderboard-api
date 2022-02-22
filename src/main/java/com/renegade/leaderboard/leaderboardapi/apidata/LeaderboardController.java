package com.renegade.leaderboard.leaderboardapi.apidata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping("api/v1/tasks")
	public List<Task> getTaskList() {
		return leaderboardService.getTaskList();
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "api/v1/leaderboard")
	public Leaderboard addScore(@RequestBody Leaderboard leaderboard) {
		if(leaderboard.getUser().getRoles().toString() != "ADMIN") {
			return (Leaderboard) leaderboardService.getLeaderboard();
		}
		return leaderboardService.addScore(leaderboard);
	}
}
