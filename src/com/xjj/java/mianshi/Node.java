package com.xjj.java.mianshi;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * µÝ¹é±éÀúÊ÷½Úµã
 */
@Data
@ToString
public class Node {
    private int num;
    private String content;

    private String desc;
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


}

class TestNode {

    public static void main(String[] args) {
        Node node = TestNode.buildNodeTree();
//        System.out.println(findMaxNode(node.getChildNodeList(),node));

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(11, "11");
        map.put(12, "12");
        map.put(13, "11");
        map.put(14, "12");
        map.put(15, "15");
        map.put(16, "16");
        setNums(node.getChildNodeList(), map);
        System.out.println(node);
    }

    static void setNums(List<Node> treeNodeList, Map<Integer, String> map) {
        for (Node node : treeNodeList) {
            node.setDesc(map.getOrDefault(node.getNum(), ""));
            if (node.getChildNodeList() == null || node.getChildNodeList().size() < 0) {
                continue;
            }
            setNums(node.getChildNodeList(), map);
        }

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

        List<Node> secondLeve02 = new ArrayList<>();
//        secondLeve02.add(new Node(13, "A13"));
//        secondLeve02.add(new Node(14, "A14"));

        List<Node> secondLeve03 = new ArrayList<>();
        secondLeve03.add(new Node(15, "A13"));
        secondLeve03.add(new Node(16, "A14"));

        List<Node> firstLevel = new ArrayList<>();
        firstLevel.add(new Node(1, "A1", secondLevel));
        firstLevel.add(new Node(2, "A2",secondLeve02));
        firstLevel.add(new Node(3, "A3",secondLeve03));
        return new Node(0, "A", firstLevel);
    }


}
