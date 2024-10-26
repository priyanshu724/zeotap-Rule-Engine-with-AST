package com.zeotap.Response;

import com.zeotap.model.Node;
import jakarta.persistence.*;


public class RuleResponse {

    private String type;
    private String value;

    private RuleResponse left;
    private RuleResponse right;

    public RuleResponse() {}
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public RuleResponse getLeft() {
        return left;
    }

    public void setLeft(RuleResponse left) {
        this.left = left;
    }

    public RuleResponse getRight() {
        return right;
    }

    public void setRight(RuleResponse right) {
        this.right = right;
    }
}
