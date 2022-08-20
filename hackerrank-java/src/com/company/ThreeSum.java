package com.company;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        int firstElement;
        Set<String> uniqueResultSet  = new HashSet<>();
        List<List<Integer>> threeSumResult = new ArrayList<>();
        for (int i=0; i < nums.length - 1; i++ ) {
            firstElement = nums[i];
            List<List<Integer>> midResult = twoSum(Arrays.copyOfRange(nums, i+1,  nums.length), target - firstElement);
            for (List<Integer> entry : midResult)  {
                entry.add(nums[i]);

                if (isListUnique(uniqueResultSet, entry)) {
                    threeSumResult.add(entry);
                }
            }
        }
        return threeSumResult;
    }

    public static List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0 ; i< nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                List<Integer> midResult = new ArrayList<>();
                midResult.add(target - nums[i]);
                midResult.add(nums[i]);

                result.add(midResult);
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static boolean isListUnique(Set<String> set, List<Integer> list)
    {
        Collections.sort(list);
        String key = list.toString();
        if (!set.contains(key)) {
            set.add(key);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}, 0  ));
    }


}
