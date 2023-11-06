package com.praveenit.repo;

import com.praveenit.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepo extends JpaRepository<Plan, Integer> {
}
