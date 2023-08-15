package com.laibaijiang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 5, 2, 3, 5, 10};
        bucketSortResolve(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bucketSortResolve(int[] arr){
        //max、min
        int min = arr[0];
        int max = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
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
