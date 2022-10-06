package com.company;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveDuplicatesMoreThanTwo {


    public static List<Integer> removeDuplicatesMoreThanTwo(List<Integer> array) {

        int prevCount = 1;
        Integer prevElement = 0;
        for (int i=0; i<array.size(); i++) {
            if (array.get(i) == prevElement) {
                if(prevCount>=2){
                    array.set(i, Integer.MIN_VALUE);
                } else {
                    prevCount++;
                }
            } else {
                prevCount = 1;
                prevElement = array.get(i);
            }
        }
        array.removeIf(x -> x == Integer.MIN_VALUE);
        return array;

    }
    public static List<Integer> removeDuplicatesMoreThanTwoWithIterator(List<Integer> array) {

        int prevCount = 1;
        Integer prevElement = 0;
        Iterator<Integer> iterator = array.iterator();
        while(iterator.hasNext()) {
            Integer current = iterator.next();
            if (current == prevElement) {
                if(prevCount>=2){
                    iterator.remove();
                } else {
                    prevCount++;
                }
            } else {
                prevCount = 1;
                prevElement = current;
            }


        }
        return array;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,3,3,3,3,3,4,5,6,6,6};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(6);
        list.add(6);
        System.out.println(removeDuplicatesMoreThanTwoWithIterator(list));
        //System.out.println(removeDuplicatesMoreThanTwo(list));
    }
}
