package com.laibaijiang;

import java.util.LinkedList;

/**
 * 理解题意：
 * 给定了一个数组，里面的数字不确定是否升序排列的，如果是，那么就返回0，如果不是，找到子数组将其升序后可以让整个数组升序，并且子数组要求长度最短
 */
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {

    }
    public static int ShortestUnsortedContinuousSubarrayResolve(int[] nums) {
        return findUnsortedSubArray(nums);
    }

    /**
     * 结题思路：
     * 初始化栈，设值左边值为数组长度，右边值为0
     * 使用单调栈，
     *  1. 从左至右使用单调递增栈，只要找到第一个开始下降的，那么弹出栈顶值，左边值为弹出值和初始化值的最小值。
     *  2. 从右至左使用单调递减栈，只要找到第一个开始增加的，弹出栈顶值，右边值为弹出值和初始化值的最大值。
     * 最后返回的时候，如果左边值大于右边值，直接返回0，说明原数组就是有序的，否则返回右边值 - 左边值 + 1(因为求长度，二者代表的是数组下表)
     * @param nums
     * @return
     */
    public static int findUnsortedSubArray(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        int size = nums.length;
        int left = size, right = 0;
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int newLeft = stack.pop();
                left = Math.min(newLeft, left);
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = size - 1; i >= 0; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int newRight = stack.pop();
                right = Math.max(newRight, right);
            }
            stack.push(i);
        }
        if (left < right) {
            return left - right + 1;
        } else {
            return 0;
        }
    }
}
