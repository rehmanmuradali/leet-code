package com.company;

import java.util.Arrays;

public class ReverseString {


    public static String reverseString(String input){
        char[] arr = input.toCharArray();
        int start = 0;
        int end = input.length() - 1;
        while(start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("abc"));
        System.out.println(reverseString("abcd"));

    }
}
