package com.laibaijiang;

import com.laibaijiang.base.ListNode;

/**
 * @see <></>
 */
public class MergeKLists {

    /**
     * 解法1： 采用顺序合并，从前到后两个两个进行合并。
     * 时间复杂度：根据官方的回答，第一次合并为n，第二次为2n，第i次为in，,,,,，因此总的时间复杂度为(1+2+...+k)*n=O(k^2*n)
     * 空间复杂度：因为没有使用其他任何辅助空间，复杂度为O(1)
     * @param lists
     * @return
     */
    public static ListNode mergeK1(ListNode[] lists){
        ListNode res = null;
        for(int i = 0; i < lists.length; i++){
            res = mergeTwo(lists[i], res);
        }
        return res;
    }


    public static ListNode mergeTwo(ListNode l1, ListNode l2){
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

    /**
     * 解法2：采用二分法，类似于快速排序，
     * 时间复杂度：O(kn*logk)，k为第几轮
     * 空间复杂度：O(1)
     * @param lists
     * @param left = 0
     * @param right = lists.length() - 1
     * @return
     */
    public static ListNode refusion(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = refusion(lists, left, mid);
        ListNode l2 = refusion(lists, mid + 1, right);
        return mergeTwo(l1, l2);
    }
}
