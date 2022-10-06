package com.company;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class card {


    public static int card(int[][] player) {
        int res = -1 ;
        for (int i =0 ; i<player.length; i++ ) {
            int result = solveOne(player[i]);
            res = Math.max(res, result);
        }
        return res;
    }

    public static int  solveOne(int[] cards) {

        Map<Integer, Integer> cMap = new HashMap<>();
        for (int i =0; i< cards.length; i++){
            if (cMap.containsKey(cards[i])){
                cMap.put(cards[i], cMap.get(cards[i]) + 1);
            }
            else {
                cMap.put(cards[i], 1);
            }
        }
        int max = -1;
        for (Map.Entry<Integer, Integer> mapElement : cMap.entrySet()) {
            if ((Integer) mapElement.getValue() == 1)  {
                max = Math.max(max, (Integer)mapElement.getKey());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] c = new int[][] { {5,7,3,9,4,9,8,3,1} ,{1,2,2,4,4,1 }, {1,2,3}};
        System.out.println(card(c));
    }
}
