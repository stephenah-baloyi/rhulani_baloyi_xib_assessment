package com.xib.assessment.service.impl;

import com.xib.assessment.domain.Agent;
import com.xib.assessment.domain.Team;
import com.xib.assessment.repository.AgentRepository;
import com.xib.assessment.repository.TeamRepository;
import com.xib.assessment.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Agent> fetchAllAgents() {

        List<Agent> agents = this.agentRepository.findAll();

        return agents;
    }

    @Override
    public Agent fetchSpecificAgent(Long agentId) {

        Optional<Agent> agent = this.agentRepository.findById(agentId);

        return agent.get();
    }

    @Override
    public HashMap<String, Long> createAgent(Agent agent) {
        HashMap<String, Long> response = new HashMap<>();
        Agent savedAgent = this.agentRepository.save(agent);

        response.put("agentId", savedAgent.getId());

        return response;
    }



    @Override
    public List<Agent> fetchAgentsPagination() {
        return null;
    }

    @Override
    public HashMap<String, String> updateAgentTeam(Long teamId, Agent agent) {

        HashMap<String, String> response = new HashMap<>();
        Optional<Team> optionalTeam = this.teamRepository.findById(teamId);

        response.put("message", "Failed");

        if(optionalTeam.isPresent()) {
            agent.setTeam(optionalTeam.get());
            this.agentRepository.save(agent);
            response.put("message", "Updated successfully");
        }


        return response;
    }

}
