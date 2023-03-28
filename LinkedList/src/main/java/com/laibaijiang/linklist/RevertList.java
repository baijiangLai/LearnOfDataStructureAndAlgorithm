package com.laibaijiang.linklist;

import com.laibaijiang.base.ListNode;

public class RevertList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        RevertList revertList = new RevertList();
        ListNode listNode = revertList.reverseList2(node1);
    }
    //使用纯链表的方式进行解决
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode p = head, q = head.next, h = null;
        while (q != null){
            h = q.next;
            q.next = h;
            p = q;
            q = h;
        }
        head.next = null;
        head = p;
        return head;
    }

    //递归的方式进行解决(可以再稿纸上模拟一下，)
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //找到最后，这是链表的最后一个节点(只有当所有地柜函数出栈完成链表的翻转)
        ListNode newHead = reverseList2(head.next);
        //进行局部的翻转
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    //TODO:还可以使用栈的方式解决
}
