package com.company;


import java.util.Arrays;

public class ReverseByWord {

    public static String reverseStringByWord(String input){
        char[] arr = input.toCharArray();
        String word = "";
        StringBuilder result = new StringBuilder();
        int end = input.length() - 1;
        int start = end - 1;
        while(start >= 0 && end >=0) {
            if(arr[end] == ' ') {
                end--;
                start = end - 1;
                continue;
            }
            if(arr[start] != ' ') {
                start--;
                continue;
            }
            word = String.valueOf(Arrays.copyOfRange(arr, start+1, end+1));
            end = start-1;
            start--;
            result.append(" ").append(word);
        }
        if(end >= 0 ) {
            result.append(" ").append(String.valueOf(Arrays.copyOfRange(arr, 0, end+1)));
        }
        return result.substring(1);
    }


    public static void main(String[] args) {
        System.out.println(reverseStringByWord("i am rehman"));
        System.out.println(reverseStringByWord("this is  mz    "));
        System.out.println(reverseStringByWord("this is      mz"));
    }


}
