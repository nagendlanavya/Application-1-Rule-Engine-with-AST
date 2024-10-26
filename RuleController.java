package com.example.ruleengine.controller;

import com.example.ruleengine.model.Node;
import com.example.ruleengine.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/rules")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @PostMapping("/create")
    public Node createRule(@RequestParam String ruleString) {
        return ruleService.createRule(ruleString);
    }

    @PostMapping("/evaluate")
    public boolean evaluateRule(@RequestBody Node node, @RequestBody Map<String, Object> data) {
        return ruleService.evaluateRule(node, data);
    }
}
