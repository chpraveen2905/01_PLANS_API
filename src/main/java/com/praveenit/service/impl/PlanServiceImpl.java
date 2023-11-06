package com.praveenit.service.impl;

import com.praveenit.entity.Plan;
import com.praveenit.entity.PlanCategory;
import com.praveenit.repo.PlanCategoryRepo;
import com.praveenit.repo.PlanRepo;
import com.praveenit.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanRepo planRepo;
    @Autowired
    private PlanCategoryRepo planCategoryRepo;

    @Override
    public Map<Integer, String> getPlanCategories() {
        List<PlanCategory> planCategories = planCategoryRepo.findAll();
        Map<Integer, String> categoryMap = new HashMap<>();
        planCategories.forEach(category -> categoryMap.put(category.getCategoryId(), category.getCategoryName()));
        return categoryMap;
    }

    @Override
    public boolean savePlan(Plan plan) {
        Plan savedPlan = planRepo.save(plan);
        return savedPlan.getPlanId() != null;
    }


    @Override
    public List<Plan> getAllPlans() {
        return planRepo.findAll();
    }

    @Override
    public Plan getPlanById(Integer planId) {
        Optional<Plan> plan = planRepo.findById(planId);
        if (plan.isPresent()) {
            return plan.get();
        }
        return null;
    }

    @Override
    public boolean updatePlan(Plan plan) {
        planRepo.save(plan);
        return plan.getPlanId() != null;
    }

    @Override
    public boolean deletePlan(Integer planId) {
        boolean status = false;
        try {
            planRepo.deleteById(planId);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean planStatusChange(Integer planId, String status) {
        Optional<Plan> plan = planRepo.findById(planId);
        if(plan.isPresent()){
            Plan cplan = plan.get();
            cplan.setActiveSw(status);
            planRepo.save(cplan);
            return true;
        }
        return false;
    }
}
