package com.laibaijiang.linklist;

import com.laibaijiang.base.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题意：给出两个链表，二者与某一节点相交，找出相交的那个节点
 */
public class IntersectionNode {
    //使用长短链表进行标记
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode p = headA;
        int len1 = 0, len2 = 0;
        while (p != null){
            len1 += 1;
            p = p.next;
        }
        p = headB;
        while (p != null){
            len2 += 1;
            p = p.next;
        }
        ListNode longer = len1 > len2 ? headA : headB;
        ListNode shorter = len1 > len2 ? headB : headA;
        int dif = len1 > len2 ? (len1 - len2) : (len2 - len1);
        while (dif > 0){
            longer = longer.next;
            dif--;
        }
        while (longer != shorter){
            longer = longer.next;
            shorter = shorter.next;
        }
        return longer;
    }

    //使用map,key: listNode, value为每个节点出现的次数
    //将任何一个链表遍历，并放入map中，随后再遍历另外一个链表，看是否有节点存在于map中，有就break
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map = new HashMap<>();
        while (headB != null){
            map.put(headB, 1);
            headB = headB.next;
        }
        while(headA != null){
            if (map.containsKey(headA)){
                break;
            }
            headA = headA.next;
        }
        return headA;
    }
}
