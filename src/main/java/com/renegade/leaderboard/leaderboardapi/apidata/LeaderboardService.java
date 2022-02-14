package com.renegade.leaderboard.leaderboardapi.apidata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.renegade.leaderboard.leaderboardapi.tasks.Task;
import com.renegade.leaderboard.leaderboardapi.tasks.TaskRepository;
import com.renegade.leaderboard.leaderboardapi.user.User;
import com.renegade.leaderboard.leaderboardapi.user.UserRepository;

@Service
public class LeaderboardService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private LeaderboardRepository leaderboardRepository;
	
	public List<Task> getTaskList() {
		List<Task> taskList = new ArrayList<Task>();
		taskRepository.findAll(Sort.by(Sort.Direction.ASC, "points")).forEach(taskList::add);
		return taskList;
	}
	
	public Task addTask(Task task) {
		return taskRepository.save(task);
	}
	
	public  User addUser(User user) {
		return userRepository.save(user);
	}
	
	public List<Leaderboard> getLeaderboard() {
		List<Leaderboard> leaderboard = new ArrayList<Leaderboard>();
		leaderboard = leaderboardRepository.showLeaderBoard();
		for (Leaderboard leader : leaderboard) {
			leaderboard.add(new Leaderboard(leader.getId(), leader.getScore(), leader.getUser()));
		}
		return leaderboard;
	}
}
