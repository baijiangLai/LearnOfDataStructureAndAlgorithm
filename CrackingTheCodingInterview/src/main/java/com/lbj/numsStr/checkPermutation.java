package com.lbj.numsStr;

import java.util.HashMap;
import java.util.Map;

public class checkPermutation {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bca";
        boolean res = checkPermutationResolve(s1,s2);
        System.out.println(res);
    }

    private static boolean checkPermutationResolve(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        for (Character c : s2.toCharArray()) {
            s2Map.put(c, s2Map.getOrDefault(c, 0) + 1);
        }

        return s1Map.entrySet().equals(s2Map.entrySet());
    }
}
