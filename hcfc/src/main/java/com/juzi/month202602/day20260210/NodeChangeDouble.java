package com.juzi.month202602.day20260210;

import com.juzi.Node;

/**
 * 链表两两互换
 *
 * @author wenhai.lu
 * Create at 2026-02-10 下午 7:10
 */
public class NodeChangeDouble {
    public static void main(String[] args) {
        Node root = Node.getNode();
        Node dummyNode = new Node(0);
        dummyNode.next = root;
        Node last = dummyNode;
        while (last != null && last.next != null && last.next.next != null) {
            // 最后两个
            // 如果使用简短语句,有个最起码的原则,在给某个值赋值前,一定要临时存一下,要不然原本的值就没了
            Node third = last.next.next;
            Node fourth = last.next.next.next;
            Node second = last.next;
            last.next = third;
            third.next = second;
            second.next = fourth;
            last = second;
        }
        Node head = dummyNode.next;
        while (head != null) {
            System.out.println(head.num);
            head = head.next;
        }
    }
}
