package com.zeotap.service;

import java.util.Map;

import com.zeotap.Request.RequestWrapper;
import com.zeotap.Request.RuleRequest;
import com.zeotap.Response.RuleResponse;
import com.zeotap.model.Node;
import com.zeotap.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleService {

    @Autowired
    private RuleRepository ruleRepository;

    // Dynamic rule parsing from rule string
    public RuleResponse createRule(String ruleString) {
        if (ruleString == null) {
            throw new IllegalArgumentException("Rule cannot be null");
        }
        // Parse the rule string into an AST
        return parseRule(ruleString);
    }




    public RuleResponse combineRules(String rule1, String rule2, String operator) {
        // Add a null check to ensure `rule1` and `rule2` are not null
        if (rule1 == null || rule2 == null) {
            throw new IllegalArgumentException("Rule1 and Rule2 must not be null");
        }

        // Trim to ensure the strings are properly formatted
        rule1 = rule1.trim();
        rule2 = rule2.trim();

        // Proceed with parsing after validation
        RuleResponse leftNode = parseRule(rule1);
        RuleResponse rightNode = parseRule(rule2);

        // Create the root node for the combination
        RuleResponse combinedNode = new RuleResponse();
        combinedNode.setType(operator); // AND or OR
        combinedNode.setLeft(leftNode);
        combinedNode.setRight(rightNode);

        return combinedNode;
    }


public boolean evaluateRule(Node node, Map<String, Object> data) {
    if (node == null) {
        // Handle the null case, for example, by returning false or throwing an exception
        System.err.println("Node is null");
        return false; // or throw an exception
    }

    // Base case: Evaluate operand nodes
    if ("operand".equals(node.getType())) {
        return evaluateCondition(node.getValue(), data);
    }

    // Recursive evaluation of left and right sub-trees
    boolean leftResult = evaluateRule(node.getLeft(), data);
    boolean rightResult = evaluateRule(node.getRight(), data);

    // Combining results based on the node type (AND/OR)
    return "AND".equals(node.getType()) ? leftResult && rightResult : leftResult || rightResult;
}


    private boolean evaluateCondition(String condition, Map<String, Object> data) {
        try {
            if (condition.contains(">")) {
                String[] parts = condition.split(">");
                String field = parts[0].trim();
                int value = Integer.parseInt(parts[1].trim());
                Object fieldValue = data.get(field);

                // Ensure field is an integer and compare
                return fieldValue instanceof Integer && (int) fieldValue > value;

            } else if (condition.contains("=")) {
                String[] parts = condition.split("=");
                String field = parts[0].trim();
                String value = parts[1].trim().replace("'", "");
                Object fieldValue = data.get(field);

                // Ensure field is a string and compare
                return fieldValue instanceof String && fieldValue.equals(value);

            } else if (condition.contains("<")) {
                String[] parts = condition.split("<");
                String field = parts[0].trim();
                int value = Integer.parseInt(parts[1].trim());
                Object fieldValue = data.get(field);

                // Ensure field is an integer and compare
                return fieldValue instanceof Integer && (int) fieldValue < value;
            }
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number in condition: " + condition);
        } catch (ClassCastException e) {
            System.err.println("Type mismatch for field in data map: " + condition);
        }
        return false;  // Fallback if condition evaluation fails
    }



    private RuleResponse parseRule(String ruleString) {
        // Trim leading/trailing whitespace
        ruleString = ruleString.trim();

        // Remove leading/trailing parentheses, if present
        if (ruleString.startsWith("(") && ruleString.endsWith(")")) {
            ruleString = ruleString.substring(1, ruleString.length() - 1).trim();
        }

        // Check for AND or OR to create operator nodes
        if (ruleString.contains(" AND ")) {
            String[] parts = ruleString.split(" AND ", 2); // Split by AND
            RuleResponse root = new RuleResponse();
            root.setType("AND");
            root.setLeft(parseRule(parts[0].trim()));  // Parse the left part
            root.setRight(parseRule(parts[1].trim())); // Parse the right part
            return root;
        } else if (ruleString.contains(" OR ")) {
            String[] parts = ruleString.split(" OR ", 2); // Split by OR
            RuleResponse root = new RuleResponse();
            root.setType("OR");
            root.setLeft(parseRule(parts[0].trim()));  // Parse the left part
            root.setRight(parseRule(parts[1].trim())); // Parse the right part
            return root;
        } else {
            // Operand node, remove extra quotes if present
            RuleResponse leaf = new RuleResponse();
            leaf.setType("operand");
            leaf.setValue(ruleString.replace("\"", "").trim());  // Clean quotes
            return leaf;
        }
    }

}
