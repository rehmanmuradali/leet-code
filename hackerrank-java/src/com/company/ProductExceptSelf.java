package com.company;

import java.util.Arrays;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length + 2];
        int[] suffixProduct = new int[nums.length + 2];
        int[] result = new int[nums.length];
        prefixProduct[0] = 1;
        suffixProduct[nums.length + 1] = 1;


        // i  j
        // 6  3

        //   j
        //     1  2  3   4
        //  1  1  2  6   24  0
        //  0  24 24 12  4   1
        //     24, 12, 8, 6

        //           i
        // 1 1 2 6 24 1

        //     i
        // 1  0  0  0   0  1
        // 1  24 24 12  4  1


        for (int i=1; i<nums.length; i++) {
            prefixProduct[i] = prefixProduct[i-1] * nums[i-1];
        }

        for (int i=suffixProduct.length-2; i>0; i--) {
            suffixProduct[i] = suffixProduct[i+1] * nums[i-1];
        }



        for (int i=0; i<nums.length; i++) {
            result[i] = prefixProduct[i] * suffixProduct[i+2];

        }
        return result;

    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }
}
