package com.juzi.month202603.day20260318;

import com.juzi.Node;

/**
 * 链表反转
 *
 * @author wenhai.lu
 * Create at 2026-03-18 下午 8:54
 */
public class NodeConvert {
    public static void main(String[] args) {
        Node node = Node.getNode();
        Node pre = null;
        Node current = node;
        while (current != null) {
            Node temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        Node head = pre;
        while (head != null) {
            System.out.println(head.num);
            head = head.next;
        }
    }
}
