package hellofresh.test;

import hellofresh.HelloFresh;

import java.util.ArrayList;
import java.util.List;

public class FindPairsOfEqualSumTest {


    public static void TestFindPairsOfEqualSum_InputValidValues_OutputCorrectResult(){

        List<List<Integer>> expected= new ArrayList<>();
        List<Integer> pair1 = new ArrayList<>();
        pair1.add(2);
        pair1.add(8);
        List<Integer> pair2 = new ArrayList<>();
        pair2.add(3);
        pair2.add(7);
        List<Integer> pair3 = new ArrayList<>();
        pair3.add(9);
        pair3.add(1);
        List<Integer> pair4 = new ArrayList<>();
        pair4.add(9);
        pair4.add(1);

        expected.add(pair1);
        expected.add(pair2);
        expected.add(pair3);
        expected.add(pair4);

        List<List<Integer>> result  = HelloFresh.findPairsOfEqualSum(new int[]{8, 7, 2, 5, 3, 1, 1, 9}, 10);
        if (result.size() !=  expected.size()) {
            System.out.println("Size test failed");
            return;
        }

        for(int i =0; i< result.size(); i++){
            List<Integer> resultPair = result.get(i);
            List<Integer> expectedPair = expected.get(i);
            if(!resultPair.get(0).equals(expectedPair.get(0)) || !resultPair.get(1).equals(expectedPair.get(1))) {
                System.out.println("Pair mismatched");
                return;
            }
        }


        System.out.println("All Test cases passed");
        ////!(resultPair.get(0).equals(expectedPair.get(0)) && resultPair.get(1).equals(expectedPair.get(1))


    }

    public static void main(String[] args) {
        TestFindPairsOfEqualSum_InputValidValues_OutputCorrectResult();
    }
}
