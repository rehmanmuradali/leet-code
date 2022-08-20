package com.company;

import javax.print.attribute.standard.PresentationDirection;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class AdjustDiscount {

    public static String[] solution(String S, String[] B) {


        BigDecimal[] bArray = new BigDecimal[B.length];
        BigDecimal bSum = BigDecimal.ZERO;
        BigDecimal sSum = new BigDecimal(S);
        Map<BigDecimal, Integer> orderMap = new HashMap<>();
        for (int i=0; i<B.length; i++){
            BigDecimal bigDecimal = new BigDecimal(B[i]);
            bArray[i] = bigDecimal;
            bSum = bSum.add(bigDecimal);
            orderMap.put(bigDecimal, i);
        }

        Arrays.sort(bArray, Collections.reverseOrder());
        //System.out.println(Arrays.toString(bArray));

        String[] resultArrays = new String[bArray.length];
        for(int i=0; i< bArray.length; i++ ) {

//            System.out.println("stotal: " + sSum);
//            System.out.println("current amount: " + bArray[i]);
//            System.out.println("btotal : " + bSum);
            BigDecimal result = sSum.multiply(bArray[i]).divide(bSum, 2, RoundingMode.FLOOR);
            //result = result.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            System.out.println("result: " + result);
            int index = orderMap.get(bArray[i]);
            resultArrays[index] = result.toString();
            sSum = sSum.subtract(result);
            bSum = bSum.subtract(bArray[i]);
            System.out.println();
        }
        return resultArrays;
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(solution("300.01", new String[]{ "300.00", "200.00", "100.00"})));
        System.out.println(Arrays.toString(solution("1.236", new String[]{ "0.05", "2.01", "1.00"})));
    }

}
