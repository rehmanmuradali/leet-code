package com.company;

import java.util.HashSet;
import java.util.Set;

public class MinContinuousUnique {

    public static int solution(int[] A) {
        Set<Integer> unique = new HashSet<>();
        int[] arr = new int[100000];
        int min = A.length;
        for (int k : A) {
            unique.add(k);
        }

        for (int i=0, j=0; i<=j && j<A.length; ){

            if(unique.size() > 0) {
                arr[A[j]]++;
                unique.remove(A[j++]);
            }
            else {
                if(arr[A[i]] == 1){
                    unique.add(arr[A[i]]);
                    min = Math.min(min,j-i);
                }
                arr[A[i]]--;
                i++;
            }
        }
        return min;

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,1,1,3,2,1,1,3}));

        //System.out.println(solution(new int[]{7,5,2,7,2,7,4,7}));
        //System.out.println(solution(new int[]{7,7,7}));
    }
}

