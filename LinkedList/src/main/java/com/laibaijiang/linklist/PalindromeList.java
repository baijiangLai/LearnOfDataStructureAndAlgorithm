package com.laibaijiang.linklist;


import com.laibaijiang.base.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class PalindromeList {
    //解法1：使用快慢指针找到中间节点之后进行链表翻转，随后逐个进行val比对
    public boolean isPalindrome1(ListNode head) {
        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode reverseNode = reverse(mid);
        while(reverseNode!= null && head != null){
            if(head.val != reverseNode.val){
                return false;
            }
            reverseNode = reverseNode.next;
            head = head.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head, q = head.next, h = null;
        while(q != null){
            h = q.next;
            q.next = p;
            p = q;
            q = h;
        }
        head.next = null;
        head = p;
        return head;
    }

    //解法2：使用栈，整个链表入栈，随后将栈顶节点值和链表第一个节点依次进行比对
    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        Deque<ListNode> stack = new LinkedList<>();
        ListNode p = head;
        while(p != null){
            stack.push(p);
            p = p.next;
        }
        while(head != null){
            p = stack.pop();
            if(p.val != head.val){
                return false;
            }else {
                head = head.next;
            }
        }
        return true;
    }
}
