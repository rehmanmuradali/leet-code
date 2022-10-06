package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestInArray {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            priorityQueue.add(num);
        }

        for(int i =0; i < k; i++){
            priorityQueue.poll();
        }
        if (!priorityQueue.isEmpty())
            return priorityQueue.peek();
        else return 0;
    }

}
