package com.juzi.month202603.day20260318;

import com.juzi.Node;

/**
 * 链表上环的检测
 *
 * @author wenhai.lu
 * Create at 2026-03-18 下午 9:04
 */
public class NodeLoopCheck {
    public static void main(String[] args) {
        Node nodeLoop = Node.getNodeLoop();
        Node slow = nodeLoop;
        Node fast = nodeLoop;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("有环");
        } else {
            System.out.println("五环");
        }
    }
}
