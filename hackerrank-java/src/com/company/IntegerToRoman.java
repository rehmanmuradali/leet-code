package com.company;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    public static String intToRoman(int num) {
        int[] numbersArray = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] letterArray = new String[]{"M", "CM", "D", "CD" ,"C",  "XC", "L",  "XL", "X", "IX" , "V", "IV" , "I"};
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (num > 0) {
            int remaining = num - numbersArray[index];
            if  (remaining >= 0 ) {
                result.append(letterArray[index]);
                num = num - numbersArray[index];
            } else {
                index++;

            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
