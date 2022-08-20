package com.company;

import java.util.*;

public class PrecendenceRule {


    public static void main(String[] args) {
        System.out.println(findWord(new String[]{"R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G"}));
    }



    public static String findWord(String[] rules) {

        Map<String, String> dac = new HashMap<>();
        Set<String> endingLetters = new HashSet<>();
        for (String rule : rules) {
            String[] params;
            params = rule.split(">");
            dac.put(params[0], params[1]);
            endingLetters.add(params[1]);
        }

        String head = "";
        for (Map.Entry<String, String> entry : dac.entrySet()) {
             if (!endingLetters.contains(entry.getKey())) {
                 head = entry.getKey();
                 break;
             }
        }
        StringBuilder result = new StringBuilder();
        while (dac.containsKey(head)) {
            result.append(head);
            head = dac.get(head);
        }
        result.append(head);
        return result.toString();

    }

}
