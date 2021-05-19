package com.example.demo.May;

/**
 * @Author: ln
 * @Date: 2021/5/14 14:44
 * @Description:单链表反转
 */
public class SingleLinkedReversal {
    static class LindNode{
        int value;
        LindNode next;

        public LindNode(int value, LindNode next){
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 迭代法
     * @param node
     * @return
     */
    public static LindNode iteration(LindNode node){
        LindNode beg = null, mid = node, end;
        while (mid.next != null){
            end = mid.next;
            mid.next = beg;
            beg = mid;
            mid = end;
        }
        mid.next = beg;
        return mid;
    }

    /**
     * 递归法
     * @param node
     * @return
     */
    public static LindNode recursion(LindNode node){
        if (node == null || node.next == null){
            return node;
        }
        LindNode lindNode = recursion(node.next);
        node.next.next = node;
        node.next = null;
        return lindNode;
    }

    public static void main(String[] args) {
        LindNode node5 = new LindNode(5,null);
        LindNode node4 = new LindNode(4, node5);
        LindNode node3 = new LindNode(3, node4);
        LindNode node2 = new LindNode(2, node3);
        LindNode node1 = new LindNode(1, node2);
        LindNode node = iteration(node1);
        System.out.println(node);

        LindNode nodeRe = recursion(node1);
        System.out.println(nodeRe);
    }
}
