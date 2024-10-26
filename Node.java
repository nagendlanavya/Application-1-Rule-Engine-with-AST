package com.example.ruleengine.model;

public class Node {
    private String nodeType;  
    private Node left;        
    private Node right;       
    private String value;     

    public Node(String nodeType, Node left, Node right, String value) {
        this.nodeType = nodeType;
        this.left = left;
        this.right = right;
        this.value = value;
    }

    // Getters and Setters
    public String getNodeType() { return nodeType; }
    public Node getLeft() { return left; }
    public Node getRight() { return right; }
    public String getValue() { return value; }
}
