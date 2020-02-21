package com.xib.assessment.service.impl;

import com.xib.assessment.domain.Agent;
import com.xib.assessment.domain.Manager;
import com.xib.assessment.repository.ManagerRepository;
import com.xib.assessment.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public HashMap<String, Long> createManager(Manager manager) {
        HashMap<String, Long> response = new HashMap<>();
        Manager savedManager = this.managerRepository.save(manager);

        response.put("agentId", savedManager.getId());

        return response;
    }
}
