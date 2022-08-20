package com.company;


import java.math.BigInteger;
import java.util.*;

public class Main {


    public static List<Integer> findNumberSequence(String direction) {

        List<Integer> result = new ArrayList<>();
        for (int i= 0 ; i<direction.length(); i++){
            long index = direction.indexOf('L',i);
        }
        for (int i= 0 ; i<direction.length(); i++){
            result.add(direction.indexOf('L',i));
        }
        return result;
    }


    public static void main(String[] args) {
	// write your code here
        System.out.println(findNumberSequence("RR"));
    }
}
