package com.laibaijiang;

import java.util.LinkedList;


/**
 * 本题是一道经典的关于栈的应用。
 * 思路：
 * 1. 使用两个栈：数字栈、字符串栈，数字栈存在给定字符串中的数字，字符串栈存放每次重复多少次之后的字符串。
 * 2.
 * 2.1.当遇见是数字的时候，将数字从String类型转换到int类型
 * 2.2.当遇见是字符的时候，那么直接保存到一个stringBuilder中
 * 2.3.当遇见是左括号的时候，说明从此时开始要准备进行重复，字符串栈入栈之前的stringBuidler对象，并且将该对象制空，同时将数字入数字栈，并将临时数字制空。
 * 2.4.当遇见是有括号的时候，说明此时需要进行重复字符串工作，将数字栈中数字弹出，表示需要重复的次数，同时生成一个新的stringBuilder对象(这个对象是用来表示之前的字符串+每次生成的字符串，因此在重复完成之后，需要赋给之前的stringBuilder对象)。
 */
public class DecodeString {
    public static void main(String[] args) {
        String res = DecodeStringResolve("3[a]2[bc]");
        System.out.println(res);
    }

    public static String DecodeStringResolve(String s) {
        StringBuilder sb = new StringBuilder();
        int size = s.length();
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<String> strStack = new LinkedList<>();
        int num = 0;
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (Character.isLetter(c)) {
                sb.append(c);
            } else if (c == '[') {
                strStack.push(sb.toString());
                sb = new StringBuilder();
                numStack.push(num);
                num = 0;
            } else if (c == ']') {
                int repeat = numStack.pop();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(strStack.pop());
                for (int j = 0; j < repeat; j++) {
                    stringBuilder.append(sb.toString());
                }
                sb = stringBuilder;
            }
        }
        return sb.toString();
    }
}
