package com.laibaijiang;

import java.util.LinkedList;

/**
 * 本题使用栈的方式解决
 * 遍历每个柱子的时候，只要当前柱子高度不小于栈顶柱子，就将当前柱子入栈。
 * 只要当前柱子高度小于栈顶的柱子，此时说明栈顶的柱子找到了右边的第一个小于自身高度的柱子，就可以将栈顶柱子出栈计算以该柱子为高的矩形面积了
 */
public class LargestRectangleArea {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int res = largestRectangleAreaResolve(heights);
        System.out.println(res);
    }

    public static int largestRectangleAreaResolve(int[] heights) {
        int size = heights.length;

        // 给新数组临时在头尾加上两个高度为0的柱子，为了预防空指针
        int[] temp = new int[size + 2];
        for (int i = 1; i < temp.length - 1; i++) {
            temp[i] = heights[i - 1];
        }

        LinkedList<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < temp.length; i++) {
            // 只要当前柱子高度小于栈顶的柱子高度，就计算面积
            while (!stack.isEmpty() && temp[i] < temp[stack.peek()]){
                int left = stack.pop();
                int h = temp[left];
                int w = i - stack.peek() - 1;
                res = Math.max(res, w *h);
            }
            stack.push(i);
        }
        return res;
    }
}
