package com.laibaijiang.linklist;

import com.laibaijiang.base.ListNode;

/**
 * 题意：
 * 给出链表，返回一个按照升序排列的结果
 * 如果对排序算法有了解的话，可以按照排序算法的思想进行求解
 *
 * @link https://leetcode.cn/problems/sort-an-array/
 */
public class SortList {
    //解法1：使用排序算法进行解决
    int[] nums;
    public ListNode sortListSolution(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = head;
        int count = 0;
        while(p != null){
            count++;
            p = p.next;
        }
        p = head;
        nums = new int[count];
        for(int i = 0; i < count; i++){
            nums[i] = p.val;
            p = p.next;
        }
        mergeSort(nums, 0, count - 1);
        p = dummy;
        for(int i = 0; i < count; i++){
            System.out.println(nums[i]);
            ListNode s = new ListNode(nums[i]);
            p.next = s;
            p = s;
        }
        return dummy.next;
    }

    private void mergeSort(int[] nums, int low, int high){
        if(low < high){
            int mid = low + ((high - low) >> 1);
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }
    private void merge(int[] nums, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        int idx = 0;
        //分别指向两个数组的开始
        int i = low, j = mid + 1;
        while(i <= mid && j <= high){
            if(nums[i] <= nums[j]){
                temp[idx++] = nums[i++];
            }else {
                temp[idx++] = nums[j++];
            }
        }
        //没有比较完全的
        while(i <= mid){
            temp[idx++] = nums[i++];
        }
        while(j <= high){
            temp[idx++] = nums[j++];
        }
        for(int count = 0; count < idx; count++){
            nums[count + low] = temp[count];
        }
    }


    /**
     * 解法2：给出了时间复杂度O(nlogn)，想到二分的解决办法
     * 先找到链表的中点，将前后两段进行排序，最后再合并即可。
     */
    public ListNode sortListSolution2(ListNode head){
        return sort(head, null);
    }

    private ListNode sort(ListNode head, ListNode tail){
        if (head == tail){
            return head;
        }
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == tail){
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode l1 = sort(head, mid);
        ListNode l2 = sort(mid, tail);
        ListNode res = mergeTwoList(l1, l2);
        return res;
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null){
            p.next = l1;
        }
        if(l2 != null){
            p.next = l2;
        }
        return dummy.next;
    }
}
