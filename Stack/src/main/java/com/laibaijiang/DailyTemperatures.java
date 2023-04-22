package com.laibaijiang;

import java.util.LinkedList;

/**
 * 理解题意：
 * 给定了一个数组，里面是每天的温度值，需要返回一个结果数组，结果数组中的值是对第几天来说，下一次出现比当天还高的温度是在几天之后。如果没有，就是0，有就是那个第几天
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.printf(DailyTemperaturesResolve(temperatures).toString());
    }

    /**
     * 依旧使用单调递增栈，只要入栈的值比前一个大，那么就要计算
     * 此时弹出栈就是那个第几天，那么最后就是res[idx] = i - idx;(idx = stack.pop())
     * @param temperatures
     * @return
     */
    public static int[] DailyTemperaturesResolve(int[] temperatures) {
        int size = temperatures.length;
        int[] res = new int[size];

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int biggerIdx = stack.pop();
                res[biggerIdx] = i - biggerIdx;
            }
            stack.push(i);
        }

        return res;
    }
}
