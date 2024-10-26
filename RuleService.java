package com.example.ruleengine.service;

import com.example.ruleengine.model.Node;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class RuleService {
    public Node createRule(String ruleString) {
        String[] tokens = ruleString.split(" ");
        Node left = new Node("operand", null, null, tokens[0] + " " + tokens[1] + " " + tokens[2]);
        Node right = new Node("operand", null, null, tokens[4] + " " + tokens[5] + " " + tokens[6]);
        return new Node("operator", left, right, tokens[3]);
    }

    public boolean evaluateRule(Node node, Map<String, Object> data) {
        if ("operand".equals(node.getNodeType())) {
            String[] condition = node.getValue().split(" ");
            String attribute = condition[0];
            String operator = condition[1];
            String value = condition[2];
            Object dataValue = data.get(attribute);
            if (dataValue == null) return false;
            if ("=".equals(operator)) return dataValue.equals(value);
            if (">".equals(operator)) return Integer.parseInt(dataValue.toString()) > Integer.parseInt(value);
            if ("<".equals(operator)) return Integer.parseInt(dataValue.toString()) < Integer.parseInt(value);
        }
        if ("operator".equals(node.getNodeType())) {
            if ("AND".equals(node.getValue())) return evaluateRule(node.getLeft(), data) && evaluateRule(node.getRight(), data);
            if ("OR".equals(node.getValue())) return evaluateRule(node.getLeft(), data) || evaluateRule(node.getRight(), data);
        }
        return false;
    }
}
