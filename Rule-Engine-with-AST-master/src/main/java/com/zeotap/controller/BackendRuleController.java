package com.zeotap.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zeotap.Request.RequestWrapper;
import com.zeotap.Request.RuleRequest;
import com.zeotap.Response.RuleResponse;
import com.zeotap.Request.CombineRuleRequest;
import com.zeotap.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zeotap.service.RuleService;

import java.util.Map;

@RestController
@RequestMapping("/api/rules")
public class BackendRuleController {


    @Autowired
    private final RuleService ruleService;

    public BackendRuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping("/create")
    public RuleResponse createRule(@RequestBody RuleRequest ruleRequest ) {
        if (ruleRequest == null || ruleRequest.getRule() == null) {
            throw new IllegalArgumentException("RuleRequest or Rule cannot be null");
        }
       return ruleService.createRule(ruleRequest.getRule());

    }


    @PostMapping("/combine")
    public RuleResponse combineRules(@RequestBody CombineRuleRequest request) {
        return ruleService.combineRules(request.getRule1(), request.getRule2(), request.getOperator());
    }


    @PostMapping("/evaluate")
    public boolean evaluateRule(@RequestBody RequestWrapper request) {
        if (request == null || request.getRule() == null) {
            // Handle the case where the request or rule is null
            throw new IllegalArgumentException("Request or rule cannot be null");
        }
        return ruleService.evaluateRule(request.getRule(), request.getData());
    }


}
