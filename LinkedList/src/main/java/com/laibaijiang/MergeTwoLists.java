package com.laibaijiang;

import com.laibaijiang.base.ListNode;

/**
 * 题目条件：
 * 1. 给出两个链表(升序)
 * 2. 合并之后也要是升序
 */

public class MergeTwoLists {

    /**
     * 不断的比较结点值，采用尾插法，也就是后面题解说的迭代法
     * @param list1
     * @param list2
     * @return
     * 时间复杂度: O(len1 + len2)
     * 空间复杂度: O(1)
     */
    public static ListNode merge1(ListNode list1, ListNode list2){
        if (list1 == null) {
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode dummy = new ListNode();
        dummy.next = null;
        ListNode p = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else if (list1.val > list2.val) {
                p.next = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null){
            p.next = list1;
        }
        if (list2 != null){
            p.next = list2;
        }
        return dummy.next;
    }

    /**
     * 问题的核心是在与不断的值比较，且每次比较的核心都没有变，那么采用递归的方法进行解决
     * @param list1
     * @param list2
     * @return
     * 时间复杂度: O(len1 + len2)
     * 空间复杂度: O(len1 + len2)，可以想象是在不断的压栈的问题，大问题包含小问题，问题将从最小的那个解出发
     * 为什么可以不设置虚拟结点？
     * 答：因为每次递归到最后一个解需要有指针进行记录，采用虚拟结点的话，得到的答案是只有最后的解而没有记录前面解
     *https://leetcode.cn/problems/merge-two-sorted-lists/solution/yi-kan-jiu-hui-yi-xie-jiu-fei-xiang-jie-di-gui-by-/
     *
     */
    public static ListNode merge2(ListNode list1, ListNode list2){
        if (list1 == null){
            return list2;
        }else if (list2 == null){
            return list1;
        } else if (list1.val < list2.val){
            list1.next = merge2(list1.next, list2);
            return list1;
        } else {
            list2.next = merge2(list1, list2.next);
            return list2;
        }
    }
    /**
     图解：
     * |------------------------------|     |------------------------------|    |                              |
     * |l1   1->2->4                  |     |l1      -> |1->2->4|          |    |l1     -> 1 |->2->4|          |
     * |l2   1->3->4                  |---->|l2  1   -> |->3->4|           |--->|l2   1      |->3->4|          |
     * |                              |     |                              |    |                              |
     * |------------------------------|     |------------------------------|    |                              |
     *
     *   |                              |   |                              |   |                              |
     *   |l1   ->1->2 -> |4|            |   |l1   ->1->2       |4|         |   |l1   ->1->2     |4|           |
     * ->|l2  1       -> |3->4|         |-->|l2  1       ->3 ->|4|         |-->|l2  1      ->3->4             |
     *   |                              |   |                              |   |                              |
     *   |                              |   |                              |   |                              |
     *
     *   |                              |
     *   |l1   ->1->2      ->4          |
     * ->|l2  1      ->3->4             |
     *   |                              |
     *   |                              |
     */
}
