package com.lbj.numsStr;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class isUnique {
    public static void main(String[] args) {
        String s = "abc";
        boolean res = isUniqueResolve(s);
        System.out.println(res);
    }

    private static boolean isUniqueResolve(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            freq.put(c, freq.getOrDefault(c,0) + 1);
        }
        for (Integer value : freq.values()) {
            if (value > 1) {
                return false;
            }
        }
        return true;

    }
}
