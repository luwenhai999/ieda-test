package com.juzi.month202603.day20260307;

import com.juzi.Node;

/**
 * 链表反转
 *
 * @author wenhai.lu
 * Create at 2026-03-07 下午 7:49
 */
public class NodeConvert {
    public static void main(String[] args) {
        Node node = Node.getNode();
        Node pre = null;
        Node cur = node;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        Node head = pre;
        while (head != null) {
            System.out.println(head.num);
            head = head.next;
        }
    }
}
