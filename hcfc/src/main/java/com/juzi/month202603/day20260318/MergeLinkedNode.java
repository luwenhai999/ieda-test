package com.juzi.month202603.day20260318;

import com.juzi.Node;

/**
 * 合并有序列表
 *
 * @author wenhai.lu
 * Create at 2026-03-18 下午 8:18
 */
public class MergeLinkedNode {
    public static void main(String[] args) {
        Node nodeOne = Node.getNodeOne();
        Node nodeTwo = Node.getNodeTwo();

        Node head = new Node();
        Node current = head;

        while (nodeOne != null && nodeTwo != null) {
            if (nodeOne.num < nodeTwo.num) {
                current.next = nodeOne;
                current = nodeOne;
                nodeOne = nodeOne.next;
            } else {
                current.next = nodeTwo;
                current = nodeTwo;
                nodeTwo = nodeTwo.next;
            }
        }
        while (nodeOne != null) {
            current.next = nodeOne;
            current = nodeOne;
            nodeOne = nodeOne.next;
        }
        while (nodeTwo != null) {
            current.next = nodeTwo;
            current = nodeTwo;
            nodeTwo = nodeTwo.next;
        }
        head = head.next;
        while (head != null) {
            System.out.println(head.num);
            head = head.next;
        }
    }
}
