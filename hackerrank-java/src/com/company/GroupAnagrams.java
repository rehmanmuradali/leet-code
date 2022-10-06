package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String test : strs) {
            char[] arr  = test.toCharArray();
            Arrays.sort(arr);
            String sortedString = Arrays.toString(arr);
            if (map.containsKey(sortedString)) {
                map.get(sortedString).add(test);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(test);
                map.put(sortedString, newList);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static List<List<String>> groupAnagramsWithoutSorting(String[] input) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for ( int i=0; i< input.length; i++) {
            int[] charactersCount = new int[26];
            String current = input[i];
            for (int j =0; j < current.length(); j++ ) {
                charactersCount[current.charAt(j) - 'a' ]++;
            }
            String key = Arrays.toString(charactersCount);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(current);
            map.put(key, value);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat", "abcd", "abcdddd"}));
        System.out.println(groupAnagramsWithoutSorting(new String[]{"eat","tea","tan","ate","nat","bat", "abcd", "abcdddd"}));
    }
}
