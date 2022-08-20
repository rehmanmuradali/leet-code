package com.company;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithAtMostTwoDistinctCharacters {


    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        Set<Character> unique = new HashSet<>();
        for (int i=0, j=0; i<s.length(); i++) {
            unique.add(s.charAt(i));
            while (unique.size() > 2) {

            }
            if (unique.contains(s.charAt(i))) {

            }
        }

        
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}
