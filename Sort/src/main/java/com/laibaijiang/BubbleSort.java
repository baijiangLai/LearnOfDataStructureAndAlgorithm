package com.laibaijiang;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,4,6,7,2,3,3};
        optimize(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr){
        int len = arr.length;
        // 外层比较的趟数
        for (int i = 0 ; i < len - 1; i++){
            // 内层比较的次数
            for (int j = 0; j < len - i - 1; j++){
                if (arr[j] >= arr[j + 1]){
                    swap(arr, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int j) {
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
    }

    public static void optimize(int[] arr) {
        int len = arr.length;
        boolean hasChange = true;
        //如果在某一次遍历的时候发现数组已经排序好的，那么就不需要进行额外的遍历了
        for (int i = 0; i < len - 1 && hasChange; i++) {
            hasChange = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] >= arr[j + 1]) {
                    swap(arr,j);
                    hasChange = true;
                }
            }

        }
    }

}
