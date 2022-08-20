package com.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {



    }

    public static int numberOfTokens(int expiryLimit, List<List<Integer>> commands) {
        // Write your code here


        Map<Integer, Integer> expirationMap = new HashMap<>();

        for(int i=0; i<commands.size())

        // If created -> and comes it T -> ignore?
        // If created -> expired -> comes with rest -> ignore
        // if not exists -> reset -> ignore





        // Map <Id, Expiry>
        // 0 -> Create
        // 1 -> getValue form Map -> Value >= T  , putValue -> T+ expiryLimit
        // Last time T
        // For each value
        // if < T ->   count++

    }
    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {



        // Write your code here

        // a. len ! = b.len  -> -1

        //tea            toe
        //                 o -> 1
        // a -> 1


        //  abb
        //

//        List<Integer> result = new ArrayList<>();
//        for (int i=0; i<a.size(); i++){
//            String aString = a.get(i);
//            String bString = b.get(i);
//
//            if(aString.length() != bString.length()) {
//                result.add(-1);
//                continue;
//            }
//
//            Map<Character, Integer> occurrenceA = new HashMap<>();
//            Map<Character, Integer> occurrenceB = new HashMap<>();
//            for (int index= 0; index < aString.length(); index++){
//                Character current =  aString.getCha[index];
//                if (occurrenceA.containsKey(current)) {
//                    occurrenceA.put(current, occurrenceA.get(index) + 1);
//                } else {
//                    occurrenceA.put(current, 1);
//                }
//            }
//
//            for (int index= 0; index < bString.length(); index++){
//                Character current =  bString[index];
//                if (occurrenceB.constains(current)) {
//                    occurrenceB.put(current, occurrenceB.get(index) + 1);
//                } else {
//                    occurrenceB.put(current, 1);
//                }
//            }
//
//
//            // a -> 1  |   c -> 1
//            for (Map.Entry<Character,Integer> entry : occurrenceA.entrySet())  {
//
//                if(occurrenceB.constainsKey(entry.getKey())) {
//                    Integer bOccur = occurrenceB.get(entry.getKey());
//                    Integer aOccur = occurrenceA.get(entry.getKey());
//                    if ((aOccur - bOccur) == 0 ){
//                        occurrenceB.remove(entry.getKey());
//                    } else {
//                        occurrenceB.put(entry.getKey(), Math.abs(aOccur - bOccur));
//                    }
//                }
//            }
//            int currentResult = 0;
//            for (Map.Entry<Character,Integer> entry : occurrenceB.entrySet())  {
//                currentResult += entry.getValue();
//            }
//            result.add(currentResult);
//        }


    }
}
