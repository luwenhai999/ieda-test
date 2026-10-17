package com.juzi.month202602.day20260207;

import com.juzi.Node;

/**
 * 获取第n个节点
 *
 * @author wenhai.lu
 * Create at 2026-02-07 下午 10:19
 */
public class NodeGetNumN {
    public static void main(String[] args) {
        Node root = Node.getNode();
        Node dummyNode = new Node();
        dummyNode.next = root;
        // 删除第n个节点
        //需要找到n-1个节点
        Node cur = dummyNode;
        int offset = -1;
        int target = 8;
        while (offset < target - 1) {
            cur = cur.next;
            offset++;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        } else {
            cur.next = null;
        }
        Node head = dummyNode.next;
        while (head != null) {
            System.out.println(head.num);
            head = head.next;
        }
    }

    private static void insertTail(Node dummyNode) {
        // 在尾部插入
        Node cur = dummyNode;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(6);
        Node head = dummyNode.next;
        while (head != null) {
            System.out.println(head.num);
            head = head.next;
        }
    }

    private static void insertAtN(Node root) {
        // 头部插入节点
        Node temp = new Node(6);
        temp.next = root;
        Node head = temp;
        while (head != null) {
            System.out.println(head.num);
            head = head.next;
        }
    }

    private static void insertBeforeN(Node dummyNode) {
        // 在第n个节点前插入一个6的节点
        int offset = -1;
        int target = 0;
        Node cur = dummyNode;
        // 便宜的位置要到达目标值之前
        while (offset < target - 1) {
            cur = cur.next;
        }
        Node insert = new Node(6);
        // 先将next领出来
        Node temp = cur.next;
        // next赋值插入值
        cur.next = insert;
        // 插入值的next为拎出来的那个
        insert.next = temp;

        Node head = dummyNode.next;
        while (head != null) {
            System.out.println(head.num);
            head = head.next;
        }
    }

    private static void getM(Node dummyNode) {
        // 获取第n个节点,n从零开始
        Node cur = dummyNode.next;
        int offset = 0;
        int target = 1;
        while (offset < target) {
            offset++;
            cur = cur.next;
        }
        System.out.println(cur.num);
    }
}
