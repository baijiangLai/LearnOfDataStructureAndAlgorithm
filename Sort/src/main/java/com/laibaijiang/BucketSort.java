package com.laibaijiang;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {5,4,6,7,2,3,3};
        bucketSortResolve(arr);
        System.out.println(arr.toString());
    }
    public static void bucketSortResolve(int[] arr){
        //找出最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        //找出最小值
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < max){
                min = arr[i];
            }
        }
        //确定桶的数量，这是一个大桶，大桶里面分别放好几个小桶
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        //确定桶的数量
        int count = (max - min) / arr.length + 1;
        for (int i = 0; i < count; i++) {
            //放入空数据
            buckets.add(new ArrayList<>());
        }
        //遍历arr，把对应数据放入桶中
        for (int i = 0; i < arr.length; i++) {
            //找到数据应该放入的桶中
            buckets.get((arr[i] - min) / arr.length).add(arr[i]);
        }
        //对每个小桶进行排序
        for (int i = 0; i < buckets.size(); i++) {
            Collections.sort(buckets.get(i));
        }
        //遍历每个桶里的每个数据，输出到arr中
        int k = 0;
        for (int i = 0; i < buckets.size(); i++) {
            ArrayList<Integer> smallBuckets = buckets.get(i);
            for (int j = 0; j < smallBuckets.size(); j++) {
                arr[k++] = smallBuckets.get(j);
            }
        }
    }
}
