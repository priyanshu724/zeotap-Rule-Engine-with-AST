package com.zeotap.controller;

import com.zeotap.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/api/rules")
public class UIController {

    @Autowired
    private RuleService ruleService;


    @GetMapping("/")  // Handles the root URL (localhost:8080/)
    public String showIndexPage() {
        return "index";  // Returns the index.html in the templates folder
    }


}
