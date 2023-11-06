package com.praveenit.rest;

import com.praveenit.constants.AppConstants;
import com.praveenit.entity.Plan;
import com.praveenit.props.AppProperties;
import com.praveenit.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PlanRestController {
    @Autowired
    private PlanService planService;

    private Map<String, String> messages;

    PlanRestController(PlanService planService, AppProperties appProperties) {
        this.planService = planService;
        this.messages = appProperties.getMessages();
    }

    @GetMapping("/categories")
    public ResponseEntity<Map<Integer, String>> fetchPlanCategories() {
        Map<Integer, String> category = planService.getPlanCategories();
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/plan")
    public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
        String responseMsg = AppConstants.EMPTY_STR;
        boolean isSaved = planService.savePlan(plan);
        if (isSaved) {
            responseMsg = messages.get(AppConstants.PLAN_SAVE_SUCC);
        } else {
            responseMsg = messages.get(AppConstants.PLAN_SAVE_FAIL);
        }

        return new ResponseEntity<String>(responseMsg, HttpStatus.CREATED);
    }

    @GetMapping("/plan/{planId}")
    public ResponseEntity<Plan> fetchPlanDetails(@PathVariable Integer planId) {
        return ResponseEntity.ok(planService.getPlanById(planId));
    }

    @PutMapping("/plan")
    public ResponseEntity<String> changePlan(@RequestBody Plan plan) {
        boolean updatedPLan = planService.updatePlan(plan);
        String responseMsg = AppConstants.EMPTY_STR;
        if (updatedPLan) {
            responseMsg = messages.get(AppConstants.PLAN_UPDATE_SUCC);
        } else {
            responseMsg = messages.get(AppConstants.PLAN_UPDATE_FAIL);
        }
        return new ResponseEntity<>(responseMsg, HttpStatus.OK);
    }
    @DeleteMapping("/plan/{planId}")
    public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
        boolean deletedPlan = planService.deletePlan(planId);
        String responseMsg = AppConstants.EMPTY_STR;
        if (deletedPlan) {
            responseMsg = messages.get(AppConstants.PLAN_DELETE_SUCC);
        } else {
            responseMsg = messages.get(AppConstants.PLAN_DELETE_FAIL);
        }
        return new ResponseEntity<>(responseMsg, HttpStatus.OK);
    }

    @PutMapping("/status-change/{planId}/{status}")
    public ResponseEntity<String> changeStatus(@PathVariable Integer planId, @PathVariable String status){
        String responseMsg = AppConstants.EMPTY_STR;
        boolean isStatusChange = planService.planStatusChange(planId,status);
        if(isStatusChange){
            responseMsg = messages.get(AppConstants.PLAN_STATUS_CHANGE);
        }else{
            responseMsg = messages.get(AppConstants.PLAN_STATUS_CHANGE_FAIL);
        }
        return new ResponseEntity<>(responseMsg, HttpStatus.OK);
    }
}
