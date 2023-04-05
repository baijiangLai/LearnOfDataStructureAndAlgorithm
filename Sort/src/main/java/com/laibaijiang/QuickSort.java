package com.laibaijiang;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,4,6,7,2,3,3};
        quickSortResolve(arr);
        System.out.println(arr.toString());
    }
    public static void quickSortResolve(int[] arr){
        int size = arr.length;
        quickSort(arr, 0, size - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high){
            int mid = partition(arr, low, high);
            quickSort(arr, low, mid - 1);
            quickSort(arr, mid + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high){
            //找基准数右侧比基准数小的数进行交换
            while (low < high && arr[high] >= pivot){
                high--;
            }
            if (low < high){
                arr[low] = arr[high];
            }
            //找基准数右侧比基准数大的数进行交换
            while (low < high && arr[low] <= pivot){
                low++;
            }
            if (low < high){
                arr[high] = arr[low];
            }
        }
        //此时low == high
        arr[low] = pivot;
        return low;
    }
}
