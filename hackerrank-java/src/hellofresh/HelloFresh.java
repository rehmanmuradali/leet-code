package hellofresh;

import java.util.*;

public class HelloFresh {

//    Given an unsorted integer array, find a pair with the given sum in it.
//            Input:
//    nums = [8, 7, 2, 5, 3, 1, 1, 9]
//    target = 10
//    Output:
//    Pair found (8, 2)
//    or
//    Pair found (7, 3)
//    Input:
//    nums = [5, 2, 6, 8, 1, 9]
//    target = 12
//    Output: Pair not found

    // O(n2)
    //  8
    // map
    // 8   7
    // time -> O(n)
    // Space  ->  O(n)
    //


    // set      8  7  2  5
    // i        0  1  2  3  4
    // currentElement
    // target  = 10
    //  [8, 7, 2, 5, 3, 1, 1, 9]
    // Result:
    // 2 8
    // 3 7
    public static List<List<Integer>> findPairsOfEqualSum(int[] input, int target) {
        if(input.length < 2) {
            System.out.println("Pair not found");
            return new ArrayList<>();
        }
        //Set<Integer> foundElements = new HashSet<>();
        Map<Integer, Integer> foundElementsMaps = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0 ; i<input.length; i++) {
            if (foundElementsMaps.containsKey(target - input[i])) {
                int occurrence = foundElementsMaps.get(target - input[i]);
                for(int j = 0; j < occurrence; j++) {
                    List<Integer> currentPair= new ArrayList<>();
                    currentPair.add(input[i]);
                    currentPair.add(target - input[i]);
                    result.add(currentPair);
                }
            }

            //foundElements.add(input[i]);
            int occurrence = foundElementsMaps.getOrDefault(input[i], 0);
            foundElementsMaps.put(input[i], occurrence + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello world");
        int[] input = new int[]{8, 7, 2, 5, 3, 1};
        System.out.println(findPairsOfEqualSum(input, 10));
    }
}
