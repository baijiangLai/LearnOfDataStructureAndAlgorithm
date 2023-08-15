package com.laibaijiang;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 5, 2, 3, 5, 10};
        countSortResolve(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countSort(int[] arr) {
        //max
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //数组
        int[] count = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int j = 0;
        //输出
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j++] = i;
                count[i]--;
            }

        }
    }

    public static void countSortResolve(int[] arr) {
        //max、min
        int min = arr[0];
        int max = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        //数组
        int[] count = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        int j = 0;
        //输出
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j++] = i + min;
                count[i]--;
            }

        }
    }
}
