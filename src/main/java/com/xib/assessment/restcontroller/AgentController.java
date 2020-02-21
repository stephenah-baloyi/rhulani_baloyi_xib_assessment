package com.xib.assessment.restcontroller;

import com.xib.assessment.domain.Agent;
import com.xib.assessment.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class AgentController {

    @Autowired
    private AgentService agentService;

    @GetMapping("/agents/fetch-all-agents")
    public List<Agent> fetchAllAgents() {

        List<Agent> agents = this.agentService.fetchAllAgents();

        return agents;
    }

    @GetMapping("/agent/{id}/fetch-specific-agent")
    public Agent fetchSpecificAgent(@PathVariable("id")Long agentId) {

        Agent agent = this.agentService.fetchSpecificAgent(agentId);

        return agent;
    }

    @GetMapping("/agents/{id}/fetch-specific-agent")
    public List<Agent>  fetchAgentsPagination(@PathVariable("id")Long agentId) {

        List<Agent> agents = this.agentService.fetchAgentsPagination();

        return agents;
    }

    @PostMapping("/agent/create-agent")
    public HashMap<String, Long> createTeam(@RequestBody Agent agent) {

        HashMap<String, Long> response = this.agentService.createAgent(agent);

        return response;
    }

    @PutMapping("/team/{id}/agent")
    public HashMap<String, String> updateAgentTeam(@PathVariable("id")Long teamId, @RequestBody Agent agent) {
        return this.agentService.updateAgentTeam(teamId, agent);
    }

}
