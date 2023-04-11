package com.laibaijiang;

import java.util.LinkedList;

/**
 * 题目思路
 * 1. 单调栈
 * 2. 动态规划(在动态规划部分给出)
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap(height);
        System.out.println(res);
    }

    /**
     * 满足接雨水的条件一定是：后面一个柱子的高度大于前面一个柱子的高度，这样才能形成凹槽接雨水
     *
     * 使用单调递增栈
     * 1. 只要当前柱子的高度小于栈顶对应柱子的高度，那么就入栈。
     * 2. 不满足情况是，说明当前柱子高度大于栈顶对应柱子的高度，那么此时栈顶的元素就是凹槽部分，将其弹出。
     *  2.1 如果取出将凹槽，栈为空，那么直接退出就行(预防[0,1]这种情况)
     *  2.2 此时栈顶对应的就是栈左边的柱子。
     *  2.3 此时指针指向了右边的柱子，那么宽度就是当前位置 - left - 1
     *  2.4 此时的高度就是左、右柱子高度最小的那个减去凹槽部分。
     *  2.5 每次的面积就是w * h，最后累加每次的面积即可。
     *
     * @param height
     * @return
     */
    public static int trap(int[] height){
        int res = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        int size = height.length;
        if (size == 0){
            return  0;
        }
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                //取出凹槽部分
                int top = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int w = i - left - 1;
                int h = Math.min(height[i], height[left]) - height[top];
                res += w * h;
            }
            stack.push(i);
        }
        return res;
    }
}
