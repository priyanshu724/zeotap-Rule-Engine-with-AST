package com.zeotap.Request;

import com.zeotap.model.Node;

import java.util.Map;

public class RequestWrapper {
    private Node rule;  // This is the rule structure represented as a tree of Node
    private Map<String, Object> data;  // This holds the data for evaluation

    // Getters and setters
    public Node getRule() {
        return rule;
    }

    public void setRule(Node rule) {
        this.rule = rule;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}

