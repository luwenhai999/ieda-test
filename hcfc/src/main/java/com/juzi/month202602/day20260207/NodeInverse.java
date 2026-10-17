package com.juzi.month202602.day20260207;

import com.juzi.Node;

/**
 * 节点反转
 *
 * @author wenhai.lu
 * Create at 2026-02-07 下午 9:06
 */
public class NodeInverse {
    public static void main(String[] args) {
        Node head = Node.getNode();
        Node pre = null;
        Node current = head;
        while (current != null) {
            // 将当前的下一个拎出来
            Node next = current.next;
            // 将当前的next改成上一个
            current.next = pre;
            // 将当前转化内上一个
            pre = current;
            // 将拎出来的那个转换为当前
            current = next;
        }
        while (pre != null) {
            System.out.println(pre.num);
            pre = pre.next;
        }
    }
}
