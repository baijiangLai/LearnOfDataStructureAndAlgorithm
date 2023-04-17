package com.laibaijiang;

import java.util.LinkedList;

/**
 * 本题解决思路与84. 柱状图中最大的矩形思想一致，只不过要先单独求出每列柱子的高度
 */
public class MaximalRectangle {
    public static void main(String[] args) {

    }

    public static int MaximalRectangleResolve(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 0) {
            return 0;
        }
        int[] heights = new int[col];
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largest(heights));
        }
        return maxArea;
    }

    private static int largest(int[] heights) {
        int[] temp = new int[heights.length + 2];
        temp[0] = 0;
        temp[temp.length - 1] = 0;
        int res = 0;
        for (int i = 1; i < temp.length - 1; i++) {
            temp[i] = heights[i - 1];
        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[i] < temp[stack.peek()]) {
                int left = stack.pop();
                int h = temp[left];
                int w = i - stack.peek() - 1;
                res = Math.max(res, w * h);
            }
            stack.push(i);
        }
        return res;
    }
}
