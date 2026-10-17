package com.juzi.month202602.day20260203;

import com.juzi.Node;

/**
 * 链表的操作
 *
 * @author wenhai.lu
 * Create at 2026-02-03 21:13
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        Node head = getNode();
        // 反转
        Node last = null;
        Node cur = head;
        boolean first = true;
        while (cur != null) {
            Node next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;

        }
        while (last != null) {
            System.out.println(last.num);
            last = last.next;
        }


    }

    private static void getNNode(Node head) {
        // 获取第n个节点,从0开始
        int n = 0;
        int target = 4;// 即第五个数据
        Node dummyNode = new Node();
        dummyNode.next = head;

        Node cur = dummyNode;
        while (n <= target) {
            cur = cur.next;
            n++;
        }
        System.out.println(cur.num);
    }

    private static void firstFunc(Node head) {
        int target = 1;
        Node dummyNode = new Node();
        dummyNode.next = head;
        Node lastNode = dummyNode;
        while (lastNode != null && lastNode.next != null) {
            Node thisNode = lastNode.next;
            if (thisNode.num == target) {
                lastNode.next = thisNode.next;
            } else {
                lastNode = thisNode;
            }
        }
        head = dummyNode.next;


        while (head != null) {
            System.out.println(head.num);
            head = head.next;
        }
    }

    private static void noDummyStyle(Node head) {
        // 链表的删除
        int taget = 5;
        while (head != null && head.num == 5) {
            head = head.next;
        }
        Node lastNode = head;
        while (lastNode.next != null) {
            Node thisNode = lastNode.next;
            if (thisNode.num == taget) {
                // 这一步调整,相当于是将本节点的next修成了下节点的下节点,
                // 但lastNode没变,再次循环会处理这个下节点的下节点
                lastNode.next = thisNode.next;
            } else {
                // 证明lastNode的调整完了,需要换一个lastNode
            }
            lastNode = thisNode;
        }
        while (head != null) {
            System.out.println(head.num);
            head = head.next;
        }
    }

    public static Node getNode() {
        Node lastNode = new Node();
        lastNode.num = 1;
        Node head = lastNode;
        for (int i = 2; i < 10; i++) {
            // 创建当前节点
            Node thisNode = new Node();
            thisNode.num = i;

            // 将当前节点赋值给上一个节点
            lastNode.next = thisNode;

            // 当前节点转换为上一个节点
            lastNode = thisNode;
        }
        return head;
    }
}

