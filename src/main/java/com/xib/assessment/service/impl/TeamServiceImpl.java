package com.xib.assessment.service.impl;

import com.xib.assessment.domain.Agent;
import com.xib.assessment.domain.Team;
import com.xib.assessment.repository.AgentRepository;
import com.xib.assessment.repository.ManagerRepository;
import com.xib.assessment.repository.TeamRepository;
import com.xib.assessment.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public List<Team> fetchAllTeams() {

        List<Team> teams = this.teamRepository.findAll();

        return teams;
    }

    @Override
    public Team fetchSpecificTeam(Long teamId) {

        Optional<Team> optionalTeam = this.teamRepository.findById(teamId);

        return optionalTeam.get();
    }



    @Override
    public HashMap<String, Long> createTeam(Team team) {
        HashMap<String, Long> response = new HashMap<>();
        Team savedTeam = this.teamRepository.save(team);

        response.put("teamID", savedTeam.getId());

        return response;
    }

    @Override
    public List<Team> fetchEmptyTeams() {

        List<Team> emptyTeams = new ArrayList<>();

        List<Team> teams = this.teamRepository.findAll();

        for (Team team: teams) {
            if (team.getManagers().size() < 1) {
                List<Agent> agents = this.agentRepository.findByTeam(team);

                if (agents.size() < 1) {
                    emptyTeams.add(team);
                }
            }
        }


        return emptyTeams;
    }

}
