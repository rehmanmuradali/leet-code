package com.company;

import java.util.HashMap;
import java.util.Map;

public class MinimumSlidingWindowSubstring {

    public static String minWindow(String s, String t) {
        Map<Character, Integer> occurrence = new HashMap<>();
        String result = "";
        for (Character x : t.toCharArray()) {
            occurrence.put(x, occurrence.getOrDefault(x, 0) + 1);
        }
        int left = 0;
        int right = 0;
        while (right < s.length() || isValidWindow(occurrence)) {

            if(!isValidWindow(occurrence)) {
                if(occurrence.containsKey(s.charAt(right))) {
                    occurrence.put(s.charAt(right), occurrence.get(s.charAt(right)) - 1);
                }
                right++;
                continue;
            }

            result = (!result.equals("") && (result.length() <= (right - left))) ? result : s.substring(left, right);

            if(occurrence.containsKey(s.charAt(left))) {
                occurrence.put(s.charAt(left), occurrence.get(s.charAt(left)) + 1);
            }
            left++;

        }
        return result;
    }

    public static boolean isValidWindow(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet() ) {
            if (entry.getValue() > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
