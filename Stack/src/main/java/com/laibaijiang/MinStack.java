package com.laibaijiang;

import java.util.LinkedList;

public class MinStack {
    public static void main(String[] args) {

    }

    /**
     * 在类中定义两个栈。一个数据栈，一个最小数据栈
     * 每次放入数据的时候，数据栈正常放，最小数据栈栈顶数据要和当前数判断，如果栈顶大于当前数，那么入栈，否则再次入栈顶数据
     */
    class MinStackResolve {
        LinkedList<Integer> data;
        LinkedList<Integer> minData;
        public MinStackResolve() {
            data = new LinkedList<>();
            minData = new LinkedList<>();
        }

        public void push(int val) {
            data.push(val);
            if (minData.isEmpty() || minData.peek() > val) {
                minData.push(val);
            } else {
                minData.push(minData.peek());
            }
        }

        public void pop() {
            data.pop();
            minData.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return minData.peek();
        }
    }
}
