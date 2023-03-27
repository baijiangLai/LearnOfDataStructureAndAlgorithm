package com.laibaijiang.linklist;

import com.laibaijiang.base.ListNode;

/**
 * 本题与141的区别是：找出是在哪个节点发生的循环
 * 同理使用快慢指针的方法(慢指针每次下移一步，快指针每次下移两步)，设值一个死循环，只有当快慢指针停在同一个位置的时候才出循环
 * 最后已经确认了是有循环后，将快指针的位置设值在头，由于会循环，那么只有当快指针和慢指针重合的时候，才是那个发生开始环形的节点
 */
public class AnuularList2 {
    public ListNode detectCycle(ListNode head){
        if (head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (true){
            if (fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }

        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
