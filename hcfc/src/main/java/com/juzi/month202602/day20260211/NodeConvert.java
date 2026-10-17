package com.juzi.month202602.day20260211;

import com.juzi.Node;

/**
 * 链表的反转
 *
 * @author wenhai.lu
 * Create at 2026-02-11 下午 7:42
 */
public class NodeConvert {
    public static void main(String[] args) {
        Node root = Node.getNode();
        Node last = null;
        Node cur = root;
        while (cur != null) {
            // 自己的值没有被使用前,不能先被赋值
            // 如果先被赋值的话,再给别人就是被赋值的那个数据了
            Node temp = cur.next;
            cur.next = last;
            last = cur;
            cur = temp;
        }
        root = last;
        while (root != null) {
            System.out.println(root.num);
            root = root.next;
        }
    }
}
