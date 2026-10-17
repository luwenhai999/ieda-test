package com.lugang.anytest.aBinary;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二叉树
 *
 * @author wenhai.lu
 * Create at 2025-06-02 0:02
 */
public class LegalBinaryDemo {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        Queue<BinaryNode> queue = new ArrayDeque<>();
        // 首相将首字母放到队列中
        BinaryNode head = new BinaryNode(arr[0]);
        queue.add(head);
        // 后续的遍历从1开始,因为首字母已经处理了
        int index = 1;
        while (!queue.isEmpty()) {
            // 拿出当前元素
            BinaryNode current = queue.poll();
            // index第一次使用,是left
            if (index < arr.length) {
                Integer leftValue = arr[index++];
                if (leftValue != null) {
                    BinaryNode leftNode = new BinaryNode(leftValue);
                    current.left = leftNode;
                    queue.offer(leftNode);
                }
            }
            // index第二次使用,是right
            if (index < arr.length) {
                Integer rightValue = arr[index++];
                if (rightValue != null) {
                    BinaryNode rightNode = new BinaryNode(rightValue);
                    current.right = rightNode;
                    queue.offer(rightNode);
                }
            }
        }
        first(head);

    }

    private static void first(BinaryNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        first(head.left);
        first(head.right);
    }

}

class BinaryNode {
    public int value;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode(int value) {
        this.value = value;
    }
}


interface  a{}
interface  b{}
interface  c extends a,b{

}