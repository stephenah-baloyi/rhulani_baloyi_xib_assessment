package com.xib.assessment.service;

import com.xib.assessment.domain.Manager;

import java.util.HashMap;


public interface ManagerService {

    HashMap<String, Long> createManager(Manager manager);
}
