package com.laibaijiang;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,4,6,7,2,3,3};
        bubbleSort(arr);
        System.out.println(arr.toString());
    }
    public static void bubbleSort(int[] arr){
        int len = arr.length;
        // 外层比较的趟数
        for (int i = 0 ; i < len - 1; i++){
            // 内层比较的次数
            for (int j = 0; j < len - i - 1; j++){
                if (arr[j] >= arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
