package com.company;

import java.util.*;

public class ThreeSumCloset {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // -4, -1, 1, 2
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i=0; i<nums.length-2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right)  {


                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                if (sum < target ) {
                    left++;
                }
                else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }

            }
        }

        return closestSum;
    }




    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1, 1, 1, 1}, 0 ));
    }


}
