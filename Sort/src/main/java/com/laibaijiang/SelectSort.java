package com.laibaijiang;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 6, 7, 2, 3, 3};
        selectSortResolve(arr);
        System.out.println(arr.toString());
    }
    public static void selectSortResolve(int[] arr){
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            //默认当前最小数的下标是第一个
            int minIdx = i;
            for (int j = i + 1; j < size; j++) {
                //找到比当前最小数还小的数，进行交换
                if (arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
