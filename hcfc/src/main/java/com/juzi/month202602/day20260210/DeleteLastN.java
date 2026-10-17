package com.juzi.month202602.day20260210;

import com.juzi.Node;

/**
 * 删除倒数第n个元素
 *
 * @author wenhai.lu
 * Create at 2026-02-10 下午 10:11
 */
public class DeleteLastN {
    public static void main(String[] args) {
        Node root = Node.getNode();
        Node dummyNode = new Node(0);
        dummyNode.next = root;
        int target = 0;
        Node cur = dummyNode;
        for (int i = -1; i < target + 1; i++) {
            cur = cur.next;
        }
        Node deleteNode = dummyNode;
        while (cur != null) {
            cur = cur.next;
            deleteNode = deleteNode.next;
        }
        deleteNode.next = deleteNode.next.next;
        Node head = dummyNode.next;
        while (head != null) {
            System.out.println(head.num);
            head = head.next;
        }
    }
}
