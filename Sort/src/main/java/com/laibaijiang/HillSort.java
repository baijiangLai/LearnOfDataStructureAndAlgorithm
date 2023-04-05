package com.laibaijiang;


public class HillSort {
    public static void main(String[] args) {
        int[] arr = {5,4,6,7,2,3,3};
        hillSortResolve(arr);
        System.out.println(arr.toString());
    }
    public static void hillSortResolve(int[] arr){
        //gap设值为size / 2
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            //正式进行比较，拆分为arr[i]和arr[i + gap]
            for (int i = gap; i < arr.length; i++) {
                //每组数据要进行比较，比如拆分出来后是[23,65,48]，那么48要分别与65、23进行比较，找到自己的位置
                for (int j = i; j >= gap; j -= gap){
                    if (arr[j] < arr[j - gap]){
                        swap(arr, j, j - gap);
                    }else {
                        break;
                    }
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
