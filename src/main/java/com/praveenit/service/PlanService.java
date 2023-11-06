package com.praveenit.service;

import com.praveenit.entity.Plan;

import java.util.List;
import java.util.Map;

public interface PlanService {

    public Map<Integer, String> getPlanCategories();
    public boolean savePlan(Plan plan);

    List<Plan> getAllPlans();

    Plan getPlanById(Integer planId);
    boolean updatePlan(Plan plan);
    boolean deletePlan(Integer planId);
    boolean planStatusChange(Integer planId, String status);

}
