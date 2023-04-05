package com.laibaijiang;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {5,4,6,7,2,3,3};
        heapSortResolve(arr);
        System.out.println(arr.toString());
    }

    public static void heapSortResolve(int[] arr){
        //建堆
        buildHeap(arr);
        //进行交换
        int size = arr.length;
        for (int i = size - 1; i > 0; i--) {
            //每次交换第一个元素和最后一个元素
            swap(arr, 0, i);
            //重新保持堆的稳定
            heapify(arr, 0, i);
        }
    }

    private static void buildHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
            heapify(arr, i, arr.length);
        }
    }

    private static void heapify(int[] arr, int i, int length) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        //如果左节点大于当前节点值，进行记录
        if (left < length && arr[left] > arr[largest]){
            largest = left;
        }
        //如果右节点大于当前节点值，进行记录
        if (right < length && arr[right] > arr[largest]){
            largest = right;
        }
        //只要当前节点值与原节点值不一样，进行交换，并重新保持堆的稳定
        if (largest != i){
            swap(arr, i, largest);
            heapify(arr, largest, length);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
