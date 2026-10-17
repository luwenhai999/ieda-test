package com.juzi;

import java.util.Objects;

/**
 * @author wenhai.lu
 * Create at 2026-02-03 22:06
 */
public class Node {
    public int num;
    public Node next;

    public Node(int num) {
        this.num = num;
    }

    public Node() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return num == node.num &&
                next.equals(node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, next);
    }

    public static Node getNode() {
        Node lastNode = new Node();
        lastNode.num = 1;
        Node head = lastNode;
        for (int i = 2; i < 10; i++) {
            Node thisNode = new Node();
            thisNode.num = i;
            lastNode.next = thisNode;
            lastNode = thisNode;
        }
        return head;
    }

    public static Node getNodeLoop() {
        Node lastNode = new Node();
        lastNode.num = 1;
        Node head = lastNode;
        Node nodeFour = null;
        for (int i = 2; i < 10; i++) {
            Node thisNode = new Node();
            thisNode.num = i;
            lastNode.next = thisNode;
            lastNode = thisNode;
            if (i == 4) {
                nodeFour = thisNode;
            }
        }
        lastNode.next = nodeFour;
        return head;
    }

    public static Node getNodeOne() {
        Node lastNode = new Node();
        lastNode.num = 1;
        Node head = lastNode;
        for (int i = 3; i < 10; i += 2) {
            Node thisNode = new Node();
            thisNode.num = i;
            lastNode.next = thisNode;
            lastNode = thisNode;
        }
        return head;
    }

    public static Node getNodeTwo() {
        Node lastNode = new Node();
        lastNode.num = 0;
        Node head = lastNode;
        for (int i = 2; i < 10; i += 2) {
            Node thisNode = new Node();
            thisNode.num = i;
            lastNode.next = thisNode;
            lastNode = thisNode;
        }
        return head;
    }

}
