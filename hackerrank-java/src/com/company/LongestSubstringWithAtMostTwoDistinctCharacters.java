package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithAtMostTwoDistinctCharacters {


    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        Set<Character> unique = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0 ;
        for (int i=0, j=0; i<s.length(); i++) {
            unique.add(s.charAt(i));
            int occurrence = map.getOrDefault(s.charAt(i), 0 );
            map.put(s.charAt(i), occurrence + 1);
            while (unique.size() > 2) {
                occurrence = map.getOrDefault(s.charAt(j), 0);
                occurrence--;
                map.put(s.charAt(j), occurrence);
                if (occurrence <= 0) {
                    unique.remove(s.charAt(j));
                    map.remove(s.charAt(j));
                }
                j++;
            }
            maxLength = Math.max(maxLength, i-j);
        }
        return maxLength + 1;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("abccccccc"));
    }
}
//  map:  e,2  c,1 b,1  -> e,1
// set:   e   c  b -> c b
// i  0  1  2  3
// j  0  1
// max 3
