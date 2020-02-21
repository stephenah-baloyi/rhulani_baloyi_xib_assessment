package com.xib.assessment.repository;

import com.xib.assessment.domain.Agent;
import com.xib.assessment.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
