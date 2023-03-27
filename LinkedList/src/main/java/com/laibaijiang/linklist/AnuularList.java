package com.laibaijiang.linklist;

import com.laibaijiang.base.ListNode;

/**
 * 使用快慢指针的方法，初始化时快慢指针都在链表头，每次快指针下移两个位置，慢指针下移一个位置，如果快指针和满指针相等的时候，那么说明存在环形
 */
public class AnuularList {
    public boolean hasCycle1(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return false;
            }
        }

        return false;
    }
}
