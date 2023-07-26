package com.laibaijiang;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 6, 7, 2, 3, 100};
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
        //max
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //min
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
        }

        //数组
        int[] count = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] + min]++;
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
