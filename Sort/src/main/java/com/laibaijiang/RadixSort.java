package com.laibaijiang;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {26,3,49,556,81,9,863,0};
        radixSortResolve(arr);
        System.out.println(arr.toString());
    }
    public static void radixSortResolve(int[] arr){
        //分解个十百...位  value/exp(具体指代个、十、百位)%10

        //找到max
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        for (int exp = 1; max/exp > 0; exp *= 10){
            //先进行个位的数据提取、再十位
            //创建10个桶以及temp数组
            int[] buckets = new int[10];
            int[] temp = new int[arr.length];

            //计算每个桶中的数据个数
            for (int i = 0; i < arr.length; i++) {
                buckets[arr[i] / exp % 10]++;
            }

            //桶的数据的累加
            for (int i = 1; i < buckets.length; i++) {
                buckets[i] += buckets[i - 1];
            }

            //得到累加数据之后，向temp数组中放入数据
            //从后向前遍历arr，放在temp数组中
            /**
             * TODO：这块是基数排序的重点
             */
            for (int i = arr.length - 1; i >= 0; i--) {
                //temp数组的索引值 = buckets[i] - 1
                //而buckets[i] = arr[i] / exp % 10
                temp[buckets[arr[i] / exp % 10] - 1] = arr[i];
                buckets[arr[i] / exp % 10]--;
            }
            //temp数组输出至arr中
            for (int i = 0; i < temp.length; i++) {
                arr[i] = temp[i];
            }
        }
    }
}
