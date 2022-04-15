package com.xjj.java.mianshi;

import java.util.ArrayList;
import java.util.List;

/**
 * µÝ¹é±éÀúÊ÷½Úµã
 */
public class Node {
    private int num;
    private String content;
    private List<Node> childNodeList;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Node> getChildNodeList() {
        return childNodeList;
    }

    public void setChildNodeList(List<Node> childNodeList) {
        this.childNodeList = childNodeList;
    }

    public Node(int num, String content, List<Node> childNodeList) {
        this.num = num;
        this.content = content;
        this.childNodeList = childNodeList;
    }

    public Node(int num, String content) {
        this.num = num;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", content='" + content + '\'' +
                ", childNodeList=" + childNodeList +
                '}';
    }
}

class TestNode {

    public static void main(String[] args) {
        Node node = TestNode.buildNodeTree();
        System.out.println(findMaxNode(node.getChildNodeList(),node));
    }

    static Node findMaxNode(List<Node> treeNodeList, Node maxNode) {
        if (treeNodeList == null) {
            return maxNode;
        }
        for (Node node : treeNodeList) {
            if (node.getNum() > maxNode.getNum()) {
                maxNode = node;
            }
            maxNode = findMaxNode(node.getChildNodeList(), maxNode);
        }
        return maxNode;
    }


     static Node buildNodeTree() {
        List<Node> secondLevel = new ArrayList<>();
        secondLevel.add(new Node(11, "A11"));
        secondLevel.add(new Node(12, "A12"));
        List<Node> firstLevel = new ArrayList<>();
        firstLevel.add(new Node(1, "A1", secondLevel));
        firstLevel.add(new Node(2, "A2"));
        return new Node(0, "A", firstLevel);
    }



}
