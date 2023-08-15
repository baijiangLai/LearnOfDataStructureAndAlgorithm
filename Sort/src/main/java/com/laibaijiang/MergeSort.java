package com.laibaijiang;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,4,7,1,2,3,6};
        mergeSortResolve(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSortResolve(int[] arr){
        int size = arr.length;
        mergeArr(arr, 0, size - 1);
    }

    /**
     * 数组被划分为了[low,mid] [mid + 1, high]
     * @param arr
     * @param low
     * @param high
     */
    private static void mergeArr(int[] arr, int low, int high) {
        if (low < high){
            int mid = low + ((high - low) >> 1);
            mergeArr(arr, low, mid);
            mergeArr(arr, mid + 1, high);
            merge(arr, mid,low, high);
        }
    }

    /**
     *
     * @param arr 待排序的数组
     * @param mid 待合并子数组的中间索引
     * @param low 待合并子数组的开始索引
     * @param high 待合并子数组的结束索引
     */
    private static void merge(int[] arr, int mid, int low, int high) {
        int[] temp = new int[high - low + 1];
        int idx = 0;
        int i  = low, j = mid + 1;
        while (i <= mid && j <= high){
            if (arr[i] <= arr[j]){
                temp[idx++] = arr[i++];
            }else {
                temp[idx++] = arr[j++];
            }
        }
        while (i <= mid){
            temp[idx++] = arr[i++];
        }

        while (j <= high){
            temp[idx++] = arr[j++];
        }
        for (int count = 0; count < idx; count++){
            arr[count + low] = temp[count];
        }
    }
}
