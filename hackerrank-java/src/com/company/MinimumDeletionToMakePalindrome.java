package com.company;

import java.util.HashMap;
import java.util.Map;

public class MinimumDeletionToMakePalindrome {


    public static int solution(String s) {
        int length = s.length();
        if (length < 2) return 0;
        Map<Character, Integer> occurrence = new HashMap<>();
        for(int i =0; i< s.length(); i++){
            occurrence.put(s.charAt(i), occurrence.getOrDefault(s.charAt(i), 0) + 1);
        }

        int count = 0;
        boolean foundPreviousSingleOccurrence = false;
        for (Map.Entry<Character, Integer> entry : occurrence.entrySet()) {
            if ( entry.getValue() % 2 != 0 ) {
                if (!foundPreviousSingleOccurrence) {
                    foundPreviousSingleOccurrence = true;
                    continue;
                }
                count++;
            }
        }
        return count;

    }
    public static void main(String[] args) {
        //System.out.println(solution("ervervige"));
        System.out.println(solution("bbac"));
        //System.out.println(solution("aaabab"));
//        System.out.println(solution("x"));
//        System.out.println(solution("xx"));
//        System.out.println(solution("xiix"));
//        System.out.println(solution("abad"));

    }

}
