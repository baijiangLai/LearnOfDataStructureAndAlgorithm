package com.laibaijiang;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,4,6,7,2,3,3};
        mergeSortResolve(arr);
        System.out.println(arr.toString());
    }
    public static void mergeSortResolve(int[] arr){
        int size = arr.length;
        mergeArr(arr, 0, size - 1);
    }

    private static void mergeArr(int[] arr, int low, int high) {
        if (low < high){
            int mid = low + ((high - low) >> 1);
            mergeArr(arr, low, mid);
            mergeArr(arr, mid + 1, high);
            merge(arr, mid,low, high);
        }
    }

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
