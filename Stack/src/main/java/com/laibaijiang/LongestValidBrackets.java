package com.laibaijiang;

import java.util.LinkedList;

/**
 * 题目给出一个字符串，要找出这个字符串中最常的有效的括号。
 * 本题有两种解法
 * 1. 使用单调栈
 * 2. 使用动态规划的思想解决(会在动态规划的章节给出解答)
 */
public class LongestValidBrackets {
    public static void main(String[] args) {
        LongestValidBracketsResolve();
    }
    public static void LongestValidBracketsResolve(){
        String s = "(()";
        int solution = LongestValidBrackets.Solution(s);
        System.out.println(solution);
    }

    /**
     * 左括号入栈，有括号出栈
     * @param s
     * @return
     */
    public static int Solution(String s){
        int res = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        //同时为了预防第一个字符是有括号，那么在操作之前，先放入一个-1，防止后面的空指针问题
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            }else {
                stack.pop();
                //如果出栈之后，栈为空，那么说明之前的全部满足，那么不管此时是左括号还是有括号，再次入栈
                if (stack.isEmpty()){
                    stack.push(i);
                }
                //出栈之后计数
                res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }
}
