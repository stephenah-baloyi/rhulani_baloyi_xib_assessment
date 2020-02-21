package com.xib.assessment.repository;

import com.xib.assessment.domain.Agent;
import com.xib.assessment.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    List<Agent> findByTeam(Team team);
}
