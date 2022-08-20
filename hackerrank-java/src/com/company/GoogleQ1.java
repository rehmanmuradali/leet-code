package com.company;
import java.util.HashSet;
import java.util.Set;

public class GoogleQ1 {


    public static int solution(int[] x, int[] y) {
        // Your code here
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        for (int j : x) {
            setX.add(j);
        }
        for (int j : y) {
            setY.add(j);
        }

        Set<Integer> result;
        if (setX.size() > setY.size()) {
            setX.removeAll(setY);
            result = setX;
        } else {
            setY.removeAll(setX);
            result = setY;
        }

        return result.iterator().next();

    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{14, 27, 1, 4, 2, 50, 3, 1}, new int[]{2, 4, -4, 3, 1, 1, 14, 27, 50}));
    }
}
