package com.xib.assessment.service;

import com.xib.assessment.domain.Agent;

import java.util.HashMap;
import java.util.List;

public interface AgentService {

    List<Agent> fetchAllAgents();
    Agent fetchSpecificAgent(Long agentId);
    HashMap<String, Long> createAgent(Agent agent);
    List<Agent> fetchAgentsPagination();
    HashMap<String, String> updateAgentTeam(Long teamId, Agent agent);
}
