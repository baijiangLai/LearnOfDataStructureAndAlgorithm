package com.laibaijiang;

/**
 * 题目链接： https://leetcode.cn/problems/valid-parentheses
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 该题的基本思路就是使用栈
 * 1. 有效括号首先肯定是成对出现的。
 * 2. 使用map存放括号，key为右括号，value为左括号。
 * 3. 遍历给定字符串，如果是左括号，那么就入栈，如果是右括号，那么查看栈顶元素是否和map中对应的左括号一致，是就弹出。
 * 4. 如果遍历完全，只需要看栈是否为空。
 */
public class ValidBucket {
    public static boolean isValid(String s){
        int size = s.length();
        if (size % 2 == 1){
            return false;
        }
        //定义栈
        LinkedList<Character> stack = new LinkedList<>();
        //定义map
        Map<Character, Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');

        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if (stack.isEmpty() || !map.get(c).equals(stack.peek())){
                    return false;
                }else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
