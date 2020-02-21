package com.xib.assessment.restcontroller;

import com.xib.assessment.domain.Team;
import com.xib.assessment.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/teams/fetch-all-teams")
    public List<Team> fetchAllTeams() {

        List<Team> teams = this.teamService.fetchAllTeams();

        return teams;
    }

    @GetMapping("/team/{id}/fetch-specific-team")
    public Team fetchSpecificTeam(@PathVariable("id")Long teamId) {

        Team team = this.teamService.fetchSpecificTeam(teamId);

        return team;
    }

    @PostMapping("/team/create-team")
    public HashMap<String, Long> createTeam(@RequestBody  Team team) {

        HashMap<String, Long> response = this.teamService.createTeam(team);

        return response;
    }

    @GetMapping("/teams/empty-teams")
    List<Team> fetchEmptyTeams() {
        return this.teamService.fetchEmptyTeams();
    }
}
