package com.praveenit.repo;

import com.praveenit.entity.PlanCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory,Integer> {
}
