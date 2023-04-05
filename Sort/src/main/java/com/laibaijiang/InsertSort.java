package com.laibaijiang;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {5,4,6,7,2,3,3};
        insetSort(arr);
        System.out.println(arr.toString());
    }
    public static void insetSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            //从这里将划分为一个有序表和一个无序表
            for (int j = i; j > 0; j--){
                //查找到了相应合适的位置进行交换
                if (arr[j] < arr[j - 1]){
                    swap(arr, j, j - 1);
                }else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
